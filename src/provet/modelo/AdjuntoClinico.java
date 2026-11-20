
package provet.modelo;

import java.sql.Timestamp;

public class AdjuntoClinico {
    private int idAdjunto;
    private Integer idDiagnostico;
    private Integer idAnalisis;
    private String tipoArchivo;
    private String rutaArchivo;
    private String descripcion;
    private Timestamp fechaSubida;

    public AdjuntoClinico() {}

    public int getIdAdjunto() { return idAdjunto; }
    public void setIdAdjunto(int idAdjunto) { this.idAdjunto = idAdjunto; }
    public Integer getIdDiagnostico() { return idDiagnostico; }
    public void setIdDiagnostico(Integer idDiagnostico) { this.idDiagnostico = idDiagnostico; }
    public Integer getIdAnalisis() { return idAnalisis; }
    public void setIdAnalisis(Integer idAnalisis) { this.idAnalisis = idAnalisis; }
    public String getTipoArchivo() { return tipoArchivo; }
    public void setTipoArchivo(String tipoArchivo) { this.tipoArchivo = tipoArchivo; }
    public String getRutaArchivo() { return rutaArchivo; }
    public void setRutaArchivo(String rutaArchivo) { this.rutaArchivo = rutaArchivo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Timestamp getFechaSubida() { return fechaSubida; }
    public void setFechaSubida(Timestamp fechaSubida) { this.fechaSubida = fechaSubida; }
}