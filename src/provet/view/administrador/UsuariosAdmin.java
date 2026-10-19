package provet.view.administrador;
import java.awt.Component;
import javax.swing.JOptionPane;
import provet.view.inicio.Login;
import provet.componentes.botonSwing;
import provet.componentes.PanelRedondeado;
import provet.dao.UsuarioAdminDAO;
import javax.swing.*;
import java.awt.*;
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
    String apellido = "";
    String correo = "";
    String telefono = "";
    String especialidad = "";
    String cedula = "";
    String estado = "Activo";
    String usuario = "";
    String sueldoBase = "";
    String fechaContratacion = "";

    Usuario(String n, String r, String i) {
        nombre = n;
        rol = r;
        id = i;
    }

    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
    public String getId() { return id; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getEspecialidad() { return especialidad; }
    public String getCedula() { return cedula; }
    public String getEstado() { return estado; }
    public String getUsuario() { return usuario; }
    public String getSueldoBase() { return sueldoBase; }
    public String getFechaContratacion() { return fechaContratacion; }

    public void setNombre(String n) { nombre = n; }
    public void setRol(String r) { rol = r; }
    public void setApellido(String a) { apellido = a; }
    public void setCorreo(String c) { correo = c; }
    public void setTelefono(String t) { telefono = t; }
    public void setEspecialidad(String e) { especialidad = e; }
    public void setCedula(String c) { cedula = c; }
    public void setEstado(String e) { estado = e; }
    public void setUsuario(String u) { usuario = u; }
    public void setSueldoBase(String s) { sueldoBase = s; }
    public void setFechaContratacion(String f) { fechaContratacion = f; }
}

public UsuariosAdmin() {
    initComponents();
    construirUI();

    cargarUsuariosDesdeBD();
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
        jPanel1.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Calendario.setForeground(new java.awt.Color(39, 53, 38));
        btn_Calendario.setText("Notificaciones");
        btn_Calendario.addActionListener(this::btn_CalendarioActionPerformed);
        jPanel1.add(btn_Calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        btn_Reportes.setText("Reportes");
        btn_Reportes.addActionListener(this::btn_ReportesActionPerformed);
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

    private void btn_CalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CalendarioActionPerformed
    new NotificacionesAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_CalendarioActionPerformed

    private void btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportesActionPerformed
    new ReportesAdmin().setVisible(true); 
    this.setVisible(false);
    }//GEN-LAST:event_btn_ReportesActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        mostrarDialogoConfirmacion(
            "¿Estás seguro de que deseas salir?",
            "Confirmar salida",
            () -> {
                new Login().setVisible(true);
                this.dispose();
            }
        );
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void mostrarDialogoConfirmacion(String mensaje, String titulo, Runnable accionConfirmar) {
        JDialog dialog = new JDialog(this, titulo, true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(450, 220);
        dialog.setLocationRelativeTo(this);
        dialog.setUndecorated(true);

        PanelRedondeado panel = new PanelRedondeado();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new java.awt.Color(192, 207, 178));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel lblMensaje = new JLabel(mensaje, SwingConstants.CENTER);
        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblMensaje.setForeground(new java.awt.Color(39, 53, 38));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelBotones.setOpaque(false);

        botonSwing btnSi = new botonSwing();
        btnSi.setText("Sí");
        btnSi.setForeground(new java.awt.Color(39, 53, 38));
        btnSi.setPreferredSize(new Dimension(120, 45));
        btnSi.addActionListener(e -> {
            accionConfirmar.run();
            dialog.dispose();
        });

        botonSwing btnNo = new botonSwing();
        btnNo.setText("No");
        btnNo.setForeground(new java.awt.Color(39, 53, 38));
        btnNo.setPreferredSize(new Dimension(120, 45));
        btnNo.addActionListener(e -> dialog.dispose());

        panelBotones.add(btnSi);
        panelBotones.add(btnNo);

        panel.add(lblMensaje, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void construirUI() {

    jPanel2.setLayout(new java.awt.BorderLayout());

    javax.swing.JPanel barraTop = new javax.swing.JPanel();
    barraTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 15));
    barraTop.setBackground(new java.awt.Color(228,230,217));
    barraTop.setPreferredSize(new java.awt.Dimension(1150, 60));
    lblTotal = new javax.swing.JLabel("Total usuarios: 0");
    lblTotal.setFont(new java.awt.Font("Tahoma", 0, 14));

    botonSwing btnNuevo = new botonSwing();
    btnNuevo.setText("+ Nuevo usuario");
    btnNuevo.setBackground(new java.awt.Color(108,135,118));
    btnNuevo.setForeground(java.awt.Color.BLACK);
    btnNuevo.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14)); 
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
    
 private void cargarUsuariosDesdeBD() {
    panelLista.removeAll();
    
    UsuarioAdminDAO dao = new UsuarioAdminDAO();
    java.util.List<UsuarioAdminDAO.UsuarioAdmin> usuariosBD = dao.selectAll();
    
    // Convertir usuarios de BD a formato local
    listaUsuarios.clear();
    for (UsuarioAdminDAO.UsuarioAdmin uBD : usuariosBD) {
        Usuario u = new Usuario(uBD.getNombre() + " " + uBD.getApellido(), uBD.getRol(), String.valueOf(uBD.getId()));
        u.setApellido(uBD.getApellido());
        u.setCorreo(uBD.getCorreo());
        u.setTelefono(uBD.getTelefono());
        u.setEstado(uBD.getEstado());
        u.setUsuario(uBD.getUsuario());
        u.setSueldoBase(String.valueOf(uBD.getSueldoBase()));
        u.setFechaContratacion(uBD.getFechaContratacion() != null ? uBD.getFechaContratacion().toString() : "");
        listaUsuarios.add(u);
    }
    
    int totalUsuarios = listaUsuarios.size(); 
    for (Usuario u : listaUsuarios) {
        panelLista.add(crearCard(u));
        panelLista.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0,10)));
    }
    lblTotal.setText("Total usuarios: " + totalUsuarios);
    panelLista.revalidate();
    panelLista.repaint();
}
    
    private provet.componentes.PanelRedondeado crearCard(Usuario u) {

    provet.componentes.PanelRedondeado card = new provet.componentes.PanelRedondeado();
    card.setLayout(new java.awt.BorderLayout());
    card.setBackground(new java.awt.Color(192,207,178));
    card.setBorder(javax.swing.BorderFactory.createEmptyBorder(20,20,20,20));
    card.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 120));

    javax.swing.JPanel panelIzq = new javax.swing.JPanel();
    panelIzq.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
    panelIzq.setOpaque(false);

    botonSwing ver = new botonSwing();
    ver.setText("Ver datos");
    ver.setForeground(java.awt.Color.BLACK);
    botonSwing editar = new botonSwing();
    editar.setText("Editar");
    editar.setForeground(java.awt.Color.BLACK);

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
        UsuariosRegistro form = new UsuariosRegistro(this, "ver", u);
        form.setVisible(true);
    });

    editar.addActionListener(e -> {
        UsuariosRegistro form = new UsuariosRegistro(this, "editar", u);
        form.setVisible(true);

        if (form.isGuardado()) {
            if (form.isEliminado()) {
                // Eliminar usuario usando DAO
                UsuarioAdminDAO dao = new UsuarioAdminDAO();
                int resultado = dao.delete(Integer.parseInt(u.getId()));
                
                if (resultado > 0) {
                    cargarUsuariosDesdeBD();
                    NotificacionesAdmin.agregarNotificacionGlobal(
                        "Usuario eliminado",
                        "Se eliminó el usuario: " + u.getNombre(),
                        "hoy"
                    );
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar usuario en base de datos");
                }
            } else {
                // Actualizar usuario usando DAO
                UsuarioAdminDAO.UsuarioAdmin uBD = new UsuarioAdminDAO.UsuarioAdmin();
                uBD.setId(Integer.parseInt(u.getId()));
                uBD.setNombre(form.getNombre());
                uBD.setApellido(form.getApellido());
                uBD.setCorreo(form.getCorreo());
                uBD.setTelefono(form.getTelefono());
                uBD.setUsuario(form.getUsuario());
                uBD.setSueldoBase(Double.parseDouble(form.getSueldoBase().isEmpty() ? "0" : form.getSueldoBase()));
                uBD.setFechaContratacion(new java.util.Date()); // Fecha actual
                uBD.setRol(form.getRol());
                uBD.setPassword("123456"); // Password por defecto
                uBD.setFotoPerfil("");
                
                UsuarioAdminDAO dao = new UsuarioAdminDAO();
                int resultado = dao.update(uBD);
                
                if (resultado > 0) {
                    cargarUsuariosDesdeBD();
                    NotificacionesAdmin.agregarNotificacionGlobal(
                        "Usuario actualizado",
                        "Se actualizó el usuario: " + form.getNombre(),
                        "hoy"
                    );
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar usuario en base de datos");
                }
            }
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
    UsuariosRegistro form = new UsuariosRegistro(this, "nuevo", null);
    form.setVisible(true);

    if (form.isGuardado()) {
        // Crear objeto UsuarioAdminDAO para guardar en BD
        UsuarioAdminDAO.UsuarioAdmin uBD = new UsuarioAdminDAO.UsuarioAdmin();
        uBD.setNombre(form.getNombre());
        uBD.setApellido(form.getApellido());
        uBD.setCorreo(form.getCorreo());
        uBD.setTelefono(form.getTelefono());
        uBD.setUsuario(form.getUsuario());
        uBD.setSueldoBase(Double.parseDouble(form.getSueldoBase().isEmpty() ? "0" : form.getSueldoBase()));
        uBD.setFechaContratacion(new java.util.Date()); // Fecha actual
        uBD.setRol(form.getRol());
        uBD.setPassword("123456"); // Password por defecto
        uBD.setFotoPerfil("");
        
        UsuarioAdminDAO dao = new UsuarioAdminDAO();
        int resultado = dao.insert(uBD);
        
        if (resultado > 0) {
            cargarUsuariosDesdeBD();
            NotificacionesAdmin.agregarNotificacionGlobal(
                "Nuevo usuario",
                "Se creó el usuario: " + form.getNombre(),
                "hoy"
            );
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al crear usuario en base de datos");
        }
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
    cargarUsuariosDesdeBD();
    NotificacionesAdmin.agregarNotificacionGlobal(
        "Nuevo usuario",
        "Se creó el usuario: " + nombre,
        "hoy"
    );

cargarUsuariosDesdeBD();
    }
 
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new UsuariosAdmin().setVisible(true));
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
