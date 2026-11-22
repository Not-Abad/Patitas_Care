
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.PacienteDetalle;
import provet.utilidades.dbConection;

public class PacienteDetalleDAO {

    public List<PacienteDetalle> selectAllActivos() {
        List<PacienteDetalle> lista = new ArrayList<>();
        String sql = "SELECT m.id_mascota, m.id_propietario, m.id_raza, m.nombre, m.sexo, "
                   + "m.fecha_nacimiento, m.peso_actual_kg, m.antecedentes_medicos, "
                   + "r.nombre AS nombre_raza, e.nombre AS nombre_especie, "
                   + "p.nombre AS nombre_propietario "
                   + "FROM mascotas m "
                   + "INNER JOIN catalogo_razas r ON m.id_raza = r.id_raza "
                   + "INNER JOIN catalogo_especies e ON r.id_especie = e.id_especie "
                   + "INNER JOIN propietarios p ON m.id_propietario = p.id_propietario "
                   + "WHERE m.estatus = 'Activo' "
                   + "ORDER BY m.nombre ASC";

        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearBasico(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error en PacienteDetalleDAO.selectAllActivos: " + e.getMessage());
        }
        return lista;
    }

    public List<PacienteDetalle> buscarPorFiltro(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return selectAllActivos();
        }
        List<PacienteDetalle> lista = new ArrayList<>();
        String sql = "SELECT m.id_mascota, m.id_propietario, m.id_raza, m.nombre, m.sexo, "
                   + "m.fecha_nacimiento, m.peso_actual_kg, m.antecedentes_medicos, "
                   + "r.nombre AS nombre_raza, e.nombre AS nombre_especie, "
                   + "p.nombre AS nombre_propietario "
                   + "FROM mascotas m "
                   + "INNER JOIN catalogo_razas r ON m.id_raza = r.id_raza "
                   + "INNER JOIN catalogo_especies e ON r.id_especie = e.id_especie "
                   + "INNER JOIN propietarios p ON m.id_propietario = p.id_propietario "
                   + "WHERE m.estatus = 'Activo' AND ("
                   + "CAST(m.id_mascota AS CHAR) LIKE ? OR "
                   + "LOWER(m.nombre) LIKE ? OR "
                   + "LOWER(r.nombre) LIKE ? OR "
                   + "LOWER(e.nombre) LIKE ? OR "
                   + "LOWER(p.nombre) LIKE ?) "
                   + "ORDER BY m.nombre ASC";

        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;

        String patron = "%" + texto.trim().toLowerCase() + "%";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 5; i++) {
                ps.setString(i, patron);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearBasico(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en PacienteDetalleDAO.buscarPorFiltro: " + e.getMessage());
        }
        return lista;
    }

    public PacienteDetalle selectDetalleById(int idMascota) {
        String sql = "SELECT m.id_mascota, m.id_propietario, m.id_raza, m.nombre, m.sexo, "
                   + "m.fecha_nacimiento, m.peso_actual_kg, m.antecedentes_medicos, "
                   + "r.nombre AS nombre_raza, e.nombre AS nombre_especie, "
                   + "p.nombre AS nombre_propietario "
                   + "FROM mascotas m "
                   + "INNER JOIN catalogo_razas r ON m.id_raza = r.id_raza "
                   + "INNER JOIN catalogo_especies e ON r.id_especie = e.id_especie "
                   + "INNER JOIN propietarios p ON m.id_propietario = p.id_propietario "
                   + "WHERE m.id_mascota = ?";

        Connection conn = dbConection.getConexion();
        if (conn == null) return null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    PacienteDetalle detalle = mapearBasico(rs);
                    detalle.setVacunas(consultarVacunas(conn, idMascota));
                    return detalle;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en PacienteDetalleDAO.selectDetalleById: " + e.getMessage());
        }
        return null;
    }

    private PacienteDetalle mapearBasico(ResultSet rs) throws SQLException {
        PacienteDetalle p = new PacienteDetalle();
        p.setIdMascota(rs.getInt("id_mascota"));
        p.setIdPropietario(rs.getInt("id_propietario"));
        p.setIdRaza(rs.getInt("id_raza"));
        p.setNombre(rs.getString("nombre"));
        p.setRaza(rs.getString("nombre_raza"));
        p.setEspecie(rs.getString("nombre_especie"));
        p.setNombrePropietario(rs.getString("nombre_propietario"));
        p.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        p.setSexo(rs.getString("sexo"));

        Object pesoObj = rs.getObject("peso_actual_kg");
        if (pesoObj instanceof Number) {
            p.setPeso(((Number) pesoObj).doubleValue());
        }

        String antecedentes = rs.getString("antecedentes_medicos");
        p.setAlergias((antecedentes != null && !antecedentes.isBlank()) ? antecedentes : "Sin antecedentes registrados");
        return p;
    }

    private String consultarVacunas(Connection conn, int idMascota) {
        String sql = "SELECT GROUP_CONCAT(cv.nombre SEPARATOR ', ') "
                   + "FROM esquema_vacunacion ev "
                   + "INNER JOIN catalogo_vacunas cv ON ev.id_vacuna = cv.id_vacuna "
                   + "WHERE ev.id_mascota = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String res = rs.getString(1);
                    return (res != null && !res.isBlank()) ? res : "Ninguna registrada";
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar vacunas: " + e.getMessage());
        }
        return "Ninguna registrada";
    }
}