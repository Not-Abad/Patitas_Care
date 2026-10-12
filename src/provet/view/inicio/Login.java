
//Paquete al que pertenece la ventana
package provet.view.inicio;

//Inicio de la clase Login, que hereda de la clase JFrame

import javax.swing.JOptionPane;
import provet.view.veterinario.Menu_Principal;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    @SuppressWarnings("unchecked")
    public Login() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Operativo = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        pnl_Login = new provet.componentes.PanelRedondeado();
        link_nuevaCuenta = new provet.componentes.linkLabel();
        link_recuperarContra = new provet.componentes.linkLabel();
        txt_Usuario = new javax.swing.JTextField();
        txt_Contraseña = new javax.swing.JTextField();
        chk_Ojo = new javax.swing.JCheckBox();
        btn_Aceptar = new provet.componentes.botonSwing();
        lbl_Bienvenido = new javax.swing.JLabel();
        lbl_Pregunta1 = new javax.swing.JLabel();
        lbl_Usuario = new javax.swing.JLabel();
        lbl_Contraseña = new javax.swing.JLabel();
        lbl_Pregunta2 = new javax.swing.JLabel();
        lbl_MarcoContraseña = new javax.swing.JLabel();
        pnl_Informativo = new javax.swing.JPanel();
        lbl_TituloP1 = new javax.swing.JLabel();
        lbl_TituloP2 = new javax.swing.JLabel();
        lbl_DescripcionP1 = new javax.swing.JLabel();
        lbl_DescripcionP2 = new javax.swing.JLabel();
        lbl_DescripcionP3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patitas Care");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Operativo.setBackground(new java.awt.Color(228, 230, 217));
        pnl_Operativo.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        pnl_Operativo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Titulo.setText("PatitasCare");
        pnl_Operativo.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 30, 220, 30));

        pnl_Login.setBackground(new java.awt.Color(192, 207, 178));
        pnl_Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        link_nuevaCuenta.setText("Crea una cuenta aquí");
        link_nuevaCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                link_nuevaCuentaMouseClicked(evt);
            }
        });
        pnl_Login.add(link_nuevaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        link_recuperarContra.setText("Haz clic aquí");
        link_recuperarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                link_recuperarContraMouseClicked(evt);
            }
        });
        pnl_Login.add(link_recuperarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        txt_Usuario.setBackground(new java.awt.Color(216, 218, 203));
        txt_Usuario.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        txt_Usuario.setForeground(new java.awt.Color(39, 53, 38));
        txt_Usuario.setToolTipText("Usuario");
        txt_Usuario.setActionCommand("<Not Set>");
        txt_Usuario.setAutoscrolls(false);
        txt_Usuario.setBorder(null);
        txt_Usuario.setCaretColor(new java.awt.Color(39, 53, 38));
        pnl_Login.add(txt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 230, 30));

        txt_Contraseña.setBackground(new java.awt.Color(216, 218, 203));
        txt_Contraseña.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txt_Contraseña.setForeground(new java.awt.Color(39, 53, 38));
        txt_Contraseña.setToolTipText("Usuario");
        txt_Contraseña.setActionCommand("<Not Set>");
        txt_Contraseña.setAutoscrolls(false);
        txt_Contraseña.setBorder(null);
        txt_Contraseña.setCaretColor(new java.awt.Color(39, 53, 38));
        pnl_Login.add(txt_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 190, 30));

        chk_Ojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/secretario/eye.png"))); // NOI18N
        pnl_Login.add(chk_Ojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 40, 30));

        btn_Aceptar.setBackground(new java.awt.Color(69, 98, 78));
        btn_Aceptar.setForeground(new java.awt.Color(228, 230, 217));
        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });
        pnl_Login.add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 230, 50));

        lbl_Bienvenido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_Bienvenido.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Bienvenido.setText("¡Bienvenido!");
        pnl_Login.add(lbl_Bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, -1));

        lbl_Pregunta1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Pregunta1.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Pregunta1.setText("¿No tienes una cuenta con nosotros?");
        pnl_Login.add(lbl_Pregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, -1));

        lbl_Usuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Usuario.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Usuario.setText("Usuario:");
        pnl_Login.add(lbl_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        lbl_Contraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Contraseña.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Contraseña.setText("Contraseña:");
        pnl_Login.add(lbl_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, -1));

        lbl_Pregunta2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Pregunta2.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Pregunta2.setText("¿Olvidaste tu contraseña?");
        pnl_Login.add(lbl_Pregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 180, -1));

        lbl_MarcoContraseña.setBackground(new java.awt.Color(216, 218, 203));
        lbl_MarcoContraseña.setOpaque(true);
        pnl_Login.add(lbl_MarcoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 230, 30));

        pnl_Operativo.add(pnl_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 390, 330));

        getContentPane().add(pnl_Operativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 450, 470));

        pnl_Informativo.setBackground(new java.awt.Color(69, 98, 78));
        pnl_Informativo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_TituloP1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbl_TituloP1.setForeground(new java.awt.Color(228, 230, 217));
        lbl_TituloP1.setText("¡Hola ");
        pnl_Informativo.add(lbl_TituloP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 100));

        lbl_TituloP2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbl_TituloP2.setForeground(new java.awt.Color(228, 230, 217));
        lbl_TituloP2.setText("usuario!");
        pnl_Informativo.add(lbl_TituloP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 310, 50));

        lbl_DescripcionP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_DescripcionP1.setForeground(new java.awt.Color(228, 230, 217));
        lbl_DescripcionP1.setText("PatitasCare es un sistema que permite el");
        pnl_Informativo.add(lbl_DescripcionP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 280, 20));

        lbl_DescripcionP2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_DescripcionP2.setForeground(new java.awt.Color(228, 230, 217));
        lbl_DescripcionP2.setText("manejo de personal médico y usuarios para");
        pnl_Informativo.add(lbl_DescripcionP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 310, 20));

        lbl_DescripcionP3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_DescripcionP3.setForeground(new java.awt.Color(228, 230, 217));
        lbl_DescripcionP3.setText("el mejor cuidado de tus mascotas.");
        pnl_Informativo.add(lbl_DescripcionP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 280, 20));

        getContentPane().add(pnl_Informativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarsActionPerformed
    }//GEN-LAST:event_btn_iniciarsActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        verificar_Datos();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void link_nuevaCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link_nuevaCuentaMouseClicked
        System.out.println("Se presiono crear cuenta");
    }//GEN-LAST:event_link_nuevaCuentaMouseClicked

    private void link_recuperarContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link_recuperarContraMouseClicked
        if(txt_Usuario.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Error, no hay usuario para recuperar contraseña");
           txt_Usuario.requestFocus();
        }else{
            Recuperar_Contraseña vEmergente = new Recuperar_Contraseña();
            vEmergente.setVisible(true);
        }
        
    }//GEN-LAST:event_link_recuperarContraMouseClicked

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
    private provet.componentes.botonSwing btn_Aceptar;
    private javax.swing.JCheckBox chk_Ojo;
    private javax.swing.JLabel lbl_Bienvenido;
    private javax.swing.JLabel lbl_Contraseña;
    private javax.swing.JLabel lbl_DescripcionP1;
    private javax.swing.JLabel lbl_DescripcionP2;
    private javax.swing.JLabel lbl_DescripcionP3;
    private javax.swing.JLabel lbl_MarcoContraseña;
    private javax.swing.JLabel lbl_Pregunta1;
    private javax.swing.JLabel lbl_Pregunta2;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_TituloP1;
    private javax.swing.JLabel lbl_TituloP2;
    private javax.swing.JLabel lbl_Usuario;
    private provet.componentes.linkLabel link_nuevaCuenta;
    private provet.componentes.linkLabel link_recuperarContra;
    private javax.swing.JPanel pnl_Informativo;
    private provet.componentes.PanelRedondeado pnl_Login;
    private javax.swing.JPanel pnl_Operativo;
    private javax.swing.JTextField txt_Contraseña;
    private javax.swing.JTextField txt_Usuario;
    // End of variables declaration//GEN-END:variables
}
