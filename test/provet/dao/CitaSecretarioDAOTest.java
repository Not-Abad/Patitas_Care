package provet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.utility.MountableFile;
import provet.utilidades.Conexion;
import static org.junit.Assert.*;

public class CitaSecretarioDAOTest {

    // MariaDB en un contenedor, creado solo para estas pruebas
    @ClassRule
    public static MariaDBContainer<?> mariadb = new MariaDBContainer<>("mariadb:10.11")
            .withDatabaseName("patitas_care")
            .withStartupTimeoutSeconds(240)
            .withCopyFileToContainer(
                    MountableFile.forHostPath("bd_patitas.sql"),
                    "/docker-entrypoint-initdb.d/01-bd_patitas.sql");

    // Apunta Conexion al contenedor en lugar de XAMPP
    @BeforeClass
    public static void configurarConexion() {
        System.setProperty("db.url", mariadb.getJdbcUrl());
        System.setProperty("db.user", mariadb.getUsername());
        System.setProperty("db.pass", mariadb.getPassword());
    }

    @AfterClass
    public static void cerrarConexion() {
        Conexion.cerrarConexion();
        System.clearProperty("db.url");
        System.clearProperty("db.user");
        System.clearProperty("db.pass");
    }

    private final CitaSecretarioDAO dao = new CitaSecretarioDAO();
    private Connection conn;
    private String nombreMascota;
    private int idMascota;
    private int idCliente;
    private int idCitaCreada = -1;

    // Elige una mascota real con nombre unico antes de cada prueba
    @Before
    public void preparar() throws Exception {
        conn = Conexion.getConexion();
        assertNotNull("Debe haber conexion con el contenedor", conn);
        String sql = "SELECT id_mascota, id_cliente, nombre FROM mts_mascota "
                   + "WHERE nombre IN (SELECT nombre FROM mts_mascota "
                   + "GROUP BY nombre HAVING COUNT(*) = 1) LIMIT 1";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            assertTrue("Debe existir al menos una mascota en la BD", rs.next());
            idMascota = rs.getInt("id_mascota");
            idCliente = rs.getInt("id_cliente");
            nombreMascota = rs.getString("nombre");
        }
    }

    // Borra la cita de prueba
    @After
    public void limpiar() {
        if (idCitaCreada > 0) {
            dao.eliminar(idCitaCreada);
        }
    }

    @Test
    public void guardarCita() throws Exception {
        idCitaCreada = dao.insertarConNombre(nombreMascota, "Raza", "Especie",
                "2026-12-01 10:00:00", "Vacunacion", "Refuerzo anual");
        assertTrue("Debe devolver un id de cita valido", idCitaCreada > 0);

        String sql = "SELECT id_cliente, id_mascota, id_estatus_cita, motivo "
                   + "FROM trn_cita WHERE id_cita = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCitaCreada);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("La cita debe existir en trn_cita", rs.next());
                assertEquals(idCliente, rs.getInt("id_cliente"));
                assertEquals(idMascota, rs.getInt("id_mascota"));
                assertEquals("Estatus Pendiente", 1, rs.getInt("id_estatus_cita"));
                assertEquals("Vacunacion - Refuerzo anual", rs.getString("motivo"));
            }
        }
    }

    @Test
    public void motivoLargo() throws Exception {
        String descripcionLarga = "A".repeat(300);
        idCitaCreada = dao.insertarConNombre(nombreMascota, "Raza", "Especie",
                "2026-12-01 11:00:00", "Consulta general", descripcionLarga);
        assertTrue(idCitaCreada > 0);

        String sql = "SELECT CHAR_LENGTH(motivo) FROM trn_cita WHERE id_cita = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCitaCreada);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue(rs.next());
                assertEquals(255, rs.getInt(1));
            }
        }
    }

    @Test
    public void citaDeHoy() throws Exception {
        // "Hoy" segun la propia base de datos (el contenedor trabaja en hora UTC)
        String hoy;
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT CURDATE()")) {
            rs.next();
            hoy = rs.getString(1) + " 18:00:00";
        }

        int antes = dao.contarPendientesHoy();
        idCitaCreada = dao.insertarConNombre(nombreMascota, "Raza", "Especie",
                hoy, "Consulta general", "");
        assertTrue(idCitaCreada > 0);

        assertEquals(antes + 1, dao.contarPendientesHoy());

        boolean aparece = false;
        List<CitaSecretarioDAO.CitaDTO> pendientes = dao.selectPendientesHoy();
        for (CitaSecretarioDAO.CitaDTO c : pendientes) {
            if (c.idCita == idCitaCreada) {
                aparece = true;
            }
        }
        assertTrue("La cita de hoy debe aparecer en pendientes", aparece);
    }

    @Test
    public void cancelarCita() throws Exception {
        idCitaCreada = dao.insertarConNombre(nombreMascota, "Raza", "Especie",
                "2026-12-02 09:00:00", "Vacunacion", "");
        assertTrue(idCitaCreada > 0);

        assertTrue(dao.actualizarEstatus(idCitaCreada, 2)); // 2 = Cancelada

        String sql = "SELECT id_estatus_cita FROM trn_cita WHERE id_cita = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCitaCreada);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue(rs.next());
                assertEquals(2, rs.getInt(1));
            }
        }
    }
}