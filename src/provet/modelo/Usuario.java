
package provet.modelo;

import java.sql.Timestamp;

public class Usuario {
    private int idUsuario;
    private int idRol;
    private String username;
    private String passwordHash;
    private boolean isActive;
    private Timestamp ultimoAcceso;
    private Timestamp createdAt;

    public Usuario() {}

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) { this.idRol = idRol; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public Timestamp getUltimoAcceso() { return ultimoAcceso; }
    public void setUltimoAcceso(Timestamp ultimoAcceso) { this.ultimoAcceso = ultimoAcceso; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}