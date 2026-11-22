
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Receta;
import provet.utilidades.dbConection;

public class RecetaDAO {

    public boolean insert(Receta obj) {
        String sql = "INSERT INTO recetas (id_diagnostico, id_veterinario, indicaciones_generales) VALUES (?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdDiagnostico());
            ps.setInt(2, obj.getIdVeterinario());
            ps.setString(3, obj.getIndicacionesGenerales());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdReceta(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en RecetaDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Receta selectById(int idReceta) {
        String sql = "SELECT * FROM recetas WHERE id_receta = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idReceta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en RecetaDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Receta> selectAll() {
        List<Receta> lista = new ArrayList<>();
        String sql = "SELECT * FROM recetas";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en RecetaDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Receta obj) {
        String sql = "UPDATE recetas SET id_diagnostico = ?, id_veterinario = ?, indicaciones_generales = ? WHERE id_receta = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdDiagnostico());
            ps.setInt(2, obj.getIdVeterinario());
            ps.setString(3, obj.getIndicacionesGenerales());
            ps.setInt(4, obj.getIdReceta());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en RecetaDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idReceta) {
        String sql = "DELETE FROM recetas WHERE id_receta = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idReceta);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en RecetaDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Receta mapear(ResultSet rs) throws SQLException {
        Receta r = new Receta();
        r.setIdReceta(rs.getInt("id_receta"));
        r.setIdDiagnostico(rs.getInt("id_diagnostico"));
        r.setIdVeterinario(rs.getInt("id_veterinario"));
        r.setFechaEmision(rs.getTimestamp("fecha_emision"));
        r.setIndicacionesGenerales(rs.getString("indicaciones_generales"));
        return r;
    }
}