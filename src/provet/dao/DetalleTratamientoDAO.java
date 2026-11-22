
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.DetalleTratamiento;
import provet.utilidades.dbConection;

public class DetalleTratamientoDAO {

    public boolean insert(DetalleTratamiento obj) {
        String sql = "INSERT INTO detalle_tratamiento (id_receta, medicamento, dosis, frecuencia, duracion_dias, fecha_inicio, fecha_fin, estado, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdReceta());
            ps.setString(2, obj.getMedicamento());
            ps.setString(3, obj.getDosis());
            ps.setString(4, obj.getFrecuencia());
            if (obj.getDuracionDias() != null) ps.setInt(5, obj.getDuracionDias());
            else ps.setNull(5, Types.SMALLINT);
            ps.setDate(6, obj.getFechaInicio());
            ps.setDate(7, obj.getFechaFin());
            ps.setString(8, obj.getEstado() != null ? obj.getEstado() : "Activo");
            ps.setString(9, obj.getObservaciones());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdDetalle(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en DetalleTratamientoDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public DetalleTratamiento selectById(int idDetalle) {
        String sql = "SELECT * FROM detalle_tratamiento WHERE id_detalle = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idDetalle);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en DetalleTratamientoDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<DetalleTratamiento> selectAll() {
        List<DetalleTratamiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_tratamiento";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en DetalleTratamientoDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(DetalleTratamiento obj) {
        String sql = "UPDATE detalle_tratamiento SET id_receta = ?, medicamento = ?, dosis = ?, frecuencia = ?, duracion_dias = ?, fecha_inicio = ?, fecha_fin = ?, estado = ?, observaciones = ? WHERE id_detalle = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdReceta());
            ps.setString(2, obj.getMedicamento());
            ps.setString(3, obj.getDosis());
            ps.setString(4, obj.getFrecuencia());
            if (obj.getDuracionDias() != null) ps.setInt(5, obj.getDuracionDias());
            else ps.setNull(5, Types.SMALLINT);
            ps.setDate(6, obj.getFechaInicio());
            ps.setDate(7, obj.getFechaFin());
            ps.setString(8, obj.getEstado());
            ps.setString(9, obj.getObservaciones());
            ps.setInt(10, obj.getIdDetalle());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en DetalleTratamientoDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idDetalle) {
        String sql = "DELETE FROM detalle_tratamiento WHERE id_detalle = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idDetalle);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en DetalleTratamientoDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private DetalleTratamiento mapear(ResultSet rs) throws SQLException {
        DetalleTratamiento dt = new DetalleTratamiento();
        dt.setIdDetalle(rs.getInt("id_detalle"));
        dt.setIdReceta(rs.getInt("id_receta"));
        dt.setMedicamento(rs.getString("medicamento"));
        dt.setDosis(rs.getString("dosis"));
        dt.setFrecuencia(rs.getString("frecuencia"));
        dt.setDuracionDias(rs.getObject("duracion_dias", Integer.class));
        dt.setFechaInicio(rs.getDate("fecha_inicio"));
        dt.setFechaFin(rs.getDate("fecha_fin"));
        dt.setEstado(rs.getString("estado"));
        dt.setObservaciones(rs.getString("observaciones"));
        return dt;
    }
}