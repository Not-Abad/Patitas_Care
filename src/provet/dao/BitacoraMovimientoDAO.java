
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.BitacoraMovimiento;
import provet.utilidades.dbConection;

public class BitacoraMovimientoDAO {

    public boolean insert(BitacoraMovimiento obj) {
        String sql = "INSERT INTO bitacora_movimientos (id_usuario, tabla_afectada, id_registro_afectado, accion, valor_anterior, valor_nuevo, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, obj.getIdUsuario());
            ps.setString(2, obj.getTablaAfectada());
            ps.setInt(3, obj.getIdRegistroAfectado());
            ps.setString(4, obj.getAccion());
            ps.setString(5, obj.getValorAnterior());
            ps.setString(6, obj.getValorNuevo());
            ps.setString(7, obj.getDescripcion());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdBitacora(rs.getLong(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en BitacoraMovimientoDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public BitacoraMovimiento selectById(long idBitacora) {
        String sql = "SELECT * FROM bitacora_movimientos WHERE id_bitacora = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idBitacora);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en BitacoraMovimientoDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<BitacoraMovimiento> selectAll() {
        List<BitacoraMovimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM bitacora_movimientos";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en BitacoraMovimientoDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(BitacoraMovimiento obj) {
        String sql = "UPDATE bitacora_movimientos SET id_usuario = ?, tabla_afectada = ?, id_registro_afectado = ?, accion = ?, valor_anterior = ?, valor_nuevo = ?, descripcion = ? WHERE id_bitacora = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, obj.getIdUsuario());
            ps.setString(2, obj.getTablaAfectada());
            ps.setInt(3, obj.getIdRegistroAfectado());
            ps.setString(4, obj.getAccion());
            ps.setString(5, obj.getValorAnterior());
            ps.setString(6, obj.getValorNuevo());
            ps.setString(7, obj.getDescripcion());
            ps.setLong(8, obj.getIdBitacora());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en BitacoraMovimientoDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(long idBitacora) {
        String sql = "DELETE FROM bitacora_movimientos WHERE id_bitacora = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, idBitacora);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en BitacoraMovimientoDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private BitacoraMovimiento mapear(ResultSet rs) throws SQLException {
        BitacoraMovimiento b = new BitacoraMovimiento();
        b.setIdBitacora(rs.getLong("id_bitacora"));
        b.setIdUsuario(rs.getInt("id_usuario"));
        b.setTablaAfectada(rs.getString("tabla_afectada"));
        b.setIdRegistroAfectado(rs.getInt("id_registro_afectado"));
        b.setAccion(rs.getString("accion"));
        b.setValorAnterior(rs.getString("valor_anterior"));
        b.setValorNuevo(rs.getString("valor_nuevo"));
        b.setDescripcion(rs.getString("descripcion"));
        b.setFechaHora(rs.getTimestamp("fecha_hora"));
        return b;
    }
}