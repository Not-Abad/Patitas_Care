
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Diagnostico;
import provet.utilidades.dbConection;

public class DiagnosticoDAO {

    public boolean insert(Diagnostico obj) {
        String sql = "INSERT INTO diagnosticos (id_consulta, id_veterinario, descripcion, tipo_diagnostico, estado) VALUES (?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdConsulta());
            ps.setInt(2, obj.getIdVeterinario());
            ps.setString(3, obj.getDescripcion());
            ps.setString(4, obj.getTipoDiagnostico() != null ? obj.getTipoDiagnostico() : "Presuntivo");
            ps.setString(5, obj.getEstado() != null ? obj.getEstado() : "Activo");
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdDiagnostico(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en DiagnosticoDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Diagnostico selectById(int idDiagnostico) {
        String sql = "SELECT * FROM diagnosticos WHERE id_diagnostico = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idDiagnostico);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en DiagnosticoDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Diagnostico> selectAll() {
        List<Diagnostico> lista = new ArrayList<>();
        String sql = "SELECT * FROM diagnosticos";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en DiagnosticoDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Diagnostico obj) {
        String sql = "UPDATE diagnosticos SET id_consulta = ?, id_veterinario = ?, descripcion = ?, tipo_diagnostico = ?, estado = ? WHERE id_diagnostico = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdConsulta());
            ps.setInt(2, obj.getIdVeterinario());
            ps.setString(3, obj.getDescripcion());
            ps.setString(4, obj.getTipoDiagnostico());
            ps.setString(5, obj.getEstado());
            ps.setInt(6, obj.getIdDiagnostico());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en DiagnosticoDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idDiagnostico) {
        String sql = "DELETE FROM diagnosticos WHERE id_diagnostico = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idDiagnostico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en DiagnosticoDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Diagnostico mapear(ResultSet rs) throws SQLException {
        Diagnostico d = new Diagnostico();
        d.setIdDiagnostico(rs.getInt("id_diagnostico"));
        d.setIdConsulta(rs.getInt("id_consulta"));
        d.setIdVeterinario(rs.getInt("id_veterinario"));
        d.setDescripcion(rs.getString("descripcion"));
        d.setTipoDiagnostico(rs.getString("tipo_diagnostico"));
        d.setEstado(rs.getString("estado"));
        d.setFechaRegistro(rs.getTimestamp("fecha_registro"));
        d.setUpdatedAt(rs.getTimestamp("updated_at"));
        return d;
    }
}