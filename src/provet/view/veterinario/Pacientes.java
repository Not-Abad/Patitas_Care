
package provet.view.veterinario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import provet.model.Paciente;
import provet.model.ControlPacientes;
import provet.componentes.PanelPaciente;
import provet.componentes.PanelPaciente2;
import java.awt.GridLayout;
import javax.swing.JDialog;
import provet.model.ControlUsuarios;
import provet.model.Usuario;
public class Pacientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Pacientes.class.getName());
    private Usuario usuario;
    
   public Pacientes(Usuario usuario) {
    initComponents();
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.usuario = usuario;

    if (usuario != null) {
    lblNombreVet.setText(usuario.getNombre());
    } else {
    lblNombreVet.setText("Sin usuario");
    }
    
    

    contenedor_Cartas1.setLayout(new GridLayout(0, 2, 20, 20));
    contenedor_Cartas1.setPreferredSize(null); 

    // DATOS DE PRUEBA
    ControlPacientes.listaPacientes.add(
        new Paciente(1, "Firulais", "Perro", "Labrador", 3, 20, "M", "", "", "src/img/perro1.jpg")
    );

    ControlPacientes.listaPacientes.add(
        new Paciente(2, "Michi", "Gato", "Siames", 2, 5, "H", "", "", "src/img/gato1.jpg")
    );

    ControlPacientes.listaPacientes.add(
        new Paciente(3, "Rocky", "Perro", "Bulldog", 4, 18, "M", "", "", "src/img/perro2.jpg")
    );
    ControlPacientes.listaPacientes.add(
        new Paciente(3, "Rocky", "Perro", "Bulldog", 4, 18, "M", "", "", "src/img/perro2.jpg")
    );
    

    cargarPacientes();
}
    
    public void agregarPaciente(Paciente p) {
    PanelPaciente panel = new PanelPaciente();
    panel.setDatos(p);

    contenedor_Cartas1.add(panel);
    contenedor_Cartas1.revalidate();
    contenedor_Cartas1.repaint();
}
    
    public void cargarPacientes() {
    contenedor_Cartas1.removeAll();

    for (Paciente p : ControlPacientes.listaPacientes) {
    PanelPaciente panel = new PanelPaciente();
    panel.setDatos(p);

    panel.setClickListener(() -> {
        System.out.println("CLICK RECIBIDO");
        panel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        abrirPanelConDatos(p);
    });
    panel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    contenedor_Cartas1.add(panel);
}

    contenedor_Cartas1.revalidate();
    contenedor_Cartas1.repaint();
}
    
    private void abrirPanel() {
    JDialog dialog = new JDialog(
        (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this),true );

    dialog.setTitle("Detalle del paciente");

    PanelPaciente2 panel = new PanelPaciente2();

    dialog.add(panel);
    dialog.pack(); 
    dialog.setLocationRelativeTo(null); 

    dialog.setVisible(true);
}

    private void abrirPanelConDatos(Paciente p) {
    JDialog dialog = new JDialog(this, true);
    dialog.setTitle("Detalle del paciente");

    PanelPaciente2 panel = new PanelPaciente2();
    panel.setDatos(p); // 👈 importante

    dialog.add(panel);
    dialog.pack();
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblNombreVet = new javax.swing.JLabel();
        btn_MenuP = new provet.componentes.botonSwing();
        botonSwing1 = new provet.componentes.botonSwing();
        btn_Reportes = new provet.componentes.botonSwing();
        btn_Salir = new provet.componentes.botonSwing();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        contenedor_Cartas1 = new provet.componentes.Contenedor_Cartas();
        contenedor_Cartas2 = new provet.componentes.Contenedor_Cartas();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new provet.componentes.botonSwing();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(108, 135, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Veterinario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel1.setText("FOTO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 255, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 53, 38));
        jLabel15.setText("PatitasCare");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        lblNombreVet.setBackground(new java.awt.Color(51, 255, 51));
        lblNombreVet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreVet.setForeground(new java.awt.Color(39, 53, 38));
        lblNombreVet.setText("Veterinario");
        jPanel2.add(lblNombreVet, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        btn_MenuP.setText("Menú Principal");
        btn_MenuP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuPActionPerformed(evt);
            }
        });
        jPanel2.add(btn_MenuP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        botonSwing1.setText("Pacientes");
        botonSwing1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing1ActionPerformed(evt);
            }
        });
        jPanel2.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Reportes.setText("Reportes");
        btn_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReportesActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 250, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 740));

        jPanel3.setBackground(new java.awt.Color(228, 230, 217));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor_Cartas1.setBackground(new java.awt.Color(108, 135, 118));
        contenedor_Cartas1.add(contenedor_Cartas2, new java.awt.GridBagConstraints());

        jPanel3.add(contenedor_Cartas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 940, 570));
        jPanel3.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 740, 30));

        btnBuscar.setBackground(new java.awt.Color(108, 135, 118));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 170, -1));

        jScrollPane1.setViewportView(jPanel3);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, -8, 1060, 750));

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

    private void btn_MenuPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuPActionPerformed
        Menu_Principal m = new Menu_Principal(ControlUsuarios.usuarioActivo); 
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_MenuPActionPerformed

    private void btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportesActionPerformed
        Reportes_Citas r = new Reportes_Citas(usuario);
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ReportesActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSwing1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String texto = txtBuscar.getText().trim().toLowerCase();

    contenedor_Cartas1.removeAll();

    for (Paciente p : ControlPacientes.listaPacientes) {

        boolean coincideNombre =
                p.getNombre().toLowerCase().contains(texto);

        boolean coincideID =
                String.valueOf(p.getID()).contains(texto);

        if (coincideNombre || coincideID) {

            PanelPaciente panel = new PanelPaciente();
            panel.setDatos(p);

            panel.setClickListener(() -> {
                abrirPanelConDatos(p);
            });

            panel.setCursor(
                new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
            );

            contenedor_Cartas1.add(panel);
        }
    }

    contenedor_Cartas1.revalidate();
    contenedor_Cartas1.repaint();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Pacientes(ControlUsuarios.usuarioActivo).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing botonSwing1;
    private provet.componentes.botonSwing btnBuscar;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private provet.componentes.Contenedor_Cartas contenedor_Cartas1;
    private provet.componentes.Contenedor_Cartas contenedor_Cartas2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreVet;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
