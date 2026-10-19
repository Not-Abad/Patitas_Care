
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

    //Insertar un nuevo empleado
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

    //Leer un empleado por su ID
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

    //Leer todos los empleados
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

    //Actualizar un empleado
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

    //Eliminar un empleado
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
    
    //Autenticar usuario
    public Empleado autenticarUsuario(String usuario, String contrasena) {
        Empleado empleadoLogueado = null;
        String sql = "SELECT * FROM mts_empleado WHERE usuario = ? AND password = ?";
        
        //Obtenemos la conexión AFUERA del try para que no se cierre automáticamente
        Connection conn = Conexion.getConexion();

        if (conn != null) {
            //Solo el PreparedStatement va en el try para que se cierre al terminar
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
}