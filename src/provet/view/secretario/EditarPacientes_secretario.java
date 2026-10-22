/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package provet.view.secretario;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import provet.dao.MascotaSecretarioDAO;
import provet.view.secretario.Registrar_paciente_secretario;
import provet.view.secretario.Reporte_secretario;
import provet.view.secretario.editar_paciente;

/**
 *
 * @author Andreij Haziel
 */
public class EditarPacientes_secretario extends javax.swing.JFrame {

    /**
     * Creates new form EditarPacientes_secretario
     */
    public EditarPacientes_secretario() {
    initComponents();

    // Poblar combo de filtro con especies desde BD (con fallback a lista fija)
    try {
        java.util.List<String> especies = Datos.mascotaDAO.getEspecies();
        java.util.List<String> listaConTodos = new java.util.ArrayList<>();
        listaConTodos.add("Todos");
        listaConTodos.addAll(especies);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(listaConTodos.toArray(new String[0])));
    } catch (Exception ex) {
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Todos", "Perro", "Gato", "Hamster", "Ardilla", "Uron", "Cuyo", "Conejo", "Especie diferente"}
        ));
    }

    cargarTabla();

    // --- Búsqueda en tiempo real ---
    jTextField_bucarPaciente.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        public void insertUpdate(javax.swing.event.DocumentEvent e)  { filtrarTabla(); }
        public void removeUpdate(javax.swing.event.DocumentEvent e)  { filtrarTabla(); }
        public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrarTabla(); }
    });

    // --- Filtro por especie ---
    jComboBox1.addActionListener(e -> filtrarTabla());

    // --- Selección de fila ---
    jTableBuscarPaciente.getSelectionModel().addListSelectionListener(e -> {
        int fila = jTableBuscarPaciente.getSelectedRow();
        if (fila != -1) {
            System.out.println("Paciente seleccionado: " + jTableBuscarPaciente.getValueAt(fila, 1));
        }
    });

    // --- Dar de baja ---
    boton_dar_de_baja.addActionListener(e -> {
        int fila = jTableBuscarPaciente.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un paciente de la tabla primero.", "Sin selección", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idMascota = Integer.parseInt(jTableBuscarPaciente.getValueAt(fila, 0).toString());
        String nombreSeleccionado = jTableBuscarPaciente.getValueAt(fila, 1).toString();
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "¿Seguro que deseas eliminar a \"" + nombreSeleccionado + "\" de la base de datos?\nSus citas asociadas también serán eliminadas.",
            "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            boolean ok = Datos.mascotaDAO.eliminar(idMascota);
            if (ok) {
                Datos.sincronizarConVeterinario();
                cargarTabla();
                javax.swing.JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente de la base de datos.");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar de la base de datos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    // --- Ver detalles ---
    boton_ver_detalles.addActionListener(e -> {
        int fila = jTableBuscarPaciente.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un paciente de la tabla primero.", "Sin selección", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idMascota = Integer.parseInt(jTableBuscarPaciente.getValueAt(fila, 0).toString());
        MascotaSecretarioDAO.MascotaDTO dto = Datos.mascotaDAO.selectById(idMascota);
        if (dto != null) {
            String detalles = "ID BD: " + dto.idMascota + "\n"
                + "Nombre: " + dto.nombreMascota + "\n"
                + "Especie: " + dto.especie + "\n"
                + "Raza: " + dto.raza + "\n"
                + "Sexo: " + dto.sexo + "\n"
                + "Fecha nacimiento: " + dto.fechaNacimiento + "\n"
                + "Propietario: " + dto.nombrePropietario + "\n"
                + "Teléfono: " + (dto.telefonoPropietario != null ? dto.telefonoPropietario : "N/A") + "\n"
                + "Email: " + (dto.emailPropietario != null ? dto.emailPropietario : "N/A") + "\n"
                + "Estatus cliente: " + dto.estatusCliente;
            javax.swing.JOptionPane.showMessageDialog(this, detalles, "Detalle del paciente", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el paciente en la BD.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    });

    if(isUndecorated()){

        dispose();

        setUndecorated(false);

    }

    getContentPane().removeAll();

    getContentPane().setLayout(
        new java.awt.BorderLayout()
    );

    getContentPane().add(
        jPanel2,
        java.awt.BorderLayout.WEST
    );

    getContentPane().add(
        jPanel1,
        java.awt.BorderLayout.CENTER
    );

    jPanel2.setPreferredSize(
        new java.awt.Dimension(
            270,
            0
        )
    );

    setDefaultCloseOperation(
        DISPOSE_ON_CLOSE
    );

    setExtendedState(
        JFrame.MAXIMIZED_BOTH
    );
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linkLabel1 = new provet.componentes.linkLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        botonSwing3 = new provet.componentes.botonSwing();
        botonSwing1 = new provet.componentes.botonSwing();
        btn_Calendario = new provet.componentes.botonSwing();
        btn_Reportes = new provet.componentes.botonSwing();
        btn_Salir = new provet.componentes.botonSwing();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBuscarPaciente = new javax.swing.JTable();
        jTextField_bucarPaciente = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        boton_dar_de_baja = new provet.componentes.botonSwing();
        boton_editar = new provet.componentes.botonSwing();
        boton_ver_detalles = new provet.componentes.botonSwing();
        botonSwing2 = new provet.componentes.botonSwing();

        linkLabel1.setText("linkLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(108, 135, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 255, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 53, 38));
        jLabel6.setText("Nombre");
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
        jLabel16.setText("Secretario");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        botonSwing3.setText("Menú Principal");
        botonSwing3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing3ActionPerformed(evt);
            }
        });
        jPanel2.add(botonSwing3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        botonSwing1.setForeground(new java.awt.Color(39, 53, 38));
        botonSwing1.setText("Registrar Paciente");
        botonSwing1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing1ActionPerformed(evt);
            }
        });
        jPanel2.add(botonSwing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        btn_Calendario.setForeground(new java.awt.Color(39, 53, 38));
        btn_Calendario.setText("Editar Paciente");
        btn_Calendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CalendarioActionPerformed(evt);
            }
        });
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

        jPanel1.setBackground(new java.awt.Color(228, 230, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(1291, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(51, 255, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(39, 53, 38));
        jLabel9.setText("EDITAR PACIENTES");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 29));

        jTableBuscarPaciente.setBackground(new java.awt.Color(242, 242, 242));
        jTableBuscarPaciente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableBuscarPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Especie", "Raza", "Edad", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBuscarPaciente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 1120, 380));
        jPanel1.add(jTextField_bucarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 840, 40));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtrar", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 250, 40));

        boton_dar_de_baja.setBackground(new java.awt.Color(255, 51, 51));
        boton_dar_de_baja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/secretario/exit.png"))); // NOI18N
        boton_dar_de_baja.setText("Dar de baja");
        boton_dar_de_baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_dar_de_bajaActionPerformed(evt);
            }
        });
        jPanel1.add(boton_dar_de_baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 570, 240, 50));

        boton_editar.setBackground(new java.awt.Color(108, 135, 118));
        boton_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/secretario/lapiz.png"))); // NOI18N
        boton_editar.setText("Editar");
        boton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editarActionPerformed(evt);
            }
        });
        jPanel1.add(boton_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 240, 50));

        boton_ver_detalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/secretario/eye.png"))); // NOI18N
        boton_ver_detalles.setText("Ver detalles");
        jPanel1.add(boton_ver_detalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 610, 330, 50));

        botonSwing2.setBackground(new java.awt.Color(108, 135, 118));
        botonSwing2.setText("Regresar");
        botonSwing2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSwing2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonSwing2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 160, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1470, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSwing3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing3ActionPerformed
        Dashboard_Secretario menu = new Dashboard_Secretario();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonSwing3ActionPerformed

    private void botonSwing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing1ActionPerformed
        Registrar_paciente_secretario menu = new Registrar_paciente_secretario();
        menu.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_botonSwing1ActionPerformed

    private void btn_CalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CalendarioActionPerformed
        EditarPacientes_secretario menu = new EditarPacientes_secretario();
        menu.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btn_CalendarioActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportesActionPerformed
    Reporte_secretario menu = new Reporte_secretario();
    menu.setVisible(true);
    this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_btn_ReportesActionPerformed

    private void boton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editarActionPerformed
        int fila = jTableBuscarPaciente.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un paciente de la tabla primero.", "Sin selección", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idMascota = Integer.parseInt(jTableBuscarPaciente.getValueAt(fila, 0).toString());
        MascotaSecretarioDAO.MascotaDTO dto = Datos.mascotaDAO.selectById(idMascota);
        if (dto != null) {
            editar_paciente editor = new editar_paciente(dto);
            editor.setVisible(true);
            EditarPacientes_secretario.this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo cargar el paciente de la BD.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_boton_editarActionPerformed

    private void boton_dar_de_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_dar_de_bajaActionPerformed
        int fila = jTableBuscarPaciente.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un paciente de la tabla primero.", "Sin selección", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idMascota = Integer.parseInt(jTableBuscarPaciente.getValueAt(fila, 0).toString());
        String nombre = jTableBuscarPaciente.getValueAt(fila, 1).toString();
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
            "¿Seguro que deseas eliminar a \"" + nombre + "\" de la base de datos?\nEsta acción también borrará sus citas relacionadas.",
            "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            boolean ok = Datos.mascotaDAO.eliminar(idMascota);
            if (ok) {
                Datos.sincronizarConVeterinario();
                cargarTabla();
                javax.swing.JOptionPane.showMessageDialog(this, "Mascota eliminada correctamente de la base de datos.");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar de la base de datos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_boton_dar_de_bajaActionPerformed

    private void botonSwing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSwing2ActionPerformed
        Dashboard_Secretario menu = new Dashboard_Secretario();
        menu.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_botonSwing2ActionPerformed

    private void cargarTabla() {
        // Cargar desde base de datos
        Datos.cargarMascotas();
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableBuscarPaciente.getModel();
        modelo.setRowCount(0);
        for (MascotaSecretarioDAO.MascotaDTO d : Datos.mascotas) {
            modelo.addRow(new Object[]{
                d.idMascota,
                d.nombreMascota,
                d.especie,
                d.raza,
                d.fechaNacimiento,
                d.estatusCliente
            });
        }
    }

    private void filtrarTabla() {
        String textoBusqueda = jTextField_bucarPaciente.getText().trim().toLowerCase();
        String especieFiltro = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : "Todos";

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableBuscarPaciente.getModel();
        modelo.setRowCount(0);

        for (MascotaSecretarioDAO.MascotaDTO d : Datos.mascotas) {
            boolean coincideTexto = textoBusqueda.isEmpty()
                || String.valueOf(d.idMascota).contains(textoBusqueda)
                || d.nombreMascota.toLowerCase().contains(textoBusqueda)
                || d.raza.toLowerCase().contains(textoBusqueda)
                || d.nombrePropietario.toLowerCase().contains(textoBusqueda);

            boolean coincideEspecie = especieFiltro.equals("Todos")
                || d.especie.equalsIgnoreCase(especieFiltro);

            if (coincideTexto && coincideEspecie) {
                modelo.addRow(new Object[]{
                    d.idMascota,
                    d.nombreMascota,
                    d.especie,
                    d.raza,
                    d.fechaNacimiento,
                    d.estatusCliente
                });
            }
        }
    }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarPacientes_secretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPacientes_secretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPacientes_secretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPacientes_secretario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPacientes_secretario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private provet.componentes.botonSwing botonSwing1;
    private provet.componentes.botonSwing botonSwing2;
    private provet.componentes.botonSwing botonSwing3;
    private provet.componentes.botonSwing boton_dar_de_baja;
    private provet.componentes.botonSwing boton_editar;
    private provet.componentes.botonSwing boton_ver_detalles;
    private provet.componentes.botonSwing btn_Calendario;
    private provet.componentes.botonSwing btn_Reportes;
    private provet.componentes.botonSwing btn_Salir;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBuscarPaciente;
    private javax.swing.JTextField jTextField_bucarPaciente;
    private provet.componentes.linkLabel linkLabel1;
    // End of variables declaration//GEN-END:variables
}
