/** @author jesus-abad */

//Indicamos a que paquete pertenece la clase
package provet.dao;

//Importamos las clases a usar
import provet.model.Cita;               //Importamos la clase modelo Cita
import provet.utilidades.Conexion;      //Importamos la clase Conexion
import java.sql.Connection;             //Importamos la libreria de conexion
import java.sql.PreparedStatement;      //Importamos la libreria de sentencias SQL
import java.sql.ResultSet;              //Importamos la libreria de la tabla virtual SQL
import java.sql.SQLException;           //Importamos la libreria de gestión de errores
import java.util.ArrayList;             //Importamos la libreria de listas
import java.util.List;                  //Importamos la libreria de listas

//Inicio de la clase CitaDAO
public class CitaDAO {

    //Insertar una nueva cita
    public int insert(Cita cita) {
        int filasAfectadas = 0;
        String sql = "INSERT INTO mts_cita (id_cliente, id_mascota, id_estatus_cita, fecha_programada, motivo) VALUES (?, ?, ?, ?, ?)";
        Connection conn = Conexion.getConexion();

        //Si existe la conexión, Entonces...
        if (conn != null) {
            
            //Caja de seguridad para los datos de la cita
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, cita.getIdCliente());           //Insertamos ID cliente en el 1er lugar
                pstmt.setInt(2, cita.getIdMascota());           //Insertamos ID mascota en el 2do lugar
                pstmt.setInt(3, cita.getIdEstatusCita());       //Insertamos estatus en el 3er lugar
                pstmt.setTimestamp(4, cita.getFechaProgramada()); //Insertamos fecha en el 4to lugar
                pstmt.setString(5, cita.getMotivo());           //Insertamos motivo en el 5to lugar
                
                filasAfectadas = pstmt.executeUpdate();         //Envíamos la orden a MariaDB y guardamos respuesta
            } catch (SQLException e) {
                System.err.println("Error al insertar cita: " + e.getMessage());
            }
        }
        return filasAfectadas;                                  //Retorna la respuesta de MariaDB
    }

    //Leer una cita por su ID
    public Cita selectById(int idCita) {
        Cita cita = null;                                       //Inicializamos el objeto como nulo
        String sql = "SELECT * FROM mts_cita WHERE id_cita = ?"; //Consulta para buscar por ID
        Connection conn = Conexion.getConexion();               //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la consulta
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idCita);                        //Insertamos ID a buscar
                ResultSet rs = pstmt.executeQuery();            //Ejecutamos y guardamos el resultado

                //Si se encontró un registro, Entonces...
                if (rs.next()) {
                    cita = new Cita();                          //Instanciamos nueva Cita
                    cita.setIdCita(rs.getInt("id_cita"));
                    cita.setIdCliente(rs.getInt("id_cliente"));
                    cita.setIdMascota(rs.getInt("id_mascota"));
                    cita.setIdEstatusCita(rs.getInt("id_estatus_cita"));
                    cita.setFechaProgramada(rs.getTimestamp("fecha_programada"));
                    cita.setMotivo(rs.getString("motivo"));
                }
            } catch (SQLException e) {
                System.err.println("Error al buscar cita por ID: " + e.getMessage());
            }
        }
        return cita;                                            //Retorna el objeto cita encontrado
    }

    //Leer todas las citas
    public List<Cita> selectAll() {
        List<Cita> listaCitas = new ArrayList<>();              //Lista vacía para guardar resultados
        String sql = "SELECT * FROM mts_cita";                  //Consulta general
        Connection conn = Conexion.getConexion();               //Obtenemos la conexión activa

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la consulta
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {         //Ejecutamos y recibimos datos

                //Mientras haya registros...
                while (rs.next()) {
                    Cita cita = new Cita();                     //Creamos objeto Cita
                    cita.setIdCita(rs.getInt("id_cita"));
                    cita.setIdCliente(rs.getInt("id_cliente"));
                    cita.setIdMascota(rs.getInt("id_mascota"));
                    cita.setIdEstatusCita(rs.getInt("id_estatus_cita"));
                    cita.setFechaProgramada(rs.getTimestamp("fecha_programada"));
                    cita.setMotivo(rs.getString("motivo"));
                    
                    listaCitas.add(cita);                       //Agregamos a la lista
                }
            } catch (SQLException e) {
                System.err.println("Error al listar citas: " + e.getMessage());
            }
        }
        return listaCitas;                                      //Retorna la lista completa
    }

    //Actualizar una cita
    public boolean update(Cita cita) {
        boolean actualizado = false;                            //Bandera de control
        String sql = "UPDATE mts_cita SET id_cliente=?, id_mascota=?, id_estatus_cita=?, fecha_programada=?, motivo=? WHERE id_cita=?";
        Connection conn = Conexion.getConexion();               //Obtenemos conexión

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para la actualización
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, cita.getIdCliente());
                pstmt.setInt(2, cita.getIdMascota());
                pstmt.setInt(3, cita.getIdEstatusCita());
                pstmt.setTimestamp(4, cita.getFechaProgramada());
                pstmt.setString(5, cita.getMotivo());
                pstmt.setInt(6, cita.getIdCita());              //ID para identificar registro

                if (pstmt.executeUpdate() > 0) {
                    actualizado = true;                         //Marcamos éxito
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar cita: " + e.getMessage());
            }
        }
        return actualizado;                                     //Retorna estado de la operación
    }

    //Eliminar una cita
    public boolean delete(int idCita) {
        boolean eliminado = false;                              //Bandera de control
        String sql = "DELETE FROM mts_cita WHERE id_cita = ?";  //Consulta borrar
        Connection conn = Conexion.getConexion();               //Obtenemos conexión

        //Si existe la conexión, Entonces...
        if (conn != null) {
            //Caja de seguridad para el borrado
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idCita);                        //Asignamos ID

                if (pstmt.executeUpdate() > 0) {
                    eliminado = true;                           //Marcamos éxito
                }
            } catch (SQLException e) {
                System.err.println("Error al eliminar cita: " + e.getMessage());
            }
        }
        return eliminado;                                       //Retorna estado de la operación
    }
}