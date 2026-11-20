
package provet.modelo;

import java.sql.Timestamp;

public class Cita {
    private int idCita;
    private int idMascota;
    private int idVeterinario;
    private int idUsuarioRegistro;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;
    private String motivo;
    private String estado;
    private boolean recordatorioEnviado;
    private Timestamp createdAt;

    public Cita() {}

    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public int getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(int idVeterinario) { this.idVeterinario = idVeterinario; }
    public int getIdUsuarioRegistro() { return idUsuarioRegistro; }
    public void setIdUsuarioRegistro(int idUsuarioRegistro) { this.idUsuarioRegistro = idUsuarioRegistro; }
    public Timestamp getFechaHoraInicio() { return fechaHoraInicio; }
    public void setFechaHoraInicio(Timestamp fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }
    public Timestamp getFechaHoraFin() { return fechaHoraFin; }
    public void setFechaHoraFin(Timestamp fechaHoraFin) { this.fechaHoraFin = fechaHoraFin; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public boolean isRecordatorioEnviado() { return recordatorioEnviado; }
    public void setRecordatorioEnviado(boolean recordatorioEnviado) { this.recordatorioEnviado = recordatorioEnviado; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}