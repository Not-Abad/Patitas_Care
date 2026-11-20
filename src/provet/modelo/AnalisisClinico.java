
package provet.modelo;

import java.sql.Timestamp;

public class AnalisisClinico {
    private int idAnalisis;
    private int idMascota;
    private Integer idConsulta;
    private Integer idDiagnostico;
    private int idVeterinario;
    private String tipoAnalisis;
    private String resultados;
    private String observaciones;
    private Timestamp fechaSolicitud;
    private Timestamp fechaResultado;
    private String estado;

    public AnalisisClinico() {}

    public int getIdAnalisis() { return idAnalisis; }
    public void setIdAnalisis(int idAnalisis) { this.idAnalisis = idAnalisis; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public Integer getIdConsulta() { return idConsulta; }
    public void setIdConsulta(Integer idConsulta) { this.idConsulta = idConsulta; }
    public Integer getIdDiagnostico() { return idDiagnostico; }
    public void setIdDiagnostico(Integer idDiagnostico) { this.idDiagnostico = idDiagnostico; }
    public int getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(int idVeterinario) { this.idVeterinario = idVeterinario; }
    public String getTipoAnalisis() { return tipoAnalisis; }
    public void setTipoAnalisis(String tipoAnalisis) { this.tipoAnalisis = tipoAnalisis; }
    public String getResultados() { return resultados; }
    public void setResultados(String resultados) { this.resultados = resultados; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public Timestamp getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(Timestamp fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }
    public Timestamp getFechaResultado() { return fechaResultado; }
    public void setFechaResultado(Timestamp fechaResultado) { this.fechaResultado = fechaResultado; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}