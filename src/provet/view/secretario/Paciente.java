/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.view.secretario;

/**
 *
 * @author Andreij Haziel
 */
public class Paciente {
    String id, nombre, especie, raza, estado, sexo, alergias, vacunas;
    int edad, peso;

    public Paciente(String id, String nombre, String especie, String raza, int edad, int peso, String sexo, String estado, String alergias, String vacunas) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.estado = estado;
        this.peso = peso;
        this.sexo = sexo;
        this.alergias = alergias;
        this.vacunas = vacunas;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public int getEdad() { return edad; }
    public int getPeso() { return peso; }
    public String getEstado() { return estado; }
    public String getSexo() { return sexo; }
    public String getAlergias() { return alergias; }
    public String getVacunas() { return vacunas; }
}