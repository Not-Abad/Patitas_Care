
package provet.model;

import java.sql.Timestamp;

public class Cita {
    private int idCita;
    private int idCliente;
    private Integer idMascota; // Usamos Integer porque en tu ERD dice (NULL)
    private int idEstatusCita;
    private Timestamp fechaProgramada;
    private String motivo;

    public Cita() {}

    public Cita(int idCita, int idCliente, Integer idMascota, int idEstatusCita, Timestamp fechaProgramada, String motivo) {
        this.idCita = idCita;
        this.idCliente = idCliente;
        this.idMascota = idMascota;
        this.idEstatusCita = idEstatusCita;
        this.fechaProgramada = fechaProgramada;
        this.motivo = motivo;
    }

    // Getters y Setters
    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public Integer getIdMascota() { return idMascota; }
    public void setIdMascota(Integer idMascota) { this.idMascota = idMascota; }

    public int getIdEstatusCita() { return idEstatusCita; }
    public void setIdEstatusCita(int idEstatusCita) { this.idEstatusCita = idEstatusCita; }

    public Timestamp getFechaProgramada() { return fechaProgramada; }
    public void setFechaProgramada(Timestamp fechaProgramada) { this.fechaProgramada = fechaProgramada; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}