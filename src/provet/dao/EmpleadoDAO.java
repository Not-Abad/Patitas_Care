
/** @author jesus-abad */
package provet.dao;

import provet.model.Empleado;
import provet.utilidades.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    // ==========================================
    // MÉTODO CREATE: Insertar un nuevo empleado
    // ==========================================
    public int insert(Empleado empleado) {
        int filasAfectadas = 0;
        String sql = "INSERT INTO mts_empleado (id_persona, id_puesto, usuario, password, foto_perfil, sueldo_base, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, empleado.getIdPersona());
                pstmt.setInt(2, empleado.getIdPuesto());
                pstmt.setString(3, empleado.getUsuario());
                pstmt.setString(4, empleado.getPassword());
                pstmt.setString(5, empleado.getFotoPerfil());
                pstmt.setDouble(6, empleado.getSueldoBase());
                pstmt.setDate(7, empleado.getFechaContratacion());

                filasAfectadas = pstmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al insertar empleado: " + e.getMessage());
            }
        }
        return filasAfectadas;
    }

    // ==========================================
    // MÉTODO READ: Leer un empleado por su ID
    // ==========================================
    public Empleado selectById(int idEmpleado) {
        Empleado empleado = null;
        String sql = "SELECT * FROM mts_empleado WHERE id_empleado = ?";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, idEmpleado);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("id_empleado"));
                    empleado.setIdPersona(rs.getInt("id_persona"));
                    empleado.setIdPuesto(rs.getInt("id_puesto"));
                    empleado.setUsuario(rs.getString("usuario"));
                    empleado.setPassword(rs.getString("password"));
                    empleado.setFotoPerfil(rs.getString("foto_perfil"));
                    empleado.setSueldoBase(rs.getDouble("sueldo_base"));
                    empleado.setFechaContratacion(rs.getDate("fecha_contratacion"));
                }
            } catch (SQLException e) {
                System.err.println("Error al buscar empleado por ID: " + e.getMessage());
            }
        }
        return empleado;
    }

    // ==========================================
    // MÉTODO READ: Leer todos los empleados
    // ==========================================
    public List<Empleado> selectAll() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String sql = "SELECT * FROM mts_empleado";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("id_empleado"));
                    empleado.setIdPersona(rs.getInt("id_persona"));
                    empleado.setIdPuesto(rs.getInt("id_puesto"));
                    empleado.setUsuario(rs.getString("usuario"));
                    empleado.setPassword(rs.getString("password"));
                    empleado.setFotoPerfil(rs.getString("foto_perfil"));
                    empleado.setSueldoBase(rs.getDouble("sueldo_base"));
                    empleado.setFechaContratacion(rs.getDate("fecha_contratacion"));
                    
                    listaEmpleados.add(empleado);
                }
            } catch (SQLException e) {
                System.err.println("Error al listar empleados: " + e.getMessage());
            }
        }
        return listaEmpleados;
    }

    // ==========================================
    // MÉTODO UPDATE: Actualizar un empleado
    // ==========================================
    public boolean update(Empleado empleado) {
        boolean actualizado = false;
        String sql = "UPDATE mts_empleado SET id_persona=?, id_puesto=?, usuario=?, password=?, foto_perfil=?, sueldo_base=?, fecha_contratacion=? WHERE id_empleado=?";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, empleado.getIdPersona());
                pstmt.setInt(2, empleado.getIdPuesto());
                pstmt.setString(3, empleado.getUsuario());
                pstmt.setString(4, empleado.getPassword());
                pstmt.setString(5, empleado.getFotoPerfil());
                pstmt.setDouble(6, empleado.getSueldoBase());
                pstmt.setDate(7, empleado.getFechaContratacion());
                pstmt.setInt(8, empleado.getIdEmpleado());

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas > 0) {
                    actualizado = true;
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar empleado: " + e.getMessage());
            }
        }
        return actualizado;
    }

    // ==========================================
    // MÉTODO DELETE: Eliminar un empleado
    // ==========================================
    public boolean delete(int idEmpleado) {
        boolean eliminado = false;
        String sql = "DELETE FROM mts_empleado WHERE id_empleado = ?";
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, idEmpleado);

                int filasAfectadas = pstmt.executeUpdate();
                if (filasAfectadas > 0) {
                    eliminado = true;
                }
            } catch (SQLException e) {
                System.err.println("Error al eliminar empleado: " + e.getMessage());
            }
        }
        return eliminado;
    }
    
    // ==========================================
    // MÉTODO LOGIN: Autenticar usuario
    // ==========================================
    public Empleado autenticarUsuario(String usuario, String contrasena) {
        Empleado empleadoLogueado = null;
        String sql = "SELECT * FROM mts_empleado WHERE usuario = ? AND password = ?";
        
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                pstmt.setString(1, usuario);
                pstmt.setString(2, contrasena);
                
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    empleadoLogueado = new Empleado();
                    empleadoLogueado.setIdEmpleado(rs.getInt("id_empleado"));
                    empleadoLogueado.setIdPersona(rs.getInt("id_persona"));
                    empleadoLogueado.setIdPuesto(rs.getInt("id_puesto"));
                    empleadoLogueado.setUsuario(rs.getString("usuario"));
                    empleadoLogueado.setPassword(rs.getString("password")); 
                    empleadoLogueado.setFotoPerfil(rs.getString("foto_perfil"));
                    empleadoLogueado.setSueldoBase(rs.getDouble("sueldo_base"));
                    empleadoLogueado.setFechaContratacion(rs.getDate("fecha_contratacion"));
                }
            } catch (SQLException e) {
                System.err.println("Error al autenticar empleado: " + e.getMessage());
            }
        }
        return empleadoLogueado;
    }

    // ==========================================
    // MÉTODO EXTRA: Obtener email para recuperación
    // ==========================================
    public String obtenerEmailPorUsuario(String usuario) {
        String email = null;
        // Unimos la tabla empleado con persona usando su id_persona para sacar el email
        String sql = "SELECT p.email FROM mts_empleado e INNER JOIN mts_persona p ON e.id_persona = p.id_persona WHERE e.usuario = ?";
        Connection conn = Conexion.getConexion();
        
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, usuario);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    email = rs.getString("email");
                }
            } catch (SQLException e) {
                System.err.println("Error al buscar el email: " + e.getMessage());
            }
        }
        return email;
    }

    // ==========================================
    // MÉTODO EXTRA: Actualizar solo la contraseña
    // ==========================================
    public boolean actualizarPassword(String usuario, String nuevaPassword) {
        boolean actualizado = false;
        String sql = "UPDATE mts_empleado SET password = ? WHERE usuario = ?";
        Connection conn = Conexion.getConexion();
        
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nuevaPassword);
                pstmt.setString(2, usuario);
                
                if (pstmt.executeUpdate() > 0) {
                    actualizado = true;
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar contraseña: " + e.getMessage());
            }
        }
        return actualizado;
    }
}