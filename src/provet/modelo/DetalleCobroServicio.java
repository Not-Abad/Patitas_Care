
package provet.modelo;

import java.math.BigDecimal;

public class DetalleCobroServicio {
    private int idDetalleCobro;
    private int idCobro;
    private int idServicio;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public DetalleCobroServicio() {}

    public int getIdDetalleCobro() { return idDetalleCobro; }
    public void setIdDetalleCobro(int idDetalleCobro) { this.idDetalleCobro = idDetalleCobro; }
    public int getIdCobro() { return idCobro; }
    public void setIdCobro(int idCobro) { this.idCobro = idCobro; }
    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}