
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Cita;
import provet.utilidades.dbConection;

public class CitaDAO {

    public boolean insert(Cita obj) {
        String sql = "INSERT INTO citas (id_mascota, id_veterinario, id_usuario_registro, fecha_hora_inicio, fecha_hora_fin, motivo, estado, recordatorio_enviado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdMascota());
            ps.setInt(2, obj.getIdVeterinario());
            ps.setInt(3, obj.getIdUsuarioRegistro());
            ps.setTimestamp(4, obj.getFechaHoraInicio());
            ps.setTimestamp(5, obj.getFechaHoraFin());
            ps.setString(6, obj.getMotivo());
            ps.setString(7, obj.getEstado() != null ? obj.getEstado() : "Programada");
            ps.setBoolean(8, obj.isRecordatorioEnviado());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdCita(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en CitaDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Cita selectById(int idCita) {
        String sql = "SELECT * FROM citas WHERE id_cita = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCita);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en CitaDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Cita> selectAll() {
        List<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en CitaDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Cita obj) {
        String sql = "UPDATE citas SET id_mascota = ?, id_veterinario = ?, id_usuario_registro = ?, fecha_hora_inicio = ?, fecha_hora_fin = ?, motivo = ?, estado = ?, recordatorio_enviado = ? WHERE id_cita = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdMascota());
            ps.setInt(2, obj.getIdVeterinario());
            ps.setInt(3, obj.getIdUsuarioRegistro());
            ps.setTimestamp(4, obj.getFechaHoraInicio());
            ps.setTimestamp(5, obj.getFechaHoraFin());
            ps.setString(6, obj.getMotivo());
            ps.setString(7, obj.getEstado());
            ps.setBoolean(8, obj.isRecordatorioEnviado());
            ps.setInt(9, obj.getIdCita());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CitaDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idCita) {
        String sql = "DELETE FROM citas WHERE id_cita = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCita);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CitaDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Cita mapear(ResultSet rs) throws SQLException {
        Cita c = new Cita();
        c.setIdCita(rs.getInt("id_cita"));
        c.setIdMascota(rs.getInt("id_mascota"));
        c.setIdVeterinario(rs.getInt("id_veterinario"));
        c.setIdUsuarioRegistro(rs.getInt("id_usuario_registro"));
        c.setFechaHoraInicio(rs.getTimestamp("fecha_hora_inicio"));
        c.setFechaHoraFin(rs.getTimestamp("fecha_hora_fin"));
        c.setMotivo(rs.getString("motivo"));
        c.setEstado(rs.getString("estado"));
        c.setRecordatorioEnviado(rs.getBoolean("recordatorio_enviado"));
        c.setCreatedAt(rs.getTimestamp("created_at"));
        return c;
    }
}