
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.CatalogoVacuna;
import provet.utilidades.dbConection;

public class CatalogoVacunaDAO {

    public boolean insert(CatalogoVacuna obj) {
        String sql = "INSERT INTO catalogo_vacunas (nombre, descripcion, intervalo_refuerzo_dias, is_active) VALUES (?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            if (obj.getIntervaloRefuerzoDias() != null) ps.setInt(3, obj.getIntervaloRefuerzoDias());
            else ps.setNull(3, Types.SMALLINT);
            ps.setBoolean(4, obj.isActive());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdVacuna(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en CatalogoVacunaDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public CatalogoVacuna selectById(int idVacuna) {
        String sql = "SELECT * FROM catalogo_vacunas WHERE id_vacuna = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVacuna);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en CatalogoVacunaDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<CatalogoVacuna> selectAll() {
        List<CatalogoVacuna> lista = new ArrayList<>();
        String sql = "SELECT * FROM catalogo_vacunas";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en CatalogoVacunaDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(CatalogoVacuna obj) {
        String sql = "UPDATE catalogo_vacunas SET nombre = ?, descripcion = ?, intervalo_refuerzo_dias = ?, is_active = ? WHERE id_vacuna = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            if (obj.getIntervaloRefuerzoDias() != null) ps.setInt(3, obj.getIntervaloRefuerzoDias());
            else ps.setNull(3, Types.SMALLINT);
            ps.setBoolean(4, obj.isActive());
            ps.setInt(5, obj.getIdVacuna());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CatalogoVacunaDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idVacuna) {
        String sql = "DELETE FROM catalogo_vacunas WHERE id_vacuna = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVacuna);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CatalogoVacunaDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private CatalogoVacuna mapear(ResultSet rs) throws SQLException {
        CatalogoVacuna v = new CatalogoVacuna();
        v.setIdVacuna(rs.getInt("id_vacuna"));
        v.setNombre(rs.getString("nombre"));
        v.setDescripcion(rs.getString("descripcion"));
        v.setIntervaloRefuerzoDias(rs.getObject("intervalo_refuerzo_dias", Integer.class));
        v.setActive(rs.getBoolean("is_active"));
        return v;
    }
}