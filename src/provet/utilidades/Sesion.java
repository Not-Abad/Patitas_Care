
package provet.utilidades;

import provet.model.Empleado;

public class Sesion {
    
    // Aquí guardaremos al empleado que logró iniciar sesión
    private static Empleado empleadoActual = null;

    // Constructor privado para que nadie haga "new Sesion()"
    private Sesion() {}

    // Método para guardar al empleado (Se usa en el Login)
    public static void setEmpleadoActual(Empleado empleado) {
        empleadoActual = empleado;
    }

    // Método para obtener al empleado desde cualquier otra ventana
    public static Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    // Método para borrar la memoria cuando le den clic a "Cerrar Sesión"
    public static void cerrarSesion() {
        empleadoActual = null;
    }
}