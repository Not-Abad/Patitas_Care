
//Paquete al que pertenece la ventana
package provet.view.inicio;

//Importamos librerias
import javax.swing.JOptionPane;
import provet.model.ControlUsuarios;
import provet.model.Usuario;
import provet.view.administrador.MenuAdmin;
import provet.view.veterinario.Menu_Principal;
import provet.view.secretario.Dashboard_Secretario;
import provet.dao.EmpleadoDAO;
import provet.model.Empleado;
import provet.utilidades.Sesion;

//Inicio de la clase Login, que hereda de la clase JFrame
public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    private EmpleadoDAO empleadoDAO;
    
    @SuppressWarnings("unchecked")
    public Login() {
        initComponents();
        this.empleadoDAO = new EmpleadoDAO();
    }

    //Método encontrar Usuario
    public Usuario encontrarUsuario(String nombreUsuario){
        //Variable local
        Usuario usuarioEncontrado = null;

        //Revisamos la posición de toda la lista de usuarios
        for (Usuario u : ControlUsuarios.listaUsuarios) {
            //Si usuario actual es igual a usuario nombre, entonces...
            if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
                usuarioEncontrado = u;  //Guarda al usuario actual
                break;                  //Detenemos la búsqueda porque ya lo hallamos
            }
        }
        
        //Si se encontro el usuario, entonces...
        if(usuarioEncontrado != null){
            return usuarioEncontrado;           //...Retornalo
        }else{          //Si no se encontro....
            return null;                        //Retorna nulo
        }
    }
    
    public Empleado procesarLogin(String usuario, String contrasena) {
        // Validaciones básicas de campos vacíos
        if (usuario.trim().isEmpty() || contrasena.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa usuario y contraseña.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        // Llamada al DAO
        Empleado empleado = empleadoDAO.autenticarUsuario(usuario, contrasena);

        if (empleado != null) {
            System.out.println("Login exitoso. Bienvenido: " + empleado.getUsuario());
            // Aquí registrarías en tu tabla 'bit_movimientos' que este empleado Inició Sesión (id_accion = 6)
            return empleado;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Operativo = new javax.swing.JPanel();
        lbl_Titulo = new javax.swing.JLabel();
        pnl_Login = new provet.componentes.PanelRedondeado();
        link_nuevaCuenta = new provet.componentes.linkLabel();
        link_recuperarContra = new provet.componentes.linkLabel();
        txt_Usuario = new javax.swing.JTextField();
        chk_Ojo = new javax.swing.JCheckBox();
        btn_Aceptar = new provet.componentes.botonSwing();
        lbl_Bienvenido = new javax.swing.JLabel();
        lbl_Pregunta1 = new javax.swing.JLabel();
        lbl_Usuario = new javax.swing.JLabel();
        lbl_Contraseña = new javax.swing.JLabel();
        lbl_Pregunta2 = new javax.swing.JLabel();
        txt_contraseña = new javax.swing.JPasswordField();
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

        chk_Ojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--eye-closed-solid.png"))); // NOI18N
        chk_Ojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_OjoActionPerformed(evt);
            }
        });
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

        txt_contraseña.setBackground(new java.awt.Color(216, 218, 203));
        txt_contraseña.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        txt_contraseña.setForeground(new java.awt.Color(39, 53, 38));
        txt_contraseña.setBorder(null);
        pnl_Login.add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 190, 30));

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
 String user = txt_Usuario.getText().trim();
        String pass = new String(txt_contraseña.getPassword()); 

        //Validaciones básicas de campos vacíos
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa usuario y contraseña.");
            return;
        }

        //Revisamos si el usuario existe y coincide la contraseña en MariaDB
        Empleado usuarioValido = procesarLogin(user, pass);

        //Si el usuario existe y las credenciales son correctas...
        if (usuarioValido != null) {
            
            //Guardamos la Sesión Global
            Sesion.setEmpleadoActual(usuarioValido);
            
            // Obtenemos el ID del puesto para saber qué pantalla abrir
            int idPuesto = usuarioValido.getIdPuesto();

            //Estructura para abrir la ventana según el id_puesto
            switch (idPuesto) {
                case 2: // ID 1 = Administrador (Verifica este número en tu tabla cat_puesto)
                    MenuAdmin mpAdmin = new MenuAdmin();
                    mpAdmin.setVisible(true);
                    break;
                    
                case 3: // ID 2 = Veterinario
                    Menu_Principal mpVet = new Menu_Principal();
                    mpVet.setVisible(true);
                    break;
                    
                case 4: // ID 3 = Recepcionista / Cajero
                    Dashboard_Secretario mpSec = new Dashboard_Secretario();
                    mpSec.setVisible(true);
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(this, "Tu usuario no tiene un rol válido asignado.");
                    return; // Detenemos la ejecución para que no cierre el login
            }
            
            // Cierra la ventana de login
            this.dispose(); 
            
        } else {
            // CASO: CREDENCIALES INCORRECTAS
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            txt_contraseña.setText(""); // Limpiamos el campo por seguridad
            txt_contraseña.requestFocus();
        }
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void link_nuevaCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link_nuevaCuentaMouseClicked
        System.out.println("Se presiono crear cuenta");
    }//GEN-LAST:event_link_nuevaCuentaMouseClicked

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
    private javax.swing.JTextField txt_Usuario;
    private javax.swing.JPasswordField txt_contraseña;
    // End of variables declaration//GEN-END:variables
}
