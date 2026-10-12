package provet.view.propietario;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import provet.componentes.PanelCiPendientes;
import javax.swing.JFrame;

public class MenuPropietario_CitasPendientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPropietario_CitasPendientes.class.getName());

public MenuPropietario_CitasPendientes() {
    initComponents();
    panel_citas_pendientes.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 25));
    panel_citas_pendientes.setOpaque(true);
    panel_citas_pendientes.setBackground(new java.awt.Color(228, 230, 217));

    if (isUndecorated()) {
        dispose();
        setUndecorated(false);
    }

getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.BorderLayout());
    getContentPane().add(jPanel2, java.awt.BorderLayout.WEST);    // sidebar a la izquierda
    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);  // contenido al centro (se estira)
 

    
    jPanel2.setPreferredSize(new java.awt.Dimension(270, 0));

    // panel de las tarjetas se estira dentro de jPanel1
    jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentResized(java.awt.event.ComponentEvent e) {
            panel_citas_pendientes.setBounds(
                50,                              // x
                180,                             // y
                jPanel1.getWidth() - 100,        // ancho (se estira)
                jPanel1.getHeight() - 220        // alto (se estira)
            );
        }
    });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    
            }


    public void cargarDesdeTabla(JTable tabla) {
    panel_citas_pendientes.removeAll();

    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

    for (int i = 0; i < modelo.getRowCount(); i++) {
        Object valNombre = modelo.getValueAt(i, 0);
        // Saltamos filas vacías
        if (valNombre == null || valNombre.toString().trim().isEmpty()) {
            continue;
        }

        // columnas en tablacitas:
        // 0=Nombre 1=Raza 2=Especie 3=Veterinario 4=Fecha 5=Horario 6=Motivo 7=Descripción
        String nombre      = String.valueOf(modelo.getValueAt(i, 0));
        String veterinario = String.valueOf(modelo.getValueAt(i, 3));
        String fecha       = String.valueOf(modelo.getValueAt(i, 4));
        String hora        = String.valueOf(modelo.getValueAt(i, 5));
        String motivo      = String.valueOf(modelo.getValueAt(i, 6));

        PanelCiPendientes card = new PanelCiPendientes();
        card.setDatos(nombre, veterinario, fecha, hora, motivo);
        panel_citas_pendientes.add(card);
    }

    panel_citas_pendientes.revalidate();
    panel_citas_pendientes.repaint();
}

public void cargarDatos(JTable tabla) {
    cargarDesdeTabla(tabla);
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        lbl_configuracion = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        panel_citas_pendientes = new provet.componentes.PanelRedondeado();
        lbl_acceder4 = new javax.swing.JLabel();
        usuario4 = new javax.swing.JLabel();
        botonSwing2 = new provet.componentes.botonSwing();
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
        lbl_configuracion.setText("CITAS PENDIENTES PARA HOY");
        jPanel1.add(lbl_configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 29));

        jTextField1.setBackground(new java.awt.Color(228, 230, 217));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setText("Tienes una cita pendiente para hoy.");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 240, 40));

        panel_citas_pendientes.setBackground(new java.awt.Color(228, 230, 217));
        panel_citas_pendientes.setPreferredSize(new java.awt.Dimension(1000, 500));

        lbl_acceder4.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes.add(lbl_acceder4);

        usuario4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario4.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes.add(usuario4);

        jPanel1.add(panel_citas_pendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 1100, 600));

        botonSwing2.setBackground(new java.awt.Color(108, 135, 118));
        botonSwing2.setText("Regresar");
        botonSwing2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonSwing2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 70, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1200, 740));

        jPanel2.setBackground(new java.awt.Color(108, 135, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Propietario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 255, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 53, 38));
        jLabel15.setText("PatitasCare");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel16.setBackground(new java.awt.Color(51, 255, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(39, 53, 38));
        jLabel16.setText("Propietario");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void botonSwing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing2ActionPerformed
        MenuPropietario_Principal menu = new MenuPropietario_Principal();
        menu.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_botonSwing2ActionPerformed

    private void btn_MenuPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuPActionPerformed
        MenuPropietario_Principal menu = new MenuPropietario_Principal();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_MenuPActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
        MenuPropietario_Archivos menu= new MenuPropietario_Archivos();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonSwing1ActionPerformed

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
    private provet.componentes.botonSwing botonSwing2;
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_acceder4;
    private javax.swing.JLabel lbl_configuracion;
    private provet.componentes.PanelRedondeado panelRedondeado2;
    private provet.componentes.PanelRedondeado panel_citas_pendientes;
    private javax.swing.JLabel usuario4;
    // End of variables declaration//GEN-END:variables
}
