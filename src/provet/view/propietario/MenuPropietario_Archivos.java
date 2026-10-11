
package provet.view.propietario;

import javax.swing.JFrame;

public class MenuPropietario_Archivos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPropietario_Archivos.class.getName());

    public MenuPropietario_Archivos() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        panel_citas_pendientes = new provet.componentes.PanelRedondeado();
        lbl_acceder = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        btn_iniciars = new provet.componentes.boton_redondo();
        lbl_imaarchivo4 = new javax.swing.JLabel();
        lbl_archivo4 = new javax.swing.JLabel();
        lbl_archivo4fecha4 = new javax.swing.JLabel();
        lbl_estatusarchivo4 = new javax.swing.JLabel();
        btn_verarchivo3 = new javax.swing.JButton();
        btn_descargararchivo3 = new javax.swing.JButton();
        btn_eliminararchivo3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        botonSwing2 = new provet.componentes.botonSwing();
        panel_citas_pendientes1 = new provet.componentes.PanelRedondeado();
        lbl_acceder1 = new javax.swing.JLabel();
        usuario1 = new javax.swing.JLabel();
        btn_iniciars1 = new provet.componentes.boton_redondo();
        lbl_imaarchivo = new javax.swing.JLabel();
        lbl_archivo1 = new javax.swing.JLabel();
        lbl_archivo1fecha = new javax.swing.JLabel();
        lbl_estatusarchivo1 = new javax.swing.JLabel();
        btn_verarchivo = new javax.swing.JButton();
        btn_eliminararchivo = new javax.swing.JButton();
        btn_descargararchivo = new javax.swing.JButton();
        panel_citas_pendientes2 = new provet.componentes.PanelRedondeado();
        lbl_acceder2 = new javax.swing.JLabel();
        usuario2 = new javax.swing.JLabel();
        btn_iniciars2 = new provet.componentes.boton_redondo();
        lbl_imaarchivo2 = new javax.swing.JLabel();
        lbl_archivo2 = new javax.swing.JLabel();
        lbl_archivo2fecha2 = new javax.swing.JLabel();
        lbl_estatusarchivo2 = new javax.swing.JLabel();
        btn_verarchivo1 = new javax.swing.JButton();
        btn_descargararchivo1 = new javax.swing.JButton();
        btn_eliminararchivo1 = new javax.swing.JButton();
        panel_citas_pendientes3 = new provet.componentes.PanelRedondeado();
        lbl_acceder4 = new javax.swing.JLabel();
        usuario4 = new javax.swing.JLabel();
        btn_iniciars4 = new provet.componentes.boton_redondo();
        lbl_imaarchivo3 = new javax.swing.JLabel();
        lbl_arcivo3 = new javax.swing.JLabel();
        lbl_archivo3fecha3 = new javax.swing.JLabel();
        lbl_estatusarchivo3 = new javax.swing.JLabel();
        btn_verarchivo2 = new javax.swing.JButton();
        btn_descargararchivo2 = new javax.swing.JButton();
        btn_eliminararchivo2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_MenuP = new provet.componentes.botonSwing();
        botonSwing1 = new provet.componentes.botonSwing();
        btn_Calendario = new provet.componentes.botonSwing();
        btn_Reportes = new provet.componentes.botonSwing();
        btn_Salir = new provet.componentes.botonSwing();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 230, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(1291, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_citas_pendientes.setBackground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes.add(lbl_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btn_iniciars.setText("Iniciar Sesión");
        btn_iniciars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarsActionPerformed(evt);
            }
        });
        panel_citas_pendientes.add(btn_iniciars, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        lbl_imaarchivo4.setText("lbl_imaarchivo4");
        panel_citas_pendientes.add(lbl_imaarchivo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lbl_archivo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_archivo4.setText("Receta-Luna");
        panel_citas_pendientes.add(lbl_archivo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        lbl_archivo4fecha4.setText("Subido: 20/04/2026       10:43 a.m");
        panel_citas_pendientes.add(lbl_archivo4fecha4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        lbl_estatusarchivo4.setText("jLabel5");
        panel_citas_pendientes.add(lbl_estatusarchivo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        btn_verarchivo3.setText("Ver");
        btn_verarchivo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verarchivo3ActionPerformed(evt);
            }
        });
        panel_citas_pendientes.add(btn_verarchivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        btn_descargararchivo3.setText("descargar");
        panel_citas_pendientes.add(btn_descargararchivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        btn_eliminararchivo3.setText("eliminar");
        btn_eliminararchivo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminararchivo3ActionPerformed(evt);
            }
        });
        panel_citas_pendientes.add(btn_eliminararchivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        jPanel1.add(panel_citas_pendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 860, 100));

        jLabel9.setBackground(new java.awt.Color(51, 255, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(39, 53, 38));
        jLabel9.setText("MIS ARCHIVOS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 29));

        botonSwing2.setBackground(new java.awt.Color(108, 135, 118));
        botonSwing2.setText("Subir archivos");
        botonSwing2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonSwing2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonSwing2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 250, 60));

        panel_citas_pendientes1.setBackground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder1.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes1.add(lbl_acceder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        usuario1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario1.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes1.add(usuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btn_iniciars1.setText("Iniciar Sesión");
        btn_iniciars1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars1ActionPerformed(evt);
            }
        });
        panel_citas_pendientes1.add(btn_iniciars1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        lbl_imaarchivo.setText("lbl_imaarchivo");
        panel_citas_pendientes1.add(lbl_imaarchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lbl_archivo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_archivo1.setText("Radiografia-Max");
        panel_citas_pendientes1.add(lbl_archivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lbl_archivo1fecha.setText("Subido: 20/04/2026       10:30 a.m");
        panel_citas_pendientes1.add(lbl_archivo1fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        lbl_estatusarchivo1.setText("jLabel2");
        panel_citas_pendientes1.add(lbl_estatusarchivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        btn_verarchivo.setText("Ver");
        btn_verarchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verarchivoActionPerformed(evt);
            }
        });
        panel_citas_pendientes1.add(btn_verarchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        btn_eliminararchivo.setText("eliminar");
        btn_eliminararchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminararchivoActionPerformed(evt);
            }
        });
        panel_citas_pendientes1.add(btn_eliminararchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        btn_descargararchivo.setText("descargar");
        panel_citas_pendientes1.add(btn_descargararchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        jPanel1.add(panel_citas_pendientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 860, 100));

        panel_citas_pendientes2.setBackground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder2.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes2.add(lbl_acceder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        usuario2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario2.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes2.add(usuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btn_iniciars2.setText("Iniciar Sesión");
        btn_iniciars2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars2ActionPerformed(evt);
            }
        });
        panel_citas_pendientes2.add(btn_iniciars2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        lbl_imaarchivo2.setText("lbl_imaarchivo2");
        panel_citas_pendientes2.add(lbl_imaarchivo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lbl_archivo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_archivo2.setText("Examenes-Luna.pdf");
        panel_citas_pendientes2.add(lbl_archivo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lbl_archivo2fecha2.setText("Subido: 20/04/2026       10:32 a.m");
        panel_citas_pendientes2.add(lbl_archivo2fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        lbl_estatusarchivo2.setText("jLabel3");
        panel_citas_pendientes2.add(lbl_estatusarchivo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        btn_verarchivo1.setText("Ver");
        btn_verarchivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verarchivo1ActionPerformed(evt);
            }
        });
        panel_citas_pendientes2.add(btn_verarchivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        btn_descargararchivo1.setText("descargar");
        panel_citas_pendientes2.add(btn_descargararchivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        btn_eliminararchivo1.setText("eliminar");
        btn_eliminararchivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminararchivo1ActionPerformed(evt);
            }
        });
        panel_citas_pendientes2.add(btn_eliminararchivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        jPanel1.add(panel_citas_pendientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 860, 100));

        panel_citas_pendientes3.setBackground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_acceder4.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes3.add(lbl_acceder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        usuario4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuario4.setForeground(new java.awt.Color(255, 255, 255));
        panel_citas_pendientes3.add(usuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btn_iniciars4.setText("Iniciar Sesión");
        btn_iniciars4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciars4ActionPerformed(evt);
            }
        });
        panel_citas_pendientes3.add(btn_iniciars4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 40));

        lbl_imaarchivo3.setText("lbl_imaarchivo3");
        panel_citas_pendientes3.add(lbl_imaarchivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lbl_arcivo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_arcivo3.setText("Receta-Max");
        panel_citas_pendientes3.add(lbl_arcivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        lbl_archivo3fecha3.setText("Subido: 20/04/2026       10:35 a.m");
        panel_citas_pendientes3.add(lbl_archivo3fecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        lbl_estatusarchivo3.setText("jLabel4");
        panel_citas_pendientes3.add(lbl_estatusarchivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, 20));

        btn_verarchivo2.setText("Ver");
        btn_verarchivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verarchivo2ActionPerformed(evt);
            }
        });
        panel_citas_pendientes3.add(btn_verarchivo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        btn_descargararchivo2.setText("descargar");
        panel_citas_pendientes3.add(btn_descargararchivo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        btn_eliminararchivo2.setText("eliminar");
        btn_eliminararchivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminararchivo2ActionPerformed(evt);
            }
        });
        panel_citas_pendientes3.add(btn_eliminararchivo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        jPanel1.add(panel_citas_pendientes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 860, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1200, 740));

        jPanel2.setBackground(new java.awt.Color(108, 135, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Propietario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel1.setText("FOTO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 255, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 53, 38));
        jLabel15.setText("PatitasCare");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel16.setBackground(new java.awt.Color(51, 255, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(39, 53, 38));
        jLabel16.setText("Propietario");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        btn_MenuP.setText("Menú Principal");
        jPanel2.add(btn_MenuP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        botonSwing1.setText("Pacientes");
        jPanel2.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Calendario.setText("Calendario");
        jPanel2.add(btn_Calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        btn_Reportes.setText("Reportes");
        jPanel2.add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 60));

        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 250, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 740));

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

    private void btn_iniciarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarsActionPerformed
        
    }//GEN-LAST:event_btn_iniciarsActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void botonSwing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSwing2ActionPerformed

    private void btn_iniciars1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars1ActionPerformed

    private void btn_iniciars2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars2ActionPerformed

    private void btn_iniciars4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciars4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciars4ActionPerformed

    private void btn_verarchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verarchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_verarchivoActionPerformed

    private void btn_eliminararchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminararchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminararchivoActionPerformed

    private void btn_verarchivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verarchivo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_verarchivo1ActionPerformed

    private void btn_verarchivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verarchivo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_verarchivo2ActionPerformed

    private void btn_verarchivo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verarchivo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_verarchivo3ActionPerformed

    private void btn_eliminararchivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminararchivo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminararchivo1ActionPerformed

    private void btn_eliminararchivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminararchivo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminararchivo2ActionPerformed

    private void btn_eliminararchivo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminararchivo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminararchivo3ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new MenuPropietario_Archivos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing botonSwing1;
    private provet.componentes.botonSwing botonSwing2;
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_MenuP;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private javax.swing.JButton btn_descargararchivo;
    private javax.swing.JButton btn_descargararchivo1;
    private javax.swing.JButton btn_descargararchivo2;
    private javax.swing.JButton btn_descargararchivo3;
    private javax.swing.JButton btn_eliminararchivo;
    private javax.swing.JButton btn_eliminararchivo1;
    private javax.swing.JButton btn_eliminararchivo2;
    private javax.swing.JButton btn_eliminararchivo3;
    private provet.componentes.boton_redondo btn_iniciars;
    private provet.componentes.boton_redondo btn_iniciars1;
    private provet.componentes.boton_redondo btn_iniciars2;
    private provet.componentes.boton_redondo btn_iniciars4;
    private javax.swing.JButton btn_verarchivo;
    private javax.swing.JButton btn_verarchivo1;
    private javax.swing.JButton btn_verarchivo2;
    private javax.swing.JButton btn_verarchivo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_acceder;
    private javax.swing.JLabel lbl_acceder1;
    private javax.swing.JLabel lbl_acceder2;
    private javax.swing.JLabel lbl_acceder4;
    private javax.swing.JLabel lbl_archivo1;
    private javax.swing.JLabel lbl_archivo1fecha;
    private javax.swing.JLabel lbl_archivo2;
    private javax.swing.JLabel lbl_archivo2fecha2;
    private javax.swing.JLabel lbl_archivo3fecha3;
    private javax.swing.JLabel lbl_archivo4;
    private javax.swing.JLabel lbl_archivo4fecha4;
    private javax.swing.JLabel lbl_arcivo3;
    private javax.swing.JLabel lbl_estatusarchivo1;
    private javax.swing.JLabel lbl_estatusarchivo2;
    private javax.swing.JLabel lbl_estatusarchivo3;
    private javax.swing.JLabel lbl_estatusarchivo4;
    private javax.swing.JLabel lbl_imaarchivo;
    private javax.swing.JLabel lbl_imaarchivo2;
    private javax.swing.JLabel lbl_imaarchivo3;
    private javax.swing.JLabel lbl_imaarchivo4;
    private provet.componentes.PanelRedondeado panel_citas_pendientes;
    private provet.componentes.PanelRedondeado panel_citas_pendientes1;
    private provet.componentes.PanelRedondeado panel_citas_pendientes2;
    private provet.componentes.PanelRedondeado panel_citas_pendientes3;
    private javax.swing.JLabel usuario;
    private javax.swing.JLabel usuario1;
    private javax.swing.JLabel usuario2;
    private javax.swing.JLabel usuario4;
    // End of variables declaration//GEN-END:variables
}
