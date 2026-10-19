package provet.view.administrador;

import javax.swing.*;
import java.awt.*;
import provet.componentes.botonSwing;
import provet.componentes.PanelRedondeado;

public class UsuariosRegistro extends JDialog {

    private boolean guardado = false;
    private boolean eliminado = false;
    private UsuariosAdmin.Usuario usuario;
    private String modo;

    // CAMPOS
    private JTextField txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtCorreo, txtTelefono, txtUsuario, txtSueldoBase, txtFechaContratacion;
    private JComboBox<String> comboPuesto;

    public UsuariosRegistro(java.awt.Frame parent, String modo, UsuariosAdmin.Usuario u) {
        super(parent, true);
        this.modo = modo;
        this.usuario = u;

        setTitle("Usuario");
        setSize(650, 680);
        setLocationRelativeTo(parent);

        construirUI();

        if (u != null) {
            cargarDatos(u);
        }

        if (modo.equals("ver")) {
            bloquearCampos();
        }
    }

    private void construirUI() {

        JPanel fondo = new JPanel();
        fondo.setLayout(null);
        fondo.setBackground(new java.awt.Color(228,230,217));

        JLabel titulo = new JLabel(
            modo.equals("nuevo") ? "Nuevo usuario" :
            modo.equals("editar") ? "Editar usuario" : "Ver usuario",
            SwingConstants.CENTER
        );
        titulo.setBounds(25, 20, 600, 30);
        titulo.setFont(new java.awt.Font("Tahoma", 1, 20));
        titulo.setForeground(new java.awt.Color(39,53,38));
        fondo.add(titulo);

        PanelRedondeado card = new PanelRedondeado();
        card.setLayout(null);
        card.setBackground(new java.awt.Color(192,207,178));
        card.setBounds(50, 70, 550, 480);

        // DATOS PERSONALES
        card.add(label("DATOS PERSONALES", 25, 20, true));

        txtNombre = new JTextField();
        txtApellidoPaterno = new JTextField();
        txtApellidoMaterno = new JTextField();
        txtCorreo = new JTextField();
        txtTelefono = new JTextField();
        txtUsuario = new JTextField();
        txtSueldoBase = new JTextField();
        txtFechaContratacion = new JTextField();
        
        txtNombre.setBackground(new java.awt.Color(228,230,217));
        txtApellidoPaterno.setBackground(new java.awt.Color(228,230,217));
        txtApellidoMaterno.setBackground(new java.awt.Color(228,230,217));
        txtCorreo.setBackground(new java.awt.Color(228,230,217));
        txtTelefono.setBackground(new java.awt.Color(228,230,217));
        txtUsuario.setBackground(new java.awt.Color(228,230,217));
        txtSueldoBase.setBackground(new java.awt.Color(228,230,217));
        txtFechaContratacion.setBackground(new java.awt.Color(228,230,217));
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtApellidoPaterno.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtApellidoMaterno.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtCorreo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtSueldoBase.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtFechaContratacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));

        card.add(label("Nombre", 20, 50, false));
        txtNombre.setBounds(20, 70, 240, 30);
        card.add(txtNombre);

        card.add(label("Apellido Paterno", 280, 50, false));
        txtApellidoPaterno.setBounds(280, 70, 240, 30);
        card.add(txtApellidoPaterno);

        card.add(label("Apellido Materno", 20, 110, false));
        txtApellidoMaterno.setBounds(20, 130, 240, 30);
        card.add(txtApellidoMaterno);

        card.add(label("Correo", 280, 110, false));
        txtCorreo.setBounds(280, 130, 240, 30);
        card.add(txtCorreo);

        card.add(label("Teléfono", 150, 170, false));
        txtTelefono.setBounds(150, 190, 240, 30);
        card.add(txtTelefono);

        // DATOS DE EMPLEADO
        card.add(label("DATOS DE EMPLEADO", 25, 250, true));

        comboPuesto = new JComboBox<>(new String[]{"Sin Especificar", "Administrador", "Veterinario", "Recepcionista", "Cajero"});
        comboPuesto.setBackground(new java.awt.Color(228,230,217));

        card.add(label("Usuario (Login)", 20, 280, false));
        txtUsuario.setBounds(20, 300, 240, 30);
        card.add(txtUsuario);

        card.add(label("Puesto", 280, 280, false));
        comboPuesto.setBounds(280, 300, 240, 30);
        card.add(comboPuesto);

        card.add(label("Sueldo Base", 20, 340, false));
        txtSueldoBase.setBounds(20, 360, 240, 30);
        card.add(txtSueldoBase);

        card.add(label("Fecha Contratación", 280, 340, false));
        txtFechaContratacion.setBounds(280, 360, 240, 30);
        card.add(txtFechaContratacion);

        fondo.add(card);

        // BOTONES
        botonSwing btnEliminar = new botonSwing();
        btnEliminar.setText("Eliminar");
        btnEliminar.setForeground(new java.awt.Color(200, 50, 50));

        botonSwing btnCancelar = new botonSwing();
        btnCancelar.setText("Cancelar");
        btnCancelar.setForeground(new java.awt.Color(39,53,38));

        botonSwing btnGuardar = new botonSwing();
        btnGuardar.setText("Guardar");
        btnGuardar.setForeground(new java.awt.Color(39,53,38));

        // Ocultar/mostrar botones según el modo
        if (modo.equals("nuevo")) {
            // Solo cancelar y guardar
            btnEliminar.setVisible(false);
            btnCancelar.setBounds(180, 570, 120, 45);
            btnGuardar.setBounds(320, 570, 150, 45);
        } else if (modo.equals("ver")) {
            // Solo cancelar
            btnEliminar.setVisible(false);
            btnGuardar.setVisible(false);
            btnCancelar.setBounds(265, 570, 120, 45);
        } else if (modo.equals("editar")) {
            // Los tres botones
            btnEliminar.setBounds(110, 570, 130, 45);
            btnCancelar.setBounds(255, 570, 120, 45);
            btnGuardar.setBounds(390, 570, 150, 45);
        }

        fondo.add(btnEliminar);
        fondo.add(btnCancelar);
        fondo.add(btnGuardar);

        add(fondo);

        // EVENTOS
        btnCancelar.addActionListener(e -> dispose());

        btnGuardar.addActionListener(e -> confirmarGuardar());

        btnEliminar.addActionListener(e -> confirmarEliminar());
    }

    private JLabel label(String txt, int x, int y, boolean centro) {
        JLabel l = new JLabel(txt, centro ? SwingConstants.CENTER : SwingConstants.LEFT);
        l.setBounds(x, y, centro ? 500 : 200, 20);
        return l;
    }

    private void cargarDatos(UsuariosAdmin.Usuario u) {
        txtNombre.setText(u.getNombre());
        String[] apellidos = u.getApellido().split(" ", 2);
        txtApellidoPaterno.setText(apellidos.length > 0 ? apellidos[0] : "");
        txtApellidoMaterno.setText(apellidos.length > 1 ? apellidos[1] : "");
        txtCorreo.setText(u.getCorreo());
        txtTelefono.setText(u.getTelefono());
        txtUsuario.setText(u.getUsuario());
        txtSueldoBase.setText(u.getSueldoBase());
        txtFechaContratacion.setText(u.getFechaContratacion());
        comboPuesto.setSelectedItem(u.getRol());
    }

    private void bloquearCampos() {
        txtNombre.setEditable(false);
        txtApellidoPaterno.setEditable(false);
        txtApellidoMaterno.setEditable(false);
        txtCorreo.setEditable(false);
        txtTelefono.setEditable(false);
        txtUsuario.setEditable(false);
        txtSueldoBase.setEditable(false);
        txtFechaContratacion.setEditable(false);
        comboPuesto.setEnabled(false);
    }

    // 🔥 CONFIRMAR GUARDADO
    private void confirmarGuardar() {
        mostrarDialogoConfirmacion(
            "¿Estás seguro de guardar los cambios?",
            "Confirmar Guardado",
            () -> guardarDatos()
        );
    }

    // 🔥 CONFIRMAR ELIMINAR
    private void confirmarEliminar() {
        mostrarDialogoConfirmacion(
            "¿Seguro que deseas eliminar este usuario?",
            "Eliminar Usuario",
            () -> {
                eliminado = true;
                guardado = true;
                dispose();
            }
        );
    }

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

    // 🔥 GUARDAR
    private void guardarDatos() {
        // Limpiar bordes rojos
        limpiarErrores();

        // Validar campos obligatorios
        boolean hayError = false;
        StringBuilder mensajeError = new StringBuilder();

        if (txtNombre.getText().isEmpty()) {
            txtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Nombre\n");
            hayError = true;
        }
        if (txtApellidoPaterno.getText().isEmpty()) {
            txtApellidoPaterno.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Apellido Paterno\n");
            hayError = true;
        }
        if (txtApellidoMaterno.getText().isEmpty()) {
            txtApellidoMaterno.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Apellido Materno\n");
            hayError = true;
        }
        if (txtCorreo.getText().isEmpty()) {
            txtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Correo\n");
            hayError = true;
        }
        if (txtTelefono.getText().isEmpty()) {
            txtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Teléfono\n");
            hayError = true;
        } else if (!txtTelefono.getText().matches("\\d{10}")) {
            txtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Teléfono (solo números, 10 dígitos)\n");
            hayError = true;
        }
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Usuario\n");
            hayError = true;
        }
        if (txtSueldoBase.getText().isEmpty()) {
            txtSueldoBase.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Sueldo Base\n");
            hayError = true;
        }
        if (txtFechaContratacion.getText().isEmpty()) {
            txtFechaContratacion.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Fecha Contratación\n");
            hayError = true;
        } else if (!txtFechaContratacion.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
            txtFechaContratacion.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Fecha Contratación (formato: YYYY-MM-DD)\n");
            hayError = true;
        }
        if (comboPuesto.getSelectedItem().toString().equals("Sin Especificar")) {
            comboPuesto.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            mensajeError.append("- Puesto\n");
            hayError = true;
        }

        if (hayError) {
            mostrarDialogoError(mensajeError.toString());
            return;
        }

        guardado = true;

        if (usuario != null) {
            usuario.setNombre(txtNombre.getText());
            usuario.setApellido(txtApellidoPaterno.getText() + " " + txtApellidoMaterno.getText());
            usuario.setCorreo(txtCorreo.getText());
            usuario.setTelefono(txtTelefono.getText());
            usuario.setUsuario(txtUsuario.getText());
            usuario.setSueldoBase(txtSueldoBase.getText());
            usuario.setFechaContratacion(txtFechaContratacion.getText());
            usuario.setRol(comboPuesto.getSelectedItem().toString());
        }

        dispose();
    }

    private void mostrarDialogoError(String mensaje) {
        JDialog dialog = new JDialog(this, "Error", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(450, 220);
        dialog.setLocationRelativeTo(this);
        dialog.setUndecorated(true);

        PanelRedondeado panel = new PanelRedondeado();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new java.awt.Color(192, 207, 178));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel panelMensaje = new JPanel();
        panelMensaje.setLayout(new BoxLayout(panelMensaje, BoxLayout.Y_AXIS));
        panelMensaje.setOpaque(false);
        panelMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblTitulo = new JLabel("Faltan los siguientes campos obligatorios:", SwingConstants.CENTER);
        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblTitulo.setForeground(new java.awt.Color(39, 53, 38));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblCampos = new JLabel(mensaje, SwingConstants.CENTER);
        lblCampos.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblCampos.setForeground(new java.awt.Color(200, 50, 50));
        lblCampos.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelMensaje.add(lblTitulo);
        panelMensaje.add(Box.createVerticalStrut(15));
        panelMensaje.add(lblCampos);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelBotones.setOpaque(false);

        botonSwing btnAceptar = new botonSwing();
        btnAceptar.setText("Aceptar");
        btnAceptar.setForeground(new java.awt.Color(39, 53, 38));
        btnAceptar.setPreferredSize(new Dimension(120, 45));
        btnAceptar.addActionListener(e -> dialog.dispose());

        panelBotones.add(btnAceptar);

        panel.add(panelMensaje, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void limpiarErrores() {
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtApellidoPaterno.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtApellidoMaterno.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtCorreo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtSueldoBase.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtFechaContratacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        comboPuesto.setBorder(null);
    }

    // GETTERS
    public boolean isGuardado() { return guardado; }
    public boolean isEliminado() { return eliminado; }
    public String getNombre() { return txtNombre.getText(); }
    public String getApellido() { return txtApellidoPaterno.getText() + " " + txtApellidoMaterno.getText(); }
    public String getApellidoPaterno() { return txtApellidoPaterno.getText(); }
    public String getApellidoMaterno() { return txtApellidoMaterno.getText(); }
    public String getCorreo() { return txtCorreo.getText(); }
    public String getTelefono() { return txtTelefono.getText(); }
    public String getUsuario() { return txtUsuario.getText(); }
    public String getSueldoBase() { return txtSueldoBase.getText(); }
    public String getFechaContratacion() { return txtFechaContratacion.getText(); }
    public String getRol() { return comboPuesto.getSelectedItem().toString(); }

    public String getId() {
        return String.valueOf(System.currentTimeMillis());
    }
}



