/*
 * Tarjeta de cita pendiente — diseño manual sin form designer.
 */
package provet.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Tarjeta visual para mostrar los datos de una cita pendiente.
 * Uso:
 *     PanelCiPendientes card = new PanelCiPendientes();
 *     card.setDatos(nombre, vet, fecha, hora, motivo);
 */
public class PanelCiPendientes extends JPanel {

    // Paleta acorde a la app
    private static final Color VERDE_OSCURO  = new Color(39, 53, 38);
    private static final Color VERDE_MEDIO   = new Color(108, 135, 118);
    private static final Color CREMA         = new Color(228, 230, 217);
    private static final Color GRIS_TEXTO    = new Color(90, 90, 90);
    private static final Color SOMBRA        = new Color(0, 0, 0, 35);

    // Labels que se actualizan con setDatos(...)
    private final JLabel lblNombre      = new JLabel("Nombre mascota");
    private final JLabel lblVeterinario = new JLabel("Dr. Veterinario");
    private final JLabel lblFecha       = new JLabel("Fecha");
    private final JLabel lblHora        = new JLabel("Hora");
    private final JLabel lblMotivo      = new JLabel("Motivo");

    public PanelCiPendientes() {
        // Tamaño fijo para que se vea uniforme cuando haya varias tarjetas
        setPreferredSize(new Dimension(280, 220));
        setOpaque(false);  // dejamos transparente para pintar nosotros el fondo
        construirLayout();
    }

    private void construirLayout() {
        setLayout(new GridBagLayout());
        // Padding interno (deja aire dentro de la tarjeta)
        setBorder(BorderFactory.createEmptyBorder(20, 28, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(2, 0, 2, 0);

        // --- Nombre mascota (título) ---
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblNombre.setForeground(VERDE_OSCURO);
        gbc.gridy = 0;
        add(lblNombre, gbc);

        JLabel lblTagMascota = new JLabel("Mascota");
        lblTagMascota.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblTagMascota.setForeground(GRIS_TEXTO);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 12, 0);
        add(lblTagMascota, gbc);

        // --- Veterinario ---
        lblVeterinario.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblVeterinario.setForeground(VERDE_MEDIO);
        gbc.gridy = 2;
        gbc.insets = new Insets(2, 0, 0, 0);
        add(lblVeterinario, gbc);

        JLabel lblTagVet = new JLabel("Veterinario");
        lblTagVet.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblTagVet.setForeground(GRIS_TEXTO);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 14, 0);
        add(lblTagVet, gbc);

        // --- Fecha y Hora juntas ---
        JPanel filaFechaHora = new JPanel(new GridBagLayout());
        filaFechaHora.setOpaque(false);

        GridBagConstraints fh = new GridBagConstraints();
        fh.gridy = 0;
        fh.anchor = GridBagConstraints.WEST;
        fh.weightx = 0.5;
        fh.fill = GridBagConstraints.HORIZONTAL;

        JLabel iconoFecha = new JLabel("📅 ");
        iconoFecha.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
        lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblFecha.setForeground(VERDE_OSCURO);

        JPanel pFecha = new JPanel();
        pFecha.setOpaque(false);
        pFecha.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        pFecha.add(iconoFecha);
        pFecha.add(lblFecha);
        fh.gridx = 0;
        filaFechaHora.add(pFecha, fh);

        JLabel iconoHora = new JLabel("🕐 ");
        iconoHora.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
        lblHora.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblHora.setForeground(VERDE_OSCURO);

        JPanel pHora = new JPanel();
        pHora.setOpaque(false);
        pHora.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        pHora.add(iconoHora);
        pHora.add(lblHora);
        fh.gridx = 1;
        filaFechaHora.add(pHora, fh);

        gbc.gridy = 4;
        gbc.insets = new Insets(2, 0, 12, 0);
        add(filaFechaHora, gbc);

        // --- Motivo ---
        lblMotivo.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblMotivo.setForeground(GRIS_TEXTO);
        gbc.gridy = 5;
        gbc.insets = new Insets(2, 0, 0, 0);
        add(lblMotivo, gbc);
    }

    /**
     * Llena la tarjeta con los datos de la cita.
     */
    public void setDatos(String nombre, String veterinario, String fecha, String hora, String motivo) {
        lblNombre.setText(nombre);
        lblVeterinario.setText(veterinario);
        lblFecha.setText(fecha);
        lblHora.setText(hora);
        lblMotivo.setText("\"" + motivo + "\"");
    }

    /**
     * Pintamos a mano: sombra + tarjeta blanca redondeada + franja verde a la izq.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int arc = 22;     // radio de las esquinas
        int shadowOffset = 4;

        // 1) Sombra
        g2.setColor(SOMBRA);
        g2.fillRoundRect(shadowOffset, shadowOffset, w - shadowOffset - 1, h - shadowOffset - 1, arc, arc);

        // 2) Cuerpo blanco
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, w - shadowOffset, h - shadowOffset, arc, arc);

        // 3) Franja verde a la izquierda (acento)
        g2.setColor(VERDE_MEDIO);
        g2.fillRoundRect(0, 0, 15, h - shadowOffset, arc, arc);
        // Tapa el redondeo del lado derecho de la franja para que quede recta
        g2.fillRect(9, 0, 6, h - shadowOffset);

        g2.dispose();
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
