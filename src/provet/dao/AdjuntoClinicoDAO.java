
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.AdjuntoClinico;
import provet.utilidades.dbConection;

public class AdjuntoClinicoDAO {

    public boolean insert(AdjuntoClinico obj) {
        String sql = "INSERT INTO adjuntos_clinicos (id_diagnostico, id_analisis, tipo_archivo, ruta_archivo, descripcion) VALUES (?, ?, ?, ?, ?)";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            if (obj.getIdDiagnostico() != null) ps.setInt(1, obj.getIdDiagnostico());
            else ps.setNull(1, Types.INTEGER);
            if (obj.getIdAnalisis() != null) ps.setInt(2, obj.getIdAnalisis());
            else ps.setNull(2, Types.INTEGER);
            ps.setString(3, obj.getTipoArchivo());
            ps.setString(4, obj.getRutaArchivo());
            ps.setString(5, obj.getDescripcion());
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) obj.setIdAdjunto(rs.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error en AdjuntoClinicoDAO.insert: " + e.getMessage());
        }
        return false;
    }

    public AdjuntoClinico selectById(int idAdjunto) {
        String sql = "SELECT * FROM adjuntos_clinicos WHERE id_adjunto = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAdjunto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en AdjuntoClinicoDAO.selectById: " + e.getMessage());
        }
        return null;
    }

    public List<AdjuntoClinico> selectAll() {
        List<AdjuntoClinico> lista = new ArrayList<>();
        String sql = "SELECT * FROM adjuntos_clinicos";
        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            System.err.println("Error en AdjuntoClinicoDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public boolean update(AdjuntoClinico obj) {
        String sql = "UPDATE adjuntos_clinicos SET id_diagnostico = ?, id_analisis = ?, tipo_archivo = ?, ruta_archivo = ?, descripcion = ? WHERE id_adjunto = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (obj.getIdDiagnostico() != null) ps.setInt(1, obj.getIdDiagnostico());
            else ps.setNull(1, Types.INTEGER);
            if (obj.getIdAnalisis() != null) ps.setInt(2, obj.getIdAnalisis());
            else ps.setNull(2, Types.INTEGER);
            ps.setString(3, obj.getTipoArchivo());
            ps.setString(4, obj.getRutaArchivo());
            ps.setString(5, obj.getDescripcion());
            ps.setInt(6, obj.getIdAdjunto());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en AdjuntoClinicoDAO.update: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int idAdjunto) {
        String sql = "DELETE FROM adjuntos_clinicos WHERE id_adjunto = ?";
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAdjunto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error en AdjuntoClinicoDAO.delete: " + e.getMessage());
            return false;
        }
    }

    private AdjuntoClinico mapear(ResultSet rs) throws SQLException {
        AdjuntoClinico ac = new AdjuntoClinico();
        ac.setIdAdjunto(rs.getInt("id_adjunto"));
        ac.setIdDiagnostico(rs.getObject("id_diagnostico", Integer.class));
        ac.setIdAnalisis(rs.getObject("id_analisis", Integer.class));
        ac.setTipoArchivo(rs.getString("tipo_archivo"));
        ac.setRutaArchivo(rs.getString("ruta_archivo"));
        ac.setDescripcion(rs.getString("descripcion"));
        ac.setFechaSubida(rs.getTimestamp("fecha_subida"));
        return ac;
    }
}