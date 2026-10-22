package provet.view.administrador;

import javax.swing.JOptionPane;
import provet.view.inicio.Login;
import provet.componentes.botonSwing;
import provet.componentes.PanelRedondeado;
import javax.swing.*;
import java.awt.*;

public class NotificacionesAdmin extends javax.swing.JFrame {
    
private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NotificacionesAdmin.class.getName());

private static final java.awt.Color C_FONDO = new java.awt.Color(228,230,217);
private static final java.awt.Color C_OSCURO = new java.awt.Color(39,53,38);
private static final java.awt.Color C_SUAVE = new java.awt.Color(108,135,118);
private static final java.awt.Color C_CARD = new java.awt.Color(192,207,178);

public static class Notificacion {
    String titulo, desc, tiempo, seccion;
    boolean leida = false;
    
    public Notificacion(String t, String d, String ti, String s) {
        titulo = t;
        desc = d;
        tiempo = ti;
        seccion = s;
    }
}

public static java.util.List<Notificacion> listaGlobal = new java.util.ArrayList<>();
private static int sinLeer = 0;

private javax.swing.JPanel panelLista;
private javax.swing.JLabel lblBadge;
private javax.swing.JLabel lblFecha;

    public NotificacionesAdmin() {
        initComponents();
        construirUI();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelRedondeado2 = new PanelRedondeado();
        jLabel8 = new javax.swing.JLabel();
        botonSwing4 = new botonSwing();
        botonSwing1 = new botonSwing();
        btn_Calendario = new botonSwing();
        btn_Reportes = new botonSwing();
        btn_Salir = new botonSwing();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(108, 135, 118));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 255, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 53, 38));
        jLabel15.setText("PatitasCare");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel16.setBackground(new java.awt.Color(51, 255, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(39, 53, 38));
        jLabel16.setText("Administrador");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/usuario.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout panelRedondeado2Layout = new javax.swing.GroupLayout(panelRedondeado2);
        panelRedondeado2.setLayout(panelRedondeado2Layout);
        panelRedondeado2Layout.setHorizontalGroup(
            panelRedondeado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondeado2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRedondeado2Layout.setVerticalGroup(
            panelRedondeado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondeado2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(panelRedondeado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 80));

        botonSwing4.setText("Menú Principal");
        botonSwing4.addActionListener(this::botonSwing4ActionPerformed);
        jPanel1.add(botonSwing4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        botonSwing1.setForeground(new java.awt.Color(39, 53, 38));
        botonSwing1.setText("Usuarios");
        botonSwing1.addActionListener(this::botonSwing1ActionPerformed);
        jPanel1.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Calendario.setForeground(new java.awt.Color(39, 53, 38));
        btn_Calendario.setText("Notificaciones");
        btn_Calendario.addActionListener(this::btn_CalendarioActionPerformed);
        jPanel1.add(btn_Calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        btn_Reportes.setForeground(new java.awt.Color(39, 53, 38));
        btn_Reportes.setText("Reportes");
        btn_Reportes.addActionListener(this::btn_ReportesActionPerformed);
        jPanel1.add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 60));

        btn_Salir.setForeground(new java.awt.Color(39, 53, 38));
        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(this::btn_SalirActionPerformed);
        jPanel1.add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 250, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 740));

        jPanel2.setBackground(new java.awt.Color(228, 230, 217));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1210, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSwing4ActionPerformed(java.awt.event.ActionEvent evt) {
        new MenuAdmin().setVisible(true);
        this.setVisible(false);
    }

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {
        new UsuariosAdmin().setVisible(true);
        this.setVisible(false);
    }

    private void btn_CalendarioActionPerformed(java.awt.event.ActionEvent evt) {
        // Ya estamos en Notificaciones
    }

    private void btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {
        new ReportesAdmin().setVisible(true);
        this.setVisible(false);
    }

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarDialogoConfirmacion(
            "¿Estás seguro de que deseas salir?",
            "Confirmar salida",
            () -> {
                new Login().setVisible(true);
                this.dispose();
            }
        );
    }

    private void mostrarDialogoConfirmacion(String mensaje, String titulo, Runnable accionConfirmar) {
        JDialog dialog = new JDialog(this, titulo, true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(450, 220);
        dialog.setLocationRelativeTo(this);
        dialog.setUndecorated(true);

        PanelRedondeado panel = new PanelRedondeado();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new java.awt.Color(192, 207, 178));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel lblMensaje = new JLabel(mensaje, SwingConstants.CENTER);
        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblMensaje.setForeground(new java.awt.Color(39, 53, 38));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelBotones.setOpaque(false);

        botonSwing btnSi = new botonSwing();
        btnSi.setText("Sí");
        btnSi.setForeground(new java.awt.Color(39, 53, 38));
        btnSi.setPreferredSize(new Dimension(120, 45));
        btnSi.addActionListener(e -> {
            accionConfirmar.run();
            dialog.dispose();
        });

        botonSwing btnNo = new botonSwing();
        btnNo.setText("No");
        btnNo.setForeground(new java.awt.Color(39, 53, 38));
        btnNo.setPreferredSize(new Dimension(120, 45));
        btnNo.addActionListener(e -> dialog.dispose());

        panelBotones.add(btnSi);
        panelBotones.add(btnNo);

        panel.add(lblMensaje, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void construirUI() {

    jPanel2.removeAll();
    jPanel2.setLayout(null);
    jPanel2.setBackground(C_FONDO);

    javax.swing.JLabel titulo = new javax.swing.JLabel("Notificaciones");
    titulo.setBounds(30, 20, 300, 30);
    titulo.setFont(new java.awt.Font("Tahoma", 1, 22));
    titulo.setForeground(C_OSCURO);
    jPanel2.add(titulo);

    lblFecha = new javax.swing.JLabel();
    lblFecha.setBounds(30, 50, 300, 20);
    lblFecha.setForeground(C_SUAVE);
    actualizarFecha();
    jPanel2.add(lblFecha);

    lblBadge = new javax.swing.JLabel("", javax.swing.SwingConstants.CENTER);
    lblBadge.setBounds(960, 20, 160, 35);
    lblBadge.setOpaque(true);
    lblBadge.setBackground(C_CARD);
    lblBadge.setForeground(new java.awt.Color(39, 53, 38));
    lblBadge.setFont(new java.awt.Font("Tahoma", 1, 14));
    jPanel2.add(lblBadge);

    panelLista = new javax.swing.JPanel();
    panelLista.setLayout(new javax.swing.BoxLayout(panelLista, javax.swing.BoxLayout.Y_AXIS));
    panelLista.setBackground(C_FONDO);

    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(panelLista);
    scroll.setBounds(30, 90, 1090, 600);
    scroll.setBorder(null);
    jPanel2.add(scroll);

    actualizarBadge();
    renderizar();
}

private void actualizarFecha() {
    java.time.LocalDate hoy = java.time.LocalDate.now();
    java.time.format.DateTimeFormatter f =
        java.time.format.DateTimeFormatter.ofPattern("d 'de' MMMM yyyy", new java.util.Locale("es"));
    lblFecha.setText(hoy.format(f));
}

private void actualizarBadge() {
    if (sinLeer == 0) {
        lblBadge.setVisible(false);
    } else {
        lblBadge.setVisible(true);
        lblBadge.setText(sinLeer + " sin leer");
    }
}

private void renderizar() {

    panelLista.removeAll();

    String[] secciones = {"HOY", "ANTES"};

    for (String sec : secciones) {

        boolean hay = false;
        for (Notificacion n : listaGlobal) {
            if (n.seccion.equals(sec)) {
                hay = true;
                break;
            }
        }

        if (!hay) continue;

        javax.swing.JLabel lbl = new javax.swing.JLabel(sec);
        lbl.setForeground(C_SUAVE);
        lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(10,5,5,0));
        panelLista.add(lbl);

        for (Notificacion n : listaGlobal) {
            if (n.seccion.equals(sec)) {
                panelLista.add(crearFila(n));
            }
        }
    }

    panelLista.revalidate();
    panelLista.repaint();
}

private javax.swing.JPanel crearFila(Notificacion n) {

    java.awt.Color fondo = n.leida ? C_CARD : C_FONDO;

    PanelRedondeado p = new PanelRedondeado();
    p.setLayout(new java.awt.BorderLayout());
    p.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 80));
    p.setBackground(fondo);
    p.setBorder(javax.swing.BorderFactory.createLineBorder(C_CARD));

    p.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent e) {
            if (!n.leida) {
                n.leida = true;
                sinLeer--;
                actualizarBadge();
                renderizar();
            }
        }
    });

    javax.swing.JLabel txt = new javax.swing.JLabel(
        "<html><b>" + n.titulo + "</b><br>" +
        n.desc + "<br><small>" + n.tiempo + "</small></html>"
    );
    txt.setFont(new java.awt.Font("Tahoma", 0, 14));
    txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10,15,10,15));
    txt.setForeground(new java.awt.Color(39, 53, 38));
    p.add(txt, java.awt.BorderLayout.CENTER);
    return p;
    }
 
   
    public static void agregarNotificacionGlobal(String titulo, String desc, String tiempo) {
    String seccion = (tiempo.contains("min") || tiempo.contains("hora")) ? "HOY" : "ANTES";
    Notificacion n = new Notificacion(titulo, desc, tiempo, seccion);
    listaGlobal.add(0, n);
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new NotificacionesAdmin().setVisible(true));
    }

    private botonSwing botonSwing1;
    private botonSwing botonSwing4;
    private botonSwing btn_Calendario;
    private botonSwing btn_Reportes;
    private botonSwing btn_Salir;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private PanelRedondeado panelRedondeado2;
}
