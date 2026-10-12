/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.model;

/**
 *
 * @author anguv
 */
public class Reporte {
    int ID;
    String Nombre;
    String Especie;
    String Fecha;
    String Veterinario;
    String Analisis;
    String Medicamentos;
    String Dosis;
    String Motivo;
    
    public Reporte(){
        
    }
    
    public Reporte(int ID, String Nombre, String Especie, String Fecha, String Veterinario, String Analisis, String Medicamentos, String Dosis, String Motivo){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Especie = Especie;
        this.Fecha = Fecha;
        this.Veterinario = Veterinario;
        this.Analisis = Analisis;
        this.Medicamentos = Medicamentos;
        this.Dosis = Dosis;
        this.Motivo = Motivo;
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
    
    public String getFecha(){
        return Fecha;
    }
    
    public String getVeterinario(){
        return Veterinario;
    }
    
    public String getAnalisis(){
        return Analisis;
    }
    
    public String getMedicamentos(){
        return Medicamentos;
    }
    
    public String detDosis(){
        return Dosis;
    }
    
    public String getMotivo(){
        return Motivo;
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
    
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    } 
    
    public void setVeterinario(String Veterinario) {
        this.Veterinario = Veterinario;
    } 
    
    public void setAnalisis(String Analisis) {
        this.Analisis = Analisis;
    } 
    
    public void setMedicamentos(String Medicamentos) {
        this.Medicamentos = Medicamentos;
    } 
    
    public void setDosis(String Dosis) {
        this.Dosis = Dosis;
    }
    
    public void setMotivo (String Motivo) {
        this.Motivo = Motivo;
    }
  
}


