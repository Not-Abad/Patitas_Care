package provet.utilidades;

import provet.modelo.Personal;
import provet.modelo.Rol;
import provet.modelo.Usuario;

public class Sesion {

    // Objetos de la sesión activa según la nueva estructura relacional
    private static Usuario usuarioActual = null;
    private static Personal personalActual = null;
    private static Rol rolActual = null;

    // Constructor privado para evitar instanciación ("new Sesion()")
    private Sesion() {}

    /**
     * Guarda la sesión completa al validar el inicio de sesión en el Login.
     */
    public static void iniciarSesion(Usuario usuario, Personal personal, Rol rol) {
        usuarioActual = usuario;
        personalActual = personal;
        rolActual = rol;
    }

    // --- Getters y Setters ---

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Personal getPersonalActual() {
        return personalActual;
    }

    public static void setPersonalActual(Personal personal) {
        personalActual = personal;
    }

    public static Rol getRolActual() {
        return rolActual;
    }

    public static void setRolActual(Rol rol) {
        rolActual = rol;
    }

    // --- Métodos de apoyo para formularios y DAOs ---

    /**
     * Verifica si hay un usuario autenticado actualmente.
     */
    public static boolean haySesionActiva() {
        return usuarioActual != null;
    }

    /**
     * Devuelve el id_usuario activo (para citas, cobros y bitácora).
     */
    public static int getIdUsuarioActual() {
        return (usuarioActual != null) ? usuarioActual.getIdUsuario() : 0;
    }

    /**
     * Devuelve el id_personal activo (para consultas, recetas, diagnósticos y vacunas).
     * Devuelve 0 si la cuenta es administrativa y no tiene registro en 'personal'.
     */
    public static int getIdPersonalActual() {
        return (personalActual != null) ? personalActual.getIdPersonal() : 0;
    }

    /**
     * Devuelve el nombre real del empleado si existe en 'personal',
     * o su username como respaldo.
     */
    public static String getNombreMostrar() {
        if (personalActual != null && personalActual.getNombre() != null && !personalActual.getNombre().isBlank()) {
            return personalActual.getNombre();
        }
        return (usuarioActual != null) ? usuarioActual.getUsername() : "Invitado";
    }

    /**
     * Devuelve el nombre del rol activo (ej. "Administrador", "Veterinario").
     */
    public static String getNombreRol() {
        return (rolActual != null && rolActual.getNombre() != null) ? rolActual.getNombre() : "";
    }

    /**
     * Comprueba si el usuario pertenece a un rol específico sin importar mayúsculas/minúsculas.
     */
    public static boolean tieneRol(String nombreRol) {
        return rolActual != null
                && rolActual.getNombre() != null
                && rolActual.getNombre().equalsIgnoreCase(nombreRol);
    }

    /**
     * Limpia toda la sesión en memoria al hacer clic en "Cerrar Sesión".
     */
    public static void cerrarSesion() {
        usuarioActual = null;
        personalActual = null;
        rolActual = null;
    }
}