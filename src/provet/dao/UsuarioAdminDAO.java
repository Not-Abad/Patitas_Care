
package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.utilidades.dbConection;

public class UsuarioAdminDAO {

    public static class UsuarioAdmin {
        private int id;
        private int idPersonal;
        private String nombre;
        private String apellido = "";
        private String correo;
        private String telefono;
        private String especialidad;
        private String cedula;
        private String estado;
        private String usuario;
        private String password;
        private String rol;
        private double sueldoBase;
        private java.util.Date fechaContratacion;
        private String fotoPerfil;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public int getIdPersonal() { return idPersonal; }
        public void setIdPersonal(int idPersonal) { this.idPersonal = idPersonal; }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }

        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }

        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }

        public String getEspecialidad() { return especialidad; }
        public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

        public String getCedula() { return cedula; }
        public void setCedula(String cedula) { this.cedula = cedula; }

        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }

        public String getUsuario() { return usuario; }
        public void setUsuario(String usuario) { this.usuario = usuario; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }

        public String getRol() { return rol; }
        public void setRol(String rol) { this.rol = rol; }

        public double getSueldoBase() { return sueldoBase; }
        public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }

        public java.util.Date getFechaContratacion() { return fechaContratacion; }
        public void setFechaContratacion(java.util.Date fechaContratacion) { this.fechaContratacion = fechaContratacion; }

        public String getFotoPerfil() { return fotoPerfil; }
        public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }
    }

    public List<UsuarioAdmin> selectAll() {
        List<UsuarioAdmin> lista = new ArrayList<>();
        String sql = "SELECT u.id_usuario, u.username, u.password_hash, u.is_active, "
                   + "r.nombre AS rol_nombre, "
                   + "p.id_personal, p.nombre AS personal_nombre, p.telefono, p.correo, "
                   + "p.especialidad, p.cedula_profesional, p.fecha_contratacion "
                   + "FROM usuarios u "
                   + "INNER JOIN roles r ON u.id_rol = r.id_rol "
                   + "LEFT JOIN personal p ON p.id_usuario = u.id_usuario "
                   + "WHERE u.is_active = 1 "
                   + "ORDER BY u.id_usuario ASC";

        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UsuarioAdmin u = new UsuarioAdmin();
                u.setId(rs.getInt("id_usuario"));
                u.setIdPersonal(rs.getInt("id_personal"));
                u.setUsuario(rs.getString("username"));
                u.setPassword(rs.getString("password_hash"));
                u.setEstado(rs.getInt("is_active") == 1 ? "Activo" : "Inactivo");
                u.setRol(rs.getString("rol_nombre"));

                String nombreCompleto = rs.getString("personal_nombre");
                u.setNombre(nombreCompleto != null ? nombreCompleto : rs.getString("username"));
                u.setApellido("");
                u.setTelefono(rs.getString("telefono") != null ? rs.getString("telefono") : "");
                u.setCorreo(rs.getString("correo") != null ? rs.getString("correo") : "");
                u.setEspecialidad(rs.getString("especialidad") != null ? rs.getString("especialidad") : "");
                u.setCedula(rs.getString("cedula_profesional") != null ? rs.getString("cedula_profesional") : "");
                u.setFechaContratacion(rs.getDate("fecha_contratacion"));
                u.setSueldoBase(0.0);
                lista.add(u);
            }
        } catch (SQLException e) {
            System.err.println("Error en UsuarioAdminDAO.selectAll: " + e.getMessage());
        }
        return lista;
    }

    public int insert(UsuarioAdmin u, int idUsuarioEjecutor) {
        Connection conn = dbConection.getConexion();
        if (conn == null) return 0;

        try {
            conn.setAutoCommit(false);

            int idRol = obtenerOInsertarRol(conn, u.getRol());
            String sqlUser = "INSERT INTO usuarios (id_rol, username, password_hash, is_active) VALUES (?, ?, ?, 1)";
            int idNuevoUsuario;

            try (PreparedStatement ps = conn.prepareStatement(sqlUser, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, idRol);
                ps.setString(2, u.getUsuario());
                ps.setString(3, (u.getPassword() != null && !u.getPassword().isBlank()) ? u.getPassword() : "123456");
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (!rs.next()) throw new SQLException("No se generó id_usuario.");
                    idNuevoUsuario = rs.getInt(1);
                }
            }

            String nombreCompleto = (u.getNombre() + " " + (u.getApellido() != null ? u.getApellido() : "")).trim();
            String sqlPers = "INSERT INTO personal (id_usuario, nombre, telefono, correo, especialidad, cedula_profesional, fecha_contratacion, is_active) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, 1)";
            try (PreparedStatement ps = conn.prepareStatement(sqlPers)) {
                ps.setInt(1, idNuevoUsuario);
                ps.setString(2, nombreCompleto.isEmpty() ? u.getUsuario() : nombreCompleto);
                ps.setString(3, vacioANull(u.getTelefono()));
                ps.setString(4, vacioANull(u.getCorreo()));
                ps.setString(5, vacioANull(u.getEspecialidad()));
                ps.setString(6, vacioANull(u.getCedula()));
                ps.setDate(7, u.getFechaContratacion() != null
                        ? new java.sql.Date(u.getFechaContratacion().getTime())
                        : new java.sql.Date(System.currentTimeMillis()));
                ps.executeUpdate();
            }

            registrarBitacora(conn, idUsuarioEjecutor, "usuarios", idNuevoUsuario, "INSERT",
                    "Alta de usuario: " + u.getUsuario() + " (" + u.getRol() + ")");

            conn.commit();
            return idNuevoUsuario;
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ignored) {}
            System.err.println("Error en UsuarioAdminDAO.insert: " + e.getMessage());
            return 0;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }

    public int update(UsuarioAdmin u, int idUsuarioEjecutor) {
        Connection conn = dbConection.getConexion();
        if (conn == null) return 0;

        try {
            conn.setAutoCommit(false);

            int idRol = obtenerOInsertarRol(conn, u.getRol());
            String sqlUser = "UPDATE usuarios SET id_rol = ?, username = ? WHERE id_usuario = ?";
            try (PreparedStatement ps = conn.prepareStatement(sqlUser)) {
                ps.setInt(1, idRol);
                ps.setString(2, u.getUsuario());
                ps.setInt(3, u.getId());
                ps.executeUpdate();
            }

            String nombreCompleto = (u.getNombre() + " " + (u.getApellido() != null ? u.getApellido() : "")).trim();
            String sqlPers = "UPDATE personal SET nombre = ?, telefono = ?, correo = ?, especialidad = ?, cedula_profesional = ? "
                           + "WHERE id_usuario = ?";
            int filasPers;
            try (PreparedStatement ps = conn.prepareStatement(sqlPers)) {
                ps.setString(1, nombreCompleto.isEmpty() ? u.getUsuario() : nombreCompleto);
                ps.setString(2, vacioANull(u.getTelefono()));
                ps.setString(3, vacioANull(u.getCorreo()));
                ps.setString(4, vacioANull(u.getEspecialidad()));
                ps.setString(5, vacioANull(u.getCedula()));
                ps.setInt(6, u.getId());
                filasPers = ps.executeUpdate();
            }

            if (filasPers == 0) {
                String sqlInsertPers = "INSERT INTO personal (id_usuario, nombre, telefono, correo, especialidad, cedula_profesional, fecha_contratacion, is_active) "
                                     + "VALUES (?, ?, ?, ?, ?, ?, CURDATE(), 1)";
                try (PreparedStatement ps = conn.prepareStatement(sqlInsertPers)) {
                    ps.setInt(1, u.getId());
                    ps.setString(2, nombreCompleto.isEmpty() ? u.getUsuario() : nombreCompleto);
                    ps.setString(3, vacioANull(u.getTelefono()));
                    ps.setString(4, vacioANull(u.getCorreo()));
                    ps.setString(5, vacioANull(u.getEspecialidad()));
                    ps.setString(6, vacioANull(u.getCedula()));
                    ps.executeUpdate();
                }
            }

            registrarBitacora(conn, idUsuarioEjecutor, "usuarios", u.getId(), "UPDATE",
                    "Actualización de usuario: " + u.getUsuario());

            conn.commit();
            return 1;
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ignored) {}
            System.err.println("Error en UsuarioAdminDAO.update: " + e.getMessage());
            return 0;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }

    public int delete(int idUsuarioEliminar, int idUsuarioEjecutor) {
        Connection conn = dbConection.getConexion();
        if (conn == null) return 0;

        try {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement("UPDATE usuarios SET is_active = 0 WHERE id_usuario = ?")) {
                ps.setInt(1, idUsuarioEliminar);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement("UPDATE personal SET is_active = 0 WHERE id_usuario = ?")) {
                ps.setInt(1, idUsuarioEliminar);
                ps.executeUpdate();
            }

            registrarBitacora(conn, idUsuarioEjecutor, "usuarios", idUsuarioEliminar, "DELETE",
                    "Baja lógica de usuario ID: " + idUsuarioEliminar);

            conn.commit();
            return 1;
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ignored) {}
            System.err.println("Error en UsuarioAdminDAO.delete: " + e.getMessage());
            return 0;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }

    private int obtenerOInsertarRol(Connection conn, String nombreRol) throws SQLException {
        String rolLimpio = (nombreRol != null && !nombreRol.isBlank()) ? nombreRol.trim() : "Secretario";
        String sqlBuscar = "SELECT id_rol FROM roles WHERE LOWER(nombre) = LOWER(?) LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(sqlBuscar)) {
            ps.setString(1, rolLimpio);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt("id_rol");
            }
        }
        String sqlInsert = "INSERT INTO roles (nombre) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, rolLimpio);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return 1;
    }

    private void registrarBitacora(Connection conn, int idUsuario, String tabla, int idReg, String accion, String desc) {
        if (idUsuario <= 0) return;
        String sql = "INSERT INTO bitacora_movimientos (id_usuario, tabla_afectada, id_registro_afectado, accion, descripcion) "
                   + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.setString(2, tabla);
            ps.setInt(3, idReg);
            ps.setString(4, accion);
            ps.setString(5, desc);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("No se pudo registrar en bitácora: " + e.getMessage());
        }
    }

    private String vacioANull(String valor) {
        return (valor == null || valor.trim().isEmpty()) ? null : valor.trim();
    }
}