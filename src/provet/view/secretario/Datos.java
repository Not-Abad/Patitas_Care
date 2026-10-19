/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.view.secretario;
import java.util.ArrayList;

public class Datos {
    public static ArrayList<Paciente> pacientes = new ArrayList<>();
    public static ArrayList<Cita> citas = new ArrayList<>();

static {
    // Datos simulados de pacientes
    pacientes.add(new Paciente("001", "Firulais", "Perro",    "Labrador",    3, 20, "Macho",  "Muy bien", "Ninguna",         "Rabia, Parvovirus"));
    pacientes.add(new Paciente("002", "Michi",    "Gato",     "Siames",      2,  5, "Hembra", "Bien",     "Polen",           "Triple Felina"));
    pacientes.add(new Paciente("003", "Rocky",    "Perro",    "Bulldog",     4, 18, "Macho",  "Normal",   "Ninguna",         "Rabia"));
    pacientes.add(new Paciente("004", "Nube",     "Gato",     "Persa",       1,  4, "Hembra", "Muy bien", "Ninguna",         "Triple Felina, Rabia"));
    pacientes.add(new Paciente("005", "Kiwi",     "Hamster",  "Sirio",       1,  1, "Macho",  "Bien",     "Ninguna",         "Ninguna"));
    pacientes.add(new Paciente("006", "Luna",     "Perro",    "Poodle",      5,  8, "Hembra", "Bien",     "Polvo domestico", "Rabia, Parvovirus, Bordetella"));
    pacientes.add(new Paciente("007", "Thor",     "Perro",    "Pastor Aleman",6,32, "Macho",  "Normal",   "Ninguna",         "Rabia, Moquillo"));

    // Datos simulados de citas
    citas.add(new Cita("Juan Perez",   "Max",   "21/04/2026", "09:00 a.m.", "Revision general"));
    citas.add(new Cita("Ana Lopez",    "Luna",  "21/04/2026", "10:30 a.m.", "Vacunacion"));
    citas.add(new Cita("Carlos Ruiz",  "Rocky", "21/04/2026", "12:00 p.m.", "Control de peso"));
    // NOTA: sincronizarConVeterinario() se llama desde Registrar_paciente_secretario al guardar
}

/**
 * Convierte un Paciente del secretario (provet.view.secretario.Paciente)
 * al modelo global (provet.model.Paciente) y lo agrega a ControlPacientes.
 * Llamar cada vez que se registra un paciente nuevo.
 */
public static void sincronizarConVeterinario() {
    provet.model.ControlPacientes.listaPacientes.clear();
    for (Paciente p : pacientes) {
        int idNum = 0;
        try { idNum = Integer.parseInt(p.getId()); } catch (NumberFormatException e) { idNum = pacientes.indexOf(p) + 1; }
        provet.model.ControlPacientes.listaPacientes.add(
            new provet.model.Paciente(
                idNum,
                p.getNombre(),
                p.getEspecie(),
                p.getRaza(),
                (float) p.getEdad(),
                (float) p.getPeso(),
                p.getSexo(),
                p.getAlergias(),
                p.getVacunas(),
                ""
            )
        );
    }
}
}
