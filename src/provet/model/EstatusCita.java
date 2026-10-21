/* @author Not-Abad */

package provet.model;

public class EstatusCita {
    private int idEstatusCita;
    private String nomEstatusCita;
    
    public EstatusCita(){}
    
    public EstatusCita(int idEstatusCita, String nomEstatusCita){
        this.idEstatusCita  = idEstatusCita;
        this.nomEstatusCita = nomEstatusCita;
    }
    
    public int getIdEstatusCita(){ return idEstatusCita; }
    public void setIdEstatusCita(int idEstatusCita){ this.idEstatusCita  = idEstatusCita; }
    
    public String getNomEstatusCita() { return nomEstatusCita; }
    public void setNomEstatusCita(String nomEstatusCita) { this.nomEstatusCita = nomEstatusCita; }
}
