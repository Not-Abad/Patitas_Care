/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.model;

import java.util.ArrayList;
import provet.model.Paciente;

public class ControlPacientes {
    public static ArrayList<Paciente> listaPacientes = new ArrayList<>();
     // Devuelve los pacientes cuyo nombre o ID contiene el texto buscado
    public static ArrayList<Paciente> buscarPacientes(String texto) {
        String filtro = (texto == null) ? "" : texto.trim().toLowerCase();
        ArrayList<Paciente> resultado = new ArrayList<>();

        for (Paciente p : listaPacientes) {
            boolean coincideNombre = p.getNombre().toLowerCase().contains(filtro);
            boolean coincideID = String.valueOf(p.getID()).contains(filtro);

            if (coincideNombre || coincideID) {
                resultado.add(p);
            }
        }
        return resultado;
    }

}