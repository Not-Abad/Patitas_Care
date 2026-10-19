package provet.view.administrador;
import javax.swing.JOptionPane;
import provet.view.inicio.Login;
import provet.componentes.botonSwing;
import provet.componentes.PanelRedondeado;
import javax.swing.*;
import java.awt.*;
public class MenuAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuAdmin.class.getName());

    public MenuAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelRedondeado2 = new provet.componentes.PanelRedondeado();
        jLabel8 = new javax.swing.JLabel();
        botonSwing4 = new botonSwing();
        botonSwing1 = new botonSwing();
        btn_Calendario = new botonSwing();
        btn_Reportes = new botonSwing();
        btn_Salir = new botonSwing();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new provet.componentes.PanelRedondeado();
        lbl_usuario_menu = new javax.swing.JLabel();
        btn_usuarios2 = new botonSwing();
        jLabel2 = new javax.swing.JLabel();
        lbl_bienvenido_menu = new javax.swing.JLabel();
        lbl_bienvenido_sub = new javax.swing.JLabel();
        jPanel4 = new provet.componentes.PanelRedondeado();
        lbl_reportes_menu = new javax.swing.JLabel();
        btn_reportes2 = new botonSwing();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new provet.componentes.PanelRedondeado();
        lbl_notificaciones_menu = new javax.swing.JLabel();
        btn_notificaciones = new botonSwing();
        jLabel3 = new javax.swing.JLabel();

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

        btn_Reportes.setText("Reportes");
        btn_Reportes.addActionListener(this::btn_ReportesActionPerformed);
        jPanel1.add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 60));

        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(this::btn_SalirActionPerformed);
        jPanel1.add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 250, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 740));

        jPanel2.setBackground(new java.awt.Color(228, 230, 217));

        lbl_bienvenido_menu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_bienvenido_menu.setForeground(new java.awt.Color(39, 53, 38));
        lbl_bienvenido_menu.setText("¡HOLA ADMINISTRADOR!");

        lbl_bienvenido_sub.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_bienvenido_sub.setText("Bienvenido a tu espacio PatitasCare");

        jPanel3 = new provet.componentes.PanelRedondeado();
        jPanel3.setBackground(new java.awt.Color(192, 207, 178));
        jPanel3.setMaximumSize(new java.awt.Dimension(300, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 600));

        lbl_usuario_menu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_usuario_menu.setText("Usuarios");

        btn_usuarios2.setText("Entrar");
        btn_usuarios2.addActionListener(this::btn_usuarios2ActionPerformed);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/usuario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbl_usuario_menu)
                    .addComponent(jLabel2)
                    .addComponent(btn_usuarios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_usuario_menu)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(85, 85, 85)
                .addComponent(btn_usuarios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanel4 = new provet.componentes.PanelRedondeado();
        jPanel4.setBackground(new java.awt.Color(192, 207, 178));
        jPanel4.setMaximumSize(new java.awt.Dimension(300, 150));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 150));

        lbl_reportes_menu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_reportes_menu.setText("Reportes");

        btn_reportes2.setText("Entrar");
        btn_reportes2.addActionListener(this::btn_reportes2ActionPerformed);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/reportes.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbl_reportes_menu)
                    .addComponent(jLabel4)
                    .addComponent(btn_reportes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_reportes_menu)
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addGap(85, 85, 85)
                .addComponent(btn_reportes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanel5 = new provet.componentes.PanelRedondeado();
        jPanel5.setBackground(new java.awt.Color(192, 207, 178));
        jPanel5.setMaximumSize(new java.awt.Dimension(300, 600));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 600));

        lbl_notificaciones_menu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_notificaciones_menu.setText("Notificaciones");

        btn_notificaciones.setText("Entrar");
        btn_notificaciones.addActionListener(this::btn_notificacionesActionPerformed);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/notificacion.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbl_notificaciones_menu)
                    .addComponent(jLabel3)
                    .addComponent(btn_notificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_notificaciones_menu)
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(85, 85, 85)
                .addComponent(btn_notificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_bienvenido_menu)
                    .addComponent(lbl_bienvenido_sub))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lbl_bienvenido_menu)
                .addGap(10, 10, 10)
                .addComponent(lbl_bienvenido_sub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1210, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSwing4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing4ActionPerformed
    // Menú Principal - recargar la misma ventana
    this.dispose();
    new MenuAdmin().setVisible(true);
    }//GEN-LAST:event_botonSwing4ActionPerformed

    private void btn_usuarios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuarios2ActionPerformed
    new UsuariosAdmin().setVisible(true); 
    this.dispose(); 
    }//GEN-LAST:event_btn_usuarios2ActionPerformed

    private void btn_reportes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportes2ActionPerformed
    new ReportesAdmin().setVisible(true); 
    this.dispose(); 
    }//GEN-LAST:event_btn_reportes2ActionPerformed

    private void btn_notificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notificacionesActionPerformed
        new NotificacionesAdmin().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_btn_notificacionesActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
    new UsuariosAdmin().setVisible(true); 
    this.dispose();
    }//GEN-LAST:event_botonSwing1ActionPerformed

    private void btn_CalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CalendarioActionPerformed
    new NotificacionesAdmin().setVisible(true); 
    this.dispose();
    }//GEN-LAST:event_btn_CalendarioActionPerformed

    private void btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportesActionPerformed
    new ReportesAdmin().setVisible(true); 
    this.dispose();
    }//GEN-LAST:event_btn_ReportesActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        mostrarDialogoConfirmacion(
            "¿Estás seguro de que deseas salir?",
            "Confirmar salida",
            () -> {
                new Login().setVisible(true);
                this.dispose();
            }
        );
    }//GEN-LAST:event_btn_SalirActionPerformed

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


    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new MenuAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private botonSwing botonSwing1;
    private botonSwing botonSwing4;
    private botonSwing btn_Calendario;
    private botonSwing btn_Reportes;
    private botonSwing btn_Salir;
    private botonSwing btn_notificaciones;
    private botonSwing btn_reportes2;
    private botonSwing btn_usuarios2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private provet.componentes.PanelRedondeado jPanel3;
    private provet.componentes.PanelRedondeado jPanel4;
    private provet.componentes.PanelRedondeado jPanel5;
    private provet.componentes.PanelRedondeado panelRedondeado2;
    private javax.swing.JLabel lbl_admin_menu;
    private javax.swing.JLabel lbl_administrador_menu;
    private javax.swing.JLabel lbl_bienvenido_menu;
    private javax.swing.JLabel lbl_bienvenido_sub;
    private javax.swing.JLabel lbl_menuU;
    private javax.swing.JLabel lbl_notificaciones_menu;
    private javax.swing.JLabel lbl_patitas_menu;
    private javax.swing.JLabel lbl_reportes_menu;
    private javax.swing.JLabel lbl_usuario_menu;
    // End of variables declaration//GEN-END:variables
}
