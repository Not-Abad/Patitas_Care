package provet.view.administrador;

public class ReportesAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportesAdmin.class.getName());
// Colores del diseño
private final java.awt.Color C_FONDO = new java.awt.Color(228,230,217);
private final java.awt.Color C_CARD = new java.awt.Color(167, 184, 156);
private final java.awt.Color C_OSCURO = new java.awt.Color(84, 104, 94);
private final java.awt.Color C_TEXTO = new java.awt.Color(60,60,60);

// Datos en memoria (sin base de datos)
private int citas = 0;
private int nuevosPacientes = 0;
private int usuariosActivos = 0;

// Componentes dinámicos
private javax.swing.JLabel lblCitas, lblPacientes, lblUsuarios;
private javax.swing.JPanel panelHistorial;

    public ReportesAdmin() {
        initComponents();
        construirUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_patitas_menu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_admin_menu = new javax.swing.JLabel();
        lbl_administrador_menu = new javax.swing.JLabel();
        btn_menuR = new javax.swing.JButton();
        btn_notificacionesR = new javax.swing.JButton();
        btn_salidaR = new javax.swing.JButton();
        lbl_reportes = new javax.swing.JLabel();
        btn_usuariosR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(108, 135, 118));

        lbl_patitas_menu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_patitas_menu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_patitas_menu.setText("Patitas Care");
        lbl_patitas_menu.setAutoscrolls(true);

        jLabel6.setText("Foto");

        lbl_admin_menu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_admin_menu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_admin_menu.setText("Admin");

        lbl_administrador_menu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_administrador_menu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_administrador_menu.setText("Administrador");

        btn_menuR.setBackground(new java.awt.Color(228, 230, 217));
        btn_menuR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_menuR.setText("Menu Principal");

        btn_notificacionesR.setBackground(new java.awt.Color(228, 230, 217));
        btn_notificacionesR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_notificacionesR.setText("Notificaciones");

        btn_salidaR.setBackground(new java.awt.Color(228, 230, 217));
        btn_salidaR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_salidaR.setText("Salida");

        lbl_reportes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_reportes.setForeground(new java.awt.Color(255, 255, 255));
        lbl_reportes.setText("Reportes");

        btn_usuariosR.setBackground(new java.awt.Color(228, 230, 217));
        btn_usuariosR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_usuariosR.setText("Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbl_patitas_menu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel6)
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_admin_menu)
                            .addComponent(lbl_administrador_menu))))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_menuR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_notificacionesR, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btn_salidaR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_usuariosR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(lbl_reportes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbl_patitas_menu)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(lbl_admin_menu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_administrador_menu)
                        .addGap(102, 102, 102)))
                .addComponent(btn_menuR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_usuariosR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbl_reportes)
                .addGap(37, 37, 37)
                .addComponent(btn_notificacionesR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(btn_salidaR, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 740));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 0, 1150, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void construirUI() {
    jPanel2.setLayout(null);
    jPanel2.setBackground(C_FONDO);

    // TÍTULO
    javax.swing.JLabel titulo = new javax.swing.JLabel("Reportes administrativos");
    titulo.setBounds(30, 20, 400, 30);
    titulo.setFont(new java.awt.Font("Tahoma", 1, 20));
    jPanel2.add(titulo);

    javax.swing.JLabel subtitulo = new javax.swing.JLabel("Actualizado en ejecución");
    subtitulo.setBounds(30, 50, 300, 20);
    subtitulo.setForeground(C_TEXTO);
    jPanel2.add(subtitulo);

    // BOTÓN
    javax.swing.JButton btnGenerar = new javax.swing.JButton("+ Generar reporte");
    btnGenerar.setBounds(900, 20, 200, 30);
    btnGenerar.setBackground(C_OSCURO);
    btnGenerar.setForeground(java.awt.Color.WHITE);
    jPanel2.add(btnGenerar);

    btnGenerar.addActionListener(e -> generarDatos());

    // CARDS
    lblCitas = crearCard("Citas totales", 50);
    lblPacientes = crearCard("Nuevos pacientes", 300);
    lblUsuarios = crearCard("Usuarios activos", 550);

    // HISTORIAL
    panelHistorial = new javax.swing.JPanel();
    panelHistorial.setLayout(new javax.swing.BoxLayout(panelHistorial, javax.swing.BoxLayout.Y_AXIS));

    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(panelHistorial);
    scroll.setBounds(50, 200, 1000, 400);

    jPanel2.add(scroll);
}
    private javax.swing.JLabel crearCard(String titulo, int x) {
    javax.swing.JPanel card = new javax.swing.JPanel();
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

    return lblValor;
}
    private void generarDatos() {
    // Simulación dinámica
    citas += (int)(Math.random() * 10);
    nuevosPacientes += (int)(Math.random() * 5);
    usuariosActivos += (int)(Math.random() * 3);

    lblCitas.setText(String.valueOf(citas));
    lblPacientes.setText(String.valueOf(nuevosPacientes));
    lblUsuarios.setText(String.valueOf(usuariosActivos));

    agregarHistorial();
}
    private void agregarHistorial() {
    javax.swing.JPanel fila = new javax.swing.JPanel();
    fila.setLayout(new java.awt.GridLayout(1, 3));
    fila.setMaximumSize(new java.awt.Dimension(1000, 30));

    fila.add(new javax.swing.JLabel("Reporte generado"));
    fila.add(new javax.swing.JLabel(java.time.LocalDate.now().toString()));
    fila.add(new javax.swing.JLabel("Generado"));

    panelHistorial.add(fila);
    panelHistorial.revalidate();
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
    private javax.swing.JButton btn_menuR;
    private javax.swing.JButton btn_notificacionesR;
    private javax.swing.JButton btn_salidaR;
    private javax.swing.JButton btn_usuariosR;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_admin_menu;
    private javax.swing.JLabel lbl_administrador_menu;
    private javax.swing.JLabel lbl_patitas_menu;
    private javax.swing.JLabel lbl_reportes;
    // End of variables declaration//GEN-END:variables
}
