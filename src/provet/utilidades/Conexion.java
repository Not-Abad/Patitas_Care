
//Indica a que paquete pertenece
package provet.utilidades;

//Importamos la librerias para usar la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Inicio de la clase
public class Conexion {

    // -----------------------------------------------------------------------
    // CONFIGURACIÓN DE LA BASE DE DATOS
    // Cambia estos valores si tu MariaDB usa usuario/contraseña diferente.
    // El nombre de la BD debe coincidir con el que importaste (patitas_care).
    // -----------------------------------------------------------------------
    private static final String URL  = "jdbc:mariadb://localhost:3306/patitas_care"
                                       + "?useSSL=false&allowPublicKeyRetrieval=true"
                                       + "&serverTimezone=America/Mexico_City"
                                       + "&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "";          // Cambia si tu root tiene contraseña
    // -----------------------------------------------------------------------

    // Objeto Connection que almacena el estado de la conexión
    private static Connection conexion = null;

    // Constructor privado y vacío porque es una clase estática
    private Conexion() {
    }

    /**
     * Método público que establece y retorna la conexión activa.
     * Si falla, imprime un mensaje claro con la causa real y retorna null.
     */
    public static Connection getConexion() {
        try {
            // Cargar el driver de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");

            // Si la conexión es nula o está cerrada, crear una nueva
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Conexión establecida con patitas_care.");

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    cerrarConexion();
                }));
            }
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: No se encontró el driver MariaDB.");
            System.err.println("  Verifica que mariadb-java-client-*.jar esté en /lib");
            conexion = null;
        } catch (SQLException e) {
            System.err.println("ERROR al conectar a la base de datos patitas_care.");
            System.err.println("  Causa SQL : " + e.getMessage());
            System.err.println("  SQLState  : " + e.getSQLState());
            System.err.println("  Codigo    : " + e.getErrorCode());
            System.err.println("  Posibles causas:");
            System.err.println("    1. MariaDB/MySQL no está en ejecución.");
            System.err.println("    2. La base de datos 'patitas_care' no existe.");
            System.err.println("    3. Usuario/contraseña incorrectos en Conexion.java.");
            conexion = null;
        }
        return conexion;
    }

    /**
     * Verifica si la conexión está activa. Útil para mostrar diagnóstico en la UI.
     */
    public static boolean estaConectado() {
        try {
            return conexion != null && !conexion.isClosed() && conexion.isValid(2);
        } catch (SQLException e) {
            return false;
        }
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
