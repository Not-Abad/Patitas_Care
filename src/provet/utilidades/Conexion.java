
//Indica a que paquete pertenece
package provet.utilidades;

//Importamos la librerias para usar la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Inicio de la clase
public class Conexion {

    // Atributos de la conexión
    private static final String URL = "jdbc:mariadb://localhost:3306/patitas_care_actualizada";
    private static final String USER = "root"; 
    private static final String PASS = "";    
    
    // Objeto Connection que almacena el estado de la conexión
    private static Connection conexion = null; 

    // Constructor privado y vacio porque es una clase estatica
    private Conexion() {
    }

    //Método público que establece y retorna la conexión activa
    public static Connection getConexion() {
        try {
            // Cargar el driver de la base de datos 
            Class.forName("org.mariadb.jdbc.Driver");            
            
            // Si la conexión es nula o se encuentra cerrada, se crea una nueva
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conexión establecida exitosamente con Patitas Care.");
                
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    cerrarConexion();
                }));
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error crítico: No se encontró el driver MariaDB. Verifica tus dependencias.");
        } catch (SQLException e) {
            System.err.println("No se pudo conectar a la base de datos.");
            System.err.println("Causa: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión clausurada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al intentar cerrar la conexión.");
        }
    }
}