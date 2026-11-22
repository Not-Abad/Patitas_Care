
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.AnalisisClinico;
import provet.utilidades.dbConection;

public class AnalisisClinicoDAO {

    public boolean insert(AnalisisClinico obj) {
        String sql = "INSERT INTO analisis_clinicos (id_mascota, id_consulta, id_diagnostico, id_veterinario, tipo_analisis, resultados, observaciones, fecha_resultado, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdMascota());
            if (obj.getIdConsulta() != null) ps.setInt(2, obj.getIdConsulta());
            else ps.setNull(2, Types.INTEGER);
            if (obj.getIdDiagnostico() != null) ps.setInt(3, obj.getIdDiagnostico());
            else ps.setNull(3, Types.INTEGER);
            ps.setInt(4, obj.getIdVeterinario());
            ps.setString(5, obj.getTipoAnalisis());
            ps.setString(6, obj.getResultados());
            ps.setString(7, obj.getObservaciones());
            ps.setTimestamp(8, obj.getFechaResultado());
            ps.setString(9, obj.getEstado() != null ? obj.getEstado() : "Solicitado");
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdAnalisis(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en AnalisisClinicoDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public AnalisisClinico selectById(int idAnalisis) {
        String sql = "SELECT * FROM analisis_clinicos WHERE id_analisis = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAnalisis);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en AnalisisClinicoDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<AnalisisClinico> selectAll() {
        List<AnalisisClinico> lista = new ArrayList<>();
        String sql = "SELECT * FROM analisis_clinicos";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en AnalisisClinicoDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(AnalisisClinico obj) {
        String sql = "UPDATE analisis_clinicos SET id_mascota = ?, id_consulta = ?, id_diagnostico = ?, id_veterinario = ?, tipo_analisis = ?, resultados = ?, observaciones = ?, fecha_resultado = ?, estado = ? WHERE id_analisis = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdMascota());
            if (obj.getIdConsulta() != null) ps.setInt(2, obj.getIdConsulta());
            else ps.setNull(2, Types.INTEGER);
            if (obj.getIdDiagnostico() != null) ps.setInt(3, obj.getIdDiagnostico());
            else ps.setNull(3, Types.INTEGER);
            ps.setInt(4, obj.getIdVeterinario());
            ps.setString(5, obj.getTipoAnalisis());
            ps.setString(6, obj.getResultados());
            ps.setString(7, obj.getObservaciones());
            ps.setTimestamp(8, obj.getFechaResultado());
            ps.setString(9, obj.getEstado());
            ps.setInt(10, obj.getIdAnalisis());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en AnalisisClinicoDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idAnalisis) {
        String sql = "DELETE FROM analisis_clinicos WHERE id_analisis = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAnalisis);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en AnalisisClinicoDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private AnalisisClinico mapear(ResultSet rs) throws SQLException {
        AnalisisClinico a = new AnalisisClinico();
        a.setIdAnalisis(rs.getInt("id_analisis"));
        a.setIdMascota(rs.getInt("id_mascota"));
        a.setIdConsulta(rs.getObject("id_consulta", Integer.class));
        a.setIdDiagnostico(rs.getObject("id_diagnostico", Integer.class));
        a.setIdVeterinario(rs.getInt("id_veterinario"));
        a.setTipoAnalisis(rs.getString("tipo_analisis"));
        a.setResultados(rs.getString("resultados"));
        a.setObservaciones(rs.getString("observaciones"));
        a.setFechaSolicitud(rs.getTimestamp("fecha_solicitud"));
        a.setFechaResultado(rs.getTimestamp("fecha_resultado"));
        a.setEstado(rs.getString("estado"));
        return a;
    }
}