
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import provet.utilidades.dbConection;

public class CitaSecretarioDAO {

    public static class CitaDTO {
        public int idCita;
        public int idMascota;
        public int idVeterinario;
        public int idUsuarioRegistro;
        public String fechaHoraInicio;
        public String fechaHoraFin;
        public String motivo;
        public String estado; // Programada, Confirmada, Completada, Cancelada, No asistio
        public boolean recordatorioEnviado;
        public String nombreMascota;
        public String especie;
        public String raza;
        public String nombreCliente;
        public String telefonoCliente;
        public String nombreVeterinario;
    }

    private Connection getConnection() throws SQLException {
        Connection conn = dbConection.getConexion();
        if (conn == null || conn.isClosed()) {
            throw new SQLException("No se pudo obtener una conexión activa desde dbConection.");
        }
        return conn;
    }

    public List<CitaDTO> selectAll() {
        return consultarCitas("ORDER BY c.fecha_hora_inicio DESC");
    }

    public List<CitaDTO> selectPendientesHoy() {
        return consultarCitas("WHERE DATE(c.fecha_hora_inicio) = CURDATE() AND c.estado IN ('Programada', 'Confirmada') ORDER BY c.fecha_hora_inicio ASC");
    }

    private List<CitaDTO> consultarCitas(String filtroSql) {
        List<CitaDTO> lista = new ArrayList<>();
        String sql = "SELECT c.id_cita, c.id_mascota, c.id_veterinario, c.id_usuario_registro, "
                   + "c.fecha_hora_inicio, c.fecha_hora_fin, c.motivo, c.estado, c.recordatorio_enviado, "
                   + "m.nombre AS nombre_mascota, e.nombre AS especie, r.nombre AS raza, "
                   + "pr.nombre AS nombre_cliente, pr.telefono AS telefono_cliente, "
                   + "per.nombre AS nombre_veterinario "
                   + "FROM citas c "
                   + "INNER JOIN mascotas m ON c.id_mascota = m.id_mascota "
                   + "INNER JOIN propietarios pr ON m.id_propietario = pr.id_propietario "
                   + "INNER JOIN catalogo_razas r ON m.id_raza = r.id_raza "
                   + "INNER JOIN catalogo_especies e ON r.id_especie = e.id_especie "
                   + "INNER JOIN personal per ON c.id_veterinario = per.id_personal "
                   + filtroSql;
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                CitaDTO d = new CitaDTO();
                d.idCita = rs.getInt("id_cita");
                d.idMascota = rs.getInt("id_mascota");
                d.idVeterinario = rs.getInt("id_veterinario");
                d.idUsuarioRegistro = rs.getInt("id_usuario_registro");
                Timestamp ini = rs.getTimestamp("fecha_hora_inicio");
                Timestamp fin = rs.getTimestamp("fecha_hora_fin");
                d.fechaHoraInicio = ini != null ? ini.toString().substring(0, 19) : "";
                d.fechaHoraFin = fin != null ? fin.toString().substring(0, 19) : "";
                d.motivo = rs.getString("motivo");
                d.estado = rs.getString("estado");
                d.recordatorioEnviado = rs.getBoolean("recordatorio_enviado");
                d.nombreMascota = rs.getString("nombre_mascota");
                d.especie = rs.getString("especie");
                d.raza = rs.getString("raza");
                d.nombreCliente = rs.getString("nombre_cliente");
                d.telefonoCliente = rs.getString("telefono_cliente");
                d.nombreVeterinario = rs.getString("nombre_veterinario");
                lista.add(d);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public int contarPendientesHoy() {
        String sql = "SELECT COUNT(*) FROM citas WHERE DATE(fecha_hora_inicio) = CURDATE() AND estado IN ('Programada', 'Confirmada')";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public Map<String, Integer> obtenerVeterinarios() {
        Map<String, Integer> mapa = new LinkedHashMap<>();
        String sql = "SELECT p.id_personal, p.nombre "
                   + "FROM personal p "
                   + "INNER JOIN usuarios u ON p.id_usuario = u.id_usuario "
                   + "INNER JOIN roles r ON u.id_rol = r.id_rol "
                   + "WHERE p.is_active = 1 AND u.is_active = 1 "
                   + "AND LOWER(r.nombre) LIKE '%veterinario%' "
                   + "ORDER BY p.nombre";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                mapa.put(rs.getString("nombre"), rs.getInt("id_personal"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mapa;
    }

    public int obtenerUsuarioActivoPorDefecto() {
        String sql = "SELECT id_usuario FROM usuarios WHERE is_active = 1 ORDER BY id_usuario ASC LIMIT 1";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    public int insertarConNombre(String nombreMascota, String raza, String especie,
                                 int idVeterinario, int idUsuarioRegistro,
                                 String fechaHoraInicio, String fechaHoraFin, String motivo) {
        try (Connection cn = getConnection()) {
            cn.setAutoCommit(false);
            try {
                if (idVeterinario <= 0) {
                    try (PreparedStatement ps = cn.prepareStatement("SELECT id_personal FROM personal WHERE is_active = 1 LIMIT 1");
                         ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) idVeterinario = rs.getInt(1);
                    }
                }
                if (idVeterinario <= 0) {
                    cn.rollback();
                    return -1;
                }

                // Buscar mascota activa existente por nombre
                int idMascota = -1;
                try (PreparedStatement ps = cn.prepareStatement(
                        "SELECT id_mascota FROM mascotas WHERE LOWER(nombre) = LOWER(?) AND estatus = 'Activo' LIMIT 1")) {
                    ps.setString(1, nombreMascota);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) idMascota = rs.getInt(1);
                    }
                }

                // Si no existe, crear propietario general + mascota
                if (idMascota == -1) {
                    int idPropietario = -1;
                    try (PreparedStatement ps = cn.prepareStatement("SELECT id_propietario FROM propietarios WHERE is_active = 1 ORDER BY id_propietario ASC LIMIT 1");
                         ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) idPropietario = rs.getInt(1);
                    }
                    if (idPropietario == -1) {
                        try (PreparedStatement ps = cn.prepareStatement(
                                "INSERT INTO propietarios (nombre, is_active) VALUES ('Propietario General', 1)",
                                Statement.RETURN_GENERATED_KEYS)) {
                            ps.executeUpdate();
                            try (ResultSet gk = ps.getGeneratedKeys()) {
                                if (gk.next()) idPropietario = gk.getInt(1);
                            }
                        }
                    }

                    MascotaSecretarioDAO mDao = new MascotaSecretarioDAO();
                    int idRaza = mDao.resolverOInsertarRaza(cn, especie, raza);

                    try (PreparedStatement ps = cn.prepareStatement(
                            "INSERT INTO mascotas (id_propietario, id_raza, nombre, sexo, estatus) VALUES (?, ?, ?, 'Macho', 'Activo')",
                            Statement.RETURN_GENERATED_KEYS)) {
                        ps.setInt(1, idPropietario);
                        ps.setInt(2, idRaza);
                        ps.setString(3, nombreMascota);
                        ps.executeUpdate();
                        try (ResultSet gk = ps.getGeneratedKeys()) {
                            if (gk.next()) idMascota = gk.getInt(1);
                        }
                    }
                }

                String sqlCita = "INSERT INTO citas (id_mascota, id_veterinario, id_usuario_registro, fecha_hora_inicio, fecha_hora_fin, motivo, estado, recordatorio_enviado) "
                               + "VALUES (?, ?, ?, ?, ?, ?, 'Programada', 0)";
                try (PreparedStatement ps = cn.prepareStatement(sqlCita, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, idMascota);
                    ps.setInt(2, idVeterinario);
                    ps.setInt(3, idUsuarioRegistro);
                    ps.setTimestamp(4, Timestamp.valueOf(fechaHoraInicio));
                    ps.setTimestamp(5, Timestamp.valueOf(fechaHoraFin));
                    ps.setString(6, motivo);
                    ps.executeUpdate();
                    try (ResultSet gk = ps.getGeneratedKeys()) {
                        if (gk.next()) {
                            int idCita = gk.getInt(1);
                            cn.commit();
                            return idCita;
                        }
                    }
                }
                cn.rollback();
            } catch (Exception e) {
                cn.rollback();
                throw e;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public boolean actualizar(int idCita, int idVeterinario, String fechaHoraInicio, String fechaHoraFin, String motivo) {
        String sql = idVeterinario > 0
            ? "UPDATE citas SET id_veterinario = ?, fecha_hora_inicio = ?, fecha_hora_fin = ?, motivo = ? WHERE id_cita = ?"
            : "UPDATE citas SET fecha_hora_inicio = ?, fecha_hora_fin = ?, motivo = ? WHERE id_cita = ?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            int idx = 1;
            if (idVeterinario > 0) ps.setInt(idx++, idVeterinario);
            ps.setTimestamp(idx++, Timestamp.valueOf(fechaHoraInicio));
            ps.setTimestamp(idx++, Timestamp.valueOf(fechaHoraFin));
            ps.setString(idx++, motivo);
            ps.setInt(idx, idCita);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean actualizarEstado(int idCita, String nuevoEstado) {
        String sql = "UPDATE citas SET estado = ? WHERE id_cita = ?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idCita);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}