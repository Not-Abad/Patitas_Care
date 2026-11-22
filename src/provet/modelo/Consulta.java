
package provet.modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Consulta {
    private int idConsulta;
    private int idCita;
    private int idMascota;
    private int idVeterinario;
    private Timestamp fechaConsulta;
    private BigDecimal pesoRegistradoKg;
    private BigDecimal temperaturaC;
    private Integer frecuenciaCardiaca;
    private String motivoConsulta;
    private String exploracionFisica;
    private String observaciones;

    public Consulta() {}

    public int getIdConsulta() { return idConsulta; }
    public void setIdConsulta(int idConsulta) { this.idConsulta = idConsulta; }
    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public int getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(int idVeterinario) { this.idVeterinario = idVeterinario; }
    public Timestamp getFechaConsulta() { return fechaConsulta; }
    public void setFechaConsulta(Timestamp fechaConsulta) { this.fechaConsulta = fechaConsulta; }
    public BigDecimal getPesoRegistradoKg() { return pesoRegistradoKg; }
    public void setPesoRegistradoKg(BigDecimal pesoRegistradoKg) { this.pesoRegistradoKg = pesoRegistradoKg; }
    public BigDecimal getTemperaturaC() { return temperaturaC; }
    public void setTemperaturaC(BigDecimal temperaturaC) { this.temperaturaC = temperaturaC; }
    public Integer getFrecuenciaCardiaca() { return frecuenciaCardiaca; }
    public void setFrecuenciaCardiaca(Integer frecuenciaCardiaca) { this.frecuenciaCardiaca = frecuenciaCardiaca; }
    public String getMotivoConsulta() { return motivoConsulta; }
    public void setMotivoConsulta(String motivoConsulta) { this.motivoConsulta = motivoConsulta; }
    public String getExploracionFisica() { return exploracionFisica; }
    public void setExploracionFisica(String exploracionFisica) { this.exploracionFisica = exploracionFisica; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}