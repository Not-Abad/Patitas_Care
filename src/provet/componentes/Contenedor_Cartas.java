package provet.componentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Contenedor_Cartas extends PanelRedondeado {

    private GridBagConstraints gbc;
    private int eje = 1; // 1 = Vertical, 0 = Horizontal
    private final JPanel pegamentoFondo = new JPanel();

    public Contenedor_Cartas() {
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        pegamentoFondo.setOpaque(false);
        configurarGBC();
    }

    private void configurarGBC() {
        gbc = new GridBagConstraints();
        
        if (eje == 1) {
            // --- CONFIGURACIÓN VERTICAL ---
            gbc.gridwidth = GridBagConstraints.REMAINDER; 
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 0.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 0, 10, 0); 
            gbc.anchor = GridBagConstraints.NORTH;
        } else {
            // --- CONFIGURACIÓN HORIZONTAL ---
            gbc.gridwidth = 1;
            gbc.gridheight = GridBagConstraints.REMAINDER; 
            gbc.weightx = 0.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.insets = new Insets(0, 10, 0, 0); // Espacio a la izquierda para separar cartas
            gbc.anchor = GridBagConstraints.WEST;
        }
    }

    @Override
    protected void addImpl(Component comp, Object constraints, int index) {
        if (comp != pegamentoFondo && !(comp instanceof Box.Filler)) {
            
            this.remove(pegamentoFondo);

            if (comp instanceof JComponent) {
                JComponent jc = (JComponent) comp;
                // Ajustar alineaciones según el eje
                jc.setAlignmentX(eje == 1 ? Component.LEFT_ALIGNMENT : Component.CENTER_ALIGNMENT);
                jc.setAlignmentY(eje == 1 ? Component.CENTER_ALIGNMENT : Component.TOP_ALIGNMENT);
                
                Dimension size = jc.getPreferredSize();
                if (eje == 1) {
                    jc.setMaximumSize(new Dimension(Integer.MAX_VALUE, size.height));
                } else {
                    jc.setMaximumSize(new Dimension(size.width, Integer.MAX_VALUE));
                }
            }

            super.addImpl(comp, gbc, index);

            // --- RE-COLOCAR EL PEGAMENTO ---
            GridBagConstraints gbcPegamento = new GridBagConstraints();
            if (eje == 1) {
                gbcPegamento.gridwidth = GridBagConstraints.REMAINDER;
                gbcPegamento.weightx = 1.0;
                gbcPegamento.weighty = 1.0; // Empuja hacia arriba (Norte)
            } else {
                gbcPegamento.gridheight = GridBagConstraints.REMAINDER;
                gbcPegamento.weightx = 1.0; // Empuja hacia la izquierda (Oeste)
                gbcPegamento.weighty = 1.0;
            }
            gbcPegamento.fill = GridBagConstraints.BOTH;
            super.addImpl(pegamentoFondo, gbcPegamento, -1);
            
            this.revalidate();
            this.repaint();
        } else {
            super.addImpl(comp, constraints, index);
        }
    }

    // Getters y Setters para NetBeans
    public void setEje(int eje) {
        this.eje = eje;
        configurarGBC();
        this.revalidate();
        this.repaint();
    }

    public int getEje() { 
        return eje; 
    }

    @Override
    public void setLayout(LayoutManager mgr) {
        if (mgr instanceof GridBagLayout) {
            super.setLayout(mgr);
        }
    }
}