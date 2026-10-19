package provet.view.administrador;

import javax.swing.*;
import provet.componentes.botonSwing;
import provet.componentes.PanelRedondeado;

public class UsuariosRegistro extends JDialog {

    private boolean guardado = false;
    private UsuariosAdmin.Usuario usuario;
    private String modo;

    // CAMPOS
    private JTextField txtNombre, txtApellido, txtCorreo, txtTelefono;
    private JComboBox<String> comboRol, comboEstado;

    public UsuariosRegistro(java.awt.Frame parent, String modo, UsuariosAdmin.Usuario u) {
        super(parent, true);
        this.modo = modo;
        this.usuario = u;

        setTitle("Usuario");
        setSize(600, 480);
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
        titulo.setBounds(0, 20, 600, 30);
        titulo.setFont(new java.awt.Font("Tahoma", 1, 20));
        titulo.setForeground(new java.awt.Color(39,53,38));
        fondo.add(titulo);

        PanelRedondeado card = new PanelRedondeado();
        card.setLayout(null);
        card.setBackground(new java.awt.Color(192,207,178));
        card.setBounds(50, 70, 500, 270);

        // DATOS PERSONALES
        card.add(label("DATOS PERSONALES", 0, 10, true));

        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtCorreo = new JTextField();
        txtTelefono = new JTextField();
        
        txtNombre.setBackground(new java.awt.Color(228,230,217));
        txtApellido.setBackground(new java.awt.Color(228,230,217));
        txtCorreo.setBackground(new java.awt.Color(228,230,217));
        txtTelefono.setBackground(new java.awt.Color(228,230,217));
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtCorreo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));
        txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,5,5,5));

        card.add(label("Nombre", 20, 40, false));
        txtNombre.setBounds(20, 60, 200, 30);
        card.add(txtNombre);

        card.add(label("Apellido", 260, 40, false));
        txtApellido.setBounds(260, 60, 200, 30);
        card.add(txtApellido);

        card.add(label("Correo", 20, 100, false));
        txtCorreo.setBounds(20, 120, 200, 30);
        card.add(txtCorreo);

        card.add(label("Teléfono", 260, 100, false));
        txtTelefono.setBounds(260, 120, 200, 30);
        card.add(txtTelefono);

        // ROL
        card.add(label("ROL Y ACCESO", 0, 160, true));

        comboRol = new JComboBox<>(new String[]{"Administrador", "Secretario", "Veterinario"});
        comboEstado = new JComboBox<>(new String[]{"Activo", "Suspendido"});
        comboRol.setBackground(new java.awt.Color(228,230,217));
        comboEstado.setBackground(new java.awt.Color(228,230,217));

        card.add(label("Rol", 20, 190, false));
        comboRol.setBounds(20, 210, 200, 30);
        card.add(comboRol);

        card.add(label("Estado", 260, 190, false));
        comboEstado.setBounds(260, 210, 200, 30);
        card.add(comboEstado);

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
            btnCancelar.setBounds(160, 360, 120, 45);
            btnGuardar.setBounds(290, 360, 150, 45);
        } else if (modo.equals("ver")) {
            // Solo cancelar
            btnEliminar.setVisible(false);
            btnGuardar.setVisible(false);
            btnCancelar.setBounds(240, 360, 120, 45);
        } else if (modo.equals("editar")) {
            // Los tres botones
            btnEliminar.setBounds(95, 360, 130, 45);
            btnCancelar.setBounds(235, 360, 120, 45);
            btnGuardar.setBounds(365, 360, 150, 45);
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
        txtApellido.setText(u.getApellido());
        txtCorreo.setText(u.getCorreo());
        txtTelefono.setText(u.getTelefono());
        comboEstado.setSelectedItem(u.getEstado());
        comboRol.setSelectedItem(u.getRol());
    }

    private void bloquearCampos() {
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtCorreo.setEditable(false);
        txtTelefono.setEditable(false);
        comboRol.setEnabled(false);
        comboEstado.setEnabled(false);
    }

    // 🔥 CONFIRMAR GUARDADO
    private void confirmarGuardar() {

        int op = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de guardar los cambios?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION
        );

        if (op == JOptionPane.YES_OPTION) {
            guardarDatos();
        }
    }

    // 🔥 CONFIRMAR ELIMINAR
    private void confirmarEliminar() {

        int op = JOptionPane.showConfirmDialog(
            this,
            "¿Seguro que deseas eliminar este usuario?",
            "Eliminar",
            JOptionPane.YES_NO_OPTION
        );

        if (op == JOptionPane.YES_OPTION) {
            guardado = false;
            dispose();
        }
    }

    // 🔥 GUARDAR
    private void guardarDatos() {

        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre obligatorio");
            return;
        }

        guardado = true;

        if (usuario != null) {
            usuario.setNombre(txtNombre.getText());
            usuario.setApellido(txtApellido.getText());
            usuario.setCorreo(txtCorreo.getText());
            usuario.setTelefono(txtTelefono.getText());
            usuario.setEstado(comboEstado.getSelectedItem().toString());
            usuario.setRol(comboRol.getSelectedItem().toString());
        }

        dispose();
    }

    // GETTERS
    public boolean isGuardado() { return guardado; }
    public String getNombre() { return txtNombre.getText(); }
    public String getApellido() { return txtApellido.getText(); }
    public String getCorreo() { return txtCorreo.getText(); }
    public String getTelefono() { return txtTelefono.getText(); }
    public String getEstado() { return comboEstado.getSelectedItem().toString(); }
    public String getRol() { return comboRol.getSelectedItem().toString(); }

    public String getId() {
        return String.valueOf(System.currentTimeMillis());
    }
}



