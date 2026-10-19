
package provet.model;

import java.sql.Timestamp;

public class Consulta {
    private int idConsulta;
    private int idMascota;
    private int idEmpleado;
    private Timestamp fechaConsulta;
    private float pesoActual;
    private String diagnostico;
    private String tratamiento;

    public Consulta() {}

    public Consulta(int idConsulta, int idMascota, int idEmpleado, Timestamp fechaConsulta, float pesoActual, String diagnostico, String tratamiento) {
        this.idConsulta = idConsulta;
        this.idMascota = idMascota;
        this.idEmpleado = idEmpleado;
        this.fechaConsulta = fechaConsulta;
        this.pesoActual = pesoActual;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    // Getters y Setters
    public int getIdConsulta() { return idConsulta; }
    public void setIdConsulta(int idConsulta) { this.idConsulta = idConsulta; }

    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public Timestamp getFechaConsulta() { return fechaConsulta; }
    public void setFechaConsulta(Timestamp fechaConsulta) { this.fechaConsulta = fechaConsulta; }

    public float getPesoActual() { return pesoActual; }
    public void setPesoActual(float pesoActual) { this.pesoActual = pesoActual; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }
}