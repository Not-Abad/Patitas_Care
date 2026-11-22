package provet.componentes;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import provet.modelo.Propietario;

/** @author jesus-abad */
public class BuscadorCliente extends JComboBox<Propietario> {

    private List<Propietario> todosLosPropietarios = new ArrayList<>();

    public BuscadorCliente() {
        setEditable(true);
        JTextField textField = (JTextField) getEditor().getEditorComponent();
        
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Ignoramos las flechas de navegación y el Enter para que no interfieran
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_ENTER) {
                    return;
                }
                String textoEscrito = textField.getText();
                filtrarLista(textoEscrito);
            }
        });
        
        setBackground(new Color(233, 237, 225));

        // Reemplazar el botón de la flecha por uno invisible y sin dimensiones
        this.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected javax.swing.JButton createArrowButton() {
                javax.swing.JButton botonVacio = new javax.swing.JButton();
                botonVacio.setPreferredSize(new java.awt.Dimension(0, 0));
                botonVacio.setVisible(false);
                return botonVacio;
            }
        });
    }

    public void setDatosPropietarios(List<Propietario> propietarios) {
        this.todosLosPropietarios = (propietarios != null) ? propietarios : new ArrayList<>();
        filtrarLista(""); // Llena el combo al inicio
    }

    // Alias de compatibilidad por si alguna vista aún llama al nombre anterior
    public void setDatosClientes(List<Propietario> propietarios) {
        setDatosPropietarios(propietarios);
    }

    private void filtrarLista(String texto) {
        removeAllItems();
        if (todosLosPropietarios == null) {
            return;
        }

        if (texto == null || texto.isEmpty()) {
            for (Propietario p : todosLosPropietarios) {
                addItem(p);
            }
        } else {
            String filtro = texto.toLowerCase();
            for (Propietario p : todosLosPropietarios) {
                boolean coincideToString = p.toString() != null && p.toString().toLowerCase().contains(filtro);
                boolean coincideCorreo = p.getCorreo() != null && p.getCorreo().toLowerCase().contains(filtro);
                if (coincideToString || coincideCorreo) {
                    addItem(p);
                }
            }
        }
        
        JTextField textField = (JTextField) getEditor().getEditorComponent();
        textField.setText(texto);
        if (getItemCount() > 0 && isShowing()) {
            showPopup();
        } else if (isShowing()) {
            hidePopup();
        }
    }
}