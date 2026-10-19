//Indicamos a que paquete pertenece
package provet.view.inicio;

//Importamos librerias
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import provet.utilidades.Servicio_Email;
import provet.dao.EmpleadoDAO;

//Inicio de la clase
public class Recuperar_Contraseña extends JFrame {
    
    // Atributos de la clase
    private int codigoEnviado;
    private String nombreUsuario = "Usuario";
    private static final Logger logger = Logger.getLogger(Recuperar_Contraseña.class.getName());

    // Constructor por defecto (por si se abre sin nombre)
    public Recuperar_Contraseña() {
        pnl_CambiarContraseña.setVisible(false);
        prepararVentana();
    }

    // SOBRECARGA: Constructor que recibe el nombre desde el Login
    public Recuperar_Contraseña(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombreUsuario = nombre;
        }
        prepararVentana();
    }

    // Método para no repetir código
    private void prepararVentana() {
        initComponents();
        enviarCorreoRecuperacion();
    
        // Configuración de focos
        configurarFoco(txt1, txt2, null);
        configurarFoco(txt2, txt3, txt1);
        configurarFoco(txt3, txt4, txt2);
        configurarFoco(txt4, txt5, txt3);
        configurarFoco(txt5, txt6, txt4);
        configurarFoco(txt6, null, txt5);
    }

    //Método Enviar correo (Ajustado a los estándares con MariaDB)
    private void enviarCorreoRecuperacion() {
        new Thread(() -> {
            try {
                //Buscamos el correo real en la base de datos usando el DAO
                EmpleadoDAO dao = new EmpleadoDAO();
                String correoDestino = dao.obtenerEmailPorUsuario(this.nombreUsuario);

                if (correoDestino == null || correoDestino.trim().isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(this, "El usuario '" + nombreUsuario + "' no existe o no tiene un correo registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    });
                    return; // Detenemos el proceso
                }

                //Preparamos el servicio de email
                Servicio_Email service = new Servicio_Email();                  
                this.codigoEnviado = service.generarCodigoRandom();             
                Map<String, String> variables = new HashMap<>();                
                variables.put("codigo", String.valueOf(codigoEnviado));
                variables.put("nombre", nombreUsuario);

                //Cargamos la plantilla HTML y enviamos el correo
                String cuerpoHtml = service.obtenerContenidoTemplate("recuperacion.html", variables);
                service.createEmail(correoDestino, "Código de autenticación - PatitasCare", cuerpoHtml);
                service.sendEmail();
                
                // Ocultamos parcialmente el correo por seguridad visual
                String correoOculto = correoDestino.replaceAll("(^[^@]{3}|(?!^)\\G)[^@]", "$1*");
                
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Te hemos enviado un código al correo:\n" + correoOculto);
                });

            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Error al procesar el correo de recuperación", ex);
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Error al enviar el correo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                });
            }
        }).start();
    }

    //Método Verificar Código
    public void verificarCodigo() {
        String ingresado = txt1.getText() + txt2.getText() + txt3.getText() + 
                           txt4.getText() + txt5.getText() + txt6.getText();
        
        if (ingresado.length() < 6) {
            JOptionPane.showMessageDialog(this, "Por favor, completa los 6 dígitos.");
            return;
        }    

        if (ingresado.equals(String.valueOf(codigoEnviado))) {
            JOptionPane.showMessageDialog(this, "¡Éxito! El código coincide.");
            pnl_CambiarContraseña.setVisible(true);
            pnl_IngresarDatos.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Código incorrecto. Revisa tu correo.");
        }
    }
    
    private void configurarFoco(javax.swing.JTextField actual, javax.swing.JTextField siguiente, javax.swing.JTextField anterior) {
        actual.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                
                if (!Character.isDigit(c)) {
                    e.consume(); 
                    return;
                }

                if (actual.getText().length() >= 1) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                if (actual.getText().length() == 1 && siguiente != null) {
                    siguiente.requestFocus();
                }
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if ((e.isControlDown() || e.isMetaDown()) && e.getKeyCode() == java.awt.event.KeyEvent.VK_V) {
                    e.consume(); 
                    repartirCodigoPegado();
                    return;
                }

                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
                    if (actual.getText().isEmpty() && anterior != null) {
                        anterior.setText("");
                        anterior.requestFocus();
                    }
                }
            }
        });
    }

    private void repartirCodigoPegado() {
        try {
            String data = (String) java.awt.Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(java.awt.datatransfer.DataFlavor.stringFlavor);

            String soloNumeros = data.replaceAll("[^0-9]", "");
            if (soloNumeros.length() > 6) {
                soloNumeros = soloNumeros.substring(0, 6);
            }

            javax.swing.JTextField[] campos = {txt1, txt2, txt3, txt4, txt5, txt6};

            for (int i = 0; i < soloNumeros.length(); i++) {
                campos[i].setText(String.valueOf(soloNumeros.charAt(i)));
            }

            if (soloNumeros.length() > 0) {
                int proximoFoco = Math.min(soloNumeros.length(), 5);
                campos[proximoFoco].requestFocus();
            }
            
            verificarCodigo();
            
        } catch (Exception ex) {
            System.err.println("Error al pegar: " + ex.getMessage());
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Operativo = new javax.swing.JPanel();
        pnl_IngresarDatos = new provet.componentes.PanelRedondeado();
        lbl_Titulo = new javax.swing.JLabel();
        lbl_Informacion1 = new javax.swing.JLabel();
        lbl_Informacion3 = new javax.swing.JLabel();
        lbl_Informacion2 = new javax.swing.JLabel();
        lbl_Pregunta = new javax.swing.JLabel();
        link_reenviarCorreo = new provet.componentes.linkLabel();
        btn_Continuar = new provet.componentes.botonSwing();
        pnl_Valor1 = new provet.componentes.PanelRedondeado();
        txt1 = new javax.swing.JTextField();
        pnl_Valor2 = new provet.componentes.PanelRedondeado();
        txt2 = new javax.swing.JTextField();
        pnl_Valor3 = new provet.componentes.PanelRedondeado();
        txt3 = new javax.swing.JTextField();
        pnl_Valor4 = new provet.componentes.PanelRedondeado();
        txt4 = new javax.swing.JTextField();
        pnl_Valor5 = new provet.componentes.PanelRedondeado();
        txt5 = new javax.swing.JTextField();
        pnl_Valor6 = new provet.componentes.PanelRedondeado();
        txt6 = new javax.swing.JTextField();
        pnl_CambiarContraseña = new provet.componentes.PanelRedondeado();
        lbl_Titulo1 = new javax.swing.JLabel();
        lbl_Informacion4 = new javax.swing.JLabel();
        lbl_Informacion6 = new javax.swing.JLabel();
        btn_Actualizar = new provet.componentes.botonSwing();
        pnl_NuevaContra = new provet.componentes.PanelRedondeado();
        txt_NuevaPass = new javax.swing.JTextField();
        pnl_ValidarContra = new provet.componentes.PanelRedondeado();
        chk_Ojo = new javax.swing.JCheckBox();
        txt_ConfirmarPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patitas Care");
        setMinimumSize(new java.awt.Dimension(450, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Operativo.setBackground(new java.awt.Color(112, 134, 107));
        pnl_Operativo.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        pnl_Operativo.setMaximumSize(new java.awt.Dimension(450, 450));
        pnl_Operativo.setMinimumSize(new java.awt.Dimension(450, 450));
        pnl_Operativo.setPreferredSize(new java.awt.Dimension(450, 450));
        pnl_Operativo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_IngresarDatos.setBackground(new java.awt.Color(192, 207, 178));
        pnl_IngresarDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Titulo.setText("Validación de Usuario");
        pnl_IngresarDatos.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 200, -1));

        lbl_Informacion1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Informacion1.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Informacion1.setText("Te hemos enviado un código de 6 digitos a tu");
        pnl_IngresarDatos.add(lbl_Informacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 320, -1));

        lbl_Informacion3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Informacion3.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Informacion3.setText("continuar.");
        pnl_IngresarDatos.add(lbl_Informacion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 80, -1));

        lbl_Informacion2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Informacion2.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Informacion2.setText("correo electronico. Por favor, ingresalo para");
        pnl_IngresarDatos.add(lbl_Informacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 310, -1));

        lbl_Pregunta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Pregunta.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Pregunta.setText("¿No recibiste el código?");
        pnl_IngresarDatos.add(lbl_Pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 170, -1));

        link_reenviarCorreo.setText("Reenviar");
        link_reenviarCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                link_reenviarCorreoMouseClicked(evt);
            }
        });
        pnl_IngresarDatos.add(link_reenviarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        btn_Continuar.setBackground(new java.awt.Color(69, 98, 78));
        btn_Continuar.setForeground(new java.awt.Color(228, 230, 217));
        btn_Continuar.setText("Continuar");
        btn_Continuar.setToolTipText("");
        btn_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ContinuarActionPerformed(evt);
            }
        });
        pnl_IngresarDatos.add(btn_Continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 230, 50));

        pnl_Valor1.setBackground(new java.awt.Color(228, 230, 217));
        pnl_Valor1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt1.setBackground(new java.awt.Color(228, 230, 217));
        txt1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        txt1.setForeground(new java.awt.Color(39, 53, 38));
        txt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt1.setToolTipText("Usuario");
        txt1.setActionCommand("<Not Set>");
        txt1.setAutoscrolls(false);
        txt1.setBorder(null);
        txt1.setCaretColor(new java.awt.Color(39, 53, 38));
        pnl_Valor1.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 45, 80));

        pnl_IngresarDatos.add(pnl_Valor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 55, 90));

        pnl_Valor2.setBackground(new java.awt.Color(228, 230, 217));
        pnl_Valor2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt2.setBackground(new java.awt.Color(228, 230, 217));
        txt2.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        txt2.setForeground(new java.awt.Color(39, 53, 38));
        txt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2.setToolTipText("Usuario");
        txt2.setActionCommand("<Not Set>");
        txt2.setAutoscrolls(false);
        txt2.setBorder(null);
        txt2.setCaretColor(new java.awt.Color(39, 53, 38));
        pnl_Valor2.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 45, 80));

        pnl_IngresarDatos.add(pnl_Valor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 120, 55, 90));

        pnl_Valor3.setBackground(new java.awt.Color(228, 230, 217));
        pnl_Valor3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt3.setBackground(new java.awt.Color(228, 230, 217));
        txt3.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        txt3.setForeground(new java.awt.Color(39, 53, 38));
        txt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt3.setToolTipText("Usuario");
        txt3.setActionCommand("<Not Set>");
        txt3.setAutoscrolls(false);
        txt3.setBorder(null);
        txt3.setCaretColor(new java.awt.Color(39, 53, 38));
        txt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt3ActionPerformed(evt);
            }
        });
        pnl_Valor3.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 45, 80));

        pnl_IngresarDatos.add(pnl_Valor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 55, 90));

        pnl_Valor4.setBackground(new java.awt.Color(228, 230, 217));
        pnl_Valor4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt4.setBackground(new java.awt.Color(228, 230, 217));
        txt4.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        txt4.setForeground(new java.awt.Color(39, 53, 38));
        txt4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt4.setToolTipText("Usuario");
        txt4.setActionCommand("<Not Set>");
        txt4.setAutoscrolls(false);
        txt4.setBorder(null);
        txt4.setCaretColor(new java.awt.Color(39, 53, 38));
        txt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt4ActionPerformed(evt);
            }
        });
        pnl_Valor4.add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 45, 80));

        pnl_IngresarDatos.add(pnl_Valor4, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 120, 55, 90));

        pnl_Valor5.setBackground(new java.awt.Color(228, 230, 217));
        pnl_Valor5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt5.setBackground(new java.awt.Color(228, 230, 217));
        txt5.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        txt5.setForeground(new java.awt.Color(39, 53, 38));
        txt5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5.setToolTipText("Usuario");
        txt5.setActionCommand("<Not Set>");
        txt5.setAutoscrolls(false);
        txt5.setBorder(null);
        txt5.setCaretColor(new java.awt.Color(39, 53, 38));
        txt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt5ActionPerformed(evt);
            }
        });
        pnl_Valor5.add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 45, 80));

        pnl_IngresarDatos.add(pnl_Valor5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 55, 90));

        pnl_Valor6.setBackground(new java.awt.Color(228, 230, 217));
        pnl_Valor6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt6.setBackground(new java.awt.Color(228, 230, 217));
        txt6.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        txt6.setForeground(new java.awt.Color(39, 53, 38));
        txt6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt6.setToolTipText("Usuario");
        txt6.setActionCommand("<Not Set>");
        txt6.setAutoscrolls(false);
        txt6.setBorder(null);
        txt6.setCaretColor(new java.awt.Color(39, 53, 38));
        txt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt6ActionPerformed(evt);
            }
        });
        pnl_Valor6.add(txt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 45, 80));

        pnl_IngresarDatos.add(pnl_Valor6, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 120, 55, 90));

        pnl_Operativo.add(pnl_IngresarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 37, 400, 330));

        pnl_CambiarContraseña.setBackground(new java.awt.Color(192, 207, 178));
        pnl_CambiarContraseña.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Titulo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_Titulo1.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Titulo1.setText("Nueva Contraseña");
        pnl_CambiarContraseña.add(lbl_Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, -1));

        lbl_Informacion4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Informacion4.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Informacion4.setText("Ingresa una nueva Contraseña:");
        pnl_CambiarContraseña.add(lbl_Informacion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 320, -1));

        lbl_Informacion6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Informacion6.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Informacion6.setText("Confirma la Contraseña:");
        pnl_CambiarContraseña.add(lbl_Informacion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 310, -1));

        btn_Actualizar.setBackground(new java.awt.Color(69, 98, 78));
        btn_Actualizar.setForeground(new java.awt.Color(228, 230, 217));
        btn_Actualizar.setText("Actualizar Contraseña");
        btn_Actualizar.setToolTipText("");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        pnl_CambiarContraseña.add(btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 230, 50));

        pnl_NuevaContra.setBackground(new java.awt.Color(228, 230, 217));
        pnl_NuevaContra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_NuevaPass.setBackground(new java.awt.Color(228, 230, 217));
        txt_NuevaPass.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        txt_NuevaPass.setForeground(new java.awt.Color(39, 53, 38));
        txt_NuevaPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NuevaPass.setToolTipText("Usuario");
        txt_NuevaPass.setActionCommand("<Not Set>");
        txt_NuevaPass.setAutoscrolls(false);
        txt_NuevaPass.setBorder(null);
        txt_NuevaPass.setCaretColor(new java.awt.Color(39, 53, 38));
        pnl_NuevaContra.add(txt_NuevaPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 330, 30));

        pnl_CambiarContraseña.add(pnl_NuevaContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 100, 350, 40));

        pnl_ValidarContra.setBackground(new java.awt.Color(228, 230, 217));
        pnl_ValidarContra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chk_Ojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--eye-closed-solid.png"))); // NOI18N
        chk_Ojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_OjoActionPerformed(evt);
            }
        });
        pnl_ValidarContra.add(chk_Ojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 5, 40, 30));

        txt_ConfirmarPass.setBackground(new java.awt.Color(228, 230, 217));
        txt_ConfirmarPass.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        txt_ConfirmarPass.setForeground(new java.awt.Color(39, 53, 38));
        txt_ConfirmarPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ConfirmarPass.setBorder(null);
        pnl_ValidarContra.add(txt_ConfirmarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 330, 30));

        pnl_CambiarContraseña.add(pnl_ValidarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 190, 350, 40));

        pnl_Operativo.add(pnl_CambiarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 37, 400, 330));

        getContentPane().add(pnl_Operativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarsActionPerformed
    }//GEN-LAST:event_btn_iniciarsActionPerformed

    private void btn_ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ContinuarActionPerformed
        verificarCodigo();
        
    }//GEN-LAST:event_btn_ContinuarActionPerformed

    private void link_reenviarCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link_reenviarCorreoMouseClicked
        enviarCorreoRecuperacion();
    }//GEN-LAST:event_link_reenviarCorreoMouseClicked

    private void txt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt3ActionPerformed

    private void txt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt4ActionPerformed

    private void txt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt5ActionPerformed

    private void txt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt6ActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        String nuevaPass = txt_NuevaPass.getText().trim();
        String confirmarPass = new String(txt_ConfirmarPass.getPassword()).trim();

        if (nuevaPass.isEmpty() || confirmarPass.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, completa ambos campos.");
            return;
        }

        if (nuevaPass.equals(confirmarPass)) {
            
            // Instanciamos el DAO y llamamos a actualizarPassword
            EmpleadoDAO dao = new EmpleadoDAO();
            boolean exito = dao.actualizarPassword(this.nombreUsuario, nuevaPass);
            
            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this, "¡Contraseña actualizada exitosamente en PatitasCare!");
                this.dispose(); // Cierra y permite que el usuario regrese al Login
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Hubo un error al actualizar en la base de datos.", "Error SQL", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Inténtalo de nuevo.", "Error de seguridad", javax.swing.JOptionPane.ERROR_MESSAGE);
            txt_NuevaPass.setText("");
            txt_ConfirmarPass.setText("");
            txt_NuevaPass.requestFocus(); 
        }
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void chk_OjoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_OjoActionPerformed
        if(chk_Ojo.isSelected()){
            txt_ConfirmarPass.setEchoChar((char)0);
            chk_Ojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--eye-solid.png")));
        }else{
            txt_ConfirmarPass.setEchoChar('•');
            chk_Ojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basil--eye-closed-solid.png")));
        }
    }//GEN-LAST:event_chk_OjoActionPerformed

    public void verificar_Datos(){

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
        java.awt.EventQueue.invokeLater(() -> new Recuperar_Contraseña().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing btn_Actualizar;
    private provet.componentes.botonSwing btn_Continuar;
    private javax.swing.JCheckBox chk_Ojo;
    private javax.swing.JLabel lbl_Informacion1;
    private javax.swing.JLabel lbl_Informacion2;
    private javax.swing.JLabel lbl_Informacion3;
    private javax.swing.JLabel lbl_Informacion4;
    private javax.swing.JLabel lbl_Informacion6;
    private javax.swing.JLabel lbl_Pregunta;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_Titulo1;
    private provet.componentes.linkLabel link_reenviarCorreo;
    private provet.componentes.PanelRedondeado pnl_CambiarContraseña;
    private provet.componentes.PanelRedondeado pnl_IngresarDatos;
    private provet.componentes.PanelRedondeado pnl_NuevaContra;
    private javax.swing.JPanel pnl_Operativo;
    private provet.componentes.PanelRedondeado pnl_ValidarContra;
    private provet.componentes.PanelRedondeado pnl_Valor1;
    private provet.componentes.PanelRedondeado pnl_Valor2;
    private provet.componentes.PanelRedondeado pnl_Valor3;
    private provet.componentes.PanelRedondeado pnl_Valor4;
    private provet.componentes.PanelRedondeado pnl_Valor5;
    private provet.componentes.PanelRedondeado pnl_Valor6;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JPasswordField txt_ConfirmarPass;
    private javax.swing.JTextField txt_NuevaPass;
    // End of variables declaration//GEN-END:variables
}
