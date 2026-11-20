
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.CatalogoServicio;
import provet.utilidades.dbConection;

public class CatalogoServicioDAO {

    public boolean insert(CatalogoServicio obj) {
        String sql = "INSERT INTO catalogo_servicios (nombre, categoria, costo_base, activo) VALUES (?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getCategoria() != null ? obj.getCategoria() : "Otro");
            ps.setBigDecimal(3, obj.getCostoBase());
            ps.setBoolean(4, obj.isActivo());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdServicio(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en CatalogoServicioDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public CatalogoServicio selectById(int idServicio) {
        String sql = "SELECT * FROM catalogo_servicios WHERE id_servicio = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idServicio);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en CatalogoServicioDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<CatalogoServicio> selectAll() {
        List<CatalogoServicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM catalogo_servicios";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en CatalogoServicioDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(CatalogoServicio obj) {
        String sql = "UPDATE catalogo_servicios SET nombre = ?, categoria = ?, costo_base = ?, activo = ? WHERE id_servicio = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getCategoria());
            ps.setBigDecimal(3, obj.getCostoBase());
            ps.setBoolean(4, obj.isActivo());
            ps.setInt(5, obj.getIdServicio());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CatalogoServicioDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idServicio) {
        String sql = "DELETE FROM catalogo_servicios WHERE id_servicio = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idServicio);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en CatalogoServicioDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private CatalogoServicio mapear(ResultSet rs) throws SQLException {
        CatalogoServicio cs = new CatalogoServicio();
        cs.setIdServicio(rs.getInt("id_servicio"));
        cs.setNombre(rs.getString("nombre"));
        cs.setCategoria(rs.getString("categoria"));
        cs.setCostoBase(rs.getBigDecimal("costo_base"));
        cs.setActivo(rs.getBoolean("activo"));
        return cs;
    }
}