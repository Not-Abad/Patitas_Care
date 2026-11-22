
package provet.modelo;

public class Reporte {
    private int idConsulta;
    private int idCita;
    private int idMascota;
    private int idVeterinario;
    private Integer idDiagnostico;
    private Integer idReceta;

    private String nombreMascota;
    private String especie;
    private String correoPropietario;
    private String fecha;
    private String veterinario;
    private String analisis;
    private String medicamentos;
    private String dosis;
    private String motivo;

    public Reporte() {}

    public Reporte(int idMascota, String nombreMascota, String especie, String fecha,
                   String veterinario, String analisis, String medicamentos,
                   String dosis, String motivo) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.fecha = fecha;
        this.veterinario = veterinario;
        this.analisis = analisis;
        this.medicamentos = medicamentos;
        this.dosis = dosis;
        this.motivo = motivo;
    }

    // Getters y Setters
    public int getIdConsulta() { return idConsulta; }
    public void setIdConsulta(int idConsulta) { this.idConsulta = idConsulta; }

    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }

    public int getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(int idVeterinario) { this.idVeterinario = idVeterinario; }

    public Integer getIdDiagnostico() { return idDiagnostico; }
    public void setIdDiagnostico(Integer idDiagnostico) { this.idDiagnostico = idDiagnostico; }

    public Integer getIdReceta() { return idReceta; }
    public void setIdReceta(Integer idReceta) { this.idReceta = idReceta; }

    public String getNombreMascota() { return nombreMascota; }
    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getCorreoPropietario() { return correoPropietario; }
    public void setCorreoPropietario(String correoPropietario) { this.correoPropietario = correoPropietario; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getVeterinario() { return veterinario; }
    public void setVeterinario(String veterinario) { this.veterinario = veterinario; }

    public String getAnalisis() { return analisis; }
    public void setAnalisis(String analisis) { this.analisis = analisis; }

    public String getMedicamentos() { return medicamentos; }
    public void setMedicamentos(String medicamentos) { this.medicamentos = medicamentos; }

    public String getDosis() { return dosis; }
    public void setDosis(String dosis) { this.dosis = dosis; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}