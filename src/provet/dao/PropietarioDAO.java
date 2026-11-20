
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Propietario;
import provet.utilidades.dbConection;

public class PropietarioDAO {

    public boolean insert(Propietario obj) {
        String sql = "INSERT INTO propietarios (nombre, telefono, correo, direccion, is_active) VALUES (?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTelefono());
            ps.setString(3, obj.getCorreo());
            ps.setString(4, obj.getDireccion());
            ps.setBoolean(5, obj.isActive());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdPropietario(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en PropietarioDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Propietario selectById(int idPropietario) {
        String sql = "SELECT * FROM propietarios WHERE id_propietario = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPropietario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en PropietarioDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Propietario> selectAll() {
        List<Propietario> lista = new ArrayList<>();
        String sql = "SELECT * FROM propietarios";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en PropietarioDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Propietario obj) {
        String sql = "UPDATE propietarios SET nombre = ?, telefono = ?, correo = ?, direccion = ?, is_active = ? WHERE id_propietario = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTelefono());
            ps.setString(3, obj.getCorreo());
            ps.setString(4, obj.getDireccion());
            ps.setBoolean(5, obj.isActive());
            ps.setInt(6, obj.getIdPropietario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en PropietarioDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idPropietario) {
        String sql = "DELETE FROM propietarios WHERE id_propietario = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPropietario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en PropietarioDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Propietario mapear(ResultSet rs) throws SQLException {
        Propietario p = new Propietario();
        p.setIdPropietario(rs.getInt("id_propietario"));
        p.setNombre(rs.getString("nombre"));
        p.setTelefono(rs.getString("telefono"));
        p.setCorreo(rs.getString("correo"));
        p.setDireccion(rs.getString("direccion"));
        p.setActive(rs.getBoolean("is_active"));
        p.setCreatedAt(rs.getTimestamp("created_at"));
        return p;
    }
}