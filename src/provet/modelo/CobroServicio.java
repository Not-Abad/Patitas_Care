
package provet.modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CobroServicio {
    private int idCobro;
    private int idPropietario;
    private int idMascota;
    private Integer idConsulta;
    private int idUsuarioRegistro;
    private Timestamp fechaCobro;
    private BigDecimal subtotal;
    private BigDecimal total;
    private String metodoPago;
    private String estado;
    private String motivoCancelacion;

    public CobroServicio() {}

    public int getIdCobro() { return idCobro; }
    public void setIdCobro(int idCobro) { this.idCobro = idCobro; }
    public int getIdPropietario() { return idPropietario; }
    public void setIdPropietario(int idPropietario) { this.idPropietario = idPropietario; }
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    public Integer getIdConsulta() { return idConsulta; }
    public void setIdConsulta(Integer idConsulta) { this.idConsulta = idConsulta; }
    public int getIdUsuarioRegistro() { return idUsuarioRegistro; }
    public void setIdUsuarioRegistro(int idUsuarioRegistro) { this.idUsuarioRegistro = idUsuarioRegistro; }
    public Timestamp getFechaCobro() { return fechaCobro; }
    public void setFechaCobro(Timestamp fechaCobro) { this.fechaCobro = fechaCobro; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getMotivoCancelacion() { return motivoCancelacion; }
    public void setMotivoCancelacion(String motivoCancelacion) { this.motivoCancelacion = motivoCancelacion; }
}