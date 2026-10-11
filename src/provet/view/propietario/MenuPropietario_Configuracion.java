
package provet.view.propietario;

import javax.swing.JFrame;

public class MenuPropietario_Configuracion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPropietario_Configuracion.class.getName());

    public MenuPropietario_Configuracion() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        lbl_configuracion = new javax.swing.JLabel();
        btn_guardarcambios = new provet.componentes.botonSwing();
        lbl_imamascota = new javax.swing.JLabel();
        lbl_fotoperfil = new javax.swing.JLabel();
        btn_editarfoto = new provet.componentes.botonSwing();
        lbl_nombre = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txf_contraseña = new javax.swing.JTextField();
        txf_correo = new javax.swing.JTextField();
        txf_telefono = new javax.swing.JTextField();
        txf_nombre = new javax.swing.JTextField();
        txf_dirección1 = new javax.swing.JTextField();
        botonSwing4 = new provet.componentes.botonSwing();
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
        lbl_configuracion.setText("CONFIGURACIÓN");
        jPanel1.add(lbl_configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 29));

        btn_guardarcambios.setBackground(new java.awt.Color(108, 135, 118));
        btn_guardarcambios.setText("Guardar Cambios");
        btn_guardarcambios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_guardarcambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarcambiosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardarcambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 630, 250, 60));

        lbl_imamascota.setText("lbl_imaarchivo3");
        jPanel1.add(lbl_imamascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        lbl_fotoperfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_fotoperfil.setText("Foto de perfil");
        jPanel1.add(lbl_fotoperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        btn_editarfoto.setBorder(new javax.swing.border.MatteBorder(null));
        btn_editarfoto.setText("Editar Foto");
        btn_editarfoto.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jPanel1.add(btn_editarfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, -1));

        lbl_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nombre.setText("Nombre:");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        lbl_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_correo.setText("Correo:");
        jPanel1.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_telefono.setText("Teléfono:");
        jPanel1.add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        lbl_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_direccion.setText("Dirección:");
        jPanel1.add(lbl_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Contraseña:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, -1, -1));

        txf_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_contraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txf_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 360, 30));
        jPanel1.add(txf_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 360, 30));

        txf_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_telefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 360, 30));
        jPanel1.add(txf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 360, 30));

        txf_dirección1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_dirección1ActionPerformed(evt);
            }
        });
        jPanel1.add(txf_dirección1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 360, 30));

        botonSwing4.setText("Cambiar contraseña");
        botonSwing4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(botonSwing4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 460, -1, -1));

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

    private void btn_guardarcambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarcambiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardarcambiosActionPerformed

    private void txf_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_telefonoActionPerformed

    private void txf_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_contraseñaActionPerformed

    private void txf_dirección1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_dirección1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_dirección1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new MenuPropietario_Configuracion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing botonSwing1;
    private provet.componentes.botonSwing botonSwing4;
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private provet.componentes.botonSwing btn_editarfoto;
    private provet.componentes.botonSwing btn_guardarcambios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_configuracion;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_fotoperfil;
    private javax.swing.JLabel lbl_imamascota;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JTextField txf_contraseña;
    private javax.swing.JTextField txf_correo;
    private javax.swing.JTextField txf_dirección1;
    private javax.swing.JTextField txf_nombre;
    private javax.swing.JTextField txf_telefono;
    // End of variables declaration//GEN-END:variables
}
