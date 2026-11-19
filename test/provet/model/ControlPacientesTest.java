/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package provet.model;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControlPacientesTest {

    // Antes de cada prueba dejamos la lista con datos conocidos
    @Before
    public void preparar() {
        ControlPacientes.listaPacientes.clear();
        ControlPacientes.listaPacientes.add(new Paciente(1, "Firulais", "Perro", "Labrador", 3, 20, "M", "", "", ""));
        ControlPacientes.listaPacientes.add(new Paciente(2, "Michi", "Gato", "Siames", 2, 5, "H", "", "", ""));
        ControlPacientes.listaPacientes.add(new Paciente(3, "Rocky", "Perro", "Bulldog", 4, 18, "M", "", "", ""));
    }

    // Happy path: buscar un paciente por nombre y ver su detalle
    @Test
    public void buscarPorNombre_devuelveSoloElPacienteYSusDatos() {
        ArrayList<Paciente> resultado = ControlPacientes.buscarPacientes("Firulais");

        assertEquals(1, resultado.size());

        Paciente p = resultado.get(0);
        assertEquals("Firulais", p.getNombre());
        assertEquals("Perro", p.getEspecie());
        assertEquals("Labrador", p.getRaza());
        assertEquals(3f, p.getEdad(), 0.001f);
    }

    @Test
    public void buscarNoDistingueMayusculasDeMinusculas() {
        ArrayList<Paciente> resultado = ControlPacientes.buscarPacientes("firulais");

        assertEquals(1, resultado.size());
        assertEquals("Firulais", resultado.get(0).getNombre());
    }

    @Test
    public void buscarPorID_devuelveElPacienteCorrecto() {
        ArrayList<Paciente> resultado = ControlPacientes.buscarPacientes("2");

        assertEquals(1, resultado.size());
        assertEquals("Michi", resultado.get(0).getNombre());
    }
}