package provet.modelo;

public class CatalogoRaza {
    private int idRaza;
    private int idEspecie;
    private String nombre;

    public CatalogoRaza() {}
    public CatalogoRaza(int idRaza, int idEspecie, String nombre) {
        this.idRaza = idRaza;
        this.idEspecie = idEspecie;
        this.nombre = nombre;
    }

    public int getIdRaza() { return idRaza; }
    public void setIdRaza(int idRaza) { this.idRaza = idRaza; }
    public int getIdEspecie() { return idEspecie; }
    public void setIdEspecie(int idEspecie) { this.idEspecie = idEspecie; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}