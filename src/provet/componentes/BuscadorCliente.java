package provet.componentes;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import provet.model.Cliente;

/** @author jesus-abad */
public class BuscadorCliente extends JComboBox<Cliente> {

    private List<Cliente> todosLosClientes;

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
        
        setBackground(new Color(233,237,225));

        // --- SOLUCIÓN: Reemplazar el botón de la flecha por uno invisible y sin dimensiones ---
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

    public void setDatosClientes(List<Cliente> clientes) {
        this.todosLosClientes = clientes;
        filtrarLista(""); // Llena el combo al inicio
    }

    private void filtrarLista(String texto) {
        removeAllItems();
        if (texto.isEmpty()) {
            for (Cliente c : todosLosClientes) {
                addItem(c);
            }
        } else {
            for (Cliente c : todosLosClientes) {
                // Usa el toString() que definimos en la clase Cliente
                if (c.toString().toLowerCase().contains(texto.toLowerCase())) {
                    addItem(c);
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