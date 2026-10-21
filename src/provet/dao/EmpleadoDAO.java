/** @author jesus-abad */

//Indicamos a que paquete pertenece la clase
package provet.dao;

//Importamos las clases a usar
import provet.model.Empleado;           //Importamos la clase Empleado
import provet.utilidades.Conexion;      //Importamos la clase Conexion
import java.sql.Connection;             //Importamos la libreria de conexion
import java.sql.PreparedStatement;      //Importamos la libreria de sentencias SQL
import java.sql.ResultSet;              //Importamos la libreria de la tabla virtual SQL
import java.sql.SQLException;           //Importamos la libreria de gestión de errores
import java.util.ArrayList;             //Importamos la libreria de implementación de listas
import java.util.List;                  //Importamos la libreria de listas

//Inicio de la clase EmpleadoDAO
public class EmpleadoDAO {

    //Insertar un nuevo empleado
    public int insert(Empleado empleado) {
        int filasAfectadas = 0;
        String sql = "INSERT INTO mts_empleado (id_persona, id_puesto, usuario, password, foto_perfil, sueldo_base, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = Conexion.getConexion();

        //Si existe la conexión, Entonces...
        if (conn != null) {
            
            //Caja de seguridad para los datos del empleado
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, empleado.getIdPersona());            //Insertamos el ID de la persona en el 1er lugar
                pstmt.setInt(2, empleado.getIdPuesto());             //Insertamos el puesto en el 2do lugar
                pstmt.setString(3, empleado.getUsuario());        //Insertamos el usuario en el 3er lugar
                pstmt.setString(4, empleado.getPassword());       //Insertamos la contraseña en el 4to lugar
                pstmt.setString(5, empleado.getFotoPerfil());     //Insertamos la foto de perfil en el 5to lugar
                pstmt.setDouble(6, empleado.getSueldoBase());         //Insertamos el sueldo en el 6to lugar
                pstmt.setDate(7, empleado.getFechaContratacion());  //Insertamos la fecha en el 7mo lugar
                filasAfectadas = pstmt.executeUpdate();                   //Envíamos la orden a MariaDB y guardamos la respuesta
            } catch (SQLException e) {
                System.err.println("Error al insertar empleado: " + e.getMessage());
            }
        }
        return filasAfectadas;              //Retorna la respuesta de MariaDB a tu petición
    }

    //Leer un empleado por su ID
    public Empleado selectById(int idEmpleado) {
        Empleado empleado = null;                                       //Inicializamos el objeto como nulo
        String sql = "SELECT * FROM mts_empleado WHERE id_empleado = ?"; //Consulta para buscar por ID
        Connection conn = Conexion.getConexion();                       //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la consulta
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idEmpleado);                            //Insertamos el ID a buscar en el 1er lugar
                ResultSet rs = pstmt.executeQuery();                         //Ejecutamos la consulta y guardamos el resultado

                //Si se encontró un registro, Entonces...
                if (rs.next()) {
                    empleado = new Empleado();                          //Creamos una nueva instancia del objeto
                    empleado.setIdEmpleado(rs.getInt("id_empleado"));                     //Asignamos el ID del empleado
                    empleado.setIdPersona(rs.getInt("id_persona"));                        //Asignamos el ID de la persona
                    empleado.setIdPuesto(rs.getInt("id_puesto"));                           //Asignamos el puesto
                    empleado.setUsuario(rs.getString("usuario"));                           //Asignamos el nombre de usuario
                    empleado.setPassword(rs.getString("password"));                         //Asignamos la contraseña
                    empleado.setFotoPerfil(rs.getString("foto_perfil"));                  //Asignamos la foto de perfil
                    empleado.setSueldoBase(rs.getDouble("sueldo_base"));                  //Asignamos el sueldo base
                    empleado.setFechaContratacion(rs.getDate("fecha_contratacion")); //Asignamos la fecha
                }
            } catch (SQLException e) {
                System.err.println("Error al buscar empleado por ID: " + e.getMessage());
            }
        }
        return empleado;                                                //Retorna el objeto empleado encontrado o null si no existe
    }

    //Leer todos los empleados
    public List<Empleado> selectAll() {
        List<Empleado> listaEmpleados = new ArrayList<>();              //Creamos una lista vacía para guardar los resultados
        String sql = "SELECT * FROM mts_empleado";                      //Consulta para obtener todos los registros
        Connection conn = Conexion.getConexion();                       //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la consulta
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {                //Ejecutamos la consulta y recibimos los datos

                //Mientras haya registros en la tabla...
                while (rs.next()) {
                    Empleado empleado = new Empleado();                 //Creamos un nuevo objeto por cada fila
                    empleado.setIdEmpleado(rs.getInt("id_empleado"));   //Asignamos el ID
                    empleado.setIdPersona(rs.getInt("id_persona"));      //Asignamos el ID de persona
                    empleado.setIdPuesto(rs.getInt("id_puesto"));         //Asignamos el puesto
                    empleado.setUsuario(rs.getString("usuario"));         //Asignamos el usuario
                    empleado.setPassword(rs.getString("password"));       //Asignamos la contraseña
                    empleado.setFotoPerfil(rs.getString("foto_perfil"));//Asignamos la foto
                    empleado.setSueldoBase(rs.getDouble("sueldo_base"));//Asignamos el sueldo
                    empleado.setFechaContratacion(rs.getDate("fecha_contratacion")); //Asignamos la fecha
                    
                    listaEmpleados.add(empleado);                       //Agregamos el empleado a la lista
                }
            } catch (SQLException e) {
                System.err.println("Error al listar empleados: " + e.getMessage());
            }
        }
        return listaEmpleados;                                          //Retorna la lista completa de empleados
    }

    //Actualizar un empleado
    public boolean update(Empleado empleado) {
        boolean actualizado = false;                                    //Bandera de control inicializada en falso
        String sql = "UPDATE mts_empleado SET id_persona=?, id_puesto=?, usuario=?, password=?, foto_perfil=?, sueldo_base=?, fecha_contratacion=? WHERE id_empleado=?";
        Connection conn = Conexion.getConexion();                       //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la actualización
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, empleado.getIdPersona());          //Asignamos datos en cada marcador (?)
                pstmt.setInt(2, empleado.getIdPuesto());
                pstmt.setString(3, empleado.getUsuario());
                pstmt.setString(4, empleado.getPassword());
                pstmt.setString(5, empleado.getFotoPerfil());
                pstmt.setDouble(6, empleado.getSueldoBase());
                pstmt.setDate(7, empleado.getFechaContratacion());
                pstmt.setInt(8, empleado.getIdEmpleado());         //Identificamos al empleado a modificar

                int filasAfectadas = pstmt.executeUpdate();             //Enviamos la orden y guardamos el resultado
                if (filasAfectadas > 0) {
                    actualizado = true;                                 //Si se afectó alguna fila, cambiamos a verdadero
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar empleado: " + e.getMessage());
            }
        }
        return actualizado;                                             //Retorna si la actualización fue exitosa
    }

    //Eliminar un empleado
    public boolean delete(int idEmpleado) {
        boolean eliminado = false;                                      //Bandera de control inicializada en falso
        String sql = "DELETE FROM mts_empleado WHERE id_empleado = ?";  //Consulta para eliminar
        Connection conn = Conexion.getConexion();                       //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para el borrado
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idEmpleado);                       //Insertamos el ID a eliminar

                int filasAfectadas = pstmt.executeUpdate();             //Enviamos la orden a MariaDB
                if (filasAfectadas > 0) {
                    eliminado = true;                                   //Si se borró, cambiamos a verdadero
                }
            } catch (SQLException e) {
                System.err.println("Error al eliminar empleado: " + e.getMessage());
            }
        }
        return eliminado;                                               //Retorna si la eliminación fue exitosa
    }
    
    //Autenticar usuario
    public Empleado autenticarUsuario(String usuario, String contrasena) {
        Empleado empleadoLogueado = null;                               //Objeto nulo hasta encontrar coincidencia
        String sql = "SELECT * FROM mts_empleado WHERE usuario = ? AND password = ?";
        Connection conn = Conexion.getConexion();                       //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la validación
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, usuario);                            //Asignamos usuario y contraseña
                pstmt.setString(2, contrasena);
                
                ResultSet rs = pstmt.executeQuery();                    //Ejecutamos la búsqueda

                //Si encontramos el registro, Entonces...
                if (rs.next()) {
                    empleadoLogueado = new Empleado();                  //Instanciamos el empleado encontrado
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
        return empleadoLogueado;                                        //Retorna el objeto empleado o nulo si falla
    }

    //Obtener email para recuperación
    public String obtenerEmailPorUsuario(String usuario) {
        String email = null;                                            //Inicializamos email vacío
        //Unimos tablas para buscar el email del usuario
        String sql = "SELECT p.email FROM mts_empleado e INNER JOIN mts_persona p ON e.id_persona = p.id_persona WHERE e.usuario = ?";
        Connection conn = Conexion.getConexion();                       //Obtenemos la conexión activa
        
        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la consulta
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, usuario);                    //Insertamos el usuario a buscar
                ResultSet rs = pstmt.executeQuery();                    //Obtenemos el resultado
                
                //Si se encuentra el email, Entonces...
                if (rs.next()) {
                    email = rs.getString("email");                //Guardamos el email encontrado
                }
            } catch (SQLException e) {
                System.err.println("Error al buscar el email: " + e.getMessage());
            }
        }
        return email;                                                   //Retorna el email encontrado
    }

    //Actualizar solo la contraseña
    public boolean actualizarContraseña(String usuario, String nuevaPassword) {
        boolean actualizado = false;                                    //Bandera de control inicializada en falso
        String sql = "UPDATE mts_empleado SET password = ? WHERE usuario = ?";
        Connection conn = Conexion.getConexion();                       //Obtenemos la conexión activa
        
        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la actualización
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nuevaPassword);               //Insertamos la nueva clave
                pstmt.setString(2, usuario);                     //Identificamos al usuario
                
                //Si se realizó el cambio, Entonces...
                if (pstmt.executeUpdate() > 0) {
                    actualizado = true;                                  //Marcamos como exitoso
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar contraseña: " + e.getMessage());
            }
        }
        return actualizado;                                              //Retorna si se actualizó correctamente
    }
}    