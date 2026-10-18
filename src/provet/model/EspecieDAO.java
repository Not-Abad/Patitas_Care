
package provet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecieDAO {
    
    // Conexión requerida por el diagrama de clases
    private Connection conn;

    // Constructor que recibe la conexión activa (siguiendo el patrón del UML)
    public EspecieDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Inserta un nuevo registro en cat_especie.
     * Retorna el ID autogenerado o el número de filas afectadas según la convención del proyecto.
     */
    public int insert(Especie obj) {
        String sql = "INSERT INTO cat_especie (nombre_especie) VALUES (?);";
        // Se puede configurar para recuperar la llave primaria generada (AI)
        try (PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, obj.getNombreEspecie());
            int affectedRows = ps.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // Retorna el id_especie generado
                    }
                }
            }
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Modifica el nombre de una especie existente filtrando por su ID.
     */
    public boolean update(Especie obj) {
        String sql = "UPDATE cat_especie SET nombre_especie = ? WHERE id_especie = ?;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, obj.getNombreEspecie());
            ps.setInt(2, obj.getIdEspecie());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina una especie de la base de datos por su ID.
     */
    public boolean delete(int id) {
        String sql = "DELETE FROM cat_especie WHERE id_especie = ?;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Busca y retorna una Especie específica en base a su ID.
     */
    public Especie selectById(int id) {
        String sql = "SELECT id_especie, nombre_especie FROM cat_especie WHERE id_especie = ?;";
        Especie especie = null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    especie = new Especie();
                    especie.setIdEspecie(rs.getInt("id_especie"));
                    especie.setNombreEspecie(rs.getString("nombre_especie"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especie;
    }

    /**
     * Recupera y retorna la lista completa de todas las especies registradas.
     */
    public List<Especie> selectAll() {
        String sql = "SELECT id_especie, nombre_especie FROM cat_especie;";
        List<Especie> lista = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Especie especie = new Especie();
                especie.setIdEspecie(rs.getInt("id_especie"));
                especie.setNombreEspecie(rs.getString("nombre_especie"));
                lista.add(especie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}