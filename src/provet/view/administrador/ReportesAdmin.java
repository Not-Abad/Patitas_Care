package provet.view.administrador;

import javax.swing.JOptionPane;
import provet.view.inicio.Login;
import provet.componentes.botonSwing;

public class ReportesAdmin extends javax.swing.JFrame {
   
private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportesAdmin.class.getName());
public static java.util.List<Reporte> listaReportes = new java.util.ArrayList<>();

private final java.awt.Color C_FONDO = new java.awt.Color(228,230,217);
private final java.awt.Color C_CARD = new java.awt.Color(167, 184, 156);
private final java.awt.Color C_OSCURO = new java.awt.Color(84, 104, 94);
private final java.awt.Color C_TEXTO = new java.awt.Color(60,60,60);

class Reporte {
    String titulo;
    String descripcion;
    public Reporte(String t, String d) {
        titulo = t;
        descripcion = d;
 
    }
}

private int citas = 0;
private int nuevosPacientes = 0;
private int usuariosActivos = 0;

private javax.swing.JLabel lblCitas, lblPacientes, lblUsuarios;
private javax.swing.JPanel panelHistorial;

    public ReportesAdmin() {
    initComponents();
    construirUI();
    if (listaReportes.isEmpty()) {
    listaReportes.add(new Reporte("Ejemplo", "Demo"));
    }
    renderizarHistorial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelRedondeado2 = new provet.componentes.PanelRedondeado();
        jLabel8 = new javax.swing.JLabel();
        botonSwing4 = new botonSwing();
        botonSwing1 = new botonSwing();
        btn_Calendario = new botonSwing();
        btn_Reportes = new botonSwing();
        btn_Salir = new botonSwing();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(108, 135, 118));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel15.setBackground(new java.awt.Color(51, 255, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 53, 38));
        jLabel15.setText("PatitasCare");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel16.setBackground(new java.awt.Color(51, 255, 51));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(39, 53, 38));
        jLabel16.setText("Administrador");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/usuario.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout panelRedondeado2Layout = new javax.swing.GroupLayout(panelRedondeado2);
        panelRedondeado2.setLayout(panelRedondeado2Layout);
        panelRedondeado2Layout.setHorizontalGroup(
            panelRedondeado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondeado2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRedondeado2Layout.setVerticalGroup(
            panelRedondeado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondeado2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(panelRedondeado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 80));

        botonSwing4.setText("Menú Principal");
        botonSwing4.addActionListener(this::botonSwing4ActionPerformed);
        jPanel1.add(botonSwing4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        botonSwing1.setForeground(new java.awt.Color(39, 53, 38));
        botonSwing1.setText("Usuarios");
        botonSwing1.addActionListener(this::botonSwing1ActionPerformed);
        jPanel1.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Calendario.setForeground(new java.awt.Color(39, 53, 38));
        btn_Calendario.setText("Notificaciones");
        btn_Calendario.addActionListener(this::btn_CalendarioActionPerformed);
        jPanel1.add(btn_Calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        btn_Reportes.setText("Reportes");
        jPanel1.add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 60));

        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(this::btn_SalirActionPerformed);
        jPanel1.add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 250, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 740));

        jPanel2.setBackground(new java.awt.Color(228, 230, 217));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1210, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSwing4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing4ActionPerformed
     new MenuAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_botonSwing4ActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
    new UsuariosAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_botonSwing1ActionPerformed

    private void btn_CalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CalendarioActionPerformed
    new NotificacionesAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_CalendarioActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        int op = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas salir?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION
        );
        
        if (op == JOptionPane.YES_OPTION) {
            new Login().setVisible(true); 
            this.dispose(); 
        }
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void construirUI() {
    jPanel2.setLayout(null);
    jPanel2.setBackground(C_FONDO);

    javax.swing.JLabel titulo = new javax.swing.JLabel("Reportes administrativos");
    titulo.setBounds(30, 20, 400, 30);
    titulo.setFont(new java.awt.Font("Tahoma", 1, 20));
    jPanel2.add(titulo);

    javax.swing.JLabel subtitulo = new javax.swing.JLabel("Actualizado en ejecución");
    subtitulo.setBounds(30, 50, 300, 20);
    subtitulo.setForeground(C_TEXTO);
    jPanel2.add(subtitulo);

    botonSwing btnGenerar = new botonSwing();
    btnGenerar.setText("+ Generar reporte");
    btnGenerar.setBounds(900, 20, 200, 30);
    btnGenerar.setBackground(C_OSCURO);
    btnGenerar.setForeground(java.awt.Color.BLACK);
    jPanel2.add(btnGenerar);

    btnGenerar.addActionListener(e -> generarDatos());

    lblCitas = crearCard("Citas totales", 50);
    lblPacientes = crearCard("Nuevos pacientes", 300);
    lblUsuarios = crearCard("Usuarios activos", 550);

    panelHistorial = new provet.componentes.PanelRedondeado();
    panelHistorial.setLayout(new javax.swing.BoxLayout(panelHistorial, javax.swing.BoxLayout.Y_AXIS));

    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(panelHistorial);
    scroll.setBounds(50, 200, 1000, 400);

    jPanel2.add(scroll);
}
    private javax.swing.JLabel crearCard(String titulo, int x) {
    provet.componentes.PanelRedondeado card = new provet.componentes.PanelRedondeado();
    card.setLayout(null);
    card.setBackground(C_CARD);
    card.setBounds(x, 90, 200, 80);

    javax.swing.JLabel lblTitulo = new javax.swing.JLabel(titulo);
    lblTitulo.setBounds(10, 10, 180, 20);

    javax.swing.JLabel lblValor = new javax.swing.JLabel("0");
    lblValor.setBounds(10, 35, 180, 30);
    lblValor.setFont(new java.awt.Font("Tahoma", 1, 20));

    card.add(lblTitulo);
    card.add(lblValor);

    jPanel2.add(card);
    card.setVisible(true);;
    return lblValor;
}
    
    private void generarDatos() {
    citas += (int)(Math.random() * 10);
    nuevosPacientes += (int)(Math.random() * 5);
    usuariosActivos += (int)(Math.random() * 3);

    lblCitas.setText(String.valueOf(citas));
    lblPacientes.setText(String.valueOf(nuevosPacientes));
    lblUsuarios.setText(String.valueOf(usuariosActivos));

    listaReportes.add(new Reporte("Reporte generado", "Datos actualizados"));
    
    renderizarHistorial();

    NotificacionesAdmin.agregarNotificacionGlobal(
        "Nuevo reporte",
        "Se generó un reporte",
        "hoy"
    );
}
    
    private void renderizarHistorial() {
    panelHistorial.removeAll();

    // Agregar encabezado
    provet.componentes.PanelRedondeado encabezado = new provet.componentes.PanelRedondeado();
    encabezado.setLayout(new java.awt.GridLayout(1, 3));
    encabezado.setMaximumSize(new java.awt.Dimension(1000, 40));
    encabezado.setBackground(C_OSCURO);
    
    javax.swing.JLabel lblEnc1 = new javax.swing.JLabel("Título");
    lblEnc1.setForeground(java.awt.Color.WHITE);
    lblEnc1.setFont(new java.awt.Font("Tahoma", 1, 14));
    lblEnc1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
    
    javax.swing.JLabel lblEnc2 = new javax.swing.JLabel("Fecha");
    lblEnc2.setForeground(java.awt.Color.WHITE);
    lblEnc2.setFont(new java.awt.Font("Tahoma", 1, 14));
    lblEnc2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
    
    javax.swing.JLabel lblEnc3 = new javax.swing.JLabel("Descripción");
    lblEnc3.setForeground(java.awt.Color.WHITE);
    lblEnc3.setFont(new java.awt.Font("Tahoma", 1, 14));
    lblEnc3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
    
    encabezado.add(lblEnc1);
    encabezado.add(lblEnc2);
    encabezado.add(lblEnc3);
    panelHistorial.add(encabezado);
    panelHistorial.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));

    int index = 0;
    for (Reporte r : listaReportes) {

        provet.componentes.PanelRedondeado fila = new provet.componentes.PanelRedondeado();
        fila.setLayout(new java.awt.GridLayout(1, 3));
        fila.setMaximumSize(new java.awt.Dimension(1000, 50));
        
        // Color alternado
        if (index % 2 == 0) {
            fila.setBackground(new java.awt.Color(228, 230, 217));
        } else {
            fila.setBackground(new java.awt.Color(192, 207, 178));
        }

        javax.swing.JLabel lblTitulo = new javax.swing.JLabel(r.titulo);
        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        java.time.LocalDate fecha = java.time.LocalDate.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        javax.swing.JLabel lblFecha = new javax.swing.JLabel(fecha.format(formatter));
        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblFecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        javax.swing.JLabel lblDesc = new javax.swing.JLabel(r.descripcion);
        lblDesc.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblDesc.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        fila.add(lblTitulo);
        fila.add(lblFecha);
        fila.add(lblDesc);

        panelHistorial.add(fila);
        panelHistorial.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 8)));
        index++;
    }

    panelHistorial.revalidate();
    panelHistorial.repaint();
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
        java.awt.EventQueue.invokeLater(() -> new ReportesAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private botonSwing botonSwing1;
    private botonSwing botonSwing4;
    private botonSwing btn_Calendario;
    private botonSwing btn_Reportes;
    private botonSwing btn_Salir;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private provet.componentes.PanelRedondeado panelRedondeado2;
    // End of variables declaration//GEN-END:variables
}
