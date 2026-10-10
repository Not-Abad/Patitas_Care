/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provet.componentes;

import javax.swing.JButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Supongamos que cambiamos el color del boton a verde, como hacer que al seleccionarse el color coincida

public class boton_redondo extends JButton {

    private Color colorNormal = new Color(135,180,201);
    private Color colorHover = new Color(46,67,101);
    private Color colorClick = new Color(46,67,101);

    public boton_redondo() {
        super();
        inicializar();
    }

    public boton_redondo(String texto) {
        super(texto);
        inicializar();
    }

    private void inicializar() {
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBackground(colorNormal);

        // Eventos de mouse (hover + click)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
                setBackground(colorNormal);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(colorHover);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Suavizado (anti-alias)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo redondeado
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground().darker());
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 50, 50);

        g2.dispose();
    }
}