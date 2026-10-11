//Indicamos a que paquete pertenece
package provet.componentes;

//Importamos librerias
import javax.swing.*;                               //Toda la libreria .swing
import java.awt.*;                                  //Toda la libreria .awt
import java.awt.event.MouseAdapter;                 //La libreria que altera el puntero
import java.awt.event.MouseEvent;                   //La libreria que altera las acciones del mouse
import java.awt.font.TextAttribute;                 //Para aplicar estilos de texto como subrayado
import java.util.Map;                               //Para manejar los atributos de la fuente
import java.util.HashMap;                           //Para crear mapas de atributos

//Inicio de la clase labelSwing, que hereda de JLabel
public final class linkLabel extends JLabel {

    //Atributos de la clase
    private Color colorNormal;                      //Color estandar del texto
    private final Color colorClick = Color.BLUE;    //Color que adquiere al ser presionado
    private Font fuenteBase;                        //Guarda la fuente original sin alteraciones

    //Constructor de la clase 
    public linkLabel() {
        super();                                    //Recibe la herencia del padre
        this.colorNormal = new Color(39,53,38);//Color inicial
        this.fuenteBase = new Font("Tahoma", Font.BOLD, 14); //Fuente inicial
        inicializar();                              //Agrega todas las modificaciones
    }

    //Sobrecarga del constructor
    public linkLabel(String texto) {
        super(texto);                           //Recibe la herencia del padre
        this.colorNormal = new Color(39,53,38);//Color inicial
        this.fuenteBase = new Font("Tahoma", Font.BOLD, 14);
        inicializar();                              //Agrega todas las modificaciones
    }

    @Override           //Capturamos la fuente cuando el usuario la cambia en NetBeans
    public void setFont(Font font) {
        super.setFont(font);
        // Guardamos esta fuente como la base (sin subrayado)
        this.fuenteBase = font;
    }

    @Override           //Capturamos el color base cuando se cambia en el editor
    public void setForeground(Color fg) {
        super.setForeground(fg);
        // Si no es el azul de click, lo guardamos como color normal
        if (colorClick != null && !fg.equals(colorClick)) {
            this.colorNormal = fg;
        }
    }

    //Metodo para cambiar el estilo visual (Color y Subrayado)
    private void cambiarEstilo(boolean subrayar, Color color) {
        if (fuenteBase == null) return;

        // Configuramos los atributos de la fuente
        Map<TextAttribute, Object> atributos = new HashMap<>(fuenteBase.getAttributes());
        
        // Si subrayar es true, activamos el atributo, si no, lo quitamos (-1)
        atributos.put(TextAttribute.UNDERLINE, subrayar ? TextAttribute.UNDERLINE_ON : -1);
        
        // Aplicamos la fuente y el color directamente al componente
        super.setFont(fuenteBase.deriveFont(atributos));
        linkLabel.super.setForeground(color);
        repaint();
    }

    //Metodo inicializar (agrega todos los ajustes)
    private void inicializar() {
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));  //Cambia el puntero a la manita
        cambiarEstilo(false, colorNormal);  //Estado inicial: sin subrayado y color normal

        //Agregamos nuestras Listeners de Mouse al label
        addMouseListener(new MouseAdapter() {
            
            @Override       //Al pasar el mouse Subrayar
            public void mouseEntered(MouseEvent e) {
                cambiarEstilo(true, colorNormal); 
            }

            @Override       //Al quitar el mouse Quitar subrayado y volver a color normal
            public void mouseExited(MouseEvent e) {
                cambiarEstilo(false, colorNormal);
            }

            @Override       //Al presionar el click Subrayar y poner Azul
            public void mousePressed(MouseEvent e) {
                cambiarEstilo(true, colorClick);
            }

            @Override       //Al soltar el click
            public void mouseReleased(MouseEvent e) {
                //Si soltamos dentro del componente, vuelve al estado de "Hover" (Subrayado + Normal)
                if (contains(e.getPoint())) {
                    cambiarEstilo(true, colorNormal);
                } else {
                    //Si soltamos fuera, vuelve al estado base
                    cambiarEstilo(false, colorNormal);
                }
            }
        });
    }
}