package provet.modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class PacienteDetalle {

    private int idMascota;
    private int idPropietario;
    private int idRaza;
    private String nombre;
    private String especie;
    private String raza;
    private Date fechaNacimiento;
    private Double peso;
    private String sexo;
    private String nombrePropietario;
    private String alergias;
    private String vacunas;
    private String fotoUrl;

    public PacienteDetalle() {}

    public String getEdadFormateada() {
        if (fechaNacimiento == null) {
            return "No registrada";
        }
        LocalDate nacimiento = fechaNacimiento.toLocalDate();
        LocalDate hoy = LocalDate.now();
        if (nacimiento.isAfter(hoy)) {
            return "0 meses";
        }
        Period periodo = Period.between(nacimiento, hoy);
        if (periodo.getYears() >= 1) {
            return periodo.getYears() + (periodo.getYears() == 1 ? " año" : " años");
        }
        if (periodo.getMonths() >= 1) {
            return periodo.getMonths() + (periodo.getMonths() == 1 ? " mes" : " meses");
        }
        return "Menos de 1 mes";
    }

    public String getPesoFormateado() {
        return (peso != null && peso > 0) ? peso + " kg" : "No registrado";
    }

    // Getters y Setters
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }

    public int getIdPropietario() { return idPropietario; }
    public void setIdPropietario(int idPropietario) { this.idPropietario = idPropietario; }

    public int getIdRaza() { return idRaza; }
    public void setIdRaza(int idRaza) { this.idRaza = idRaza; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getNombrePropietario() { return nombrePropietario; }
    public void setNombrePropietario(String nombrePropietario) { this.nombrePropietario = nombrePropietario; }

    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }

    public String getVacunas() { return vacunas; }
    public void setVacunas(String vacunas) { this.vacunas = vacunas; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
}