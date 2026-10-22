package provet.model;

public class MedicamentoRecetado {

    private String medicamento;
    private String dosis;
    private String frecuencia;
    private String viaAdministracion;
    private String duracion;

    public MedicamentoRecetado() {
    }

    public MedicamentoRecetado(String medicamento,
                               String dosis,
                               String frecuencia,
                               String viaAdministracion,
                               String duracion) {

        this.medicamento = medicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.viaAdministracion = viaAdministracion;
        this.duracion = duracion;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}