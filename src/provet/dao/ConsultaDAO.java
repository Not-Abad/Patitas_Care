
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Consulta;
import provet.utilidades.dbConection;

public class ConsultaDAO {

    public boolean insert(Consulta obj) {
        String sql = "INSERT INTO consultas (id_cita, id_mascota, id_veterinario, fecha_consulta, peso_registrado_kg, temperatura_c, frecuencia_cardiaca, motivo_consulta, exploracion_fisica, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdCita());
            ps.setInt(2, obj.getIdMascota());
            ps.setInt(3, obj.getIdVeterinario());
            ps.setTimestamp(4, obj.getFechaConsulta());
            ps.setBigDecimal(5, obj.getPesoRegistradoKg());
            ps.setBigDecimal(6, obj.getTemperaturaC());
            if (obj.getFrecuenciaCardiaca() != null) ps.setInt(7, obj.getFrecuenciaCardiaca());
            else ps.setNull(7, Types.SMALLINT);
            ps.setString(8, obj.getMotivoConsulta());
            ps.setString(9, obj.getExploracionFisica());
            ps.setString(10, obj.getObservaciones());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdConsulta(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en ConsultaDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public Consulta selectById(int idConsulta) {
        String sql = "SELECT * FROM consultas WHERE id_consulta = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idConsulta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en ConsultaDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<Consulta> selectAll() {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consultas";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en ConsultaDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(Consulta obj) {
        String sql = "UPDATE consultas SET id_cita = ?, id_mascota = ?, id_veterinario = ?, fecha_consulta = ?, peso_registrado_kg = ?, temperatura_c = ?, frecuencia_cardiaca = ?, motivo_consulta = ?, exploracion_fisica = ?, observaciones = ? WHERE id_consulta = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdCita());
            ps.setInt(2, obj.getIdMascota());
            ps.setInt(3, obj.getIdVeterinario());
            ps.setTimestamp(4, obj.getFechaConsulta());
            ps.setBigDecimal(5, obj.getPesoRegistradoKg());
            ps.setBigDecimal(6, obj.getTemperaturaC());
            if (obj.getFrecuenciaCardiaca() != null) ps.setInt(7, obj.getFrecuenciaCardiaca());
            else ps.setNull(7, Types.SMALLINT);
            ps.setString(8, obj.getMotivoConsulta());
            ps.setString(9, obj.getExploracionFisica());
            ps.setString(10, obj.getObservaciones());
            ps.setInt(11, obj.getIdConsulta());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en ConsultaDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idConsulta) {
        String sql = "DELETE FROM consultas WHERE id_consulta = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idConsulta);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en ConsultaDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private Consulta mapear(ResultSet rs) throws SQLException {
        Consulta c = new Consulta();
        c.setIdConsulta(rs.getInt("id_consulta"));
        c.setIdCita(rs.getInt("id_cita"));
        c.setIdMascota(rs.getInt("id_mascota"));
        c.setIdVeterinario(rs.getInt("id_veterinario"));
        c.setFechaConsulta(rs.getTimestamp("fecha_consulta"));
        c.setPesoRegistradoKg(rs.getBigDecimal("peso_registrado_kg"));
        c.setTemperaturaC(rs.getBigDecimal("temperatura_c"));
        c.setFrecuenciaCardiaca(rs.getObject("frecuencia_cardiaca", Integer.class));
        c.setMotivoConsulta(rs.getString("motivo_consulta"));
        c.setExploracionFisica(rs.getString("exploracion_fisica"));
        c.setObservaciones(rs.getString("observaciones"));
        return c;
    }
}