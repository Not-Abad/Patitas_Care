/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.componentes;

import provet.model.Paciente;

import javax.swing.*;
import java.awt.*;

public class PanelPaciente extends PanelRedondeado {

    private JLabel lblFoto;
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblRaza;

    public PanelPaciente() {
        setLayout(new BorderLayout(15, 10));
        setPreferredSize(new Dimension(350, 140));
        setBackground(new Color(192, 207, 178));

        // 🔹 Panel imagen
        lblFoto = new JLabel();
        lblFoto.setPreferredSize(new Dimension(100, 100));
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setVerticalAlignment(SwingConstants.CENTER);

        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setOpaque(false);
        panelImagen.add(lblFoto, BorderLayout.CENTER);

        // 🔹 Panel texto
        lblID = new JLabel("ID");
        lblNombre = new JLabel("Nombre");
        lblRaza = new JLabel("Raza");

        lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 14));

        JPanel panelTexto = new JPanel();
        panelTexto.setOpaque(false);
        panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));

        
        panelTexto.add(lblID);
        panelTexto.add(Box.createVerticalStrut(5));

        // 🔹 Línea personalizada
        JPanel linea = new JPanel();
        linea.setBackground(new Color(108,135,118));
        linea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));

        panelTexto.add(linea);

        
        panelTexto.add(Box.createVerticalStrut(10));
        panelTexto.add(lblNombre);
        panelTexto.add(Box.createVerticalStrut(5));
        panelTexto.add(lblRaza);

        // 🔹 Agregar todo
        add(panelImagen, BorderLayout.WEST);
        add(panelTexto, BorderLayout.CENTER);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public void setDatos(Paciente paciente) {
        lblID.setText("ID: " + paciente.getID());
        lblNombre.setText(paciente.getNombre());
        lblRaza.setText(paciente.getRaza());

        // 🔥 Imagen real
        try {
            ImageIcon icono = new ImageIcon(paciente.getFoto());
            Image img = icono.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            lblFoto.setIcon(new ImageIcon(img));
            lblFoto.setText("");
        } catch (Exception e) {
            lblFoto.setText("Sin imagen");
        }
    }
}