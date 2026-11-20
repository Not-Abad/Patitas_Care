
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.DetalleCobroServicio;
import provet.utilidades.dbConection;

public class DetalleCobroServicioDAO {

    public boolean insert(DetalleCobroServicio obj) {
        String sql = "INSERT INTO detalle_cobro_servicio (id_cobro, id_servicio, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdCobro());
            ps.setInt(2, obj.getIdServicio());
            ps.setInt(3, obj.getCantidad());
            ps.setBigDecimal(4, obj.getPrecioUnitario());
            ps.setBigDecimal(5, obj.getSubtotal());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdDetalleCobro(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en DetalleCobroServicioDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public DetalleCobroServicio selectById(int idDetalleCobro) {
        String sql = "SELECT * FROM detalle_cobro_servicio WHERE id_detalle_cobro = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idDetalleCobro);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en DetalleCobroServicioDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<DetalleCobroServicio> selectAll() {
        List<DetalleCobroServicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_cobro_servicio";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en DetalleCobroServicioDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(DetalleCobroServicio obj) {
        String sql = "UPDATE detalle_cobro_servicio SET id_cobro = ?, id_servicio = ?, cantidad = ?, precio_unitario = ?, subtotal = ? WHERE id_detalle_cobro = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdCobro());
            ps.setInt(2, obj.getIdServicio());
            ps.setInt(3, obj.getCantidad());
            ps.setBigDecimal(4, obj.getPrecioUnitario());
            ps.setBigDecimal(5, obj.getSubtotal());
            ps.setInt(6, obj.getIdDetalleCobro());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en DetalleCobroServicioDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idDetalleCobro) {
        String sql = "DELETE FROM detalle_cobro_servicio WHERE id_detalle_cobro = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idDetalleCobro);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en DetalleCobroServicioDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private DetalleCobroServicio mapear(ResultSet rs) throws SQLException {
        DetalleCobroServicio dcs = new DetalleCobroServicio();
        dcs.setIdDetalleCobro(rs.getInt("id_detalle_cobro"));
        dcs.setIdCobro(rs.getInt("id_cobro"));
        dcs.setIdServicio(rs.getInt("id_servicio"));
        dcs.setCantidad(rs.getInt("cantidad"));
        dcs.setPrecioUnitario(rs.getBigDecimal("precio_unitario"));
        dcs.setSubtotal(rs.getBigDecimal("subtotal"));
        return dcs;
    }
}