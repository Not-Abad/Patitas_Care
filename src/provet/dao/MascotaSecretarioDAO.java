package provet.dao;

import provet.utilidades.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO del secretario para gestionar mascotas.
 * Maneja las tablas: mts_mascota, mts_cliente, mts_persona, cat_raza, cat_especie, cat_sexo_animal
 */
public class MascotaSecretarioDAO {

    // ---------- MODELO INTERNO (usado por los formularios del secretario) ----------
    public static class MascotaDTO {
        public int idMascota;
        public int idCliente;
        public int idPersona;
        public String nombreMascota;
        public String especie;
        public int idEspecie;
        public String raza;
        public int idRaza;
        public String sexo;
        public int idSexo;
        public String fechaNacimiento; // "yyyy-MM-dd"
        // Datos del propietario
        public String nombrePropietario;
        public String telefonoPropietario;
        public String emailPropietario;
        // Estado del cliente
        public String estatusCliente;
        public int idEstatus;
    }

    // ---------- OBTENER TODAS LAS MASCOTAS CON SUS DATOS ----------
    public List<MascotaDTO> selectAll() {
        List<MascotaDTO> lista = new ArrayList<>();
        String sql =
            "SELECT m.id_mascota, m.id_cliente, m.nombre, " +
            "       e.nombre_especie, r.nombre_raza, r.id_raza, " +
            "       s.nombre_sexo, s.id_sexo, m.fecha_nacimiento, " +
            "       p.id_persona, p.nombre AS nom_prop, p.apellido_paterno, " +
            "       p.telefono, p.email, " +
            "       ec.nom_estatus_cliente, ec.id_estatus, " +
            "       e.id_especie " +
            "FROM mts_mascota m " +
            "JOIN mts_cliente c  ON m.id_cliente  = c.id_cliente " +
            "JOIN mts_persona p  ON c.id_persona  = p.id_persona " +
            "JOIN cat_raza r     ON m.id_raza      = r.id_raza " +
            "JOIN cat_especie e  ON r.id_especie   = e.id_especie " +
            "JOIN cat_sexo_animal s ON m.id_sexo   = s.id_sexo " +
            "JOIN cat_estatus_cliente ec ON c.id_estatus = ec.id_estatus " +
            "ORDER BY m.id_mascota";
        Connection conn = Conexion.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MascotaDTO d = new MascotaDTO();
                d.idMascota       = rs.getInt("id_mascota");
                d.idCliente       = rs.getInt("id_cliente");
                d.idPersona       = rs.getInt("id_persona");
                d.nombreMascota   = rs.getString("nombre");
                d.especie         = rs.getString("nombre_especie");
                d.idEspecie       = rs.getInt("id_especie");
                d.raza            = rs.getString("nombre_raza");
                d.idRaza          = rs.getInt("id_raza");
                d.sexo            = rs.getString("nombre_sexo");
                d.idSexo          = rs.getInt("id_sexo");
                d.fechaNacimiento = rs.getString("fecha_nacimiento");
                d.nombrePropietario = rs.getString("nom_prop") + " " + rs.getString("apellido_paterno");
                d.telefonoPropietario = rs.getString("telefono");
                d.emailPropietario    = rs.getString("email");
                d.estatusCliente      = rs.getString("nom_estatus_cliente");
                d.idEstatus           = rs.getInt("id_estatus");
                lista.add(d);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar mascotas: " + e.getMessage());
        }
        return lista;
    }

    // ---------- OBTENER UNA MASCOTA POR ID ----------
    public MascotaDTO selectById(int idMascota) {
        String sql =
            "SELECT m.id_mascota, m.id_cliente, m.nombre, " +
            "       e.nombre_especie, r.nombre_raza, r.id_raza, " +
            "       s.nombre_sexo, s.id_sexo, m.fecha_nacimiento, " +
            "       p.id_persona, p.nombre AS nom_prop, p.apellido_paterno, " +
            "       p.telefono, p.email, " +
            "       ec.nom_estatus_cliente, ec.id_estatus, " +
            "       e.id_especie " +
            "FROM mts_mascota m " +
            "JOIN mts_cliente c  ON m.id_cliente  = c.id_cliente " +
            "JOIN mts_persona p  ON c.id_persona  = p.id_persona " +
            "JOIN cat_raza r     ON m.id_raza      = r.id_raza " +
            "JOIN cat_especie e  ON r.id_especie   = e.id_especie " +
            "JOIN cat_sexo_animal s ON m.id_sexo   = s.id_sexo " +
            "JOIN cat_estatus_cliente ec ON c.id_estatus = ec.id_estatus " +
            "WHERE m.id_mascota = ?";
        Connection conn = Conexion.getConexion();
        if (conn == null) return null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    MascotaDTO d = new MascotaDTO();
                    d.idMascota       = rs.getInt("id_mascota");
                    d.idCliente       = rs.getInt("id_cliente");
                    d.idPersona       = rs.getInt("id_persona");
                    d.nombreMascota   = rs.getString("nombre");
                    d.especie         = rs.getString("nombre_especie");
                    d.idEspecie       = rs.getInt("id_especie");
                    d.raza            = rs.getString("nombre_raza");
                    d.idRaza          = rs.getInt("id_raza");
                    d.sexo            = rs.getString("nombre_sexo");
                    d.idSexo          = rs.getInt("id_sexo");
                    d.fechaNacimiento = rs.getString("fecha_nacimiento");
                    d.nombrePropietario = rs.getString("nom_prop") + " " + rs.getString("apellido_paterno");
                    d.telefonoPropietario = rs.getString("telefono");
                    d.emailPropietario    = rs.getString("email");
                    d.estatusCliente      = rs.getString("nom_estatus_cliente");
                    d.idEstatus           = rs.getInt("id_estatus");
                    return d;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar mascota: " + e.getMessage());
        }
        return null;
    }

    /**
     * Registra una mascota nueva.
     * Si la raza no existe la crea; si el propietario (email) no existe lo crea también.
     * Retorna el id_mascota generado, o -1 si falla.
     */
    public int insertar(
            String nombreMascota,
            String nombreEspecie,
            String nombreRaza,
            String nombreSexo,
            String fechaNacimiento,
            String nombrePropietario,
            String apellidoProp,
            String telefonoProp,
            String emailProp
    ) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return -1;
        try {
            conn.setAutoCommit(false);

            // 1. Obtener id_especie
            int idEspecie = obtenerOCrearEspecie(conn, nombreEspecie);

            // 2. Obtener/crear raza
            int idRaza = obtenerOCrearRaza(conn, nombreRaza, idEspecie);

            // 3. Obtener id_sexo
            int idSexo = obtenerSexo(conn, nombreSexo);
            if (idSexo == -1) idSexo = 1; // fallback "Macho"

            // 4. Obtener/crear persona (propietario)
            int idPersona = obtenerOCrearPersona(conn, nombrePropietario, apellidoProp, telefonoProp, emailProp);

            // 5. Obtener/crear cliente
            int idCliente = obtenerOCrearCliente(conn, idPersona);

            // 6. Insertar mascota
            String sqlMascota = "INSERT INTO mts_mascota (id_cliente, id_raza, id_sexo, nombre, fecha_nacimiento) VALUES (?,?,?,?,?)";
            int idMascota = -1;
            try (PreparedStatement ps = conn.prepareStatement(sqlMascota, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, idCliente);
                ps.setInt(2, idRaza);
                ps.setInt(3, idSexo);
                ps.setString(4, nombreMascota);
                ps.setString(5, fechaNacimiento);
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) idMascota = rs.getInt(1);
                }
            }
            conn.commit();
            conn.setAutoCommit(true);
            return idMascota;
        } catch (SQLException e) {
            System.err.println("Error al registrar mascota: " + e.getMessage());
            try { conn.rollback(); conn.setAutoCommit(true); } catch (SQLException ex2) { /* ignore */ }
            return -1;
        }
    }

    /**
     * Actualiza el nombre y raza de una mascota existente.
     */
    public boolean actualizar(int idMascota, String nombreMascota, String nombreRaza, String nombreEspecie, String nombreSexo, String fechaNacimiento) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return false;
        try {
            conn.setAutoCommit(false);
            int idEspecie = obtenerOCrearEspecie(conn, nombreEspecie);
            int idRaza    = obtenerOCrearRaza(conn, nombreRaza, idEspecie);
            int idSexo    = obtenerSexo(conn, nombreSexo);
            if (idSexo == -1) idSexo = 1;

            String sql = "UPDATE mts_mascota SET nombre=?, id_raza=?, id_sexo=?, fecha_nacimiento=? WHERE id_mascota=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nombreMascota);
                ps.setInt(2, idRaza);
                ps.setInt(3, idSexo);
                ps.setString(4, fechaNacimiento);
                ps.setInt(5, idMascota);
                ps.executeUpdate();
            }
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar mascota: " + e.getMessage());
            try { conn.rollback(); conn.setAutoCommit(true); } catch (SQLException ex2) { /* ignore */ }
            return false;
        }
    }

    /**
     * Elimina una mascota de la base de datos (baja definitiva).
     */
    public boolean eliminar(int idMascota) {
        Connection conn = Conexion.getConexion();
        if (conn == null) return false;
        // Primero eliminar citas relacionadas para no violar FK
        try {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM trn_cita WHERE id_mascota=?")) {
                ps.setInt(1, idMascota);
                ps.executeUpdate();
            }
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM mts_mascota WHERE id_mascota=?")) {
                ps.setInt(1, idMascota);
                ps.executeUpdate();
            }
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar mascota: " + e.getMessage());
            try { conn.rollback(); conn.setAutoCommit(true); } catch (SQLException ex2) { /* ignore */ }
            return false;
        }
    }

    // ---------- HELPERS ----------

    private int obtenerOCrearEspecie(Connection conn, String nombre) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_especie FROM cat_especie WHERE nombre_especie=?")) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO cat_especie (nombre_especie) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nombre);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return 1; // fallback
    }

    private int obtenerOCrearRaza(Connection conn, String nombre, int idEspecie) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_raza FROM cat_raza WHERE nombre_raza=? AND id_especie=?")) {
            ps.setString(1, nombre);
            ps.setInt(2, idEspecie);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        // Buscar por nombre sin importar especie
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_raza FROM cat_raza WHERE nombre_raza=?")) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO cat_raza (id_especie, nombre_raza) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, idEspecie);
            ps.setString(2, nombre);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return 1;
    }

    private int obtenerSexo(Connection conn, String nombre) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_sexo FROM cat_sexo_animal WHERE nombre_sexo=?")) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    private int obtenerOCrearPersona(Connection conn, String nombre, String apellido, String telefono, String email) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_persona FROM mts_persona WHERE email=?")) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        String sql = "INSERT INTO mts_persona (nombre, apellido_paterno, telefono, email) VALUES (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido != null && !apellido.isEmpty() ? apellido : "-");
            if (telefono != null && !telefono.trim().isEmpty()) {
                ps.setString(3, telefono.trim());
            } else {
                ps.setNull(3, Types.VARCHAR);
            }
            ps.setString(4, email);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    private int obtenerOCrearCliente(Connection conn, int idPersona) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_cliente FROM mts_cliente WHERE id_persona=?")) {
            ps.setInt(1, idPersona);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO mts_cliente (id_persona, id_estatus) VALUES (?,2)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, idPersona);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    // ---------- CATÁLOGOS PARA COMBOS ----------

    public List<String> getEspecies() {
        List<String> lista = new ArrayList<>();
        Connection conn = Conexion.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement("SELECT nombre_especie FROM cat_especie ORDER BY nombre_especie");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(rs.getString(1));
        } catch (SQLException e) {
            System.err.println("Error al obtener especies: " + e.getMessage());
        }
        return lista;
    }

    public List<String> getSexos() {
        List<String> lista = new ArrayList<>();
        Connection conn = Conexion.getConexion();
        if (conn == null) return lista;
        try (PreparedStatement ps = conn.prepareStatement("SELECT nombre_sexo FROM cat_sexo_animal ORDER BY id_sexo");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(rs.getString(1));
        } catch (SQLException e) {
            System.err.println("Error al obtener sexos: " + e.getMessage());
        }
        return lista;
    }

    public int contarMascotas() {
        Connection conn = Conexion.getConexion();
        if (conn == null) return 0;
        try (PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM mts_mascota");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("Error al contar mascotas: " + e.getMessage());
        }
        return 0;
    }
}
