package provet.componentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Contenedor_Cartas extends PanelRedondeado {

    private GridBagConstraints gbc;
    private int eje = 1; 
    // Este panel invisible servirá para empujar todo hacia arriba
    private final JPanel pegamentoFondo = new JPanel();

    public Contenedor_Cartas() {
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        pegamentoFondo.setOpaque(false);
        configurarGBC();
    }

    private void configurarGBC() {
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; // Las cartas no deben estirarse verticalmente
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0); // Espacio entre cartas
        gbc.anchor = GridBagConstraints.NORTH; // Alineación al norte
    }

    @Override
    protected void addImpl(Component comp, Object constraints, int index) {
        // Si no es el panel de relleno, lo añadimos con nuestras reglas
        if (comp != pegamentoFondo && !(comp instanceof Box.Filler)) {
            
            // 1. Quitamos el pegamento temporalmente para que siempre esté al final
            this.remove(pegamentoFondo);

            // 2. Ajustamos la carta para que se alinee arriba
            if (comp instanceof JComponent) {
                JComponent jc = (JComponent) comp;
                jc.setAlignmentX(Component.LEFT_ALIGNMENT);
                jc.setMaximumSize(new Dimension(Integer.MAX_VALUE, jc.getPreferredSize().height));
            }

            // 3. Añadimos la carta
            super.addImpl(comp, gbc, index);

            // 4. Volvemos a poner el pegamento al final con weight 1.0
            GridBagConstraints gbcPegamento = new GridBagConstraints();
            gbcPegamento.gridwidth = GridBagConstraints.REMAINDER;
            gbcPegamento.weightx = 1.0;
            gbcPegamento.weighty = 1.0; // ESTO absorbe el espacio sobrante
            gbcPegamento.fill = GridBagConstraints.BOTH;
            super.addImpl(pegamentoFondo, gbcPegamento, -1);
            
            this.revalidate();
            this.repaint();
        } else {
            super.addImpl(comp, constraints, index);
        }
    }

    public void setEje(int eje) {
        this.eje = eje;
        configurarGBC();
        this.revalidate();
    }

    public int getEje() { return eje; }

    @Override
    public void setLayout(LayoutManager mgr) {
        if (mgr instanceof GridBagLayout) {
            super.setLayout(mgr);
        }
    }
}