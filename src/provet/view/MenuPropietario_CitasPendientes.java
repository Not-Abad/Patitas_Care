
package provet.view;

import javax.swing.JFrame;

public class MenuPropietario_CitasPendientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPropietario_CitasPendientes.class.getName());

    public MenuPropietario_CitasPendientes() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        lbl_configuracion = new javax.swing.JLabel();
        panel_citas_pendientes1 = new provet.componentes.PanelRedondeado();
        lbl_acceder1 = new javax.swing.JLabel();
        usuario1 = new javax.swing.JLabel();
        btn_iniciars1 = new provet.componentes.boton_redondo();
        lbl_imagenmascota = new javax.swing.JLabel();
        lbl_nombremascota = new javax.swing.JLabel();
        lbl_estatusarchivo1 = new javax.swing.JLabel();
        lbl_fecha2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_imagenagenda = new javax.swing.JLabel();
        panel_citas_pendientes2 = new provet.componentes.PanelRedondeado();
        lbl_acceder2 = new javax.swing.JLabel();
        usuario2 = new javax.swing.JLabel();
        btn_iniciars2 = new provet.componentes.boton_redondo();
        lbl_imagenmascota1 = new javax.swing.JLabel();
        lbl_nombremascota3 = new javax.swing.JLabel();
        lbl_estatusarchivo2 = new javax.swing.JLabel();
        lbl_fecha3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_imagenagenda1 = new javax.swing.JLabel();
        panel_citas_pendientes3 = new provet.componentes.PanelRedondeado();
        lbl_acceder3 = new javax.swing.JLabel();
        usuario3 = new javax.swing.JLabel();
        btn_iniciars3 = new provet.componentes.boton_redondo();
        lbl_imagenmascota2 = new javax.swing.JLabel();
        lbl_nombremascota2 = new javax.swing.JLabel();
        lbl_estatusarchivo3 = new javax.swing.JLabel();
        lbl_fecha1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_imagenagenda2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_MenuP = new provet.componentes.botonSwing();
        botonSwing1 = new provet.componentes.botonSwing();
        btn_Calendario = new provet.componentes.botonSwing();
        btn_Reportes = new provet.componentes.botonSwing();
        btn_Salir = new provet.componentes.botonSwing();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 230, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(1291, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_configuracion.setBackground(new java.awt.Color(51, 255, 51));
        lbl_configuracion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_configuracion.setForeground(new java.awt.Color(39, 53, 38));
        lbl_configuracion.setText("CITAS PENDIENTES PARA HOY");
        jPanel1.add(lbl_configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 29));

        panel_citas_pendientes1.setBackground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder1.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes1.add(lbl_acceder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        usuario1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario1.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes1.add(usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btn_iniciars1.setText("Iniciar Sesión");
        btn_iniciars1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars1ActionPerformed(evt);
            }
        });
        panel_citas_pendientes1.add(btn_iniciars1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        lbl_imagenmascota.setText("lbl_imamascota");
        panel_citas_pendientes1.add(lbl_imagenmascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        lbl_nombremascota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nombremascota.setText("Max");
        panel_citas_pendientes1.add(lbl_nombremascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        lbl_estatusarchivo1.setText("Revisiín General");
        panel_citas_pendientes1.add(lbl_estatusarchivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        lbl_fecha2.setText("21/04/2026");
        panel_citas_pendientes1.add(lbl_fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        jLabel3.setText("09:00 a.m");
        panel_citas_pendientes1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Dr. Pérez");
        panel_citas_pendientes1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        lbl_imagenagenda.setText("imagen");
        panel_citas_pendientes1.add(lbl_imagenagenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jPanel1.add(panel_citas_pendientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 380, 190));

        panel_citas_pendientes2.setBackground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder2.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes2.add(lbl_acceder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        usuario2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario2.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes2.add(usuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btn_iniciars2.setText("Iniciar Sesión");
        btn_iniciars2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars2ActionPerformed(evt);
            }
        });
        panel_citas_pendientes2.add(btn_iniciars2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        lbl_imagenmascota1.setText("lbl_imamascota");
        panel_citas_pendientes2.add(lbl_imagenmascota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        lbl_nombremascota3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nombremascota3.setText("Max");
        panel_citas_pendientes2.add(lbl_nombremascota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        lbl_estatusarchivo2.setText("Revisiín General");
        panel_citas_pendientes2.add(lbl_estatusarchivo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        lbl_fecha3.setText("21/04/2026");
        panel_citas_pendientes2.add(lbl_fecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        jLabel7.setText("09:00 a.m");
        panel_citas_pendientes2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Dr. Pérez");
        panel_citas_pendientes2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        lbl_imagenagenda1.setText("imagen");
        panel_citas_pendientes2.add(lbl_imagenagenda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jPanel1.add(panel_citas_pendientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 380, 190));

        panel_citas_pendientes3.setBackground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder3.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes3.add(lbl_acceder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        usuario3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario3.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes3.add(usuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btn_iniciars3.setText("Iniciar Sesión");
        btn_iniciars3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars3ActionPerformed(evt);
            }
        });
        panel_citas_pendientes3.add(btn_iniciars3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        lbl_imagenmascota2.setText("lbl_imamascota");
        panel_citas_pendientes3.add(lbl_imagenmascota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        lbl_nombremascota2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nombremascota2.setText("Max");
        panel_citas_pendientes3.add(lbl_nombremascota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        lbl_estatusarchivo3.setText("Revisiín General");
        panel_citas_pendientes3.add(lbl_estatusarchivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        lbl_fecha1.setText("21/04/2026");
        panel_citas_pendientes3.add(lbl_fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        jLabel10.setText("09:00 a.m");
        panel_citas_pendientes3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Dr. Pérez");
        panel_citas_pendientes3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        lbl_imagenagenda2.setText("imagen");
        panel_citas_pendientes3.add(lbl_imagenagenda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jPanel1.add(panel_citas_pendientes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 380, 190));

        jTextField1.setBackground(new java.awt.Color(228, 230, 217));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setText("Tienes una cita pendiente para hoy.");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 240, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1200, 740));

        jPanel2.setBackground(new java.awt.Color(108, 135, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Propietario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel1.setText("FOTO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 255, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 53, 38));
        jLabel15.setText("PatitasCare");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel16.setBackground(new java.awt.Color(51, 255, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(39, 53, 38));
        jLabel16.setText("Propietario");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        btn_MenuP.setText("Menú Principal");
        jPanel2.add(btn_MenuP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        botonSwing1.setText("Pacientes");
        jPanel2.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Calendario.setText("Calendario");
        jPanel2.add(btn_Calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        btn_Reportes.setText("Reportes");
        jPanel2.add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 60));

        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 250, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_administrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_administrativoActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_administrativoActionPerformed

    private void btn_atencionmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atencionmedActionPerformed
        
        dispose();    }//GEN-LAST:event_btn_atencionmedActionPerformed

    private void btn_configuraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configuraciónActionPerformed
         
    }//GEN-LAST:event_btn_configuraciónActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
        
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_iniciars1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars1ActionPerformed

    private void btn_iniciars2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars2ActionPerformed

    private void btn_iniciars3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new MenuPropietario_CitasPendientes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing botonSwing1;
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private provet.componentes.boton_redondo btn_iniciars1;
    private provet.componentes.boton_redondo btn_iniciars2;
    private provet.componentes.boton_redondo btn_iniciars3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_acceder1;
    private javax.swing.JLabel lbl_acceder2;
    private javax.swing.JLabel lbl_acceder3;
    private javax.swing.JLabel lbl_configuracion;
    private javax.swing.JLabel lbl_estatusarchivo1;
    private javax.swing.JLabel lbl_estatusarchivo2;
    private javax.swing.JLabel lbl_estatusarchivo3;
    private javax.swing.JLabel lbl_fecha1;
    private javax.swing.JLabel lbl_fecha2;
    private javax.swing.JLabel lbl_fecha3;
    private javax.swing.JLabel lbl_imagenagenda;
    private javax.swing.JLabel lbl_imagenagenda1;
    private javax.swing.JLabel lbl_imagenagenda2;
    private javax.swing.JLabel lbl_imagenmascota;
    private javax.swing.JLabel lbl_imagenmascota1;
    private javax.swing.JLabel lbl_imagenmascota2;
    private javax.swing.JLabel lbl_nombremascota;
    private javax.swing.JLabel lbl_nombremascota2;
    private javax.swing.JLabel lbl_nombremascota3;
    private provet.componentes.PanelRedondeado panel_citas_pendientes1;
    private provet.componentes.PanelRedondeado panel_citas_pendientes2;
    private provet.componentes.PanelRedondeado panel_citas_pendientes3;
    private javax.swing.JLabel usuario1;
    private javax.swing.JLabel usuario2;
    private javax.swing.JLabel usuario3;
    // End of variables declaration//GEN-END:variables
}
