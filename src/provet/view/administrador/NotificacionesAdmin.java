package provet.view.administrador;

import provet.view.inicio.Login;

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
        lbl_patitas_menu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_admin_menu = new javax.swing.JLabel();
        lbl_administrador_menu = new javax.swing.JLabel();
        btn_MenuN = new javax.swing.JButton();
        btn_reportesN = new javax.swing.JButton();
        btn_salida1 = new javax.swing.JButton();
        btn_usuariosN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(108, 135, 118));

        lbl_patitas_menu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_patitas_menu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_patitas_menu.setText("Patitas Care");
        lbl_patitas_menu.setAutoscrolls(true);

        jLabel6.setText("Foto");

        lbl_admin_menu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_admin_menu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_admin_menu.setText("Admin");

        lbl_administrador_menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_administrador_menu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_administrador_menu.setText("Administrador");

        btn_MenuN.setBackground(new java.awt.Color(228, 230, 217));
        btn_MenuN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_MenuN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/CASA.png"))); // NOI18N
        btn_MenuN.setText("Menu Principal");
        btn_MenuN.addActionListener(this::btn_MenuNActionPerformed);

        btn_reportesN.setBackground(new java.awt.Color(228, 230, 217));
        btn_reportesN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_reportesN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/REPORTES2.png"))); // NOI18N
        btn_reportesN.setText("Reportes");
        btn_reportesN.setPreferredSize(new java.awt.Dimension(97, 29));
        btn_reportesN.addActionListener(this::btn_reportesNActionPerformed);

        btn_salida1.setBackground(new java.awt.Color(228, 230, 217));
        btn_salida1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_salida1.setText("Salida");
        btn_salida1.addActionListener(this::btn_salida1ActionPerformed);

        btn_usuariosN.setBackground(new java.awt.Color(228, 230, 217));
        btn_usuariosN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_usuariosN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/USUARIO2.png"))); // NOI18N
        btn_usuariosN.setText("Usuarios");
        btn_usuariosN.addActionListener(this::btn_usuariosNActionPerformed);

        jLabel3.setBackground(new java.awt.Color(108, 135, 118));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/NOTIFICACION2.png"))); // NOI18N
        jLabel3.setText("Notificaciones");
        jLabel3.setToolTipText("");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbl_patitas_menu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_MenuN, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_admin_menu)
                                    .addComponent(lbl_administrador_menu)))
                            .addComponent(btn_reportesN, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(btn_usuariosN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_salida1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbl_patitas_menu)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(lbl_admin_menu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_administrador_menu)
                        .addGap(73, 73, 73)))
                .addComponent(btn_MenuN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_usuariosN, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_reportesN, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(btn_salida1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 740));

        jPanel2.setBackground(new java.awt.Color(228, 230, 217));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 0, 1150, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_reportesNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesNActionPerformed
    new ReportesAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_reportesNActionPerformed

    private void btn_MenuNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuNActionPerformed
    new MenuAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_MenuNActionPerformed

    private void btn_usuariosNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosNActionPerformed
     new UsuariosAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_usuariosNActionPerformed

    private void btn_salida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salida1ActionPerformed
     new Login().setVisible(true); 
    this.dispose(); 
    }//GEN-LAST:event_btn_salida1ActionPerformed

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
    lblBadge.setBounds(980, 25, 140, 25);
    lblBadge.setOpaque(true);
    lblBadge.setBackground(C_OSCURO);
    lblBadge.setForeground(java.awt.Color.WHITE);
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
        java.time.format.DateTimeFormatter.ofPattern("MMMM yyyy", new java.util.Locale("es"));
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

    javax.swing.JPanel p = new javax.swing.JPanel(new java.awt.BorderLayout());
    p.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 70));
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
    txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,10,5,5));
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_MenuN;
    private javax.swing.JButton btn_reportesN;
    private javax.swing.JButton btn_salida1;
    private javax.swing.JButton btn_usuariosN;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_admin_menu;
    private javax.swing.JLabel lbl_administrador_menu;
    private javax.swing.JLabel lbl_patitas_menu;
    // End of variables declaration//GEN-END:variables
}
