
package provet.modelo;

public class CatalogoVacuna {
    private int idVacuna;
    private String nombre;
    private String descripcion;
    private Integer intervaloRefuerzoDias;
    private boolean isActive;

    public CatalogoVacuna() {}

    public int getIdVacuna() { return idVacuna; }
    public void setIdVacuna(int idVacuna) { this.idVacuna = idVacuna; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Integer getIntervaloRefuerzoDias() { return intervaloRefuerzoDias; }
    public void setIntervaloRefuerzoDias(Integer intervaloRefuerzoDias) { this.intervaloRefuerzoDias = intervaloRefuerzoDias; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}