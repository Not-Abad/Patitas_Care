package provet.model;

import java.util.ArrayList;
import java.util.List;

public class RecetaMedica {

    private String nombre;
    private String fecha;
    private String especie;
    private String correo;
    private String motivo;

    private List<MedicamentoRecetado> medicamentos;

    public RecetaMedica() {
        medicamentos = new ArrayList<>();
    }

    public RecetaMedica(String nombre,
                        String fecha,
                        String especie,
                        String correo,
                        String motivo) {

        this.nombre = nombre;
        this.fecha = fecha;
        this.especie = especie;
        this.correo = correo;
        this.motivo = motivo;

        medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(MedicamentoRecetado medicamento) {
        medicamentos.add(medicamento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEspecie() {
        return especie;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMotivo() {
        return motivo;
    }

    public List<MedicamentoRecetado> getMedicamentos() {
        return medicamentos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setMedicamentos(List<MedicamentoRecetado> medicamentos) {
        this.medicamentos = medicamentos;
    }
}