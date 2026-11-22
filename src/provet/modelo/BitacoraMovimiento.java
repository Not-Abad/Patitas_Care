 
package provet.modelo;

import java.sql.Timestamp;

public class BitacoraMovimiento {
    private long idBitacora;
    private int idUsuario;
    private String tablaAfectada;
    private int idRegistroAfectado;
    private String accion;
    private String valorAnterior;
    private String valorNuevo;
    private String descripcion;
    private Timestamp fechaHora;

    public BitacoraMovimiento() {}

    public long getIdBitacora() { return idBitacora; }
    public void setIdBitacora(long idBitacora) { this.idBitacora = idBitacora; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getTablaAfectada() { return tablaAfectada; }
    public void setTablaAfectada(String tablaAfectada) { this.tablaAfectada = tablaAfectada; }
    public int getIdRegistroAfectado() { return idRegistroAfectado; }
    public void setIdRegistroAfectado(int idRegistroAfectado) { this.idRegistroAfectado = idRegistroAfectado; }
    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }
    public String getValorAnterior() { return valorAnterior; }
    public void setValorAnterior(String valorAnterior) { this.valorAnterior = valorAnterior; }
    public String getValorNuevo() { return valorNuevo; }
    public void setValorNuevo(String valorNuevo) { this.valorNuevo = valorNuevo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Timestamp getFechaHora() { return fechaHora; }
    public void setFechaHora(Timestamp fechaHora) { this.fechaHora = fechaHora; }
}