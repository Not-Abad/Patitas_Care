/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.model;

import java.util.ArrayList;

/**
 *
 * @author anguv
 */
public class Usuario {
    private String ID;
    private String nombre;
    private String correo;
    private String rol;
    private String estado;
    private String fecha_registro;
    
    public Usuario(String ID, String nombre, String correo, String rol, String estado, String fecha_registro) {
    this.ID = ID;
    this.nombre = nombre;
    this.correo = correo;
    this.rol = rol;
    this.estado = estado;
    this.fecha_registro = fecha_registro;
}

    public String getID() { return ID; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getRol() { return rol; }
    public String getEstado() { return estado; }
    public String getfecha_registro() { return fecha_registro; }
    
    public void setId(String id) {
    this.ID = ID;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setCorreo(String correo) {
    this.correo = correo;
}

public void setRol(String rol) {
    this.rol = rol;
}

public void setEstado(String estado) {
    this.estado = estado;
}

public void setFechaRegistro(String fecha_registro) {
    this.fecha_registro = fecha_registro;
}
    
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
}
