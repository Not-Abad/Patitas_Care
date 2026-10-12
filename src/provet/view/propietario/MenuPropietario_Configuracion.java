
package provet.view.propietario;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuPropietario_Configuracion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPropietario_Configuracion.class.getName());

    public MenuPropietario_Configuracion() {
        initComponents();
        if (isUndecorated()) {
    dispose();
    setUndecorated(false);
}

// paneles se estiran
getContentPane().removeAll();
getContentPane().setLayout(new java.awt.BorderLayout());
getContentPane().add(jPanel2, java.awt.BorderLayout.WEST);    // sidebar
getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);  // contenido

// 3) Sidebar mantiene 270px de ancho fijo
jPanel2.setPreferredSize(new java.awt.Dimension(270, 0));

// 4) Maximizar y cierre limpio
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setExtendedState(JFrame.MAXIMIZED_BOTH);
 
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
        lbl_nombremascota = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txtbotoncancelar = new provet.componentes.botonSwing();
        btn_editar = new provet.componentes.botonSwing();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_MenuP = new provet.componentes.botonSwing();
        botonSwing1 = new provet.componentes.botonSwing();
        btn_Calendario = new provet.componentes.botonSwing();
        btn_Reportes = new provet.componentes.botonSwing();
        btn_Salir = new provet.componentes.botonSwing();
        panelRedondeado2 = new provet.componentes.PanelRedondeado();
        jLabel8 = new javax.swing.JLabel();

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
        btn_guardarcambios.setText("Guardar");
        btn_guardarcambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarcambiosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardarcambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 590, 150, 40));

        lbl_imamascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mascota2.jpeg"))); // NOI18N
        jPanel1.add(lbl_imamascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        lbl_fotoperfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_fotoperfil.setText("Foto de perfil");
        jPanel1.add(lbl_fotoperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        btn_editarfoto.setBorder(new javax.swing.border.MatteBorder(null));
        btn_editarfoto.setText("Editar Foto");
        btn_editarfoto.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btn_editarfoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarfotoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editarfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, -1));

        lbl_nombremascota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nombremascota.setText("Nombre:");
        jPanel1.add(lbl_nombremascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        lbl_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_correo.setText("Correo:");
        jPanel1.add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_telefono.setText("Teléfono:");
        jPanel1.add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        lbl_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_direccion.setText("Dirección:");
        jPanel1.add(lbl_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 360, 30));

        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 360, 30));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 360, 30));

        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 360, 30));

        txtbotoncancelar.setBackground(new java.awt.Color(108, 135, 118));
        txtbotoncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/secretario/clean.png"))); // NOI18N
        txtbotoncancelar.setText("Cancelar");
        txtbotoncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbotoncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(txtbotoncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 590, 160, 40));

        btn_editar.setBackground(new java.awt.Color(108, 135, 118));
        btn_editar.setText("Editar");
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1200, 740));

        jPanel2.setBackground(new java.awt.Color(108, 135, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Nombre");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 255, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 53, 38));
        jLabel15.setText("PatitasCare");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel16.setBackground(new java.awt.Color(51, 255, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(39, 53, 38));
        jLabel16.setText("Propietario");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        btn_MenuP.setText("Menú Principal");
        btn_MenuP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuPActionPerformed(evt);
            }
        });
        jPanel2.add(btn_MenuP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        botonSwing1.setText("Mis archivos");
        botonSwing1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing1ActionPerformed(evt);
            }
        });
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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mascota2.jpeg"))); // NOI18N
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

        jPanel2.add(panelRedondeado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 80));

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


    JOptionPane.showMessageDialog(this, "Datos guardados correctamente"); 
    }//GEN-LAST:event_btn_guardarcambiosActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txtbotoncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbotoncancelarActionPerformed
  
        txt_telefono.setText("");
        txt_nombre.setText("");
        txt_correo.setText("");
        txt_direccion.setText("");



        JOptionPane.showMessageDialog(this, "Se han eliminado los datos correctamente");
    }//GEN-LAST:event_txtbotoncancelarActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
        MenuPropietario_Archivos menu= new MenuPropietario_Archivos();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonSwing1ActionPerformed

    private void btn_MenuPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuPActionPerformed
    MenuPropietario_Principal menu = new MenuPropietario_Principal();
    menu.setVisible(true);
    this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_btn_MenuPActionPerformed

    private void btn_editarfotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarfotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editarfotoActionPerformed

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
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private provet.componentes.botonSwing btn_editar;
    private provet.componentes.botonSwing btn_editarfoto;
    private provet.componentes.botonSwing btn_guardarcambios;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_configuracion;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_fotoperfil;
    private javax.swing.JLabel lbl_imamascota;
    private javax.swing.JLabel lbl_nombremascota;
    private javax.swing.JLabel lbl_telefono;
    private provet.componentes.PanelRedondeado panelRedondeado2;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private provet.componentes.botonSwing txtbotoncancelar;
    // End of variables declaration//GEN-END:variables
}
