package provet.view.administrador;

import javax.swing.*;
import provet.view.administrador.UsuariosAdmin.Usuario;

public class FormUsuario1 extends JDialog {

    private JTextField txtNombre, txtId;
    private JComboBox<String> cbRol;
    private boolean guardado = false;

    public FormUsuario1(java.awt.Frame parent) {
        super(parent, true);
        setTitle("Nuevo Usuario");
        setSize(350, 300);
        setLocationRelativeTo(parent);
        setLayout(null);

        JLabel lbl1 = new JLabel("Nombre:");
        lbl1.setBounds(30, 30, 100, 25);
        add(lbl1);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 30, 180, 25);
        add(txtNombre);

        JLabel lbl2 = new JLabel("ID:");
        lbl2.setBounds(30, 70, 100, 25);
        add(lbl2);

        txtId = new JTextField();
        txtId.setBounds(120, 70, 180, 25);
        add(txtId);

        JLabel lbl3 = new JLabel("Rol:");
        lbl3.setBounds(30, 110, 100, 25);
        add(lbl3);

        cbRol = new JComboBox<>(new String[]{
            "Administrador", "Veterinario", "Secretaria", "Propietario"
        });
        cbRol.setBounds(120, 110, 180, 25);
        add(cbRol);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 180, 100, 30);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(170, 180, 100, 30);

        add(btnGuardar);
        add(btnCancelar);

        btnGuardar.addActionListener(e -> {
            if (txtNombre.getText().isEmpty() || txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa todos los campos");
                return;
            }
            guardado = true;
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());
    }

    public FormUsuario1(java.awt.Frame parent, Usuario u) {
    this(parent);

    txtNombre.setText(u.getNombre());
    txtId.setText(u.getId());
    txtId.setEnabled(false); // no cambiar ID
    cbRol.setSelectedItem(u.getRol());
}
    
    public boolean isGuardado() { return guardado; }
    public String getNombre() { return txtNombre.getText(); }
    public String getId() { return txtId.getText(); }
    public String getRol() { return cbRol.getSelectedItem().toString(); }
}



