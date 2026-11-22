
package provet.modelo;

import java.sql.Date;

public class EsquemaVacunacion {
    private int idAplicacion;
    private int idMascota;
    private int idVacuna;
    private int idVeterinario;
    private Integer idConsulta;
    private Date fechaAplicacion;
    private Date fechaProximaDosis;
    private String lote;
    private String observaciones;

    public EsquemaVacunacion() {}

    public int getIdAplicacion() { return idAplicacion; }
    public void setIdAplicacion(int idAplicacion) { this.idAplicacion = idAplicacion; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public int getIdVacuna() { return idVacuna; }
    public void setIdVacuna(int idVacuna) { this.idVacuna = idVacuna; }
    public int getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(int idVeterinario) { this.idVeterinario = idVeterinario; }
    public Integer getIdConsulta() { return idConsulta; }
    public void setIdConsulta(Integer idConsulta) { this.idConsulta = idConsulta; }
    public Date getFechaAplicacion() { return fechaAplicacion; }
    public void setFechaAplicacion(Date fechaAplicacion) { this.fechaAplicacion = fechaAplicacion; }
    public Date getFechaProximaDosis() { return fechaProximaDosis; }
    public void setFechaProximaDosis(Date fechaProximaDosis) { this.fechaProximaDosis = fechaProximaDosis; }
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}