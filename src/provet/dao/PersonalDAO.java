
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Personal;
import provet.utilidades.dbConection;

public class PersonalDAO {

    public boolean insert(Personal obj) {
        String sql = "INSERT INTO personal (id_usuario, nombre, telefono, correo, especialidad, cedula_profesional, fecha_contratacion, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdUsuario());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getTelefono());
            ps.setString(4, obj.getCorreo());
            ps.setString(5, obj.getEspecialidad());
            ps.setString(6, obj.getCedulaProfesional());
            ps.setDate(7, obj.getFechaContratacion());
            ps.setBoolean(8, obj.isActive());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdPersonal(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en PersonalDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Personal selectById(int idPersonal) {
        String sql = "SELECT * FROM personal WHERE id_personal = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPersonal);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en PersonalDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Personal> selectAll() {
        List<Personal> lista = new ArrayList<>();
        String sql = "SELECT * FROM personal";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en PersonalDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Personal obj) {
        String sql = "UPDATE personal SET id_usuario = ?, nombre = ?, telefono = ?, correo = ?, especialidad = ?, cedula_profesional = ?, fecha_contratacion = ?, is_active = ? WHERE id_personal = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdUsuario());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getTelefono());
            ps.setString(4, obj.getCorreo());
            ps.setString(5, obj.getEspecialidad());
            ps.setString(6, obj.getCedulaProfesional());
            ps.setDate(7, obj.getFechaContratacion());
            ps.setBoolean(8, obj.isActive());
            ps.setInt(9, obj.getIdPersonal());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en PersonalDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idPersonal) {
        String sql = "DELETE FROM personal WHERE id_personal = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPersonal);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en PersonalDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Personal mapear(ResultSet rs) throws SQLException {
        Personal p = new Personal();
        p.setIdPersonal(rs.getInt("id_personal"));
        p.setIdUsuario(rs.getInt("id_usuario"));
        p.setNombre(rs.getString("nombre"));
        p.setTelefono(rs.getString("telefono"));
        p.setCorreo(rs.getString("correo"));
        p.setEspecialidad(rs.getString("especialidad"));
        p.setCedulaProfesional(rs.getString("cedula_profesional"));
        p.setFechaContratacion(rs.getDate("fecha_contratacion"));
        p.setActive(rs.getBoolean("is_active"));
        return p;
    }
}