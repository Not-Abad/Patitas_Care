package provet.view.administrador;
import java.awt.Component;
public class UsuariosAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UsuariosAdmin.class.getName());
// Colores
private final java.awt.Color C_FONDO = new java.awt.Color(228,230,217);
private final java.awt.Color C_CARD = new java.awt.Color(167,184,156);
private final java.awt.Color C_OSCURO = new java.awt.Color(84,104,94);

private javax.swing.JPanel panelLista;
public static java.util.List<Usuario> listaUsuarios = new java.util.ArrayList<>();
private javax.swing.JTextField txtBuscar;
private String filtroActual = "Todos";
private javax.swing.JLabel lblTotal;
 
class Usuario {
    String nombre;
    String rol;
    String id;

    Usuario(String n, String r, String i) {
        nombre = n;
        rol = r;
        id = i;
    }

    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
    public String getId() { return id; }

    public void setNombre(String n) { nombre = n; }
    public void setRol(String r) { rol = r; }
}

public UsuariosAdmin() {
    initComponents();
    construirUI();

    // Usuario de ejemplo
    if (listaUsuarios.isEmpty()) {
    listaUsuarios.add(new Usuario("Admin Principal", "Administrador", "001"));
}

    cargarUsuarios();
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
        btn_reportesU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/REPORTES2.png"))); // NOI18N
        btn_reportesU.setText("Reportes");
        btn_reportesU.setPreferredSize(new java.awt.Dimension(97, 29));
        btn_reportesU.addActionListener(this::btn_reportesUActionPerformed);

        btn_notificacionesU.setBackground(new java.awt.Color(228, 230, 217));
        btn_notificacionesU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_notificacionesU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/NOTIFICACION2.png"))); // NOI18N
        btn_notificacionesU.setText("Notificaciones");
        btn_notificacionesU.addActionListener(this::btn_notificacionesUActionPerformed);

        btn_salidaU.setBackground(new java.awt.Color(228, 230, 217));
        btn_salidaU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_salidaU.setText("Salida");

        lbl_usuariosU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_usuariosU.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuariosU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/USUARIO2.png"))); // NOI18N
        lbl_usuariosU.setText("Usuarios");

        btn_menuU.setBackground(new java.awt.Color(228, 230, 217));
        btn_menuU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_menuU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesAdministrativo/CASA.png"))); // NOI18N
        btn_menuU.setText("Menu Principal");
        btn_menuU.addActionListener(this::btn_menuUActionPerformed);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_reportesU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_notificacionesU, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btn_salidaU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_menuU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
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
                        .addGap(85, 85, 85)))
                .addComponent(btn_menuU, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbl_usuariosU, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_reportesU, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btn_notificacionesU, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
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
    new ReportesAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_reportesUActionPerformed

    private void btn_menuUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuUActionPerformed
    new MenuAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_menuUActionPerformed

    private void btn_notificacionesUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notificacionesUActionPerformed
    new NotificacionesAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_notificacionesUActionPerformed

    private void construirUI() {

    jPanel2.setLayout(new java.awt.BorderLayout());

    javax.swing.JPanel barraTop = new javax.swing.JPanel();
    barraTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 15));
    barraTop.setBackground(new java.awt.Color(228,230,217));
    barraTop.setPreferredSize(new java.awt.Dimension(1150, 60));
    lblTotal = new javax.swing.JLabel("Total usuarios: 0");
    lblTotal.setFont(new java.awt.Font("Tahoma", 0, 14));

    javax.swing.JButton btnNuevo = new javax.swing.JButton("+ Nuevo usuario");
    btnNuevo.setBackground(new java.awt.Color(108,135,118));
    btnNuevo.setForeground(java.awt.Color.WHITE); // letras blancas
    btnNuevo.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14)); 
    btnNuevo.setOpaque(true);
    btnNuevo.setBorderPainted(true);
    btnNuevo.setFocusPainted(true);
    btnNuevo.setPreferredSize(new java.awt.Dimension(180, 35));
    btnNuevo.addActionListener(e -> abrirFormularioNuevo());

    barraTop.add(lblTotal);
    barraTop.add(btnNuevo);
    
    panelLista = new javax.swing.JPanel();
    panelLista.setLayout(new javax.swing.BoxLayout(panelLista, javax.swing.BoxLayout.Y_AXIS));
    panelLista.setBackground(new java.awt.Color(228,230,217));

    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(panelLista);
    scroll.setBorder(null);

    jPanel2.add(barraTop, java.awt.BorderLayout.NORTH);
    jPanel2.add(scroll, java.awt.BorderLayout.CENTER);
}
    
 private void cargarUsuarios() {
    panelLista.removeAll();
    int totalUsuarios = listaUsuarios.size(); 
    for (Usuario u : listaUsuarios) {
        panelLista.add(crearCard(u));
        panelLista.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0,10)));
    }
    lblTotal.setText("Total usuarios: " + totalUsuarios);
    panelLista.revalidate();
    panelLista.repaint();
}
    
    private javax.swing.JPanel crearCard(Usuario u) {

    javax.swing.JPanel card = new javax.swing.JPanel();
    card.setLayout(new java.awt.BorderLayout());
    card.setBackground(new java.awt.Color(192,207,178));
    card.setBorder(javax.swing.BorderFactory.createEmptyBorder(20,20,20,20));
    card.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 120));

    javax.swing.JPanel panelIzq = new javax.swing.JPanel();
    panelIzq.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
    panelIzq.setOpaque(false);

    javax.swing.JButton ver = new javax.swing.JButton("Ver datos");
    javax.swing.JButton editar = new javax.swing.JButton("Editar");

    panelIzq.add(ver);
    panelIzq.add(editar);

    javax.swing.JPanel panelCentro = new javax.swing.JPanel();
    panelCentro.setLayout(new javax.swing.BoxLayout(panelCentro, javax.swing.BoxLayout.Y_AXIS));
    panelCentro.setOpaque(false);

    javax.swing.JLabel nombre = new javax.swing.JLabel(u.getNombre());
    nombre.setFont(new java.awt.Font("Tahoma", 1, 18));
    nombre.setAlignmentX(Component.CENTER_ALIGNMENT);

    javax.swing.JLabel id = new javax.swing.JLabel("ID: " + u.getId());
    id.setAlignmentX(Component.CENTER_ALIGNMENT);


    javax.swing.JLabel rol = new javax.swing.JLabel(u.getRol());
    rol.setOpaque(true);
    rol.setBackground(new java.awt.Color(90,110,90));
    rol.setForeground(java.awt.Color.WHITE);
    rol.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,10,5,10));
    rol.setAlignmentX(Component.CENTER_ALIGNMENT);

    panelCentro.add(nombre);
    panelCentro.add(id);
    panelCentro.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0,5)));
    panelCentro.add(rol);


    card.add(panelIzq, java.awt.BorderLayout.WEST);
    card.add(panelCentro, java.awt.BorderLayout.CENTER);

    // 🔹 EVENTOS
    ver.addActionListener(e -> {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Nombre: " + u.getNombre() +
            "\nID: " + u.getId() +
            "\nRol: " + u.getRol(),
            "Datos del usuario",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
    });

    editar.addActionListener(e -> {
        FormUsuario1 form = new FormUsuario1(this, u);
        form.setVisible(true);

        if (form.isGuardado()) {
            u.setNombre(form.getNombre());
            u.setRol(form.getRol());
            cargarUsuarios();
        }
    });

    return card;
}
        
    private void filtrar(String rol) {
    panelLista.removeAll();

    for (Usuario u : listaUsuarios) {
        if (rol.equals("Todos") || u.getRol().equals(rol)) {
            panelLista.add(crearCard(u));
            panelLista.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0,10)));
        }
    }

    panelLista.revalidate();
    panelLista.repaint();
}
    
    private void abrirFormularioNuevo() {
    FormUsuario1 form = new FormUsuario1(this);
    form.setVisible(true);

    if (form.isGuardado()) {
        agregarUsuario(form.getNombre(), form.getRol(), form.getId());
    }
}
    
    private void agregarUsuario(String nombre, String rol, String id) {
    // Validar ID duplicado
    for (Usuario u : listaUsuarios) {
        if (u.getId().equals(id)) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID ya existe");
            return;
        }
    }
    
    listaUsuarios.add(new Usuario(nombre, rol, id));
    cargarUsuarios();
    NotificacionesAdmin.agregarNotificacionGlobal(
        "Nuevo usuario",
        "Se creó el usuario: " + nombre,
        "hoy"
    );

cargarUsuarios();
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
