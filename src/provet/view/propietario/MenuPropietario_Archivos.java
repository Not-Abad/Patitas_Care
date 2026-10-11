
package provet.view.propietario;

import java.awt.Dimension;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.Box.Filler;
import javax.swing.JOptionPane;
import provet.componentes.Panel_DocumentoSubido;

public class MenuPropietario_Archivos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPropietario_Archivos.class.getName());

    public MenuPropietario_Archivos() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        botonSwing2 = new provet.componentes.botonSwing();
        contenedorArchivos = new provet.componentes.Contenedor_Cartas();
        contenedorArchivos.setEje(1);
        panel_DocumentoSubido1 = new provet.componentes.Panel_DocumentoSubido();
        panel_DocumentoSubido2 = new provet.componentes.Panel_DocumentoSubido();
        panel_DocumentoSubido3 = new provet.componentes.Panel_DocumentoSubido();
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

        jLabel9.setBackground(new java.awt.Color(51, 255, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(39, 53, 38));
        jLabel9.setText("MIS ARCHIVOS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 29));

        botonSwing2.setBackground(new java.awt.Color(108, 135, 118));
        botonSwing2.setForeground(new java.awt.Color(39, 53, 38));
        botonSwing2.setText("Subir archivos");
        botonSwing2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSwing2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonSwing2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 250, 60));

        contenedorArchivos.setBackground(new java.awt.Color(192, 207, 178));
        contenedorArchivos.add(panel_DocumentoSubido1, new java.awt.GridBagConstraints());
        contenedorArchivos.add(panel_DocumentoSubido2, new java.awt.GridBagConstraints());
        contenedorArchivos.add(panel_DocumentoSubido3, new java.awt.GridBagConstraints());

        jPanel1.add(contenedorArchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 970, 590));

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

        btn_MenuP.setForeground(new java.awt.Color(39, 53, 38));
        btn_MenuP.setText("Menú Principal");
        btn_MenuP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_MenuP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuPActionPerformed(evt);
            }
        });
        jPanel2.add(btn_MenuP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        botonSwing1.setForeground(new java.awt.Color(39, 53, 38));
        botonSwing1.setText("Pacientes");
        botonSwing1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel2.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Calendario.setForeground(new java.awt.Color(39, 53, 38));
        btn_Calendario.setText("Calendario");
        btn_Calendario.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
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

    private void botonSwing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing2ActionPerformed
        abrirDocumento();
    }//GEN-LAST:event_botonSwing2ActionPerformed

    private void btn_MenuPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MenuPActionPerformed

        //Metodo para abrir el documento en el sistema
    private void abrirDocumento() {
        
        // 1. Creamos la instancia del selector de archivos
        JFileChooser selector = new JFileChooser();

        // 2. Creamos filtros para que solo se vean archivos útiles (Opcional pero recomendado)
        javax.swing.filechooser.FileNameExtensionFilter filtro = new javax.swing.filechooser.FileNameExtensionFilter(
    "Documentos de Mascotas (PDF, JPG, PNG)", "pdf", "jpg", "jpeg", "png");
        selector.setFileFilter(filtro);

        // 3. Abrimos la ventana y guardamos la respuesta del usuario
        int resultado = selector.showOpenDialog(this);

        // 4. Si el usuario seleccionó un archivo y le dio a "Abrir"...
        if (resultado == JFileChooser.APPROVE_OPTION) {
            java.io.File archivoSeleccionado = selector.getSelectedFile();
            String rutaAbsoluta = archivoSeleccionado.getAbsolutePath();
    
            // Aquí es donde ocurre la magia:
            // Creamos una nueva instancia de tu componente y le pasamos la ruta
            Panel_DocumentoSubido nuevaTarjeta = new Panel_DocumentoSubido();
            nuevaTarjeta.setRutaArchivo(rutaAbsoluta);
            contenedorArchivos.add(nuevaTarjeta);
            JOptionPane.showMessageDialog(null,"Archivo vinculado: " + rutaAbsoluta);
    }
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
        java.awt.EventQueue.invokeLater(() -> new MenuPropietario_Archivos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing botonSwing1;
    private provet.componentes.botonSwing botonSwing2;
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private provet.componentes.Contenedor_Cartas contenedorArchivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private provet.componentes.Panel_DocumentoSubido panel_DocumentoSubido1;
    private provet.componentes.Panel_DocumentoSubido panel_DocumentoSubido2;
    private provet.componentes.Panel_DocumentoSubido panel_DocumentoSubido3;
    // End of variables declaration//GEN-END:variables
}
