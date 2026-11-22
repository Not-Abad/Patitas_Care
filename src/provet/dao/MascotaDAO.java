
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Mascota;
import provet.utilidades.dbConection;

public class MascotaDAO {

    public boolean insert(Mascota obj) {
        String sql = "INSERT INTO mascotas (id_propietario, id_raza, nombre, sexo, fecha_nacimiento, peso_actual_kg, antecedentes_medicos, estatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdPropietario());
            ps.setInt(2, obj.getIdRaza());
            ps.setString(3, obj.getNombre());
            ps.setString(4, obj.getSexo());
            ps.setDate(5, obj.getFechaNacimiento());
            ps.setBigDecimal(6, obj.getPesoActualKg());
            ps.setString(7, obj.getAntecedentesMedicos());
            ps.setString(8, obj.getEstatus() != null ? obj.getEstatus() : "Activo");
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdMascota(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en MascotaDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Mascota selectById(int idMascota) {
        String sql = "SELECT * FROM mascotas WHERE id_mascota = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en MascotaDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Mascota> selectAll() {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascotas";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en MascotaDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Mascota obj) {
        String sql = "UPDATE mascotas SET id_propietario = ?, id_raza = ?, nombre = ?, sexo = ?, fecha_nacimiento = ?, peso_actual_kg = ?, antecedentes_medicos = ?, estatus = ? WHERE id_mascota = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdPropietario());
            ps.setInt(2, obj.getIdRaza());
            ps.setString(3, obj.getNombre());
            ps.setString(4, obj.getSexo());
            ps.setDate(5, obj.getFechaNacimiento());
            ps.setBigDecimal(6, obj.getPesoActualKg());
            ps.setString(7, obj.getAntecedentesMedicos());
            ps.setString(8, obj.getEstatus());
            ps.setInt(9, obj.getIdMascota());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en MascotaDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idMascota) {
        String sql = "DELETE FROM mascotas WHERE id_mascota = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en MascotaDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Mascota mapear(ResultSet rs) throws SQLException {
        Mascota m = new Mascota();
        m.setIdMascota(rs.getInt("id_mascota"));
        m.setIdPropietario(rs.getInt("id_propietario"));
        m.setIdRaza(rs.getInt("id_raza"));
        m.setNombre(rs.getString("nombre"));
        m.setSexo(rs.getString("sexo"));
        m.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        m.setPesoActualKg(rs.getBigDecimal("peso_actual_kg"));
        m.setAntecedentesMedicos(rs.getString("antecedentes_medicos"));
        m.setEstatus(rs.getString("estatus"));
        m.setCreatedAt(rs.getTimestamp("created_at"));
        return m;
    }
}