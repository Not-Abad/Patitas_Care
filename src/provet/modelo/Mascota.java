
package provet.modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Mascota {
    private int idMascota;
    private int idPropietario;
    private int idRaza;
    private String nombre;
    private String sexo;
    private Date fechaNacimiento;
    private BigDecimal pesoActualKg;
    private String antecedentesMedicos;
    private String estatus;
    private Timestamp createdAt;

    public Mascota() {}

    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public int getIdPropietario() { return idPropietario; }
    public void setIdPropietario(int idPropietario) { this.idPropietario = idPropietario; }
    public int getIdRaza() { return idRaza; }
    public void setIdRaza(int idRaza) { this.idRaza = idRaza; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public BigDecimal getPesoActualKg() { return pesoActualKg; }
    public void setPesoActualKg(BigDecimal pesoActualKg) { this.pesoActualKg = pesoActualKg; }
    public String getAntecedentesMedicos() { return antecedentesMedicos; }
    public void setAntecedentesMedicos(String antecedentesMedicos) { this.antecedentesMedicos = antecedentesMedicos; }
    public String getEstatus() { return estatus; }
    public void setEstatus(String estatus) { this.estatus = estatus; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}