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
    
    public Usuario(String Nombre) {
    this.Nombre = Nombre;
}

    public String getNombre() {
        return Nombre; 
    }

    public void setNombre(String Nombre) {
    this.Nombre = Nombre;
    }





    
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
}
