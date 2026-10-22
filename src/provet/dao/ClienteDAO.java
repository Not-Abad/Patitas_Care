/* @author jesus-abad */
package provet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import provet.model.Cliente;
import provet.utilidades.Conexion; // Tu clase de conexión

public class ClienteDAO {

    // 1. MÉTODO PARA REGISTRAR (Con Transacción SQL)
    public boolean registrarCliente(Cliente cliente) {
        String sqlPersona = "INSERT INTO mts_persona (nombre, apellido_paterno, apellido_materno, telefono, email) VALUES (?, ?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO mts_cliente (id_persona, id_estatus) VALUES (?, ?)";
        
        // Obtenemos tu conexión estática
        Connection connection = Conexion.getConexion();
        if (connection == null) {
            return false; // Falla rápido si no hay conexión
        }

        PreparedStatement psPersona = null;
        PreparedStatement psCliente = null;
        ResultSet rsKeys = null;

        try {
            // Desactivamos el auto-commit para asegurar ambas tablas
            connection.setAutoCommit(false);

            // Insertar en mts_persona
            psPersona = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
            psPersona.setString(1, cliente.getNombre());
            psPersona.setString(2, cliente.getApellidoPaterno());
            psPersona.setString(3, cliente.getApellidoMaterno());
            psPersona.setString(4, cliente.getTelefono());
            psPersona.setString(5, cliente.getEmail());
            
            int filasPersona = psPersona.executeUpdate();

            if (filasPersona == 0) {
                throw new SQLException("Error: No se pudo insertar la persona.");
            }

            // Obtener el ID generado para la persona
            int idPersonaGenerado = 0;
            rsKeys = psPersona.getGeneratedKeys();
            if (rsKeys.next()) {
                idPersonaGenerado = rsKeys.getInt(1);
            } else {
                throw new SQLException("Error: No se obtuvo el ID de la persona.");
            }

            // Insertar en mts_cliente
            psCliente = connection.prepareStatement(sqlCliente);
            psCliente.setInt(1, idPersonaGenerado);
            psCliente.setInt(2, 2); 
            
            psCliente.executeUpdate();

            // Confirmar transacción
            connection.commit();
            return true;

        } catch (SQLException e) {
            // Si algo falla, revertimos todo para no dejar datos a medias
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.err.println("Error al hacer rollback: " + ex.getMessage());
            }
            System.err.println("Error en transacción de Cliente: " + e.getMessage());
            return false;
        } finally {
            // Cerrar solo los statements, NUNCA la conexión estática
            try {
                if (rsKeys != null) rsKeys.close();
                if (psPersona != null) psPersona.close();
                if (psCliente != null) psCliente.close();
                
                // IMPORTANTE: Devolver la conexión a su estado normal para otros DAOs
                if (connection != null && !connection.isClosed()) {
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    // 2. MÉTODO PARA EL BUSCADOR (El que usarás en tu JComboBox)
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        // Unimos las tablas para sacar los datos completos
        String sql = "SELECT c.id_cliente, c.id_estatus, p.nombre, p.apellido_paterno, p.apellido_materno, p.telefono, p.email " +
                     "FROM mts_cliente c INNER JOIN mts_persona p ON c.id_persona = p.id_persona";
        
        Connection connection = Conexion.getConexion();
        if (connection == null) return listaClientes;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getString("nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getInt("id_estatus")
                );
                cliente.setIdCliente(rs.getInt("id_cliente"));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener clientes: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return listaClientes;
    }
}