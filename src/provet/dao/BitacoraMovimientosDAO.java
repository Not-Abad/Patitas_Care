package provet.dao;

import provet.utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BitacoraMovimientosDAO {

    // ==========================================
    // MÉTODO CREATE: Insertar un movimiento en la bitácora
    // ==========================================
    public int insert(BitacoraMovimiento movimiento) {
        int filasAfectadas = 0;
        String sql = "INSERT INTO bit_movimientos (id_empleado, id_accion, tabla_afectada, id_registro_afectado, valor_anterior, valor_nuevo, fecha_movimiento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, movimiento.getIdEmpleado());
                pstmt.setInt(2, movimiento.getIdAccion());
                pstmt.setString(3, movimiento.getTablaAfectada());
                pstmt.setInt(4, movimiento.getIdRegistroAfectado());
                pstmt.setString(5, movimiento.getValorAnterior());
                pstmt.setString(6, movimiento.getValorNuevo());
                pstmt.setTimestamp(7, movimiento.getFechaMovimiento());
                
                filasAfectadas = pstmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al insertar movimiento en bitácora: " + e.getMessage());
            }
        }
        return filasAfectadas;
    }

    // ==========================================
    // MÉTODO READ: Obtener todos los movimientos
    // ==========================================
    public List<BitacoraMovimiento> selectAll() {
        List<BitacoraMovimiento> lista = new ArrayList<>();
        String sql = "SELECT id_bitacora, id_empleado, id_accion, tabla_afectada, id_registro_afectado, valor_anterior, valor_nuevo, fecha_movimiento " +
                    "FROM bit_movimientos ORDER BY fecha_movimiento DESC";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    BitacoraMovimiento movimiento = new BitacoraMovimiento();
                    movimiento.setIdBitacora(rs.getInt("id_bitacora"));
                    movimiento.setIdEmpleado(rs.getInt("id_empleado"));
                    movimiento.setIdAccion(rs.getInt("id_accion"));
                    movimiento.setTablaAfectada(rs.getString("tabla_afectada"));
                    movimiento.setIdRegistroAfectado(rs.getInt("id_registro_afectado"));
                    movimiento.setValorAnterior(rs.getString("valor_anterior"));
                    movimiento.setValorNuevo(rs.getString("valor_nuevo"));
                    movimiento.setFechaMovimiento(rs.getTimestamp("fecha_movimiento"));
                    lista.add(movimiento);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener movimientos: " + e.getMessage());
            }
        }
        return lista;
    }

    // ==========================================
    // MÉTODO READ: Obtener movimientos por empleado
    // ==========================================
    public List<BitacoraMovimiento> selectByEmpleado(int idEmpleado) {
        List<BitacoraMovimiento> lista = new ArrayList<>();
        String sql = "SELECT id_bitacora, id_empleado, id_accion, tabla_afectada, id_registro_afectado, valor_anterior, valor_nuevo, fecha_movimiento " +
                    "FROM bit_movimientos WHERE id_empleado = ? ORDER BY fecha_movimiento DESC";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idEmpleado);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        BitacoraMovimiento movimiento = new BitacoraMovimiento();
                        movimiento.setIdBitacora(rs.getInt("id_bitacora"));
                        movimiento.setIdEmpleado(rs.getInt("id_empleado"));
                        movimiento.setIdAccion(rs.getInt("id_accion"));
                        movimiento.setTablaAfectada(rs.getString("tabla_afectada"));
                        movimiento.setIdRegistroAfectado(rs.getInt("id_registro_afectado"));
                        movimiento.setValorAnterior(rs.getString("valor_anterior"));
                        movimiento.setValorNuevo(rs.getString("valor_nuevo"));
                        movimiento.setFechaMovimiento(rs.getTimestamp("fecha_movimiento"));
                        lista.add(movimiento);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener movimientos por empleado: " + e.getMessage());
            }
        }
        return lista;
    }

    // ==========================================
    // MÉTODO READ: Obtener movimientos por tabla
    // ==========================================
    public List<BitacoraMovimiento> selectByTabla(String tabla) {
        List<BitacoraMovimiento> lista = new ArrayList<>();
        String sql = "SELECT id_bitacora, id_empleado, id_accion, tabla_afectada, id_registro_afectado, valor_anterior, valor_nuevo, fecha_movimiento " +
                    "FROM bit_movimientos WHERE tabla_afectada = ? ORDER BY fecha_movimiento DESC";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, tabla);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        BitacoraMovimiento movimiento = new BitacoraMovimiento();
                        movimiento.setIdBitacora(rs.getInt("id_bitacora"));
                        movimiento.setIdEmpleado(rs.getInt("id_empleado"));
                        movimiento.setIdAccion(rs.getInt("id_accion"));
                        movimiento.setTablaAfectada(rs.getString("tabla_afectada"));
                        movimiento.setIdRegistroAfectado(rs.getInt("id_registro_afectado"));
                        movimiento.setValorAnterior(rs.getString("valor_anterior"));
                        movimiento.setValorNuevo(rs.getString("valor_nuevo"));
                        movimiento.setFechaMovimiento(rs.getTimestamp("fecha_movimiento"));
                        lista.add(movimiento);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener movimientos por tabla: " + e.getMessage());
            }
        }
        return lista;
    }

    // ==========================================
    // MÉTODO AUXILIAR: Obtener ID de acción por nombre
    // ==========================================
    public int obtenerIdAccion(String nombreAccion) {
        int id = 1; // Por defecto "Sin especificar"
        String sql = "SELECT id_accion FROM cat_accion_bitacora WHERE nombre_accion = ?";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombreAccion);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        id = rs.getInt("id_accion");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener ID de acción: " + e.getMessage());
            }
        }
        return id;
    }

    // Clase interna para representar un movimiento en la bitácora
    public static class BitacoraMovimiento {
        private int idBitacora;
        private int idEmpleado;
        private int idAccion;
        private String tablaAfectada;
        private int idRegistroAfectado;
        private String valorAnterior;
        private String valorNuevo;
        private Timestamp fechaMovimiento;

        // Constructor
        public BitacoraMovimiento() {
            this.fechaMovimiento = new Timestamp(System.currentTimeMillis());
        }

        public BitacoraMovimiento(int idEmpleado, int idAccion, String tablaAfectada, int idRegistroAfectado, String valorAnterior, String valorNuevo) {
            this.idEmpleado = idEmpleado;
            this.idAccion = idAccion;
            this.tablaAfectada = tablaAfectada;
            this.idRegistroAfectado = idRegistroAfectado;
            this.valorAnterior = valorAnterior;
            this.valorNuevo = valorNuevo;
            this.fechaMovimiento = new Timestamp(System.currentTimeMillis());
        }

        // Getters y Setters
        public int getIdBitacora() { return idBitacora; }
        public void setIdBitacora(int idBitacora) { this.idBitacora = idBitacora; }
        
        public int getIdEmpleado() { return idEmpleado; }
        public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }
        
        public int getIdAccion() { return idAccion; }
        public void setIdAccion(int idAccion) { this.idAccion = idAccion; }
        
        public String getTablaAfectada() { return tablaAfectada; }
        public void setTablaAfectada(String tablaAfectada) { this.tablaAfectada = tablaAfectada; }
        
        public int getIdRegistroAfectado() { return idRegistroAfectado; }
        public void setIdRegistroAfectado(int idRegistroAfectado) { this.idRegistroAfectado = idRegistroAfectado; }
        
        public String getValorAnterior() { return valorAnterior; }
        public void setValorAnterior(String valorAnterior) { this.valorAnterior = valorAnterior; }
        
        public String getValorNuevo() { return valorNuevo; }
        public void setValorNuevo(String valorNuevo) { this.valorNuevo = valorNuevo; }
        
        public Timestamp getFechaMovimiento() { return fechaMovimiento; }
        public void setFechaMovimiento(Timestamp fechaMovimiento) { this.fechaMovimiento = fechaMovimiento; }
    }
}
