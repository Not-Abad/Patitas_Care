
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.EsquemaVacunacion;
import provet.utilidades.dbConection;

public class EsquemaVacunacionDAO {

    public boolean insert(EsquemaVacunacion obj) {
        String sql = "INSERT INTO esquema_vacunacion (id_mascota, id_vacuna, id_veterinario, id_consulta, fecha_aplicacion, fecha_proxima_dosis, lote, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdMascota());
            ps.setInt(2, obj.getIdVacuna());
            ps.setInt(3, obj.getIdVeterinario());
            if (obj.getIdConsulta() != null) ps.setInt(4, obj.getIdConsulta());
            else ps.setNull(4, Types.INTEGER);
            ps.setDate(5, obj.getFechaAplicacion());
            ps.setDate(6, obj.getFechaProximaDosis());
            ps.setString(7, obj.getLote());
            ps.setString(8, obj.getObservaciones());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdAplicacion(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en EsquemaVacunacionDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public EsquemaVacunacion selectById(int idAplicacion) {
        String sql = "SELECT * FROM esquema_vacunacion WHERE id_aplicacion = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAplicacion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en EsquemaVacunacionDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<EsquemaVacunacion> selectAll() {
        List<EsquemaVacunacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM esquema_vacunacion";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en EsquemaVacunacionDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(EsquemaVacunacion obj) {
        String sql = "UPDATE esquema_vacunacion SET id_mascota = ?, id_vacuna = ?, id_veterinario = ?, id_consulta = ?, fecha_aplicacion = ?, fecha_proxima_dosis = ?, lote = ?, observaciones = ? WHERE id_aplicacion = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdMascota());
            ps.setInt(2, obj.getIdVacuna());
            ps.setInt(3, obj.getIdVeterinario());
            if (obj.getIdConsulta() != null) ps.setInt(4, obj.getIdConsulta());
            else ps.setNull(4, Types.INTEGER);
            ps.setDate(5, obj.getFechaAplicacion());
            ps.setDate(6, obj.getFechaProximaDosis());
            ps.setString(7, obj.getLote());
            ps.setString(8, obj.getObservaciones());
            ps.setInt(9, obj.getIdAplicacion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en EsquemaVacunacionDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idAplicacion) {
        String sql = "DELETE FROM esquema_vacunacion WHERE id_aplicacion = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAplicacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en EsquemaVacunacionDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private EsquemaVacunacion mapear(ResultSet rs) throws SQLException {
        EsquemaVacunacion ev = new EsquemaVacunacion();
        ev.setIdAplicacion(rs.getInt("id_aplicacion"));
        ev.setIdMascota(rs.getInt("id_mascota"));
        ev.setIdVacuna(rs.getInt("id_vacuna"));
        ev.setIdVeterinario(rs.getInt("id_veterinario"));
        ev.setIdConsulta(rs.getObject("id_consulta", Integer.class));
        ev.setFechaAplicacion(rs.getDate("fecha_aplicacion"));
        ev.setFechaProximaDosis(rs.getDate("fecha_proxima_dosis"));
        ev.setLote(rs.getString("lote"));
        ev.setObservaciones(rs.getString("observaciones"));
        return ev;
    }
}