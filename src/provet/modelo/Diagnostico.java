
package provet.modelo;

import java.sql.Timestamp;

public class Diagnostico {
    private int idDiagnostico;
    private int idConsulta;
    private int idVeterinario;
    private String descripcion;
    private String tipoDiagnostico;
    private String estado;
    private Timestamp fechaRegistro;
    private Timestamp updatedAt;

    public Diagnostico() {}

    public int getIdDiagnostico() { return idDiagnostico; }
    public void setIdDiagnostico(int idDiagnostico) { this.idDiagnostico = idDiagnostico; }
    public int getIdConsulta() { return idConsulta; }
    public void setIdConsulta(int idConsulta) { this.idConsulta = idConsulta; }
    public int getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(int idVeterinario) { this.idVeterinario = idVeterinario; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getTipoDiagnostico() { return tipoDiagnostico; }
    public void setTipoDiagnostico(String tipoDiagnostico) { this.tipoDiagnostico = tipoDiagnostico; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }
}