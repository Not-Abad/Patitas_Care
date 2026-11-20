
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Rol;
import provet.utilidades.dbConection;

public class RolDAO {

    public boolean insert(Rol obj) {
        String sql = "INSERT INTO roles (nombre) VALUES (?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNombre());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdRol(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en RolDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Rol selectById(int idRol) {
        String sql = "SELECT * FROM roles WHERE id_rol = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idRol);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en RolDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Rol> selectAll() {
        List<Rol> lista = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en RolDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Rol obj) {
        String sql = "UPDATE roles SET nombre = ? WHERE id_rol = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNombre());
            ps.setInt(2, obj.getIdRol());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en RolDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idRol) {
        String sql = "DELETE FROM roles WHERE id_rol = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idRol);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en RolDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Rol mapear(ResultSet rs) throws SQLException {
        return new Rol(rs.getInt("id_rol"), rs.getString("nombre"));
    }
}