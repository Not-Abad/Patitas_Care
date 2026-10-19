
package provet.view.veterinario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import provet.model.Paciente;
import provet.model.ControlPacientes;
import provet.componentes.PanelPaciente;
import provet.componentes.PanelPaciente2;
import provet.componentes.PanelCitas;
import provet.componentes.PanelCitas2;
import java.awt.GridLayout;
import javax.swing.JDialog;
import provet.componentes.PanelCitas_Editable;
import provet.model.ControlUsuarios;
import provet.model.Usuario;
import provet.model.Reporte;
import provet.model.ControlReportes;

public class Reportes_Citas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Reportes_Citas.class.getName());
    private Usuario usuario;
    
   public Reportes_Citas(Usuario usuario) {
    initComponents();
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    if (usuario != null) {
    lblNombreVet.setText(usuario.getNombre());
    } else {
    lblNombreVet.setText("Sin usuario");
    }
    
    

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
    

    
}
public void agregarReporte(Reporte reporte) {
    ControlReportes.listaReportes.add(reporte);

    PanelCitas_Editable carta = new PanelCitas_Editable(reporte);

    contenedor.add(carta);

    contenedor.revalidate();
    contenedor.repaint();
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
        btn_Calendario = new provet.componentes.botonSwing();
        btn_Reportes = new provet.componentes.botonSwing();
        btn_Salir = new provet.componentes.botonSwing();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        contenedor = new provet.componentes.Contenedor_Cartas();
        btnSubir = new provet.componentes.botonSwing();
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

        btn_Calendario.setText("Calendario");
        jPanel2.add(btn_Calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        btn_Reportes.setText("Reportes");
        btn_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReportesActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 60));

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

        contenedor.setBackground(new java.awt.Color(108, 135, 118));
        jPanel3.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 940, 570));

        btnSubir.setBackground(new java.awt.Color(108, 135, 118));
        btnSubir.setForeground(new java.awt.Color(39, 53, 38));
        btnSubir.setText("Subir reporte");
        btnSubir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 170, 30));
        jPanel3.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 550, 30));

        btnBuscar.setBackground(new java.awt.Color(108, 135, 118));
        btnBuscar.setText("Buscar");
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 170, 30));

        jScrollPane1.setViewportView(jPanel3);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, -8, 1030, 750));

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
        
    }//GEN-LAST:event_btn_ReportesActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
        Pacientes p = new Pacientes(usuario);
        p.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_botonSwing1ActionPerformed

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
    PanelCitas panel = new PanelCitas(this);

    JDialog dialog = new JDialog(this, "Nuevo Reporte", true);
    dialog.setSize(477, 611);
    dialog.setLocationRelativeTo(this);
    dialog.add(panel);
    dialog.setVisible(true);

    }//GEN-LAST:event_btnSubirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String texto = txtBuscar.getText().trim().toLowerCase();

        contenedor.removeAll();

    for (Reporte r : ControlReportes.listaReportes) {

    boolean coincideID =
            String.valueOf(r.getID()).contains(texto);

    boolean coincideNombre =
            r.getNombre().toLowerCase().contains(texto);

    if (coincideID || coincideNombre) {

        PanelCitas_Editable panel =
                new PanelCitas_Editable(r);

        contenedor.add(panel);
    }
}

contenedor.revalidate();
contenedor.repaint();
                 
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
        java.awt.EventQueue.invokeLater(() -> new Reportes_Citas(ControlUsuarios.usuarioActivo).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing botonSwing1;
    private provet.componentes.botonSwing btnBuscar;
    private provet.componentes.botonSwing btnSubir;
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private provet.componentes.Contenedor_Cartas contenedor;
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
