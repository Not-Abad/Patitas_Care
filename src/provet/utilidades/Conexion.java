
package provet.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Atributos privados según el diagrama UML
    private static final String URL = "jdbc:mysql://localhost:3306/patitas_care"; // Modifica con el nombre real de tu BD
    private static final String USER = "root"; // Atributo -USER: String [cite: 221, 222]
    private static final String PASS = "tu_contraseña"; // Atributo -PASS: String [cite: 223, 224]
    
    // Objeto Connection que almacena el estado de la conexión
    private static Connection conexion = null; // Atributo conexion: Connection [cite: 218, 219]

    // Constructor privado/vacío según el UML: Conexion() [cite: 225]
    public Conexion() {
    }

    /**
     * Método público que establece y retorna la conexión activa.
     * Corresponde a +getConexion(): Connection en el UML[cite: 226].
     */
    public static Connection getConexion() {
        try {
            // Cargar el driver de la base de datos (opcional en versiones modernas de JDBC, pero recomendado)
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            // Si la conexión es nula o se encuentra cerrada, se crea una nueva
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conexión establecida exitosamente con Patitas Care.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el Driver de la base de datos.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al intentar conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    /**
     * Método público para cerrar de forma segura la conexión y liberar recursos.
     * Corresponde a +cerrarConexion(): void en el UML[cite: 227].
     */
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión clausurada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al intentar cerrar la conexión.");
            e.printStackTrace();
        }
    }
}