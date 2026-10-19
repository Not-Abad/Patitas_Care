
package provet.dao;

/**
 *
 * @author jesus-abad
 */

import provet.model.Empleado;
import provet.utilidades.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {

    public Empleado autenticarUsuario(String usuario, String contrasena) {
    Empleado empleadoLogueado = null;
    String sql = "SELECT * FROM mts_empleado WHERE usuario = ? AND password = ?";

    try (Connection conn = Conexion.getConexion();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, usuario);
        pstmt.setString(2, contrasena);
        
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            empleadoLogueado = new Empleado();
            empleadoLogueado.setIdEmpleado(rs.getInt("id_empleado"));
            empleadoLogueado.setIdPersona(rs.getInt("id_persona"));
            empleadoLogueado.setIdPuesto(rs.getInt("id_puesto"));
            empleadoLogueado.setUsuario(rs.getString("usuario"));
            empleadoLogueado.setContrasena(rs.getString("password")); 
        }
    } catch (SQLException e) {
        System.err.println("Error al autenticar empleado: " + e.getMessage());
    }
    
    return empleadoLogueado;
    }
}