/* @author Not-Abad */

package provet.model;

public class EstatusCliente {
    private int idEstatus;
    private String nomEstatusCliente;
    
    public EstatusCliente(){}
    
    public EstatusCliente(int idEstatus, String nomEstatusCliente){
        this.idEstatus  = idEstatus;
        this.nomEstatusCliente = nomEstatusCliente;
    }
    
    public int getIdEstatus(){ return idEstatus; }
    public void setIdEstatus(int idEstatus){ this.idEstatus  = idEstatus; }
    
    public String getNomEstatusCliente() { return nomEstatusCliente; }
    public void setNomEstatusCliente(String nomEstatusCliente) { this.nomEstatusCliente = nomEstatusCliente; }
}
