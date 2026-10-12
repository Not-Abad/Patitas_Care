package provet.view.administrador;

import provet.view.inicio.Login;

public class ReportesAdmin extends javax.swing.JFrame {
   
private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportesAdmin.class.getName());
public static java.util.List<Reporte> listaReportes = new java.util.ArrayList<>();

private final java.awt.Color C_FONDO = new java.awt.Color(228,230,217);
private final java.awt.Color C_CARD = new java.awt.Color(167, 184, 156);
private final java.awt.Color C_OSCURO = new java.awt.Color(84, 104, 94);
private final java.awt.Color C_TEXTO = new java.awt.Color(60,60,60);

class Reporte {
    String titulo;
    String descripcion;
    public Reporte(String t, String d) {
        titulo = t;
        descripcion = d;
 
    }
}

private int citas = 0;
private int nuevosPacientes = 0;
private int usuariosActivos = 0;

private javax.swing.JLabel lblCitas, lblPacientes, lblUsuarios;
private javax.swing.JPanel panelHistorial;

    public ReportesAdmin() {
    initComponents();
    construirUI();
    if (listaReportes.isEmpty()) {
    listaReportes.add(new Reporte("Ejemplo", "Demo"));
    }
    renderizarHistorial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_patitas_menu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_admin_menu = new javax.swing.JLabel();
        lbl_administrador_menu = new javax.swing.JLabel();
        btn_menuR = new javax.swing.JButton();
        btn_notificacionesR = new javax.swing.JButton();
        btn_salidaR = new javax.swing.JButton();
        lbl_reportes = new javax.swing.JLabel();
        btn_usuariosR = new javax.swing.JButton();
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

        btn_menuR.setBackground(new java.awt.Color(228, 230, 217));
        btn_menuR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_menuR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/CASA.png"))); // NOI18N
        btn_menuR.setText("Menu Principal");
        btn_menuR.addActionListener(this::btn_menuRActionPerformed);

        btn_notificacionesR.setBackground(new java.awt.Color(228, 230, 217));
        btn_notificacionesR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_notificacionesR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/NOTIFICACION2.png"))); // NOI18N
        btn_notificacionesR.setText("Notificaciones");
        btn_notificacionesR.addActionListener(this::btn_notificacionesRActionPerformed);

        btn_salidaR.setBackground(new java.awt.Color(228, 230, 217));
        btn_salidaR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_salidaR.setText("Salida");
        btn_salidaR.addActionListener(this::btn_salidaRActionPerformed);

        lbl_reportes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_reportes.setForeground(new java.awt.Color(255, 255, 255));
        lbl_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/REPORTES2.png"))); // NOI18N
        lbl_reportes.setText("Reportes");

        btn_usuariosR.setBackground(new java.awt.Color(228, 230, 217));
        btn_usuariosR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_usuariosR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/USUARIO2.png"))); // NOI18N
        btn_usuariosR.setText("Usuarios");
        btn_usuariosR.addActionListener(this::btn_usuariosRActionPerformed);

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
                        .addComponent(jLabel6)
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_admin_menu)
                            .addComponent(lbl_administrador_menu))))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_menuR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_notificacionesR, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btn_salidaR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_usuariosR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_reportes)
                .addGap(94, 94, 94))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(lbl_admin_menu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_administrador_menu)
                        .addGap(80, 80, 80)))
                .addComponent(btn_menuR, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_usuariosR, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbl_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_notificacionesR, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(btn_salidaR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btn_menuRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuRActionPerformed
     new MenuAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_menuRActionPerformed

    private void btn_usuariosRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosRActionPerformed
    new UsuariosAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_usuariosRActionPerformed

    private void btn_notificacionesRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notificacionesRActionPerformed
    new NotificacionesAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_notificacionesRActionPerformed

    private void btn_salidaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salidaRActionPerformed
     new Login().setVisible(true); 
    this.dispose(); 
    }//GEN-LAST:event_btn_salidaRActionPerformed

    private void construirUI() {
    jPanel2.setLayout(null);
    jPanel2.setBackground(C_FONDO);

    javax.swing.JLabel titulo = new javax.swing.JLabel("Reportes administrativos");
    titulo.setBounds(30, 20, 400, 30);
    titulo.setFont(new java.awt.Font("Tahoma", 1, 20));
    jPanel2.add(titulo);

    javax.swing.JLabel subtitulo = new javax.swing.JLabel("Actualizado en ejecución");
    subtitulo.setBounds(30, 50, 300, 20);
    subtitulo.setForeground(C_TEXTO);
    jPanel2.add(subtitulo);

    javax.swing.JButton btnGenerar = new javax.swing.JButton("+ Generar reporte");
    btnGenerar.setBounds(900, 20, 200, 30);
    btnGenerar.setBackground(C_OSCURO);
    btnGenerar.setForeground(java.awt.Color.WHITE);
    jPanel2.add(btnGenerar);

    btnGenerar.addActionListener(e -> generarDatos());

    lblCitas = crearCard("Citas totales", 50);
    lblPacientes = crearCard("Nuevos pacientes", 300);
    lblUsuarios = crearCard("Usuarios activos", 550);

    panelHistorial = new javax.swing.JPanel();
    panelHistorial.setLayout(new javax.swing.BoxLayout(panelHistorial, javax.swing.BoxLayout.Y_AXIS));

    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(panelHistorial);
    scroll.setBounds(50, 200, 1000, 400);

    jPanel2.add(scroll);
}
    private javax.swing.JLabel crearCard(String titulo, int x) {
    javax.swing.JPanel card = new javax.swing.JPanel();
    card.setLayout(null);
    card.setBackground(C_CARD);
    card.setBounds(x, 90, 200, 80);

    javax.swing.JLabel lblTitulo = new javax.swing.JLabel(titulo);
    lblTitulo.setBounds(10, 10, 180, 20);

    javax.swing.JLabel lblValor = new javax.swing.JLabel("0");
    lblValor.setBounds(10, 35, 180, 30);
    lblValor.setFont(new java.awt.Font("Tahoma", 1, 20));

    card.add(lblTitulo);
    card.add(lblValor);

    jPanel2.add(card);
    card.setVisible(true);;
    return lblValor;
}
    
    private void generarDatos() {
    citas += (int)(Math.random() * 10);
    nuevosPacientes += (int)(Math.random() * 5);
    usuariosActivos += (int)(Math.random() * 3);

    lblCitas.setText(String.valueOf(citas));
    lblPacientes.setText(String.valueOf(nuevosPacientes));
    lblUsuarios.setText(String.valueOf(usuariosActivos));

    listaReportes.add(new Reporte("Reporte generado", "Datos actualizados"));
    
    renderizarHistorial();

    NotificacionesAdmin.agregarNotificacionGlobal(
        "Nuevo reporte",
        "Se generó un reporte",
        "hoy"
    );
}
    
    private void renderizarHistorial() {
    panelHistorial.removeAll();

    for (Reporte r : listaReportes) {

        javax.swing.JPanel fila = new javax.swing.JPanel();
        fila.setLayout(new java.awt.GridLayout(1, 3));
        fila.setMaximumSize(new java.awt.Dimension(1000, 30));

        fila.add(new javax.swing.JLabel(r.titulo));
        fila.add(new javax.swing.JLabel(java.time.LocalDate.now().toString()));
        fila.add(new javax.swing.JLabel(r.descripcion));

        panelHistorial.add(fila);
    }

    panelHistorial.revalidate();
    panelHistorial.repaint();
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
        java.awt.EventQueue.invokeLater(() -> new ReportesAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_menuR;
    private javax.swing.JButton btn_notificacionesR;
    private javax.swing.JButton btn_salidaR;
    private javax.swing.JButton btn_usuariosR;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_admin_menu;
    private javax.swing.JLabel lbl_administrador_menu;
    private javax.swing.JLabel lbl_patitas_menu;
    private javax.swing.JLabel lbl_reportes;
    // End of variables declaration//GEN-END:variables
}
