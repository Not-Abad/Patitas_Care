/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.view.secretario;

/**
 *
 * @author Andreij Haziel
 */
public class Cita {
    String cliente, mascota, fecha, hora, motivo;

    public Cita(String cliente, String mascota, String fecha, String hora, String motivo) {
        this.cliente = cliente;
        this.mascota = mascota;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }

    public String getCliente() { return cliente; }
    public String getMascota() { return mascota; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getMotivo() { return motivo; }
}