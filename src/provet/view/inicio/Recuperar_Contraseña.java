package provet.view.inicio;


//Paquete al que pertenece la ventana

//Importamos librerias a usar
import javax.swing.*;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

//Inicio de la clase Login, que hereda de la clase JFrame
public class Recuperar_Contraseña extends JFrame {
    
    //Atributos de la clase
    private static final String emailFrom = "patitascare.notificaciones@gmail.com";
    private static final String passwordFrom = "yrnrylwgxklboyya";
    private String emailTo;
    private String subject;
    private String content;
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    private int codigoEnviado;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Recuperar_Contraseña.class.getName());
    
    @SuppressWarnings("unchecked")
    public Recuperar_Contraseña() {
        
        mProperties = new Properties();
        initComponents();
        
        // Creamos un hilo secundario para el proceso del correo
        new Thread(() -> {
            try {
                // Movemos toda la lógica pesada aquí adentro
                createEmail();
                sendEmail();
            } catch (MessagingException ex) {
                // Manejo de error si falla la creación o el envío
                java.util.logging.Logger.getLogger(Recuperar_Contraseña.class.getName())
                    .log(java.util.logging.Level.SEVERE, "Error en el proceso de correo", ex);
            
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "No se pudo enviar el correo de recuperación.");
                });
            }
        }).start(); // Iniciamos el hilo
        
        configurarFoco(txt1, txt2, null); // El primero no tiene anterior
        configurarFoco(txt2, txt3, txt1);
        configurarFoco(txt3, txt4, txt2);
        configurarFoco(txt4, txt5, txt3);
        configurarFoco(txt5, txt6, txt4);
        configurarFoco(txt6, null, txt5); // El último no tiene siguiente
    }
    
    private void createEmail() throws MessagingException{
        emailTo = "0905chucho@gmail.com";               //Destinatario del correo
        subject = "Código de autenticación";            //Asunto del correo
        this.codigoEnviado = generarCodigoRandom();     //Crea el número random

        //Generamos el correo usando HTML
        content = "<!DOCTYPE html>" +
        "<html>" +
        "<head><meta charset='UTF-8'></head>" +
        "<body style='margin: 0; padding: 0; background-color: #D9D9C9; font-family: sans-serif;'>" +
            "<table width='100%' border='0' cellspacing='0' cellpadding='0' style='margin-top: 20px;'>" +
                "<tr>" +
                    "<td align='center'>" +
                        "<table width='600' border='0' cellspacing='0' cellpadding='0' style='background-color: #ffffff; border-radius: 15px; overflow: hidden;'>" +
                            "<tr>" +
                                "<td style='background-color: #2D4B37; padding: 30px; text-align: center;'>" +
                                    "<h1 style='color: #B5C9AD; margin: 0; font-size: 28px; letter-spacing: 2px;'>PatitasCare</h1>" +
                                "</td>" +
                            "</tr>" +
                            "<tr>" +
                                "<td style='padding: 40px; color: #333333; line-height: 1.6;'>" +
                                    "<h2 style='color: #2D4B37;'>¡Hola de nuevo!</h2>" +
                                    "<p>Recibimos una solicitud para restablecer la contraseña de tu cuenta en <strong>PatitasCare</strong>.</p>" +
                                    "<p>Tu código de verificación es:</p>" +
                                    "<div style='background-color: #F4F7F2; border: 2px dashed #B5C9AD; border-radius: 10px; padding: 20px; text-align: center; margin: 30px 0;'>" +
                                        "<span style='font-size: 42px; font-weight: bold; color: #2D4B37; letter-spacing: 10px;'>" + 
                                            codigoEnviado + 
                                        "</span>" +
                                    "</div>" +
                                    "<p>Ingresa este número en la ventana de validación para crear una nueva contraseña. Por tu seguridad, este código expirará pronto.</p>" +
                                    "<hr style='border: 0; border-top: 1px solid #eeeeee; margin: 30px 0;'>" +
                                    "<p style='font-size: 13px; color: #777777;'>Si no has sido tú, no te preocupes; nadie puede acceder a tu cuenta sin este código.</p>" +
                                "</td>" +
                            "</tr>" +
                            "<tr>" +
                                "<td style='background-color: #f9f9f9; padding: 20px; text-align: center; font-size: 12px; color: #777777;'>" +
                                    "<p>El equipo de <strong>PatitasCare</strong></p>" +
                                    "<p style='color: #3D5A45; font-style: italic; font-weight: bold;'>Cuidando a los que más quieres.</p>" +
                                "</td>" +
                            "</tr>" +
                        "</table>" +
                    "</td>" +
                "</tr>" +
            "</table>" +
        "</body>" +
        "</html>";
        
        // Protocolo simple de transferencia de correo (SMTP)
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setContent(content, "text/html; charset=utf-8");
        } catch (AddressException ex) {
            Logger.getLogger(Recuperar_Contraseña.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Recuperar_Contraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Error al enviar: " + ex.getMessage());
        }
    }
    
    //Método para generar números aleatorios
    public int generarCodigoRandom() { 
        long semilla = System.currentTimeMillis();          //La semilla es la hora actual
        Random random = new Random(semilla);            //Declaro la variable aleatoria
        int codigo = 100000 + random.nextInt(900000);  //Genero el número
 
        return codigo;                                      //Retorna el número aleatorio
    }

    public void verificarCodigo() {
    String ingresado = txt1.getText() + txt2.getText() + txt3.getText() + 
                       txt4.getText() + txt5.getText() + txt6.getText();
    
    if (ingresado.length() < 6) {
        JOptionPane.showMessageDialog(this, "Por favor, completa los 6 dígitos.");
        return;
    }    

    //Comparar con la variable global
    if (ingresado.equals(String.valueOf(codigoEnviado))) {
        JOptionPane.showMessageDialog(this, "¡Éxito! El código coincide.");
    } else {
        JOptionPane.showMessageDialog(this, "Código incorrecto. Revisa tu correo.");
    }
}
    
    private void configurarFoco(javax.swing.JTextField actual, javax.swing.JTextField siguiente, javax.swing.JTextField anterior) {
    actual.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent e) {
            char c = e.getKeyChar();
            
            // 1. Validar que solo sea un número
            if (!Character.isDigit(c)) {
                e.consume(); // Bloquea letras, símbolos o espacios
                return;
            }

            // 2. Limitar a solo 1 carácter
            if (actual.getText().length() >= 1) {
                e.consume();
            }
        }

        @Override
        public void keyReleased(java.awt.event.KeyEvent e) {
            // Si escribió un número, pasar al siguiente campo
            if (actual.getText().length() == 1 && siguiente != null) {
                siguiente.requestFocus();
            }
        }

        @Override
        public void keyPressed(java.awt.event.KeyEvent e) {
            //Detectar si el usuario presionó Ctrl + V
            if ((e.isControlDown() || e.isMetaDown()) && e.getKeyCode() == java.awt.event.KeyEvent.VK_V) {
                e.consume(); // Detenemos el pegado normal de Java
                repartirCodigoPegado();
                return;
            }

            // Si presiona borrar y el campo está vacío, regresar al anterior
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
        // 1. Acceder al portapapeles del sistema
        String data = (String) java.awt.Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(java.awt.datatransfer.DataFlavor.stringFlavor);

        // 2. Limpiar el texto: solo nos quedamos con los números y máximo 6
        String soloNumeros = data.replaceAll("[^0-9]", "");
        if (soloNumeros.length() > 6) {
            soloNumeros = soloNumeros.substring(0, 6);
        }

        // 3. Creamos un arreglo con tus campos para iterar fácil
        javax.swing.JTextField[] campos = {txt1, txt2, txt3, txt4, txt5, txt6};

        // 4. Repartir cada carácter en su respectivo cuadro
        for (int i = 0; i < soloNumeros.length(); i++) {
            campos[i].setText(String.valueOf(soloNumeros.charAt(i)));
        }

        // 5. Mover el foco al último campo llenado para que el usuario pueda seguir
        if (soloNumeros.length() > 0) {
            int proximoFoco = Math.min(soloNumeros.length(), 5);
            campos[proximoFoco].requestFocus();
        }

    } catch (Exception ex) {
        // Si el portapapeles no tiene texto o algo falla, no hacemos nada
        System.err.println("Error al pegar: " + ex.getMessage());
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Operativo = new javax.swing.JPanel();
        pnl_Login = new provet.componentes.PanelRedondeado();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patitas Care");
        setMaximumSize(new java.awt.Dimension(450, 450));
        setMinimumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(450, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Operativo.setBackground(new java.awt.Color(112, 134, 107));
        pnl_Operativo.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        pnl_Operativo.setMaximumSize(new java.awt.Dimension(450, 450));
        pnl_Operativo.setMinimumSize(new java.awt.Dimension(450, 450));
        pnl_Operativo.setPreferredSize(new java.awt.Dimension(450, 450));
        pnl_Operativo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Login.setBackground(new java.awt.Color(192, 207, 178));
        pnl_Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Titulo.setText("Validación de Usuario");
        pnl_Login.add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 200, -1));

        lbl_Informacion1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Informacion1.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Informacion1.setText("Te hemos enviado un código de 6 digitos a tu");
        pnl_Login.add(lbl_Informacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 320, -1));

        lbl_Informacion3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Informacion3.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Informacion3.setText("continuar.");
        pnl_Login.add(lbl_Informacion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 80, -1));

        lbl_Informacion2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Informacion2.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Informacion2.setText("correo electronico. Por favor, ingresalo para");
        pnl_Login.add(lbl_Informacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 310, -1));

        lbl_Pregunta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Pregunta.setForeground(new java.awt.Color(39, 53, 38));
        lbl_Pregunta.setText("¿No recibiste el código?");
        pnl_Login.add(lbl_Pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 170, -1));

        link_reenviarCorreo.setText("Reenviar");
        link_reenviarCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                link_reenviarCorreoMouseClicked(evt);
            }
        });
        pnl_Login.add(link_reenviarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        btn_Continuar.setBackground(new java.awt.Color(69, 98, 78));
        btn_Continuar.setForeground(new java.awt.Color(228, 230, 217));
        btn_Continuar.setText("Continuar");
        btn_Continuar.setToolTipText("");
        btn_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ContinuarActionPerformed(evt);
            }
        });
        pnl_Login.add(btn_Continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 230, 50));

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

        pnl_Login.add(pnl_Valor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 55, 90));

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

        pnl_Login.add(pnl_Valor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 120, 55, 90));

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

        pnl_Login.add(pnl_Valor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 55, 90));

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

        pnl_Login.add(pnl_Valor4, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 120, 55, 90));

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

        pnl_Login.add(pnl_Valor5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 55, 90));

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

        pnl_Login.add(pnl_Valor6, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 120, 55, 90));

        pnl_Operativo.add(pnl_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 37, 400, 330));

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
        //Creamos y enviamos un nuevo correo Email
        try {
            createEmail();
        } catch (MessagingException ex) {
            System.getLogger(Recuperar_Contraseña.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        sendEmail();
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
    private provet.componentes.botonSwing btn_Continuar;
    private javax.swing.JLabel lbl_Informacion1;
    private javax.swing.JLabel lbl_Informacion2;
    private javax.swing.JLabel lbl_Informacion3;
    private javax.swing.JLabel lbl_Pregunta;
    private javax.swing.JLabel lbl_Titulo;
    private provet.componentes.linkLabel link_reenviarCorreo;
    private provet.componentes.PanelRedondeado pnl_Login;
    private javax.swing.JPanel pnl_Operativo;
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
    // End of variables declaration//GEN-END:variables
}
