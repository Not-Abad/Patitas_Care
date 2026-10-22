/* @author jesus-abad */

package provet.model;

public class Cliente extends Persona {
    private int idCliente;
    private int idEstatus;

    // Constructor vacío
    public Cliente() {
        super(); // Llama al constructor de la clase Persona
    }

    // Constructor completo para crear un nuevo cliente desde la interfaz
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String email, int idEstatus) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, email); // Pasa los datos al padre
        this.idEstatus = idEstatus;
    }

    // Getters y Setters específicos de Cliente
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdEstatus() { return idEstatus; }
    public void setIdEstatus(int idEstatus) { this.idEstatus = idEstatus; }
    
    // Opcional: Sobrescribir el método toString() para que el JComboBox muestre el nombre directamente
    @Override
    public String toString() {
        return getNombre() + " " + getApellidoPaterno() + " " + (getApellidoMaterno() != null ? getApellidoMaterno() : "");
    }
}