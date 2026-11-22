
package provet.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import provet.modelo.Reporte;
import provet.utilidades.Sesion;
import provet.utilidades.dbConection;

public class ReporteCitaDAO {

    /**
     * Busca los datos básicos de la mascota, su especie y el correo de su propietario.
     */
    public Reporte buscarDatosPaciente(int idMascota) {
        String sql = "SELECT m.id_mascota, m.nombre AS nombre_mascota, "
                   + "e.nombre AS nombre_especie, p.correo AS correo_propietario "
                   + "FROM mascotas m "
                   + "INNER JOIN catalogo_razas r ON m.id_raza = r.id_raza "
                   + "INNER JOIN catalogo_especies e ON r.id_especie = e.id_especie "
                   + "INNER JOIN propietarios p ON m.id_propietario = p.id_propietario "
                   + "WHERE m.id_mascota = ?";

        Connection conn = dbConection.getConexion();
        if (conn == null) return null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Reporte r = new Reporte();
                    r.setIdMascota(rs.getInt("id_mascota"));
                    r.setNombreMascota(rs.getString("nombre_mascota"));
                    r.setEspecie(rs.getString("nombre_especie"));
                    r.setCorreoPropietario(rs.getString("correo_propietario"));
                    return r;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en ReporteCitaDAO.buscarDatosPaciente: " + e.getMessage());
        }
        return null;
    }

    /**
     * Registra en MySQL la consulta, su diagnóstico base, y opcionalmente
     * el análisis clínico y la receta con su detalle de tratamiento.
     */
    public boolean registrarReporteCompleto(Reporte r) {
        Connection conn = dbConection.getConexion();
        if (conn == null) return false;

        int idVeterinario = Sesion.getIdPersonalActual();
        int idUsuario = Sesion.getIdUsuarioActual();

        if (idVeterinario == 0 || idUsuario == 0) {
            System.err.println("Error: No hay un veterinario con sesión activa.");
            return false;
        }

        try {
            conn.setAutoCommit(false);

            // 1. Buscar una cita pendiente del paciente o crear una cita inmediata completada
            int idCita = obtenerOCrearCitaParaConsulta(conn, r.getIdMascota(), idVeterinario, idUsuario, r.getMotivo());
            r.setIdCita(idCita);
            r.setIdVeterinario(idVeterinario);

            // 2. Insertar en 'consultas'
            String sqlConsulta = "INSERT INTO consultas (id_cita, id_mascota, id_veterinario, fecha_consulta, motivo_consulta, observaciones) "
                               + "VALUES (?, ?, ?, NOW(), ?, ?)";
            int idConsulta;
            try (PreparedStatement ps = conn.prepareStatement(sqlConsulta, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, idCita);
                ps.setInt(2, r.getIdMascota());
                ps.setInt(3, idVeterinario);
                ps.setString(4, r.getMotivo());
                ps.setString(5, "Análisis: " + r.getAnalisis() + " | Medicamento: " + r.getMedicamentos());
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (!rs.next()) throw new SQLException("No se generó id_consulta.");
                    idConsulta = rs.getInt(1);
                    r.setIdConsulta(idConsulta);
                }
            }

            // 3. Insertar diagnóstico presuntivo vinculado a la consulta
            String sqlDiag = "INSERT INTO diagnosticos (id_consulta, id_veterinario, descripcion, tipo_diagnostico, estado) "
                           + "VALUES (?, ?, ?, 'Presuntivo', 'Activo')";
            int idDiagnostico;
            try (PreparedStatement ps = conn.prepareStatement(sqlDiag, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, idConsulta);
                ps.setInt(2, idVeterinario);
                ps.setString(3, r.getMotivo());
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (!rs.next()) throw new SQLException("No se generó id_diagnostico.");
                    idDiagnostico = rs.getInt(1);
                    r.setIdDiagnostico(idDiagnostico);
                }
            }

            // 4. Si se solicitaron análisis clínicos, registrar en 'analisis_clinicos'
            if (tieneContenidoValido(r.getAnalisis())) {
                String sqlAnalisis = "INSERT INTO analisis_clinicos (id_mascota, id_consulta, id_diagnostico, id_veterinario, tipo_analisis, estado) "
                                   + "VALUES (?, ?, ?, ?, ?, 'Solicitado')";
                try (PreparedStatement ps = conn.prepareStatement(sqlAnalisis)) {
                    ps.setInt(1, r.getIdMascota());
                    ps.setInt(2, idConsulta);
                    ps.setInt(3, idDiagnostico);
                    ps.setInt(4, idVeterinario);
                    ps.setString(5, r.getAnalisis());
                    ps.executeUpdate();
                }
            }

            // 5. Si se indicaron medicamentos, registrar en 'recetas' y 'detalle_tratamiento'
            if (tieneContenidoValido(r.getMedicamentos())) {
                String sqlReceta = "INSERT INTO recetas (id_diagnostico, id_veterinario, indicaciones_generales) VALUES (?, ?, ?)";
                int idReceta;
                try (PreparedStatement ps = conn.prepareStatement(sqlReceta, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, idDiagnostico);
                    ps.setInt(2, idVeterinario);
                    ps.setString(3, r.getMotivo());
                    ps.executeUpdate();
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (!rs.next()) throw new SQLException("No se generó id_receta.");
                        idReceta = rs.getInt(1);
                        r.setIdReceta(idReceta);
                    }
                }

                String sqlDetalle = "INSERT INTO detalle_tratamiento (id_receta, medicamento, dosis, frecuencia, estado) "
                                  + "VALUES (?, ?, ?, ?, 'Activo')";
                try (PreparedStatement ps = conn.prepareStatement(sqlDetalle)) {
                    ps.setInt(1, idReceta);
                    ps.setString(2, r.getMedicamentos());
                    ps.setString(3, tieneContenidoValido(r.getDosis()) ? r.getDosis() : "Según indicación");
                    ps.setString(4, "Según indicación médica");
                    ps.executeUpdate();
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ex) { /* ignorar */ }
            System.err.println("Error en ReporteCitaDAO.registrarReporteCompleto: " + e.getMessage());
            return false;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException e) { /* ignorar */ }
        }
    }

    /**
     * Obtiene el historial de reportes clínicos desde MySQL para llenar el panel de consultas.
     */
    public List<Reporte> selectAllReportes() {
        List<Reporte> lista = new ArrayList<>();
        String sql = "SELECT c.id_consulta, c.id_cita, c.id_mascota, c.id_veterinario, c.fecha_consulta, c.motivo_consulta, "
                   + "m.nombre AS nombre_mascota, e.nombre AS nombre_especie, "
                   + "prop.correo AS correo_propietario, pers.nombre AS nombre_veterinario, "
                   + "d.id_diagnostico, "
                   + "(SELECT GROUP_CONCAT(ac.tipo_analisis SEPARATOR ', ') FROM analisis_clinicos ac WHERE ac.id_consulta = c.id_consulta) AS analisis, "
                   + "(SELECT r.id_receta FROM recetas r WHERE r.id_diagnostico = d.id_diagnostico LIMIT 1) AS id_receta, "
                   + "(SELECT GROUP_CONCAT(dt.medicamento SEPARATOR ', ') FROM detalle_tratamiento dt "
                   + "   INNER JOIN recetas r ON dt.id_receta = r.id_receta WHERE r.id_diagnostico = d.id_diagnostico) AS medicamentos, "
                   + "(SELECT GROUP_CONCAT(dt.dosis SEPARATOR ', ') FROM detalle_tratamiento dt "
                   + "   INNER JOIN recetas r ON dt.id_receta = r.id_receta WHERE r.id_diagnostico = d.id_diagnostico) AS dosis "
                   + "FROM consultas c "
                   + "INNER JOIN mascotas m ON c.id_mascota = m.id_mascota "
                   + "INNER JOIN catalogo_razas rz ON m.id_raza = rz.id_raza "
                   + "INNER JOIN catalogo_especies e ON rz.id_especie = e.id_especie "
                   + "INNER JOIN propietarios prop ON m.id_propietario = prop.id_propietario "
                   + "INNER JOIN personal pers ON c.id_veterinario = pers.id_personal "
                   + "LEFT JOIN diagnosticos d ON d.id_consulta = c.id_consulta "
                   + "ORDER BY c.fecha_consulta DESC";

        Connection conn = dbConection.getConexion();
        if (conn == null) return lista;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Reporte rep = new Reporte();
                rep.setIdConsulta(rs.getInt("id_consulta"));
                rep.setIdCita(rs.getInt("id_cita"));
                rep.setIdMascota(rs.getInt("id_mascota"));
                rep.setIdVeterinario(rs.getInt("id_veterinario"));
                rep.setIdDiagnostico(rs.getObject("id_diagnostico", Integer.class));
                rep.setIdReceta(rs.getObject("id_receta", Integer.class));
                rep.setNombreMascota(rs.getString("nombre_mascota"));
                rep.setEspecie(rs.getString("nombre_especie"));
                rep.setCorreoPropietario(rs.getString("correo_propietario"));
                Timestamp ts = rs.getTimestamp("fecha_consulta");
                rep.setFecha(ts != null ? sdf.format(ts) : "");
                rep.setVeterinario(rs.getString("nombre_veterinario"));
                rep.setMotivo(rs.getString("motivo_consulta"));
                String an = rs.getString("analisis");
                String med = rs.getString("medicamentos");
                String dos = rs.getString("dosis");
                rep.setAnalisis(an != null ? an : "Ninguno");
                rep.setMedicamentos(med != null ? med : "Ninguno");
                rep.setDosis(dos != null ? dos : "N/A");
                lista.add(rep);
            }
        } catch (SQLException e) {
            System.err.println("Error en ReporteCitaDAO.selectAllReportes: " + e.getMessage());
        }
        return lista;
    }

    private int obtenerOCrearCitaParaConsulta(Connection conn, int idMascota, int idVeterinario, int idUsuario, String motivo) throws SQLException {
        String sqlBuscar = "SELECT id_cita FROM citas "
                         + "WHERE id_mascota = ? AND estado IN ('Programada', 'Confirmada') "
                         + "AND id_cita NOT IN (SELECT id_cita FROM consultas) "
                         + "ORDER BY fecha_hora_inicio ASC LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(sqlBuscar)) {
            ps.setInt(1, idMascota);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int idCitaExistente = rs.getInt("id_cita");
                    try (PreparedStatement psUpd = conn.prepareStatement("UPDATE citas SET estado = 'Completada' WHERE id_cita = ?")) {
                        psUpd.setInt(1, idCitaExistente);
                        psUpd.executeUpdate();
                    }
                    return idCitaExistente;
                }
            }
        }

        String sqlNuevaCita = "INSERT INTO citas (id_mascota, id_veterinario, id_usuario_registro, fecha_hora_inicio, fecha_hora_fin, motivo, estado) "
                            + "VALUES (?, ?, ?, NOW(), DATE_ADD(NOW(), INTERVAL 30 MINUTE), ?, 'Completada')";
        try (PreparedStatement ps = conn.prepareStatement(sqlNuevaCita, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, idMascota);
            ps.setInt(2, idVeterinario);
            ps.setInt(3, idUsuario);
            ps.setString(4, motivo);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        throw new SQLException("No se pudo vincular ni crear la cita para la consulta.");
    }

    private boolean tieneContenidoValido(String valor) {
        if (valor == null) return false;
        String limpio = valor.trim().toLowerCase();
        return !limpio.isEmpty() && !limpio.equals("no") && !limpio.equals("ninguno") && !limpio.equals("n/a");
    }
}