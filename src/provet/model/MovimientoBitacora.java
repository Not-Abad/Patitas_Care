package provet.model;

import java.sql.Timestamp;

public class MovimientoBitacora {
    private int idBitacora;
    private int idEmpleado;
    private int idAccion;
    private String tablaAfectada;
    private Integer idRegistroAfectado; // Puede ser nulo
    private String valorAnterior;
    private String valorNuevo;
    private Timestamp fechaMovimiento;

    public MovimientoBitacora() {}

    public MovimientoBitacora(int idBitacora, int idEmpleado, int idAccion, String tablaAfectada, Integer idRegistroAfectado, String valorAnterior, String valorNuevo, Timestamp fechaMovimiento) {
        this.idBitacora = idBitacora;
        this.idEmpleado = idEmpleado;
        this.idAccion = idAccion;
        this.tablaAfectada = tablaAfectada;
        this.idRegistroAfectado = idRegistroAfectado;
        this.valorAnterior = valorAnterior;
        this.valorNuevo = valorNuevo;
        this.fechaMovimiento = fechaMovimiento;
    }

    // Getters y Setters
    public int getIdBitacora() { return idBitacora; }
    public void setIdBitacora(int idBitacora) { this.idBitacora = idBitacora; }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public int getIdAccion() { return idAccion; }
    public void setIdAccion(int idAccion) { this.idAccion = idAccion; }

    public String getTablaAfectada() { return tablaAfectada; }
    public void setTablaAfectada(String tablaAfectada) { this.tablaAfectada = tablaAfectada; }

    public Integer getIdRegistroAfectado() { return idRegistroAfectado; }
    public void setIdRegistroAfectado(Integer idRegistroAfectado) { this.idRegistroAfectado = idRegistroAfectado; }

    public String getValorAnterior() { return valorAnterior; }
    public void setValorAnterior(String valorAnterior) { this.valorAnterior = valorAnterior; }

    public String getValorNuevo() { return valorNuevo; }
    public void setValorNuevo(String valorNuevo) { this.valorNuevo = valorNuevo; }

    public Timestamp getFechaMovimiento() { return fechaMovimiento; }
    public void setFechaMovimiento(Timestamp fechaMovimiento) { this.fechaMovimiento = fechaMovimiento; }
}