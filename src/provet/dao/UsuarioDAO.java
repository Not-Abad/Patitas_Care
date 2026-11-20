
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Usuario;
import provet.utilidades.dbConection;

public class UsuarioDAO {

    public boolean insert(Usuario obj) {
        String sql = "INSERT INTO usuarios (id_rol, username, password_hash, is_active, ultimo_acceso) VALUES (?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdRol());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getPasswordHash());
            ps.setBoolean(4, obj.isActive());
            ps.setTimestamp(5, obj.getUltimoAcceso());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdUsuario(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en UsuarioDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Usuario selectById(int idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en UsuarioDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Usuario> selectAll() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en UsuarioDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Usuario obj) {
        String sql = "UPDATE usuarios SET id_rol = ?, username = ?, password_hash = ?, is_active = ?, ultimo_acceso = ? WHERE id_usuario = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdRol());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getPasswordHash());
            ps.setBoolean(4, obj.isActive());
            ps.setTimestamp(5, obj.getUltimoAcceso());
            ps.setInt(6, obj.getIdUsuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en UsuarioDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en UsuarioDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Usuario mapear(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setIdUsuario(rs.getInt("id_usuario"));
        u.setIdRol(rs.getInt("id_rol"));
        u.setUsername(rs.getString("username"));
        u.setPasswordHash(rs.getString("password_hash"));
        u.setActive(rs.getBoolean("is_active"));
        u.setUltimoAcceso(rs.getTimestamp("ultimo_acceso"));
        u.setCreatedAt(rs.getTimestamp("created_at"));
        return u;
    }
}