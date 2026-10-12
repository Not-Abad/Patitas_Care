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
    private String Nombre;
    private String Contraseña;
    private String Tipo_Usuario;
    private String Telefono;
    private String email;
    private String urlFoto;
    
    public Usuario(String Nombre,String Contraseña, String Tipo_Usuario, String Telefono, String email,String urlFoto) {
    this.Nombre = Nombre;
    this.Contraseña = Contraseña;
    this.Tipo_Usuario = Tipo_Usuario;
    this.Telefono = Telefono;
    this.email = email;
    this.urlFoto = urlFoto;
}

    public String getNombre() {
        return Nombre; 
    }

    public void setNombre(String Nombre) {
    this.Nombre = Nombre;
    }
    
    public String getContraseña() {
        return Contraseña; 
    }

    public void setContraseña(String Contraseña) {
    this.Contraseña = Contraseña;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario; 
    }

    public void setTipo_Usuario(String Tipo_Usuario) {
    this.Tipo_Usuario = Tipo_Usuario;
    }

    public String getTelefono() {
        return Telefono; 
    }

    public void getTelefono(String Telefono) {
    this.Telefono = Telefono;
    }
    
    public String getemail() {
        return email; 
    }

    public void setemail(String email) {
    this.email = email;
    }

    public String geturlFoto() {
        return urlFoto; 
    }

    public void seturlFoto(String urlFoto) {
    this.urlFoto = urlFoto;
    }
    
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
}
