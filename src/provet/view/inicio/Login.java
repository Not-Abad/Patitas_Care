
//Paquete al que pertenece la ventana
package provet.view.inicio;

//Importamos librerias
import java.sql.Connection;
import javax.swing.JOptionPane;
import provet.view.administrador.MenuAdmin;
import provet.view.veterinario.Menu_Principal;
import provet.view.secretario.Dashboard_Secretario;
import provet.dao.EmpleadoDAO;
import provet.model.Empleado;
import provet.utilidades.Conexion;
import provet.utilidades.Sesion;

//Inicio de la clase Login, que hereda de la clase JFrame
public class Login extends javax.swing.JFrame {
    
    //Atributos de la clase
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    private final EmpleadoDAO empleadoDAO;
    public final Connection conn = Conexion.getConexion();
    
    //Constructor de la clase Login
    public Login() {
        initComponents();                                 //Inicia los componentes de la clase
        this.empleadoDAO = new EmpleadoDAO();             //Indicamos que empleadoDAO es un nuevo objeto de la clase
        
        //Si no existe conexión con la base de datos, Entonces...
        if (conn == null) {
            btn_Aceptar.setEnabled(false);              //Desactiva el boton Aceptar
            link_recuperarContra.setVisible(false);  //Oculta la recuperación de contraseña
            lbl_Pregunta2.setVisible(false);         //Oculta el label de recuperación
            
        } else {    //Sino...
            btn_Aceptar.setEnabled(true);               //Habilita el botón Aceptar
            link_recuperarContra.setVisible(true);   //Muesta la recuperación de contraseña
            lbl_Pregunta2.setVisible(true);          //Muestra el label de recuperación
        }
    }

    //Validamos los datos del Empleado
    public void validarEmpleado() {
        
        //Variables del método
        String usuario = txt_Usuario.getText().trim();                   //El usuario = el texto de txt_Usuario
        String contra  = new String(txt_contraseña.getPassword());  //La contraseña = el texto de txt_contraseña

        // Validaciones básicas de campos vacíos
        if (usuario.isEmpty() || contra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa usuario y contraseña.");
            return;
        }

        // Revisamos si el usuario existe y coincide la contraseña en MariaDB
        Empleado usuarioValido = empleadoDAO.autenticarUsuario(usuario, contra);

        // Si el usuario existe y las credenciales son correctas...
        if (usuarioValido != null) {
            
            // Guardamos la Sesión Global
            Sesion.setEmpleadoActual(usuarioValido);
            
            // Obtenemos el ID del puesto para saber qué pantalla abrir
            int idPuesto = usuarioValido.getIdPuesto();

            // Estructura para abrir la ventana según el id_puesto
            switch (idPuesto) {
                case 2 -> new MenuAdmin().setVisible(true);             // ID 2 = Administrador
                case 3 -> new Menu_Principal().setVisible(true);        // ID 3 = Veterinario
                case 4 -> new Dashboard_Secretario().setVisible(true);  // ID 4 = Secretario
                default -> {
                    JOptionPane.showMessageDialog(this, "Tu usuario no tiene un rol válido asignado.");
                    return; // Detenemos la ejecución para que no cierre el login
                }
            }
            
            // Cierra la ventana de login
            this.dispose(); 
            
        } else {
            // CASO: CREDENCIALES INCORRECTAS
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            txt_contraseña.setText(""); // Limpiamos el campo por seguridad
            txt_contraseña.requestFocus();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Informativo = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        pnl_Operativo = new javax.swing.JPanel();
        link_recuperarContra = new provet.componentes.linkLabel();
        txt_Usuario = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JPasswordField();
        chk_Ojo = new javax.swing.JCheckBox();
        btn_Aceptar = new provet.componentes.botonSwing();
        lbl_Usuario = new javax.swing.JLabel();
        lbl_Contraseña = new javax.swing.JLabel();
        lbl_Pregunta2 = new javax.swing.JLabel();
        lbl_MarcoContraseña = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnl_Login = new provet.componentes.PanelRedondeado();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patitas Care");
        setMinimumSize(new java.awt.Dimension(700, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Informativo.setBackground(new java.awt.Color(69, 98, 78));
        pnl_Informativo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(216, 218, 203));
        lbl_Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.png"))); // NOI18N
        pnl_Informativo.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 25, 110, -1));

        pnl_Operativo.setBackground(new java.awt.Color(228, 230, 217));
        pnl_Operativo.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        pnl_Operativo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        link_recuperarContra.setForeground(java.awt.Color.white);
        link_recuperarContra.setText("Haz clic aquí");
        link_recuperarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                link_recuperarContraMouseClicked(evt);
            }
        });
        pnl_Operativo.add(link_recuperarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        txt_Usuario.setBackground(new java.awt.Color(216, 218, 203));
        txt_Usuario.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        txt_Usuario.setForeground(new java.awt.Color(39, 53, 38));
        txt_Usuario.setToolTipText("Usuario");
        txt_Usuario.setActionCommand("<Not Set>");
        txt_Usuario.setAutoscrolls(false);
        txt_Usuario.setBorder(null);
        txt_Usuario.setCaretColor(new java.awt.Color(39, 53, 38));
        txt_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsuarioActionPerformed(evt);
            }
        });
        pnl_Operativo.add(txt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 320, 50));

        txt_contraseña.setBackground(new java.awt.Color(216, 218, 203));
        txt_contraseña.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        txt_contraseña.setForeground(new java.awt.Color(39, 53, 38));
        txt_contraseña.setBorder(null);
        txt_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contraseñaActionPerformed(evt);
            }
        });
        pnl_Operativo.add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 270, 50));

        chk_Ojo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chk_Ojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--eye-closed-solid.png"))); // NOI18N
        chk_Ojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_OjoActionPerformed(evt);
            }
        });
        pnl_Operativo.add(chk_Ojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 40, 30));

        btn_Aceptar.setBackground(new java.awt.Color(69, 98, 78));
        btn_Aceptar.setForeground(java.awt.Color.white);
        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });
        pnl_Operativo.add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 230, 50));

        lbl_Usuario.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_Usuario.setForeground(new java.awt.Color(242, 242, 242));
        lbl_Usuario.setText("Usuario:");
        pnl_Operativo.add(lbl_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 160, -1));

        lbl_Contraseña.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_Contraseña.setForeground(new java.awt.Color(242, 242, 242));
        lbl_Contraseña.setText("Contraseña:");
        pnl_Operativo.add(lbl_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 210, -1));

        lbl_Pregunta2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Pregunta2.setForeground(new java.awt.Color(242, 242, 242));
        lbl_Pregunta2.setText("¿Olvidaste tu contraseña?");
        pnl_Operativo.add(lbl_Pregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 180, -1));

        lbl_MarcoContraseña.setBackground(new java.awt.Color(216, 218, 203));
        lbl_MarcoContraseña.setOpaque(true);
        pnl_Operativo.add(lbl_MarcoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 320, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/f1.png"))); // NOI18N
        pnl_Operativo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnl_Login.setBackground(new java.awt.Color(192, 207, 178));
        pnl_Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_Operativo.add(pnl_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 50, 390, 300));

        pnl_Informativo.add(pnl_Operativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 600, 370));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FonLogin.png"))); // NOI18N
        pnl_Informativo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pnl_Informativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarsActionPerformed
    }//GEN-LAST:event_btn_iniciarsActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        validarEmpleado();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void link_recuperarContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link_recuperarContraMouseClicked
        if(txt_Usuario.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Error, no hay usuario para recuperar contraseña");
           txt_Usuario.requestFocus();
        }else{
            String Usuario = txt_Usuario.getText();
            Recuperar_Contraseña vEmergente = new Recuperar_Contraseña(Usuario);
            vEmergente.setVisible(true);

        }
        
    }//GEN-LAST:event_link_recuperarContraMouseClicked

    private void chk_OjoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_OjoActionPerformed
        if(chk_Ojo.isSelected()){
            txt_contraseña.setEchoChar((char)0);
            chk_Ojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--eye-solid.png")));
        }else{
            txt_contraseña.setEchoChar('•');
            chk_Ojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--eye-closed-solid.png")));
        }
    }//GEN-LAST:event_chk_OjoActionPerformed

    private void txt_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsuarioActionPerformed
        txt_contraseña.requestFocus();
    }//GEN-LAST:event_txt_UsuarioActionPerformed

    private void txt_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contraseñaActionPerformed
        validarEmpleado();
    }//GEN-LAST:event_txt_contraseñaActionPerformed

    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_Contraseña;
    private javax.swing.JLabel lbl_MarcoContraseña;
    private javax.swing.JLabel lbl_Pregunta2;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Usuario;
    private provet.componentes.linkLabel link_recuperarContra;
    private javax.swing.JPanel pnl_Informativo;
    private provet.componentes.PanelRedondeado pnl_Login;
    private javax.swing.JPanel pnl_Operativo;
    private javax.swing.JTextField txt_Usuario;
    private javax.swing.JPasswordField txt_contraseña;
    // End of variables declaration//GEN-END:variables
}
