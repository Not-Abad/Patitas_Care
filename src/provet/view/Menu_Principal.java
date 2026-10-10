/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package provet.view;


import javax.swing.JFrame;
/**
 *
 * @author natac
 */
public class Menu_Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu_Principal.class.getName());

    /**
     * Creates new form Menu_Principal
     */
    public Menu_Principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        lbl_nomusua = new javax.swing.JLabel();
        lbl_imausuario = new javax.swing.JLabel();
        lbl_huellas = new javax.swing.JLabel();
        lbl_bienvenido = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        btn_notificacion = new javax.swing.JButton();
        btn_configuracionbarra = new javax.swing.JButton();
        btn_reportesbarra = new javax.swing.JButton();
        btn_cerrarsesion = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1291, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nomusua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nomusua.setForeground(new java.awt.Color(0, 0, 102));
        lbl_nomusua.setText("Admin1");
        jPanel1.add(lbl_nomusua, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        lbl_imausuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario_1.png"))); // NOI18N
        jPanel1.add(lbl_imausuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 90, 77));

        lbl_huellas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_modificado.png"))); // NOI18N
        lbl_huellas.setToolTipText("");
        lbl_huellas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl_huellas.setPreferredSize(new java.awt.Dimension(217, 740));
        lbl_huellas.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                lbl_huellasVetoableChange(evt);
            }
        });
        jPanel1.add(lbl_huellas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 200, 750));

        lbl_bienvenido.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_bienvenido.setText("¡Bienvenido a ProVet!");
        jPanel1.add(lbl_bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 270, 30));

        label2.setBackground(new java.awt.Color(0, 97, 135));
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1280, 40));

        btn_notificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--notification-on-solid.png"))); // NOI18N
        btn_notificacion.setBorder(null);
        btn_notificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notificacionActionPerformed(evt);
            }
        });
        jPanel1.add(btn_notificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 50, 40, 40));

        btn_configuracionbarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--settings-alt-solid.png"))); // NOI18N
        btn_configuracionbarra.setBorder(null);
        btn_configuracionbarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configuracionbarraActionPerformed(evt);
            }
        });
        jPanel1.add(btn_configuracionbarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 50, 40, 40));

        btn_reportesbarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--folder-open-solid.png"))); // NOI18N
        btn_reportesbarra.setBorder(null);
        btn_reportesbarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportesbarraActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reportesbarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 50, 40, 40));

        btn_cerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--logout-solid.png"))); // NOI18N
        btn_cerrarsesion.setBorder(null);
        btn_cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarsesionActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 50, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_huellasVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_lbl_huellasVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_huellasVetoableChange

    private void btn_administrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_administrativoActionPerformed

    }//GEN-LAST:event_btn_administrativoActionPerformed

    private void btn_atencionmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atencionmedActionPerformed
       
        dispose();    }//GEN-LAST:event_btn_atencionmedActionPerformed

    private void btn_notificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_notificacionActionPerformed

    private void btn_configuracionbarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configuracionbarraActionPerformed
        
    }//GEN-LAST:event_btn_configuracionbarraActionPerformed

    private void btn_reportesbarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesbarraActionPerformed
        
    }//GEN-LAST:event_btn_reportesbarraActionPerformed

    private void btn_configuraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configuraciónActionPerformed
        
    }//GEN-LAST:event_btn_configuraciónActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
       
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void btn_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarsesionActionPerformed
         
    }//GEN-LAST:event_btn_cerrarsesionActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Menu_Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_configuracionbarra;
    private javax.swing.JButton btn_notificacion;
    private javax.swing.JButton btn_reportesbarra;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label2;
    private javax.swing.JLabel lbl_bienvenido;
    private javax.swing.JLabel lbl_huellas;
    private javax.swing.JLabel lbl_imausuario;
    private javax.swing.JLabel lbl_nomusua;
    // End of variables declaration//GEN-END:variables
}
