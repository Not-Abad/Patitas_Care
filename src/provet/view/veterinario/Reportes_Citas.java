package provet.view.veterinario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import provet.componentes.PanelCitas;
import provet.componentes.PanelCitas_Editable;
import provet.dao.ReporteCitaDAO;
import provet.modelo.Reporte;
import provet.modelo.Usuario;
import provet.utilidades.Sesion;

public class Reportes_Citas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Reportes_Citas.class.getName());
    private Usuario usuario;
    private final ReporteCitaDAO reporteDAO = new ReporteCitaDAO();
    private List<Reporte> listaReportes = new ArrayList<>();

    public Reportes_Citas() {
        this(Sesion.getUsuarioActual());
    }
    
    public Reportes_Citas(Usuario usuario) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.usuario = (usuario != null) ? usuario : Sesion.getUsuarioActual();

        if (Sesion.haySesionActiva()) {
            lblNombreVet.setText(Sesion.getNombreMostrar());
            String rol = Sesion.getNombreRol();
            if (!rol.isEmpty()) {
                jLabel6.setText(rol);
            }
        } else if (this.usuario != null) {
            lblNombreVet.setText(this.usuario.getUsername());
        } else {
            lblNombreVet.setText("Sin usuario");
        }

        txtBuscar.addActionListener(e -> btnBuscarActionPerformed(e));

        cargarReportesDesdeBD();
    }

    public final void cargarReportesDesdeBD() {
        this.listaReportes = reporteDAO.selectAllReportes();
        renderizarReportes(this.listaReportes);
    }

    private void renderizarReportes(List<Reporte> reportes) {
        contenedor.removeAll();
        for (Reporte r : reportes) {
            contenedor.add(new PanelCitas_Editable(r));
        }
        contenedor.revalidate();
        contenedor.repaint();
    }

    public void agregarReporte(Reporte reporte) {
        listaReportes.add(0, reporte);
        renderizarReportes(listaReportes);
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
    }//GEN-LAST:event_btn_administrativoActionPerformed

    private void btn_atencionmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atencionmedActionPerformed
        dispose();
    }//GEN-LAST:event_btn_atencionmedActionPerformed

    private void btn_configuraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configuraciónActionPerformed
    }//GEN-LAST:event_btn_configuraciónActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas salir?",
                "Confirmar salida",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            Sesion.cerrarSesion();
            new provet.view.inicio.Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_MenuPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuPActionPerformed
        Menu_Principal m = new Menu_Principal(usuario); 
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_MenuPActionPerformed

    private void btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportesActionPerformed
        cargarReportesDesdeBD();
    }//GEN-LAST:event_btn_ReportesActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
        Pacientes p = new Pacientes(usuario);
        p.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_botonSwing1ActionPerformed

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        PanelCitas panel = new PanelCitas(this);

        JDialog dialog = new JDialog(this, "Nuevo Reporte", true);
        dialog.setSize(603, 546);
        dialog.setLocationRelativeTo(this);
        dialog.add(panel);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnSubirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String texto = txtBuscar.getText().trim().toLowerCase();

        if (texto.isEmpty()) {
            renderizarReportes(listaReportes);
            return;
        }

        List<Reporte> filtrados = new ArrayList<>();
        for (Reporte r : listaReportes) {
            boolean coincideID = String.valueOf(r.getIdMascota()).contains(texto);
            boolean coincideNombre = r.getNombreMascota() != null && r.getNombreMascota().toLowerCase().contains(texto);
            boolean coincideEspecie = r.getEspecie() != null && r.getEspecie().toLowerCase().contains(texto);
            boolean coincideVet = r.getVeterinario() != null && r.getVeterinario().toLowerCase().contains(texto);
            boolean coincideMotivo = r.getMotivo() != null && r.getMotivo().toLowerCase().contains(texto);

            if (coincideID || coincideNombre || coincideEspecie || coincideVet || coincideMotivo) {
                filtrados.add(r);
            }
        }

        renderizarReportes(filtrados);
    }//GEN-LAST:event_btnBuscarActionPerformed

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> new Reportes_Citas().setVisible(true));
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