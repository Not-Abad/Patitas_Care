
package provet.view.secretario;

/* Modelo de vista para Cita alineado con la tabla `citas` de patitas_final. */
public class Cita {
    private int idCita;
    private int idMascota;
    private int idVeterinario;
    private int idUsuarioRegistro;
    private String cliente;
    private String telefonoCliente;
    private String mascota;
    private String especie;
    private String raza;
    private String veterinario;
    private String fecha;
    private String hora;
    private String fechaHoraInicio;
    private String fechaHoraFin;
    private String motivo;
    private String estado;
    private boolean recordatorioEnviado;

    public Cita(String cliente, String mascota, String fecha, String hora, String motivo) {
        this.cliente = cliente;
        this.mascota = mascota;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = "Programada";
    }

    public Cita(int idCita, int idMascota, int idVeterinario, int idUsuarioRegistro,
                String cliente, String telefonoCliente, String mascota, String especie,
                String raza, String veterinario, String fecha, String hora,
                String fechaHoraInicio, String fechaHoraFin, String motivo,
                String estado, boolean recordatorioEnviado) {
        this.idCita = idCita;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.cliente = cliente;
        this.telefonoCliente = telefonoCliente;
        this.mascota = mascota;
        this.especie = especie;
        this.raza = raza;
        this.veterinario = veterinario;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.motivo = motivo;
        this.estado = estado;
        this.recordatorioEnviado = recordatorioEnviado;
    }

    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }

    public int getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(int idVeterinario) { this.idVeterinario = idVeterinario; }

    public int getIdUsuarioRegistro() { return idUsuarioRegistro; }
    public void setIdUsuarioRegistro(int idUsuarioRegistro) { this.idUsuarioRegistro = idUsuarioRegistro; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getTelefonoCliente() { return telefonoCliente; }
    public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }

    public String getMascota() { return mascota; }
    public void setMascota(String mascota) { this.mascota = mascota; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getVeterinario() { return veterinario; }
    public void setVeterinario(String veterinario) { this.veterinario = veterinario; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getFechaHoraInicio() { return fechaHoraInicio; }
    public void setFechaHoraInicio(String fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }

    public String getFechaHoraFin() { return fechaHoraFin; }
    public void setFechaHoraFin(String fechaHoraFin) { this.fechaHoraFin = fechaHoraFin; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public boolean isRecordatorioEnviado() { return recordatorioEnviado; }
    public void setRecordatorioEnviado(boolean recordatorioEnviado) { this.recordatorioEnviado = recordatorioEnviado; }
}