
package provet.modelo;

import java.sql.Timestamp;

public class Receta {
    private int idReceta;
    private int idDiagnostico;
    private int idVeterinario;
    private Timestamp fechaEmision;
    private String indicacionesGenerales;

    public Receta() {}

    public int getIdReceta() { return idReceta; }
    public void setIdReceta(int idReceta) { this.idReceta = idReceta; }
    public int getIdDiagnostico() { return idDiagnostico; }
    public void setIdDiagnostico(int idDiagnostico) { this.idDiagnostico = idDiagnostico; }
    public int getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(int idVeterinario) { this.idVeterinario = idVeterinario; }
    public Timestamp getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Timestamp fechaEmision) { this.fechaEmision = fechaEmision; }
    public String getIndicacionesGenerales() { return indicacionesGenerales; }
    public void setIndicacionesGenerales(String indicacionesGenerales) { this.indicacionesGenerales = indicacionesGenerales; }
}