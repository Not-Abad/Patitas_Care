
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.CatalogoEspecie;
import provet.utilidades.dbConection;

public class CatalogoEspecieDAO {

    public boolean insert(CatalogoEspecie obj) {
        String sql = "INSERT INTO catalogo_especies (nombre) VALUES (?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNombre());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdEspecie(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en CatalogoEspecieDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public CatalogoEspecie selectById(int idEspecie) {
        String sql = "SELECT * FROM catalogo_especies WHERE id_especie = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEspecie);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en CatalogoEspecieDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<CatalogoEspecie> selectAll() {
        List<CatalogoEspecie> lista = new ArrayList<>();
        String sql = "SELECT * FROM catalogo_especies";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en CatalogoEspecieDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(CatalogoEspecie obj) {
        String sql = "UPDATE catalogo_especies SET nombre = ? WHERE id_especie = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNombre());
            ps.setInt(2, obj.getIdEspecie());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CatalogoEspecieDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idEspecie) {
        String sql = "DELETE FROM catalogo_especies WHERE id_especie = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idEspecie);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CatalogoEspecieDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private CatalogoEspecie mapear(ResultSet rs) throws SQLException {
        return new CatalogoEspecie(rs.getInt("id_especie"), rs.getString("nombre"));
    }
}