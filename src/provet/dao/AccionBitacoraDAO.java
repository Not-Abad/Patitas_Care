/** @author jesus-abad */

//Indicamos a que paquete pertenece la clase
package provet.dao;

//Importamos las clases a usar
import provet.model.AccionBitacora;     //Importamos la clase modelo
import provet.utilidades.Conexion;      //Importamos la clase Conexion
import java.sql.Connection;             //Importamos la libreria de conexion
import java.sql.PreparedStatement;      //Importamos la libreria de sentencias SQL
import java.sql.ResultSet;              //Importamos la libreria de la tabla virtual SQL
import java.sql.SQLException;           //Importamos la libreria de gestión de errores
import java.util.ArrayList;             //Importamos la libreria de implementación de listas
import java.util.List;                  //Importamos la libreria de listas

//Inicio de la clase AccionBitacoraDAO
public class AccionBitacoraDAO {

    //Insertar una nueva accion de bitacora
    public int insert(AccionBitacora accion) {
        int filasAfectadas = 0;
        String sql = "INSERT INTO cat_accion_bitacora (id_accion, nombre_accion) VALUES (?, ?)";
        Connection conn = Conexion.getConexion();

        //Si existe la conexión, Entonces...
        if (conn != null) {
            
            //Caja de seguridad para los datos de la acción
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, accion.getIdAccion());          //Insertamos el ID en el 1er lugar
                pstmt.setString(2, accion.getNombreAccion());//Insertamos el nombre en el 2do lugar
                filasAfectadas = pstmt.executeUpdate();              //Envíamos la orden a MariaDB y guardamos la respuesta
            } catch (SQLException e) {
                System.err.println("Error al insertar accion de bitacora: " + e.getMessage());
            }
        }
        return filasAfectadas;                                  //Retorna la respuesta de MariaDB a tu petición
    }

    //Leer una accion de bitacora por su ID
    public AccionBitacora selectById(int idAccion) {
        AccionBitacora accion = null;                                        //Inicializamos el objeto como nulo
        String sql = "SELECT * FROM cat_accion_bitacora WHERE id_accion = ?";//Consulta para buscar por ID
        Connection conn = Conexion.getConexion();                            //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la consulta
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idAccion);                          //Insertamos el ID a buscar en el 1er lugar
                ResultSet rs = pstmt.executeQuery();                    //Ejecutamos la consulta y guardamos el resultado

                //Si se encontró un registro, Entonces...
                if (rs.next()) {
                    accion = new AccionBitacora();                          //Creamos una nueva instancia del objeto
                    accion.setIdAccion(rs.getInt("id_accion"));//Asignamos el ID
                    accion.setNombreAccion(rs.getString("nombre_accion"));//Asignamos el nombre
                }
            } catch (SQLException e) {
                System.err.println("Error al buscar accion por ID: " + e.getMessage());
            }
        }
        return accion;                                              //Retorna el objeto encontrado o null si no existe
    }

    //Leer todas las acciones de bitacora
    public List<AccionBitacora> selectAll() {
        List<AccionBitacora> listaAcciones = new ArrayList<>();     //Creamos una lista vacía
        String sql = "SELECT * FROM cat_accion_bitacora";           //Consulta para obtener todos los registros
        Connection conn = Conexion.getConexion();                   //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la consulta
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {            //Ejecutamos la consulta

                //Mientras haya registros en la tabla...
                while (rs.next()) {
                    AccionBitacora accion = new AccionBitacora();               //Creamos un nuevo objeto
                    accion.setIdAccion(rs.getInt("id_accion"));    //Asignamos el ID
                    accion.setNombreAccion(rs.getString("nombre_accion")); //Asignamos el nombre
                    listaAcciones.add(accion);                      //Agregamos a la lista
                }
            } catch (SQLException e) {
                System.err.println("Error al listar acciones: " + e.getMessage());
            }
        }
        return listaAcciones;                                       //Retorna la lista completa
    }

    //Actualizar una accion de bitacora
    public boolean update(AccionBitacora accion) {
        boolean actualizado = false;                                //Bandera inicializada en falso
        String sql = "UPDATE cat_accion_bitacora SET nombre_accion=? WHERE id_accion=?";
        Connection conn = Conexion.getConexion();                   //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la actualización
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, accion.getNombreAccion());
                pstmt.setInt(2, accion.getIdAccion());

                int filasAfectadas = pstmt.executeUpdate();         //Enviamos la orden
                if (filasAfectadas > 0) {
                    actualizado = true;                             //Si se afectó alguna fila, cambiamos a verdadero
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar accion: " + e.getMessage());
            }
        }
        return actualizado;                                         //Retorna si la actualización fue exitosa
    }

    //Eliminar una accion de bitacora
    public boolean delete(int idAccion) {
        boolean eliminado = false;                                  //Bandera inicializada en falso
        String sql = "DELETE FROM cat_accion_bitacora WHERE id_accion = ?";
        Connection conn = Conexion.getConexion();                   //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para el borrado
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idAccion);                          //Insertamos el ID a eliminar

                int filasAfectadas = pstmt.executeUpdate();         //Enviamos la orden
                if (filasAfectadas > 0) {
                    eliminado = true;                               //Si se borró, cambiamos a verdadero
                }
            } catch (SQLException e) {
                System.err.println("Error al eliminar accion: " + e.getMessage());
            }
        }
        return eliminado;                                           //Retorna si la eliminación fue exitosa
    }
}