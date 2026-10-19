
package provet.model;

import java.sql.Date; // Importante para manejar la fecha_contratacion

public class Empleado {
    
    // Atributos alineados exactamente con tu base de datos
    private int idEmpleado;
    private int idPersona;
    private int idPuesto;
    private String usuario;
    private String password;
    private String fotoPerfil;
    private double sueldoBase;
    private Date fechaContratacion;

    // Constructor vacío
    public Empleado() {}

    // Constructor con todos los parámetros
    public Empleado(int idEmpleado, int idPersona, int idPuesto, String usuario, String password, String fotoPerfil, double sueldoBase, Date fechaContratacion) {
        this.idEmpleado = idEmpleado;
        this.idPersona = idPersona;
        this.idPuesto = idPuesto;
        this.usuario = usuario;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.sueldoBase = sueldoBase;
        this.fechaContratacion = fechaContratacion;
    }

    // --- Getters y Setters ---

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}