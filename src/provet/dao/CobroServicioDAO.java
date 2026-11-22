
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.CobroServicio;
import provet.utilidades.dbConection;

public class CobroServicioDAO {

    public boolean insert(CobroServicio obj) {
        String sql = "INSERT INTO cobros_servicios (id_propietario, id_mascota, id_consulta, id_usuario_registro, subtotal, total, metodo_pago, estado, motivo_cancelacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdPropietario());
            ps.setInt(2, obj.getIdMascota());
            if (obj.getIdConsulta() != null) ps.setInt(3, obj.getIdConsulta());
            else ps.setNull(3, Types.INTEGER);
            ps.setInt(4, obj.getIdUsuarioRegistro());
            ps.setBigDecimal(5, obj.getSubtotal());
            ps.setBigDecimal(6, obj.getTotal());
            ps.setString(7, obj.getMetodoPago());
            ps.setString(8, obj.getEstado() != null ? obj.getEstado() : "Pendiente");
            ps.setString(9, obj.getMotivoCancelacion());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdCobro(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en CobroServicioDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public CobroServicio selectById(int idCobro) {
        String sql = "SELECT * FROM cobros_servicios WHERE id_cobro = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCobro);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en CobroServicioDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<CobroServicio> selectAll() {
        List<CobroServicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM cobros_servicios";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en CobroServicioDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(CobroServicio obj) {
        String sql = "UPDATE cobros_servicios SET id_propietario = ?, id_mascota = ?, id_consulta = ?, id_usuario_registro = ?, subtotal = ?, total = ?, metodo_pago = ?, estado = ?, motivo_cancelacion = ? WHERE id_cobro = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdPropietario());
            ps.setInt(2, obj.getIdMascota());
            if (obj.getIdConsulta() != null) ps.setInt(3, obj.getIdConsulta());
            else ps.setNull(3, Types.INTEGER);
            ps.setInt(4, obj.getIdUsuarioRegistro());
            ps.setBigDecimal(5, obj.getSubtotal());
            ps.setBigDecimal(6, obj.getTotal());
            ps.setString(7, obj.getMetodoPago());
            ps.setString(8, obj.getEstado());
            ps.setString(9, obj.getMotivoCancelacion());
            ps.setInt(10, obj.getIdCobro());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CobroServicioDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idCobro) {
        String sql = "DELETE FROM cobros_servicios WHERE id_cobro = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCobro);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CobroServicioDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private CobroServicio mapear(ResultSet rs) throws SQLException {
        CobroServicio cs = new CobroServicio();
        cs.setIdCobro(rs.getInt("id_cobro"));
        cs.setIdPropietario(rs.getInt("id_propietario"));
        cs.setIdMascota(rs.getInt("id_mascota"));
        cs.setIdConsulta(rs.getObject("id_consulta", Integer.class));
        cs.setIdUsuarioRegistro(rs.getInt("id_usuario_registro"));
        cs.setFechaCobro(rs.getTimestamp("fecha_cobro"));
        cs.setSubtotal(rs.getBigDecimal("subtotal"));
        cs.setTotal(rs.getBigDecimal("total"));
        cs.setMetodoPago(rs.getString("metodo_pago"));
        cs.setEstado(rs.getString("estado"));
        cs.setMotivoCancelacion(rs.getString("motivo_cancelacion"));
        return cs;
    }
}