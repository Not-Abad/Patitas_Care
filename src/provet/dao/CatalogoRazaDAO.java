
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.CatalogoRaza;
import provet.utilidades.dbConection;

public class CatalogoRazaDAO {

    public boolean insert(CatalogoRaza obj) {
        String sql = "INSERT INTO catalogo_razas (id_especie, nombre) VALUES (?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdEspecie());
            ps.setString(2, obj.getNombre());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdRaza(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en CatalogoRazaDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public CatalogoRaza selectById(int idRaza) {
        String sql = "SELECT * FROM catalogo_razas WHERE id_raza = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idRaza);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en CatalogoRazaDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<CatalogoRaza> selectAll() {
        List<CatalogoRaza> lista = new ArrayList<>();
        String sql = "SELECT * FROM catalogo_razas";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en CatalogoRazaDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(CatalogoRaza obj) {
        String sql = "UPDATE catalogo_razas SET id_especie = ?, nombre = ? WHERE id_raza = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdEspecie());
            ps.setString(2, obj.getNombre());
            ps.setInt(3, obj.getIdRaza());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CatalogoRazaDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idRaza) {
        String sql = "DELETE FROM catalogo_razas WHERE id_raza = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idRaza);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CatalogoRazaDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private CatalogoRaza mapear(ResultSet rs) throws SQLException {
        return new CatalogoRaza(rs.getInt("id_raza"), rs.getInt("id_especie"), rs.getString("nombre"));
    }
}