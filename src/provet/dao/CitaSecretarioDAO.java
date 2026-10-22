package provet.dao;

import provet.utilidades.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO del secretario para gestionar citas.
 * Maneja trn_cita con JOINs a mts_cliente, mts_persona, mts_mascota, cat_estatus_cita.
 */
public class CitaSecretarioDAO {

    // ---------- MODELO INTERNO ----------
    public static class CitaDTO {
        public int idCita;
        public int idCliente;
        public Integer idMascota;
        public int idEstatusCita;
        public String estatusCita;       // "Pendiente", "Cancelada", "Atendida"
        public Timestamp fechaProgramada;
        public String motivo;
        // Datos del cliente/mascota
        public String nombreCliente;
        public String telefonoCliente;
        public String nombreMascota;
        public String especie;
    }

    // ---------- SELECCIONAR TODAS ----------
    public List<CitaDTO> selectAll() {
        List<CitaDTO> lista = new ArrayList<>();
        String sql =
            "SELECT tc.id_cita, tc.id_cliente, tc.id_mascota, tc.id_estatus_cita, " +
            "       ec.nom_estatus_cita, tc.fecha_programada, tc.motivo, " +
            "       CONCAT(p.nombre,' ',p.apellido_paterno) AS nom_cliente, " +
            "       p.telefono, " +
            "       m.nombre AS nom_mascota, " +
            "       esp.nombre_especie " +
            "FROM trn_cita tc " +
            "JOIN mts_cliente c       ON tc.id_cliente       = c.id_cliente " +
            "JOIN mts_persona p       ON c.id_persona        = p.id_persona " +
            "JOIN cat_estatus_cita ec ON tc.id_estatus_cita  = ec.id_estatus_cita " +
            "LEFT JOIN mts_mascota m  ON tc.id_mascota       = m.id_mascota " +
            "LEFT JOIN cat_raza r     ON m.id_raza           = r.id_raza " +
            "LEFT JOIN cat_especie esp ON r.id_especie       = esp.id_especie " +
            "ORDER BY tc.fecha_programada DESC";
        Connection conn = Conexion.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearCita(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar citas: " + e.getMessage());
        }
        return lista;
    }

    // ---------- SOLO CITAS PENDIENTES DE HOY ----------
    public List<CitaDTO> selectPendientesHoy() {
        List<CitaDTO> lista = new ArrayList<>();
        String sql =
            "SELECT tc.id_cita, tc.id_cliente, tc.id_mascota, tc.id_estatus_cita, " +
            "       ec.nom_estatus_cita, tc.fecha_programada, tc.motivo, " +
            "       CONCAT(p.nombre,' ',p.apellido_paterno) AS nom_cliente, " +
            "       p.telefono, " +
            "       m.nombre AS nom_mascota, " +
            "       esp.nombre_especie " +
            "FROM trn_cita tc " +
            "JOIN mts_cliente c       ON tc.id_cliente       = c.id_cliente " +
            "JOIN mts_persona p       ON c.id_persona        = p.id_persona " +
            "JOIN cat_estatus_cita ec ON tc.id_estatus_cita  = ec.id_estatus_cita " +
            "LEFT JOIN mts_mascota m  ON tc.id_mascota       = m.id_mascota " +
            "LEFT JOIN cat_raza r     ON m.id_raza           = r.id_raza " +
            "LEFT JOIN cat_especie esp ON r.id_especie       = esp.id_especie " +
            "WHERE DATE(tc.fecha_programada) = CURDATE() " +
            "  AND tc.id_estatus_cita = 1 " +    // 1 = Pendiente
            "ORDER BY tc.fecha_programada";
        Connection conn = Conexion.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearCita(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar citas pendientes: " + e.getMessage());
        }
        return lista;
    }

    // ---------- CONTAR CITAS PENDIENTES HOY (para el Dashboard) ----------
    public int contarPendientesHoy() {
        Connection conn = Conexion.getConexion();
        if (conn == null) return 0;
        String sql = "SELECT COUNT(*) FROM trn_cita WHERE DATE(fecha_programada)=CURDATE() AND id_estatus_cita=1";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("Error al contar citas: " + e.getMessage());
        }
        return 0;
    }

    // ---------- INSERTAR CITA ----------
    /**
     * Inserta una cita nueva. El cliente se busca/crea por email del propietario.
     * Retorna id_cita generado, -1 si falla.
     */
    public int insertar(int idCliente, Integer idMascota, String fechaHora, String motivo) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return -1;
        String sql = "INSERT INTO trn_cita (id_cliente, id_mascota, id_estatus_cita, fecha_programada, motivo) VALUES (?,?,1,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, idCliente);
            if (idMascota != null) ps.setInt(2, idMascota);
            else ps.setNull(2, Types.INTEGER);
            ps.setString(3, fechaHora); // formato "yyyy-MM-dd HH:mm:ss"
            ps.setString(4, motivo);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar cita: " + e.getMessage());
        }
        return -1;
    }

    /**
     * Inserta cita buscando/creando cliente por nombre y teléfono (flujo desde AgendarCitas).
     */
    public int insertarConNombre(String nombreMascota, String razaMascota, String especie,
                                  String fechaHora, String motivo, String descripcion) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return -1;

        try {
            conn.setAutoCommit(false);

            // Buscar mascota por nombre
            int idMascota = -1;
            int idCliente = -1;
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT m.id_mascota, m.id_cliente FROM mts_mascota m WHERE m.nombre=? LIMIT 1")) {
                ps.setString(1, nombreMascota);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idMascota = rs.getInt("id_mascota");
                        idCliente = rs.getInt("id_cliente");
                    }
                }
            }

            // Si no encontró mascota, buscar cliente genérico o crear uno temporal
            if (idCliente == -1) {
                // Crear persona temporal para el registro
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO mts_persona (nombre, apellido_paterno, email) VALUES (?,'-','sin_email@patitascare.mx')",
                        Statement.RETURN_GENERATED_KEYS)) {
                    ps.setString(1, nombreMascota.isEmpty() ? "Sin nombre" : nombreMascota);
                    ps.executeUpdate();
                    int idPersona;
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        idPersona = rs.next() ? rs.getInt(1) : -1;
                    }
                    if (idPersona > 0) {
                        try (PreparedStatement ps2 = conn.prepareStatement(
                                "INSERT INTO mts_cliente (id_persona, id_estatus) VALUES (?,2)",
                                Statement.RETURN_GENERATED_KEYS)) {
                            ps2.setInt(1, idPersona);
                            ps2.executeUpdate();
                            try (ResultSet rs = ps2.getGeneratedKeys()) {
                                if (rs.next()) idCliente = rs.getInt(1);
                            }
                        }
                    }
                }
            }

            if (idCliente == -1) { conn.rollback(); conn.setAutoCommit(true); return -1; }

            // Insertar cita
            String motivoCompleto = motivo + (descripcion != null && !descripcion.trim().isEmpty() ? " - " + descripcion : "");
            String sql = "INSERT INTO trn_cita (id_cliente, id_mascota, id_estatus_cita, fecha_programada, motivo) VALUES (?,?,1,?,?)";
            int idCita = -1;
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, idCliente);
                if (idMascota > 0) ps.setInt(2, idMascota);
                else ps.setNull(2, Types.INTEGER);
                ps.setString(3, fechaHora);
                ps.setString(4, motivoCompleto.length() > 255 ? motivoCompleto.substring(0, 255) : motivoCompleto);
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) idCita = rs.getInt(1);
                }
            }

            conn.commit();
            conn.setAutoCommit(true);
            return idCita;
        } catch (SQLException e) {
            System.err.println("Error al insertar cita con nombre: " + e.getMessage());
            try { conn.rollback(); conn.setAutoCommit(true); } catch (SQLException ex2) { /* ignore */ }
            return -1;
        }
    }

    // ---------- ACTUALIZAR ESTATUS ----------
    public boolean actualizarEstatus(int idCita, int nuevoEstatus) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE trn_cita SET id_estatus_cita=? WHERE id_cita=?")) {
            ps.setInt(1, nuevoEstatus);
            ps.setInt(2, idCita);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar estatus cita: " + e.getMessage());
            return false;
        }
    }

    // ---------- ACTUALIZAR CITA ----------
    public boolean actualizar(int idCita, String nuevaFechaHora, String nuevoMotivo) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE trn_cita SET fecha_programada=?, motivo=? WHERE id_cita=?")) {
            ps.setString(1, nuevaFechaHora);
            ps.setString(2, nuevoMotivo);
            ps.setInt(3, idCita);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar cita: " + e.getMessage());
            return false;
        }
    }

    // ---------- ELIMINAR CITA ----------
    public boolean eliminar(int idCita) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return false;
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM trn_cita WHERE id_cita=?")) {
            ps.setInt(1, idCita);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar cita: " + e.getMessage());
            return false;
        }
    }

    // ---------- BUSCAR CLIENTE POR NOMBRE DE MASCOTA ----------
    public int getIdClientePorMascota(String nombreMascota) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return -1;
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT id_cliente FROM mts_mascota WHERE nombre=? LIMIT 1")) {
            ps.setString(1, nombreMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar cliente por mascota: " + e.getMessage());
        }
        return -1;
    }

    // ---------- OBTENER MASCOTAS PARA COMBO ----------
    public List<String[]> getMascotas() {
        // Retorna [id_mascota, nombre, especie]
        List<String[]> lista = new ArrayList<>();
        Connection conn = Conexion.getConexion();
        if (conn == null) return lista;
        String sql = "SELECT m.id_mascota, m.nombre, e.nombre_especie " +
                     "FROM mts_mascota m " +
                     "JOIN cat_raza r ON m.id_raza=r.id_raza " +
                     "JOIN cat_especie e ON r.id_especie=e.id_especie " +
                     "ORDER BY m.nombre";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new String[]{
                    String.valueOf(rs.getInt("id_mascota")),
                    rs.getString("nombre"),
                    rs.getString("nombre_especie")
                });
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener mascotas: " + e.getMessage());
        }
        return lista;
    }

    // ---------- HELPER ----------
    private CitaDTO mapearCita(ResultSet rs) throws SQLException {
        CitaDTO d = new CitaDTO();
        d.idCita          = rs.getInt("id_cita");
        d.idCliente       = rs.getInt("id_cliente");
        d.idMascota       = rs.getObject("id_mascota") != null ? rs.getInt("id_mascota") : null;
        d.idEstatusCita   = rs.getInt("id_estatus_cita");
        d.estatusCita     = rs.getString("nom_estatus_cita");
        d.fechaProgramada = rs.getTimestamp("fecha_programada");
        d.motivo          = rs.getString("motivo");
        d.nombreCliente   = rs.getString("nom_cliente");
        d.telefonoCliente = rs.getString("telefono");
        d.nombreMascota   = rs.getString("nom_mascota");
        d.especie         = rs.getString("nombre_especie");
        return d;
    }
}
