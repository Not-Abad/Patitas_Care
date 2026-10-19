/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.model;

/**
 *
 * @author jesus-abad
 */
public class Empleado {
    private int idEmpleado;
    private int idPersona;
    private int idPuesto;
    private String usuario;
    private String contrasena;

    public Empleado() {}

    public Empleado(int idEmpleado, int idPersona, int idPuesto, String usuario, String contrasena) {
        this.idEmpleado = idEmpleado;
        this.idPersona = idPersona;
        this.idPuesto = idPuesto;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public int getIdPuesto() { return idPuesto; }
    public void setIdPuesto(int idPuesto) { this.idPuesto = idPuesto; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}