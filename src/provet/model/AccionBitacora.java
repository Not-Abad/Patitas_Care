package provet.model;

public class AccionBitacora {
    private int idAccion;
    private String nombreAccion;

    public AccionBitacora() {}

    public AccionBitacora(int idAccion, String nombreAccion) {
        this.idAccion = idAccion;
        this.nombreAccion = nombreAccion;
    }

    public int getIdAccion() { return idAccion; }
    public void setIdAccion(int idAccion) { this.idAccion = idAccion; }

    public String getNombreAccion() { return nombreAccion; }
    public void setNombreAccion(String nombreAccion) { this.nombreAccion = nombreAccion; }
}