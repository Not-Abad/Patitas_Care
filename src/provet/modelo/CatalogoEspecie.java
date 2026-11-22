
package provet.modelo;

public class CatalogoEspecie {
    private int idEspecie;
    private String nombre;

    public CatalogoEspecie() {}
    public CatalogoEspecie(int idEspecie, String nombre) {
        this.idEspecie = idEspecie;
        this.nombre = nombre;
    }

    public int getIdEspecie() { return idEspecie; }
    public void setIdEspecie(int idEspecie) { this.idEspecie = idEspecie; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}