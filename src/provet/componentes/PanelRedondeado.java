
package provet.componentes;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class PanelRedondeado extends JPanel {

    private int radio = 30;

    public PanelRedondeado() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radio, radio));

        g2.dispose();
        super.paintComponent(g);
    }
}