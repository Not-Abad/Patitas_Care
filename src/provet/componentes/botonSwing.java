
//Indicamos a que paquete pertenece
package provet.componentes;

//Importamos librerias
import javax.swing.*;                   //Toda la libreria .swiwng
import java.awt.*;                      //Toda la libreria .awt
import java.awt.event.MouseAdapter;     //La libreria que altera el puntero
import java.awt.event.MouseEvent;       //La libreria que altera las acciones del mouse
import java.awt.geom.RoundRectangle2D;  //La libreria que calcula la forma de componente

//Inicio de la clase botonSwing, que hereda de JButton
public final class botonSwing extends JButton {

    //Atributos de la clase
    private Color colorNormal;          //Color estandar del boton
    private Color colorHover;           //Color que adquiere al estar en la mira del puntero
    private Color colorClick;           //Color que adquiere al ser presionado
    private final int redondeo = 30;    //Atributo de la forma del boton

    //Constructor de la clase
    public botonSwing() {
        super();                                        //Recibe la herencia del padre
        setBackground(new Color(233, 237, 225));  //Color de fondo inicial (se puede cambiar desde el Frame)
        inicializar();                                  //Agrega todas las modificaciones
    }

    //Sobrecarga del constructor de la clase
    public botonSwing(String texto) {
        super(texto);                               //Recibe la herencia del padre
        setBackground(new Color(233, 237, 225));  //Color de fondo inicial (se puede cambiar desde el Frame)
        inicializar();                                  //Agrega todas las modificaciones
    }
    
    @Override           //Modifica el metodo setBackground
    public void setBackground(Color bg) {
        
        super.setBackground(bg);    //Usamos la lógica original de Java para que actue como nativo
        this.colorNormal = bg;      //Guardamos el color elegido como nuestro estado base.
    
        //Calculos el tono del color
        int promedioBrillo = (bg.getRed() + bg.getGreen() + bg.getBlue()) / 3;

        //Si el tono es mayor a 128(es alto), Entonces...
        if (promedioBrillo > 128) {
            float factor = 0.9f; // Entre más bajo este número, más oscuro será el hover
            this.colorHover = new Color(
                (int)(bg.getRed() * factor),
                (int)(bg.getGreen() * factor),
                (int)(bg.getBlue() * factor)
            );
        } else {        //Si no, Entonces..
            this.colorHover = bg.brighter();    //Hover es claro
        }
    
        this.colorClick = bg.darker();          //Al presionar click siempre se oscurece el botón
    }

    //Metodo inicializar (agrega todos los ajustes)
    private void inicializar() {
        
        //Estilizamos el botón
        setContentAreaFilled(false);        //Desactiva el relleno cuadrado por defecto de Java
        setFocusPainted(false);             //Elimina el recuadro de puntitos al hacer click
        setBorderPainted(false);            //Quita el borde gris estándar de los botones
        setOpaque(false);              //Hace que el componente sea transparente en las esquinas
        setCursor(new Cursor(Cursor.HAND_CURSOR));  //Cambia el puntero a la manita
        setFont(new Font("Tahoma", Font.BOLD, 16));   // Define una tipografía

        //Agregamos nuestras Listeners de Mouse al boton
        addMouseListener(new MouseAdapter() {
            
            @Override       //Al pasar el mouse
            public void mouseEntered(MouseEvent e) {
                botonSwing.super.setBackground(colorHover);     //Cambia el color a hover
                repaint();                                         //Repinta
            }   

            @Override       //Al quitar el mouse 
            public void mouseExited(MouseEvent e) {
                botonSwing.super.setBackground(colorNormal);    //Regresa a su color base
                repaint();                                         //Repinta
            }

            @Override       //Al dar click
            public void mousePressed(MouseEvent e) {
                botonSwing.super.setBackground(colorClick);     //Cambia el color a click
                repaint();                                         //Repinta
            }

            @Override       //Al soltar el click
            public void mouseReleased(MouseEvent e) {
                //Si al soltar el clic el mouse sigue encima del botón, Entonces...
                if (contains(e.getPoint())) {
                    botonSwing.super.setBackground(colorHover); //Volvemos al color de Hover
                } else {    //Si no, Entonces...
                    botonSwing.super.setBackground(colorNormal);//Regresamos al base
                }
                repaint();                                         //Repinta
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
        // Si NO está habilitado, usamos un color gris/opaco, de lo contrario el normal
        if (!isEnabled()) {
            // Obtenemos el color actual y lo oscurecemos un 30% (factor 0.7f)
            float factor = 0.7f;
            Color colorDeshabilitado = new Color(
                Math.max(0, (int)(colorNormal.getRed() * factor)),
                Math.max(0, (int)(colorNormal.getGreen() * factor)),
                Math.max(0, (int)(colorNormal.getBlue() * factor))
            );
            g2.setColor(colorDeshabilitado);        
        } else {
            g2.setColor(getBackground());
        }
    
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), redondeo, redondeo));
        g2.dispose();
    
        super.paintComponent(g);
    }  

    

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        // Cambiar el cursor según el estado
        setCursor(b ? new Cursor(Cursor.HAND_CURSOR) : new Cursor(Cursor.DEFAULT_CURSOR));
        repaint(); // Obliga a redibujar para aplicar el cambio de color
    }
}

    /*
    @Override   //Modificamos el metodo paintComponent
    protected void paintComponent(Graphics g) {
        //Convertimos el objeto Graphics a Graphics2D para acceder a funciones de dibujo avanzadas
        Graphics2D g2 = (Graphics2D) g.create();
        
        //Activamos el suavizado de bordes (Antialiasing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Definimos el color que usará el pincel
        g2.setColor(getBackground());
        
        //Dibujamos y rellenamos la forma del botón
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), redondeo, redondeo));
        
        //Limpiamos la memoria
        g2.dispose();
        
        //Llamamos al método de la clase padre
        super.paintComponent(g);
    }
*/