package provet.view.secretario;

import java.util.ArrayList;
import java.util.List;
import provet.dao.CitaSecretarioDAO;
import provet.dao.MascotaSecretarioDAO;
import provet.utilidades.Sesion;

/**
 * Clase central de datos del módulo Secretario conectada a patitas_final.
 */
public class Datos {

    public static final MascotaSecretarioDAO mascotaDAO = new MascotaSecretarioDAO();
    public static final CitaSecretarioDAO citaDAO = new CitaSecretarioDAO();

    public static List<MascotaSecretarioDAO.MascotaDTO> mascotas = new ArrayList<>();
    public static List<CitaSecretarioDAO.CitaDTO> citas = new ArrayList<>();

    public static void cargarMascotas() {
        mascotas = mascotaDAO.selectAll();
    }

    public static void cargarCitas() {
        citas = citaDAO.selectAll();
    }

    public static void recargarTodo() {
        cargarMascotas();
        cargarCitas();
    }

    /**
     * Registra una nueva mascota en patitas_final y actualiza la lista en memoria.
     */
    public static int insertarMascota(String nombreMascota, String especie, String raza, String sexo,
                                      String fechaNacimiento, Double pesoActualKg, String antecedentesMedicos,
                                      String nombreProp, String telefonoProp, String direccionProp, String correoProp) {
        int idNuevo = mascotaDAO.insertar(
            nombreMascota, especie, raza, sexo, fechaNacimiento,
            pesoActualKg, antecedentesMedicos,
            nombreProp, telefonoProp, direccionProp, correoProp
        );
        if (idNuevo > 0) {
            cargarMascotas();
        }
        return idNuevo;
    }

    /**
     * Obtiene el id_usuario de la sesión activa o un usuario activo de respaldo.
     */
    public static int obtenerIdUsuarioActual() {
        int idUsuario = Sesion.getIdUsuarioActual();
        return (idUsuario > 0) ? idUsuario : citaDAO.obtenerUsuarioActivoPorDefecto();
    }

    public static int totalMascotas() {
        return mascotaDAO.contarMascotas();
    }

    public static int citasPendientesHoy() {
        return citaDAO.contarPendientesHoy();
    }

    public static List<CitaSecretarioDAO.CitaDTO> citasPendientesHoyLista() {
        return citaDAO.selectPendientesHoy();
    }
}