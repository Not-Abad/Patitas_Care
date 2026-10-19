package provet.dao;

import provet.utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAdminDAO {

    // ==========================================
    // MÉTODO READ: Obtener todos los empleados (usuarios administrativos)
    // ==========================================
    public List<UsuarioAdmin> selectAll() {
        List<UsuarioAdmin> lista = new ArrayList<>();
        String sql = "SELECT e.id_empleado, p.nombre, p.apellido_paterno, p.apellido_materno, p.email, p.telefono, " +
                    "e.usuario, e.password, e.foto_perfil, e.sueldo_base, e.fecha_contratacion, " +
                    "cat.nombre_puesto " +
                    "FROM mts_empleado e " +
                    "JOIN mts_persona p ON e.id_persona = p.id_persona " +
                    "JOIN cat_puesto cat ON e.id_puesto = cat.id_puesto";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    UsuarioAdmin usuario = new UsuarioAdmin();
                    usuario.setId(rs.getInt("id_empleado"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido_paterno") + " " + rs.getString("apellido_materno"));
                    usuario.setCorreo(rs.getString("email"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setUsuario(rs.getString("usuario"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setFotoPerfil(rs.getString("foto_perfil"));
                    usuario.setSueldoBase(rs.getDouble("sueldo_base"));
                    usuario.setFechaContratacion(rs.getDate("fecha_contratacion"));
                    usuario.setRol(rs.getString("nombre_puesto"));
                    usuario.setEstado("Activo"); // Valor por defecto ya que mts_persona no tiene id_estatus
                    lista.add(usuario);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener usuarios: " + e.getMessage());
            }
        }
        return lista;
    }

    // ==========================================
    // MÉTODO READ: Obtener un empleado por ID
    // ==========================================
    public UsuarioAdmin selectById(int id) {
        UsuarioAdmin usuario = null;
        String sql = "SELECT e.id_empleado, p.nombre, p.apellido_paterno, p.apellido_materno, p.email, p.telefono, " +
                    "e.usuario, e.password, e.foto_perfil, e.sueldo_base, e.fecha_contratacion, " +
                    "cat.nombre_puesto " +
                    "FROM mts_empleado e " +
                    "JOIN mts_persona p ON e.id_persona = p.id_persona " +
                    "JOIN cat_puesto cat ON e.id_puesto = cat.id_puesto " +
                    "WHERE e.id_empleado = ?";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        usuario = new UsuarioAdmin();
                        usuario.setId(rs.getInt("id_empleado"));
                        usuario.setNombre(rs.getString("nombre"));
                        usuario.setApellido(rs.getString("apellido_paterno") + " " + rs.getString("apellido_materno"));
                        usuario.setCorreo(rs.getString("email"));
                        usuario.setTelefono(rs.getString("telefono"));
                        usuario.setUsuario(rs.getString("usuario"));
                        usuario.setPassword(rs.getString("password"));
                        usuario.setFotoPerfil(rs.getString("foto_perfil"));
                        usuario.setSueldoBase(rs.getDouble("sueldo_base"));
                        usuario.setFechaContratacion(rs.getDate("fecha_contratacion"));
                        usuario.setRol(rs.getString("nombre_puesto"));
                        usuario.setEstado("Activo"); // Valor por defecto
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener usuario por ID: " + e.getMessage());
            }
        }
        return usuario;
    }

    // ==========================================
    // MÉTODO CREATE: Insertar un nuevo empleado
    // ==========================================
    public int insert(UsuarioAdmin usuario) {
        int filasAfectadas = 0;
        
        // Primero insertar en mts_persona
        String sqlPersona = "INSERT INTO mts_persona (nombre, apellido_paterno, apellido_materno, email, telefono) VALUES (?, ?, ?, ?, ?)";
        String sqlEmpleado = "INSERT INTO mts_empleado (id_persona, id_puesto, usuario, password, foto_perfil, sueldo_base, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try {
                // Insertar persona
                int idPuesto = obtenerIdPuesto(usuario.getRol());
                
                try (PreparedStatement pstmtPersona = conn.prepareStatement(sqlPersona, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    String[] apellidos = usuario.getApellido().split(" ", 2);
                    String apellidoPaterno = apellidos.length > 0 ? apellidos[0] : "";
                    String apellidoMaterno = apellidos.length > 1 ? apellidos[1] : "";
                    
                    pstmtPersona.setString(1, usuario.getNombre());
                    pstmtPersona.setString(2, apellidoPaterno);
                    pstmtPersona.setString(3, apellidoMaterno);
                    pstmtPersona.setString(4, usuario.getCorreo());
                    pstmtPersona.setString(5, usuario.getTelefono());
                    
                    filasAfectadas = pstmtPersona.executeUpdate();
                    
                    if (filasAfectadas > 0) {
                        try (ResultSet rs = pstmtPersona.getGeneratedKeys()) {
                            if (rs.next()) {
                                int idPersona = rs.getInt(1);
                                
                                // Insertar empleado
                                try (PreparedStatement pstmtEmpleado = conn.prepareStatement(sqlEmpleado)) {
                                    pstmtEmpleado.setInt(1, idPersona);
                                    pstmtEmpleado.setInt(2, idPuesto);
                                    pstmtEmpleado.setString(3, usuario.getUsuario());
                                    pstmtEmpleado.setString(4, usuario.getPassword());
                                    pstmtEmpleado.setString(5, usuario.getFotoPerfil());
                                    pstmtEmpleado.setDouble(6, usuario.getSueldoBase());
                                    pstmtEmpleado.setDate(7, new java.sql.Date(usuario.getFechaContratacion().getTime()));
                                    
                                    filasAfectadas = pstmtEmpleado.executeUpdate();
                                }
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al insertar usuario: " + e.getMessage());
            }
        }
        return filasAfectadas;
    }

    // ==========================================
    // MÉTODO UPDATE: Actualizar un empleado
    // ==========================================
    public int update(UsuarioAdmin usuario) {
        int filasAfectadas = 0;
        String sqlPersona = "UPDATE mts_persona SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, email = ?, telefono = ? WHERE id_persona = (SELECT id_persona FROM mts_empleado WHERE id_empleado = ?)";
        String sqlEmpleado = "UPDATE mts_empleado SET id_puesto = ?, usuario = ?, password = ?, foto_perfil = ?, sueldo_base = ? WHERE id_empleado = ?";
        
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try {
                int idPuesto = obtenerIdPuesto(usuario.getRol());
                
                // Actualizar persona
                try (PreparedStatement pstmtPersona = conn.prepareStatement(sqlPersona)) {
                    String[] apellidos = usuario.getApellido().split(" ", 2);
                    String apellidoPaterno = apellidos.length > 0 ? apellidos[0] : "";
                    String apellidoMaterno = apellidos.length > 1 ? apellidos[1] : "";
                    
                    pstmtPersona.setString(1, usuario.getNombre());
                    pstmtPersona.setString(2, apellidoPaterno);
                    pstmtPersona.setString(3, apellidoMaterno);
                    pstmtPersona.setString(4, usuario.getCorreo());
                    pstmtPersona.setString(5, usuario.getTelefono());
                    pstmtPersona.setInt(6, usuario.getId());
                    
                    filasAfectadas = pstmtPersona.executeUpdate();
                }
                
                // Actualizar empleado
                try (PreparedStatement pstmtEmpleado = conn.prepareStatement(sqlEmpleado)) {
                    pstmtEmpleado.setInt(1, idPuesto);
                    pstmtEmpleado.setString(2, usuario.getUsuario());
                    pstmtEmpleado.setString(3, usuario.getPassword());
                    pstmtEmpleado.setString(4, usuario.getFotoPerfil());
                    pstmtEmpleado.setDouble(5, usuario.getSueldoBase());
                    pstmtEmpleado.setInt(6, usuario.getId());
                    
                    filasAfectadas = pstmtEmpleado.executeUpdate();
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar usuario: " + e.getMessage());
            }
        }
        return filasAfectadas;
    }

    // ==========================================
    // MÉTODO DELETE: Eliminar un empleado
    // ==========================================
    public int delete(int id) {
        int filasAfectadas = 0;
        String sql = "DELETE FROM mts_empleado WHERE id_empleado = ?";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                filasAfectadas = pstmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar usuario: " + e.getMessage());
            }
        }
        return filasAfectadas;
    }

    // ==========================================
    // MÉTODO AUXILIAR: Obtener ID de puesto por nombre
    // ==========================================
    private int obtenerIdPuesto(String nombrePuesto) {
        int id = 0;
        String sql = "SELECT id_puesto FROM cat_puesto WHERE nombre_puesto = ?";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombrePuesto);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        id = rs.getInt("id_puesto");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener ID de puesto: " + e.getMessage());
            }
        }
        return id;
    }

    // Clase interna para representar un usuario administrativo
    public static class UsuarioAdmin {
        private int id;
        private String nombre;
        private String apellido;
        private String correo;
        private String telefono;
        private String usuario;
        private String password;
        private String fotoPerfil;
        private double sueldoBase;
        private java.util.Date fechaContratacion;
        private String rol;
        private String estado;

        // Getters y Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        
        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }
        
        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }
        
        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }
        
        public String getUsuario() { return usuario; }
        public void setUsuario(String usuario) { this.usuario = usuario; }
        
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        
        public String getFotoPerfil() { return fotoPerfil; }
        public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }
        
        public double getSueldoBase() { return sueldoBase; }
        public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }
        
        public java.util.Date getFechaContratacion() { return fechaContratacion; }
        public void setFechaContratacion(java.util.Date fechaContratacion) { this.fechaContratacion = fechaContratacion; }
        
        public String getRol() { return rol; }
        public void setRol(String rol) { this.rol = rol; }
        
        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }
    }
}
