package provet.view.administrador;

public class UsuariosAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UsuariosAdmin.class.getName());
// Colores
private final java.awt.Color C_FONDO = new java.awt.Color(228,230,217);
private final java.awt.Color C_CARD = new java.awt.Color(167,184,156);
private final java.awt.Color C_OSCURO = new java.awt.Color(84,104,94);

// Modelo en memoria
private java.util.List<Usuario> listaUsuarios = new java.util.ArrayList<>();
private javax.swing.JPanel panelLista;
private javax.swing.JTextField txtBuscar;
private String filtroActual = "Todos";

// Clase interna (evita errores)
class Usuario {
    String nombre;
    String rol;
    String id;

    Usuario(String n, String r, String i){
        nombre = n;
        rol = r;
        id = i;
    }
}
    public UsuariosAdmin() {
        initComponents();
        construirUI();
    cargarEjemplo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_patitas_menu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_admin_menu = new javax.swing.JLabel();
        lbl_administrador_menu = new javax.swing.JLabel();
        btn_reportesU = new javax.swing.JButton();
        btn_notificacionesU = new javax.swing.JButton();
        btn_salidaU = new javax.swing.JButton();
        lbl_usuariosU = new javax.swing.JLabel();
        btn_menuU = new javax.swing.JButton();
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

        btn_reportesU.setBackground(new java.awt.Color(228, 230, 217));
        btn_reportesU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_reportesU.setText("Reportes");
        btn_reportesU.setPreferredSize(new java.awt.Dimension(97, 29));
        btn_reportesU.addActionListener(this::btn_reportesUActionPerformed);

        btn_notificacionesU.setBackground(new java.awt.Color(228, 230, 217));
        btn_notificacionesU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_notificacionesU.setText("Notificaciones");

        btn_salidaU.setBackground(new java.awt.Color(228, 230, 217));
        btn_salidaU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_salidaU.setText("Salida");

        lbl_usuariosU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_usuariosU.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuariosU.setText("Usuarios");

        btn_menuU.setBackground(new java.awt.Color(228, 230, 217));
        btn_menuU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_menuU.setText("Menu Principal");

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
                    .addComponent(btn_reportesU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_notificacionesU, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btn_salidaU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_menuU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(lbl_usuariosU)
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
                        .addGap(95, 95, 95)))
                .addComponent(btn_menuU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lbl_usuariosU)
                .addGap(40, 40, 40)
                .addComponent(btn_reportesU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_notificacionesU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(btn_salidaU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btn_reportesUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_reportesUActionPerformed

    private void construirUI() {
    jPanel2.setLayout(null);
    jPanel2.setBackground(C_FONDO);

    // TÍTULO
    javax.swing.JLabel titulo = new javax.swing.JLabel("Usuarios");
    titulo.setBounds(30, 20, 200, 30);
    titulo.setFont(new java.awt.Font("Tahoma", 1, 20));
    jPanel2.add(titulo);

    // BUSCADOR
    txtBuscar = new javax.swing.JTextField();
    txtBuscar.setBounds(30, 60, 200, 30);
    jPanel2.add(txtBuscar);

    txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent e) {
            refrescarLista();
        }
    });

    // BOTONES FILTRO
    String[] roles = {"Todos","Administrador","Veterinario","Secretario","Propietario"};
    int x = 250;

    for(String rol : roles){
        javax.swing.JButton btn = new javax.swing.JButton(rol);
        btn.setBounds(x, 60, 130, 30);
        jPanel2.add(btn);

        btn.addActionListener(e -> {
            filtroActual = rol;
            refrescarLista();
        });

        x += 140;
    }

    // BOTÓN NUEVO
    javax.swing.JButton btnNuevo = new javax.swing.JButton("+ Nuevo usuario");
    btnNuevo.setBounds(900, 20, 200, 30);
    btnNuevo.setBackground(C_OSCURO);
    btnNuevo.setForeground(java.awt.Color.WHITE);
    jPanel2.add(btnNuevo);

    btnNuevo.addActionListener(e -> agregarUsuario());

    // PANEL LISTA
    panelLista = new javax.swing.JPanel();
    panelLista.setLayout(new javax.swing.BoxLayout(panelLista, javax.swing.BoxLayout.Y_AXIS));
    panelLista.setBackground(C_FONDO);

    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(panelLista);
    scroll.setBounds(30, 120, 1080, 580);
    scroll.setBorder(null);

    jPanel2.add(scroll);
}
    private void cargarEjemplo() {
    listaUsuarios.add(new Usuario("Admin Principal","Administrador","001"));
    refrescarLista();
}
    private void agregarUsuario() {
    String nombre = "Usuario " + (listaUsuarios.size()+1);
    String[] roles = {"Administrador","Veterinario","Secretario","Propietario"};
    String rol = roles[(int)(Math.random()*roles.length)];

    listaUsuarios.add(new Usuario(nombre, rol, "00" + listaUsuarios.size()));
    refrescarLista();
}
    private void refrescarLista() {
    panelLista.removeAll();

    String busqueda = txtBuscar.getText().toLowerCase();

    for(Usuario u : listaUsuarios){

        boolean coincideBusqueda = u.nombre.toLowerCase().contains(busqueda);
        boolean coincideFiltro = filtroActual.equals("Todos") || u.rol.equals(filtroActual);

       if(coincideBusqueda && coincideFiltro){
    panelLista.add(crearCard(u));
    panelLista.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0,10)));
}
    }

    panelLista.revalidate();
    panelLista.repaint();
}
    private javax.swing.JPanel crearCard(Usuario u){
    javax.swing.JPanel card = new javax.swing.JPanel();
    card.setLayout(null);
    card.setBackground(C_CARD);

    // Iniciales
    javax.swing.JLabel inicial = new javax.swing.JLabel(u.nombre.substring(0,1));
    inicial.setBounds(10,10,40,40);
    inicial.setOpaque(true);
    inicial.setBackground(C_OSCURO);
    inicial.setForeground(java.awt.Color.WHITE);
    inicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    card.setMaximumSize(new java.awt.Dimension(1000, 130));
    card.setPreferredSize(new java.awt.Dimension(1000, 130));

    // Nombre
    javax.swing.JLabel nombre = new javax.swing.JLabel(u.nombre);
    nombre.setBounds(60,10,200,20);

    // ID
    javax.swing.JLabel id = new javax.swing.JLabel("ID: " + u.id);
    id.setBounds(60,30,200,20);

    // Rol
    javax.swing.JLabel rol = new javax.swing.JLabel(u.rol);
    rol.setBounds(10,60,150,20);
    rol.setOpaque(true);
    rol.setBackground(C_OSCURO);
    rol.setForeground(java.awt.Color.WHITE);

    // Botones
    javax.swing.JButton ver = new javax.swing.JButton("Ver datos");
    ver.setBounds(10,90,120,25);

    javax.swing.JButton editar = new javax.swing.JButton("Editar");
    editar.setBounds(140,90,120,25);
    editar.setBackground(C_OSCURO);
    editar.setForeground(java.awt.Color.WHITE);

    card.add(inicial);
    card.add(nombre);
    card.add(id);
    card.add(rol);
    card.add(ver);
    card.add(editar);

    return card;
}
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new UsuariosAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_menuU;
    private javax.swing.JButton btn_notificacionesU;
    private javax.swing.JButton btn_reportesU;
    private javax.swing.JButton btn_salidaU;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_admin_menu;
    private javax.swing.JLabel lbl_administrador_menu;
    private javax.swing.JLabel lbl_patitas_menu;
    private javax.swing.JLabel lbl_usuariosU;
    // End of variables declaration//GEN-END:variables
}
