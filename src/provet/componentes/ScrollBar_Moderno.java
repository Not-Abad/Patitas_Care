package provet.componentes;

// Importaciones explícitas para evitar conflictos
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class ScrollBar_Moderno extends BasicScrollBarUI {

    @Override
    protected void installDefaults() {
        super.installDefaults();
        // Es aquí donde se configura la opacidad de la barra
        scrollbar.setOpaque(false);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        // No pintamos el fondo (track) para que parezca que la barra flota
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        // Pintamos solo la "barrita" que se mueve
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Color de la barrita (Gris con transparencia)
        g2.setColor(new Color(150, 150, 150, 150));
        
        // Dibujamos el rectángulo redondeado
        g2.fillRoundRect(thumbBounds.x + 2, thumbBounds.y + 2, 
                         thumbBounds.width - 4, thumbBounds.height - 4, 10, 10);
        g2.dispose();
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createInvisibleButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createInvisibleButton();
    }

    private JButton createInvisibleButton() {
        JButton b = new JButton();
        b.setPreferredSize(new Dimension(0, 0));
        b.setMinimumSize(new Dimension(0, 0));
        b.setMaximumSize(new Dimension(0, 0));
        return b;
    }
}