/* @author jesus-abad */

package provet.model;

import java.time.LocalDateTime;

public class Persona {
    private int idPersona;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String email;
    private LocalDateTime fechaRegistroSistema; // Atributo agregado

    // Constructor vacío
    public Persona() {
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String email) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.email = email;
    }

    public Persona(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String email, LocalDateTime fechaRegistroSistema) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistroSistema = fechaRegistroSistema;
    }

    // Getters y Setters
    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getFechaRegistroSistema() { return fechaRegistroSistema; }
    public void setFechaRegistroSistema(LocalDateTime fechaRegistroSistema) { this.fechaRegistroSistema = fechaRegistroSistema; }
}