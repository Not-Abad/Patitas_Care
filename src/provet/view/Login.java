
//Paquete al que pertenece la ventana
package provet.view;

//Importamos librerias
import java.awt.Font;                   //Para modificar la letra del texto
import java.awt.font.TextAttribute;     //Para modificar los atributos del texto
import java.util.Map;                   //Para emplear Map

//Inicio de la clase Login, que hereda de la clase JFrame
public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    @SuppressWarnings("unchecked")
    public Login() {
        initComponents();
        
        Font font_recuperarContraseña = lbl_recuperarContraseña.getFont();
        Map<TextAttribute, Object> attributes_RC = (Map<TextAttribute, Object>) font_recuperarContraseña.getAttributes();
        attributes_RC.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lbl_recuperarContraseña.setFont(font_recuperarContraseña.deriveFont(attributes_RC));
        
        Font font_nuevaCuenta = lbl_nuevaCuenta.getFont();
        Map<TextAttribute, Object> attributes_NC = (Map<TextAttribute, Object>) font_nuevaCuenta.getAttributes();
        attributes_NC.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lbl_nuevaCuenta.setFont(font_nuevaCuenta.deriveFont(attributes_NC));
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_recuperarContraseña = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        botonSwing1 = new provet.componentes.botonSwing();
        lbl_nuevaCuenta = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Provet");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 230, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_recuperarContraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_recuperarContraseña.setForeground(new java.awt.Color(39, 53, 38));
        lbl_recuperarContraseña.setText("Haz click aquí");
        lbl_recuperarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_recuperarContraseñaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_recuperarContraseñaMouseEntered(evt);
            }
        });
        jPanel1.add(lbl_recuperarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 100, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(39, 53, 38));
        jLabel7.setText("PatitasCare");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 110, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(39, 53, 38));
        jLabel8.setText("¡Bienvenido!");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(39, 53, 38));
        jLabel9.setText("Contraseña:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 240, -1));

        jTextField1.setBackground(new java.awt.Color(216, 218, 203));
        jTextField1.setToolTipText("Usuario");
        jTextField1.setActionCommand("<Not Set>");
        jTextField1.setAutoscrolls(false);
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(0, 204, 102));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 230, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(39, 53, 38));
        jLabel10.setText("¿Olvidaste tu contraseña?");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 180, -1));

        jTextField2.setBackground(new java.awt.Color(216, 218, 203));
        jTextField2.setToolTipText("Usuario");
        jTextField2.setActionCommand("<Not Set>");
        jTextField2.setAutoscrolls(false);
        jTextField2.setBorder(null);
        jTextField2.setCaretColor(new java.awt.Color(0, 204, 102));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 230, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(39, 53, 38));
        jLabel11.setText("Usuario:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 240, -1));

        botonSwing1.setBackground(new java.awt.Color(69, 98, 78));
        botonSwing1.setForeground(new java.awt.Color(228, 230, 217));
        botonSwing1.setText("Iniciar");
        botonSwing1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 230, 50));

        lbl_nuevaCuenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_nuevaCuenta.setForeground(new java.awt.Color(39, 53, 38));
        lbl_nuevaCuenta.setText("Crea una cuenta aquí.");
        lbl_nuevaCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_nuevaCuentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_nuevaCuentaMouseEntered(evt);
            }
        });
        jPanel1.add(lbl_nuevaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 240, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(39, 53, 38));
        jLabel12.setText("¿No tienes una cuenta con nosotros?");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 250, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 420, 470));

        jPanel2.setBackground(new java.awt.Color(69, 98, 78));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(228, 230, 217));
        jLabel1.setText("el mejor cuidado de tus mascotas.");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 280, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(228, 230, 217));
        jLabel2.setText("usuario!");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 310, 100));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(228, 230, 217));
        jLabel4.setText("PatitasCare es un sistema que permite el");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 260, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(228, 230, 217));
        jLabel5.setText("manejo de personal médico y usuarios para");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 280, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(228, 230, 217));
        jLabel6.setText("¡Hola ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 100));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarsActionPerformed
    }//GEN-LAST:event_btn_iniciarsActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
        verificar_Datos();
    }//GEN-LAST:event_botonSwing1ActionPerformed

    private void lbl_recuperarContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_recuperarContraseñaMouseClicked
        System.out.println("Presionaron Recuperar contraseña");
    }//GEN-LAST:event_lbl_recuperarContraseñaMouseClicked

    private void lbl_recuperarContraseñaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_recuperarContraseñaMouseEntered
        lbl_recuperarContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbl_recuperarContraseñaMouseEntered

    private void lbl_nuevaCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nuevaCuentaMouseClicked
        System.out.println("Presionaron Nueva Cuenta");
    }//GEN-LAST:event_lbl_nuevaCuentaMouseClicked

    private void lbl_nuevaCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_nuevaCuentaMouseEntered
        lbl_nuevaCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbl_nuevaCuentaMouseEntered

    public void verificar_Datos(){
        // Aquí iría tu lógica (ej: if usuario y pass son correctos...)
    
        // 1. Abrir la ventana del menú principal
        Menu_Principal menu = new Menu_Principal();
        menu.setVisible(true);
    
        // 2. Cerrar la ventana actual de Login
        this.dispose();
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
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing botonSwing1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_nuevaCuenta;
    private javax.swing.JLabel lbl_recuperarContraseña;
    // End of variables declaration//GEN-END:variables
}
