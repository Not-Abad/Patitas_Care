
package provet.view.veterinario;

import javax.swing.JFrame;
import provet.model.Usuario;
import provet.model.ControlUsuarios;


public class Menu_Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu_Principal.class.getName());
    private Usuario usuario;

    public Menu_Principal(Usuario usuario) {
    initComponents();
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.usuario = usuario;
    if (usuario != null) {
    lblNombreVet.setText(usuario.getNombre());
    } else {
    lblNombreVet.setText("Sin usuario");
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        panel_citas_notificaciones = new provet.componentes.PanelRedondeado();
        lbl_acceder4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panel_citas_completados = new provet.componentes.PanelRedondeado();
        lbl_acceder3 = new javax.swing.JLabel();
        btn_iniciars3 = new provet.componentes.boton_redondo();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panel_horario = new provet.componentes.PanelRedondeado();
        lbl_acceder2 = new javax.swing.JLabel();
        btn_iniciars2 = new provet.componentes.boton_redondo();
        jLabel14 = new javax.swing.JLabel();
        panel_cirugias_pendientes = new provet.componentes.PanelRedondeado();
        lbl_acceder1 = new javax.swing.JLabel();
        btn_iniciars1 = new provet.componentes.boton_redondo();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panel_citas_pendientes = new provet.componentes.PanelRedondeado();
        lbl_acceder = new javax.swing.JLabel();
        btn_iniciars = new provet.componentes.boton_redondo();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblNombreVet = new javax.swing.JLabel();
        btn_MenuP = new provet.componentes.botonSwing();
        btnPacientes = new provet.componentes.botonSwing();
        btn_Calendario = new provet.componentes.botonSwing();
        btnReportes = new provet.componentes.botonSwing();
        btn_Salir = new provet.componentes.botonSwing();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 230, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(1291, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_citas_notificaciones.setBackground(new java.awt.Color(192, 207, 178));
        panel_citas_notificaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder4.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_notificaciones.add(lbl_acceder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel11.setBackground(new java.awt.Color(51, 255, 51));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(39, 53, 38));
        jLabel11.setText("Notificaciones");
        panel_citas_notificaciones.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 29));

        jPanel1.add(panel_citas_notificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 200, 540));

        panel_citas_completados.setBackground(new java.awt.Color(192, 207, 178));
        panel_citas_completados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder3.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_completados.add(lbl_acceder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        btn_iniciars3.setText("Iniciar Sesión");
        btn_iniciars3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars3ActionPerformed(evt);
            }
        });
        panel_citas_completados.add(btn_iniciars3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        jLabel10.setBackground(new java.awt.Color(51, 255, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(39, 53, 38));
        jLabel10.setText("completadas");
        panel_citas_completados.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 29));

        jLabel13.setBackground(new java.awt.Color(51, 255, 51));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(39, 53, 38));
        jLabel13.setText("Citas");
        panel_citas_completados.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 29));

        jPanel1.add(panel_citas_completados, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 560, 110));

        panel_horario.setBackground(new java.awt.Color(192, 207, 178));
        panel_horario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder2.setForeground(new java.awt.Color(255, 255, 255));
        panel_horario.add(lbl_acceder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        btn_iniciars2.setText("Iniciar Sesión");
        btn_iniciars2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars2ActionPerformed(evt);
            }
        });
        panel_horario.add(btn_iniciars2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        jLabel14.setBackground(new java.awt.Color(51, 255, 51));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(39, 53, 38));
        jLabel14.setText("Mi horario");
        panel_horario.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 29));

        jPanel1.add(panel_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 560, 210));

        panel_cirugias_pendientes.setBackground(new java.awt.Color(192, 207, 178));
        panel_cirugias_pendientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder1.setForeground(new java.awt.Color(255, 255, 255));
        panel_cirugias_pendientes.add(lbl_acceder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        btn_iniciars1.setText("Iniciar Sesión");
        btn_iniciars1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars1ActionPerformed(evt);
            }
        });
        panel_cirugias_pendientes.add(btn_iniciars1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        jLabel7.setBackground(new java.awt.Color(51, 255, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(39, 53, 38));
        jLabel7.setText("Cirugías");
        panel_cirugias_pendientes.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 29));

        jLabel8.setBackground(new java.awt.Color(51, 255, 51));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(39, 53, 38));
        jLabel8.setText("pendientes");
        panel_cirugias_pendientes.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel1.add(panel_cirugias_pendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 270, 170));

        panel_citas_pendientes.setBackground(new java.awt.Color(192, 207, 178));
        panel_citas_pendientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes.add(lbl_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        btn_iniciars.setText("Iniciar Sesión");
        btn_iniciars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarsActionPerformed(evt);
            }
        });
        panel_citas_pendientes.add(btn_iniciars, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        jLabel5.setBackground(new java.awt.Color(51, 255, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(39, 53, 38));
        jLabel5.setText("Citas");
        panel_citas_pendientes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 29));

        jLabel12.setBackground(new java.awt.Color(51, 255, 51));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(39, 53, 38));
        jLabel12.setText("pendientes");
        panel_citas_pendientes.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel1.add(panel_citas_pendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 250, 170));

        jLabel9.setBackground(new java.awt.Color(51, 255, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(39, 53, 38));
        jLabel9.setText("¡HOLA VETERINARIO!");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 29));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1200, 740));

        jPanel2.setBackground(new java.awt.Color(108, 135, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Veterinario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel1.setText("FOTO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 255, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 53, 38));
        jLabel15.setText("PatitasCare");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        lblNombreVet.setBackground(new java.awt.Color(51, 255, 51));
        lblNombreVet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreVet.setForeground(new java.awt.Color(39, 53, 38));
        lblNombreVet.setText("Veterinario");
        jPanel2.add(lblNombreVet, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        btn_MenuP.setText("Menú Principal");
        btn_MenuP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuPActionPerformed(evt);
            }
        });
        jPanel2.add(btn_MenuP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        btnPacientes.setText("Pacientes");
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Calendario.setText("Calendario");
        jPanel2.add(btn_Calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel2.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 60));

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

    private void btn_iniciarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarsActionPerformed
        
    }//GEN-LAST:event_btn_iniciarsActionPerformed

    private void btn_iniciars1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars1ActionPerformed

    private void btn_iniciars2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars2ActionPerformed

    private void btn_iniciars3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars3ActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        Pacientes p = new Pacientes(usuario);
        p.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        Reportes_Citas r = new Reportes_Citas(usuario);
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btn_MenuPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MenuPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    java.awt.EventQueue.invokeLater(() -> {
        Menu_Principal m = new Menu_Principal(ControlUsuarios.usuarioActivo);
        m.setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing btnPacientes;
    private provet.componentes.botonSwing btnReportes;
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Salir;
    private provet.componentes.boton_redondo btn_iniciars;
    private provet.componentes.boton_redondo btn_iniciars1;
    private provet.componentes.boton_redondo btn_iniciars2;
    private provet.componentes.boton_redondo btn_iniciars3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombreVet;
    private javax.swing.JLabel lbl_acceder;
    private javax.swing.JLabel lbl_acceder1;
    private javax.swing.JLabel lbl_acceder2;
    private javax.swing.JLabel lbl_acceder3;
    private javax.swing.JLabel lbl_acceder4;
    private provet.componentes.PanelRedondeado panel_cirugias_pendientes;
    private provet.componentes.PanelRedondeado panel_citas_completados;
    private provet.componentes.PanelRedondeado panel_citas_notificaciones;
    private provet.componentes.PanelRedondeado panel_citas_pendientes;
    private provet.componentes.PanelRedondeado panel_horario;
    // End of variables declaration//GEN-END:variables
}
