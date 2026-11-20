/*Objeto conector con la base de datos situada en MySQL Workbench*/

// Indica a que paquete pertenece
package provet.utilidades;

// Importamos las librerias para usar la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Inicio de la Clse
public class dbConection {

    // CONFIGURACIÓN DE LA BASE DE DATOS (MySQL)
    private static final String URL  = "jdbc:mysql://localhost:3307/patitas_final"
                                       + "?useSSL=false&allowPublicKeyRetrieval=true"
                                       + "&serverTimezone=America/Mexico_City"
                                       + "&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "admin";

    // Objeto Connection que almacena el estado de la conexión
    private static Connection conexion = null;

    // Constructor privado y vacío porque es una clase estática
    private dbConection() {
    }

    /* Método público que establece y retorna la conexión activa con MySQL.
    (Si falla, imprime un mensaje claro con la causa real y retorna null). */
    public static Connection getConexion() {
        try {
            // Cargar el driver de MySQL Connector/J 8.0+
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Si la conexión es nula o está cerrada, crear una nueva
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conexión establecida con MySQL (patitas_final).");

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    cerrarConexion();
                }));
            }
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: No se encontró el driver de MySQL.");
            System.err.println("  Verifica que mysql-connector-j-*.jar esté en /lib y en el Classpath.");
            conexion = null;
        } catch (SQLException e) {
            System.err.println("ERROR al conectar a la base de datos MySQL (patitas_final).");
            System.err.println("  Causa SQL : " + e.getMessage());
            System.err.println("  SQLState  : " + e.getSQLState());
            System.err.println("  Codigo    : " + e.getErrorCode());
            System.err.println("  Posibles causas:");
            System.err.println("    1. El servicio de MySQL no está en ejecución.");
            System.err.println("    2. La base de datos 'patitas_final' no existe o el puerto es incorrecto.");
            System.err.println("    3. Usuario/contraseña incorrectos en Conexion_2.java.");
            conexion = null;
        }
        return conexion;
    }

    /* Verifica si la conexión está activa. Útil para mostrar diagnóstico en la UI.*/
    public static boolean estaConectado() {
        try {
            return conexion != null && !conexion.isClosed() && conexion.isValid(2);
        } catch (SQLException e) {
            return false;
        }
    }
    
    //Cierra la conexión para no saturar el gestor
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión MySQL cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión MySQL: " + e.getMessage());
        }
    }
/*    
    // Método temporal solo para probar la conexión (puedes borrarlo después)
    public static void main(String[] args) {
        System.out.println("Probando conexión a MySQL...");
        Connection conn = dbConection.getConexion();

        if (conn != null && dbConection.estaConectado()) {
            try (java.sql.Statement st = conn.createStatement();
                 java.sql.ResultSet rs = st.executeQuery("SHOW TABLES")) {

                System.out.println("¡ÉXITO! Tablas encontradas en la base de datos:");
                int contador = 0;
                while (rs.next()) {
                    contador++;
                    System.out.println("  " + contador + ". " + rs.getString(1));
                }
                System.out.println("Total de tablas detectadas: " + contador);

            } catch (SQLException e) {
                System.err.println("Conectó al servidor, pero falló la consulta: " + e.getMessage());
            } finally {
                dbConection.cerrarConexion();
            }
        } else {
            System.err.println("FALLO: No se pudo establecer la conexión con MySQL.");
        }
    }
*/
}