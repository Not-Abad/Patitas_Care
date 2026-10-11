/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.model;

/**
 *
 * @author anguv
 */
public class Paciente {
    int ID;
    String Nombre;
    String Especie;
    String Raza;
    float Edad;
    float Peso;
    String Sexo;
    String Alergias;
    String Vacunas;
    
    public Paciente(){
        
    }
    
    public Paciente(int ID, String Nombre, String Especie, String Raza, float Edad, float Peso, String Sexo, String Alergias, String Vacunas){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Especie = Especie;
        this.Raza = Raza;
        this.Edad = Edad;
        this.Peso = Peso;
        this.Sexo = Sexo;
        this.Alergias = Alergias;
        this.Vacunas = Vacunas;
    }
    
    //getters
    public int getID(){
        return ID;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public String getEspecie(){
        return Especie;
    }
    
    public String getRaza(){
        return Raza;
    }
    
    public float getEdad(){
        return Edad;
    }
    
    public float getPeso(){
        return Peso;
    }
    
    public String getSexo(){
        return Sexo;
    }
    
    public String getAlergias(){
        return Alergias;
    }
    
    public String getVacunas(){
        return Vacunas;
    }
    
    //setters
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }  
    
    public void setEspecie(String Especie) {
        this.Especie = Especie;
    } 
    
    public void setRaza(String Raza) {
        this.Raza = Raza;
    } 
    
    public void setEdad(float Edad) {
        this.Edad = Edad;
    } 
    
    public void setPeso(float Peso) {
        this.Peso = Peso;
    } 
    
    public void setAlergias(String Alergias) {
        this.Alergias = Alergias;
    }
    
    public void setVacunas (String Vacunas) {
        this.Vacunas = Vacunas;
    }
  
}


