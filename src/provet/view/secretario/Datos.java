package provet.view.secretario;

import provet.dao.MascotaSecretarioDAO;
import provet.dao.CitaSecretarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase central de datos del módulo Secretario.
 * Ahora lee y escribe directamente en la base de datos PatitasCare.
 * Los DAOs encapsulan toda la lógica SQL.
 */
public class Datos {

    // DAOs públicos para uso directo desde los formularios
    public static final MascotaSecretarioDAO mascotaDAO = new MascotaSecretarioDAO();
    public static final CitaSecretarioDAO citaDAO = new CitaSecretarioDAO();

    // Listas en memoria (se recargan desde BD)
    public static List<MascotaSecretarioDAO.MascotaDTO> mascotas = new ArrayList<>();
    public static List<CitaSecretarioDAO.CitaDTO> citas = new ArrayList<>();

    /**
     * Recarga mascotas desde la base de datos.
     * Llamar al abrir cualquier formulario que muestre mascotas.
     */
    public static void cargarMascotas() {
        mascotas = mascotaDAO.selectAll();
    }

    /**
     * Recarga citas desde la base de datos.
     * Llamar al abrir formularios de citas.
     */
    public static void cargarCitas() {
        citas = citaDAO.selectAll();
    }

    /**
     * Recarga todo de la base de datos.
     */
    public static void recargarTodo() {
        cargarMascotas();
        cargarCitas();
    }

    /**
     * Sincroniza las mascotas de la BD con el modelo global del veterinario.
     * Mantiene compatibilidad con el módulo veterinario existente.
     */
    public static void sincronizarConVeterinario() {
        cargarMascotas();
        provet.model.ControlPacientes.listaPacientes.clear();
        for (MascotaSecretarioDAO.MascotaDTO d : mascotas) {
            provet.model.ControlPacientes.listaPacientes.add(
                new provet.model.Paciente(
                    d.idMascota,
                    d.nombreMascota,
                    d.especie,
                    d.raza,
                    0f,   // edad no guardada directamente, se calcula por fecha_nacimiento
                    0f,
                    d.sexo,
                    "",   // alergias (no en la BD básica)
                    "",   // vacunas
                    ""
                )
            );
        }
    }

    // ======== MÉTODOS HELPER PARA LOS FORMULARIOS ========

    /**
     * Número de mascotas en la BD.
     */
    public static int totalMascotas() {
        return mascotaDAO.contarMascotas();
    }

    /**
     * Número de citas pendientes hoy.
     */
    public static int citasPendientesHoy() {
        return citaDAO.contarPendientesHoy();
    }

    /**
     * Devuelve citas pendientes de hoy (cargadas de BD).
     */
    public static List<CitaSecretarioDAO.CitaDTO> citasPendientesHoyLista() {
        return citaDAO.selectPendientesHoy();
    }
}
