package provet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import provet.utilidades.dbConection;

public class MascotaSecretarioDAO {

    public static class MascotaDTO {
        public int idMascota;
        public int idPropietario;
        public int idRaza;
        public String nombreMascota;
        public String especie;
        public String raza;
        public String sexo;
        public String fechaNacimiento;
        public double pesoActualKg;
        public String antecedentesMedicos;
        public String estatus; // Activo, Inactivo, Fallecido
        public String nombrePropietario;
        public String telefonoPropietario;
        public String correoPropietario;
    }

    private Connection getConnection() throws SQLException {
    Connection conn = dbConection.getConexion();
    if (conn == null || conn.isClosed()) {
        throw new SQLException("No se pudo obtener una conexión activa desde dbConection.");
    }
    return conn;
}

    public List<MascotaDTO> selectAll() {
        List<MascotaDTO> lista = new ArrayList<>();
        String sql = "SELECT m.id_mascota, m.id_propietario, m.id_raza, m.nombre, m.sexo, "
                   + "m.fecha_nacimiento, m.peso_actual_kg, m.antecedentes_medicos, m.estatus, "
                   + "r.nombre AS raza, e.nombre AS especie, "
                   + "p.nombre AS nombre_prop, p.telefono, p.correo "
                   + "FROM mascotas m "
                   + "INNER JOIN catalogo_razas r ON m.id_raza = r.id_raza "
                   + "INNER JOIN catalogo_especies e ON r.id_especie = e.id_especie "
                   + "INNER JOIN propietarios p ON m.id_propietario = p.id_propietario "
                   + "ORDER BY m.id_mascota DESC";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearDTO(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public MascotaDTO selectById(int idMascota) {
        String sql = "SELECT m.id_mascota, m.id_propietario, m.id_raza, m.nombre, m.sexo, "
                   + "m.fecha_nacimiento, m.peso_actual_kg, m.antecedentes_medicos, m.estatus, "
                   + "r.nombre AS raza, e.nombre AS especie, "
                   + "p.nombre AS nombre_prop, p.telefono, p.correo "
                   + "FROM mascotas m "
                   + "INNER JOIN catalogo_razas r ON m.id_raza = r.id_raza "
                   + "INNER JOIN catalogo_especies e ON r.id_especie = e.id_especie "
                   + "INNER JOIN propietarios p ON m.id_propietario = p.id_propietario "
                   + "WHERE m.id_mascota = ?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapearDTO(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Inserta propietario (si no existe) y mascota con peso y antecedentes médicos en patitas_final.
     */
    public int insertar(String nombreMascota, String especie, String raza, String sexo,
                        String fechaNacimiento, Double pesoActualKg, String antecedentesMedicos,
                        String nombreProp, String telefonoProp, String direccionProp, String correoProp) {
        try (Connection cn = getConnection()) {
            cn.setAutoCommit(false);
            try {
                int idPropietario = resolverOInsertarPropietario(cn, nombreProp, telefonoProp, direccionProp, correoProp);
                int idRaza = resolverOInsertarRaza(cn, especie, raza);

                String sql = "INSERT INTO mascotas "
                           + "(id_propietario, id_raza, nombre, sexo, fecha_nacimiento, peso_actual_kg, antecedentes_medicos, estatus) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, 'Activo')";
                try (PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, idPropietario);
                    ps.setInt(2, idRaza);
                    ps.setString(3, nombreMascota);
                    ps.setString(4, (sexo != null && sexo.equalsIgnoreCase("Hembra")) ? "Hembra" : "Macho");

                    if (fechaNacimiento != null && !fechaNacimiento.trim().isEmpty()) {
                        ps.setDate(5, java.sql.Date.valueOf(fechaNacimiento.trim()));
                    } else {
                        ps.setNull(5, Types.DATE);
                    }

                    if (pesoActualKg != null) {
                        ps.setDouble(6, pesoActualKg);
                    } else {
                        ps.setNull(6, Types.DECIMAL);
                    }

                    if (antecedentesMedicos != null && !antecedentesMedicos.trim().isEmpty()) {
                        ps.setString(7, antecedentesMedicos.trim());
                    } else {
                        ps.setNull(7, Types.VARCHAR);
                    }

                    ps.executeUpdate();
                    try (ResultSet gk = ps.getGeneratedKeys()) {
                        if (gk.next()) {
                            int idMascota = gk.getInt(1);
                            cn.commit();
                            return idMascota;
                        }
                    }
                }
                cn.rollback();
            } catch (Exception e) {
                cn.rollback();
                throw e;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    /**
     * Sobrecarga de 9 parámetros por compatibilidad con llamadas anteriores.
     */
    public int insertar(String nombreMascota, String especie, String raza, String sexo,
                        String fechaNacimiento, String nombreProp, String telefonoProp,
                        String direccionProp, String correoProp) {
        return insertar(nombreMascota, especie, raza, sexo, fechaNacimiento,
                        null, null, nombreProp, telefonoProp, direccionProp, correoProp);
    }

    public boolean actualizar(int idMascota, String nombre, String raza, String especie,
                              String sexo, String fechaNacimiento, String estatus) {
        String sql = "UPDATE mascotas SET nombre = ?, id_raza = ?, sexo = ?, fecha_nacimiento = ?, estatus = ? "
                   + "WHERE id_mascota = ?";
        try (Connection cn = getConnection()) {
            int idRaza = resolverOInsertarRaza(cn, especie, raza);
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setInt(2, idRaza);
                ps.setString(3, (sexo != null && sexo.equalsIgnoreCase("Hembra")) ? "Hembra" : "Macho");
                if (fechaNacimiento != null && !fechaNacimiento.trim().isEmpty()) {
                    ps.setDate(4, java.sql.Date.valueOf(fechaNacimiento.trim()));
                } else {
                    ps.setNull(4, Types.DATE);
                }
                ps.setString(5, estatus);
                ps.setInt(6, idMascota);
                return ps.executeUpdate() > 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /** Baja lógica respetando llaves foráneas en citas, consultas y cobros_servicios. */
    public boolean darDeBaja(int idMascota) {
        String sql = "UPDATE mascotas SET estatus = 'Inactivo' WHERE id_mascota = ?";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int idMascota) {
        return darDeBaja(idMascota);
    }

    public int contarMascotas() {
        String sql = "SELECT COUNT(*) FROM mascotas WHERE estatus = 'Activo'";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<String> getEspecies() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nombre FROM catalogo_especies ORDER BY nombre";
        try (Connection cn = getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(rs.getString("nombre"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<String> getSexos() {
        return List.of("Macho", "Hembra");
    }

    public int resolverOInsertarRaza(Connection cn, String especie, String raza) throws SQLException {
        String esp = (especie == null || especie.trim().isEmpty()) ? "Perro" : especie.trim();
        String raz = (raza == null || raza.trim().isEmpty()) ? "Mestizo" : raza.trim();

        int idEspecie = -1;
        try (PreparedStatement ps = cn.prepareStatement("SELECT id_especie FROM catalogo_especies WHERE LOWER(nombre) = LOWER(?)")) {
            ps.setString(1, esp);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) idEspecie = rs.getInt(1);
            }
        }
        if (idEspecie == -1) {
            try (PreparedStatement ps = cn.prepareStatement("INSERT INTO catalogo_especies (nombre) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, esp);
                ps.executeUpdate();
                try (ResultSet gk = ps.getGeneratedKeys()) {
                    if (gk.next()) idEspecie = gk.getInt(1);
                }
            }
        }

        try (PreparedStatement ps = cn.prepareStatement("SELECT id_raza FROM catalogo_razas WHERE id_especie = ? AND LOWER(nombre) = LOWER(?)")) {
            ps.setInt(1, idEspecie);
            ps.setString(2, raz);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO catalogo_razas (id_especie, nombre) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, idEspecie);
            ps.setString(2, raz);
            ps.executeUpdate();
            try (ResultSet gk = ps.getGeneratedKeys()) {
                if (gk.next()) return gk.getInt(1);
            }
        }
        throw new SQLException("No se pudo resolver id_raza");
    }

    private int resolverOInsertarPropietario(Connection cn, String nombreProp, String telefono,
                                             String direccion, String correo) throws SQLException {
        String dato = (nombreProp == null || nombreProp.trim().isEmpty()) ? "Sin especificar" : nombreProp.trim();

        if (dato.matches("\\d+")) {
            int idBuscado = Integer.parseInt(dato);
            try (PreparedStatement ps = cn.prepareStatement("SELECT id_propietario FROM propietarios WHERE id_propietario = ?")) {
                ps.setInt(1, idBuscado);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) return rs.getInt(1);
                }
            }
        }

        try (PreparedStatement ps = cn.prepareStatement("SELECT id_propietario FROM propietarios WHERE LOWER(nombre) = LOWER(?) LIMIT 1")) {
            ps.setString(1, dato);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }

        String sqlIns = "INSERT INTO propietarios (nombre, telefono, correo, direccion, is_active) VALUES (?, ?, ?, ?, 1)";
        try (PreparedStatement ps = cn.prepareStatement(sqlIns, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, dato);
            ps.setString(2, (telefono != null && !telefono.trim().isEmpty()) ? telefono.trim() : null);
            ps.setString(3, (correo != null && !correo.trim().isEmpty()) ? correo.trim() : null);
            ps.setString(4, (direccion != null && !direccion.trim().isEmpty()) ? direccion.trim() : null);
            ps.executeUpdate();
            try (ResultSet gk = ps.getGeneratedKeys()) {
                if (gk.next()) return gk.getInt(1);
            }
        }
        throw new SQLException("No se pudo registrar ni localizar al propietario");
    }

    private MascotaDTO mapearDTO(ResultSet rs) throws SQLException {
        MascotaDTO d = new MascotaDTO();
        d.idMascota = rs.getInt("id_mascota");
        d.idPropietario = rs.getInt("id_propietario");
        d.idRaza = rs.getInt("id_raza");
        d.nombreMascota = rs.getString("nombre");
        d.sexo = rs.getString("sexo");
        Date fn = rs.getDate("fecha_nacimiento");
        d.fechaNacimiento = fn != null ? fn.toString() : "";
        d.pesoActualKg = rs.getDouble("peso_actual_kg");
        d.antecedentesMedicos = rs.getString("antecedentes_medicos");
        d.estatus = rs.getString("estatus");
        d.raza = rs.getString("raza");
        d.especie = rs.getString("especie");
        d.nombrePropietario = rs.getString("nombre_prop");
        d.telefonoPropietario = rs.getString("telefono");
        d.correoPropietario = rs.getString("correo");
        return d;
    }
}