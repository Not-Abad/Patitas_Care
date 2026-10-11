
//Indicamos a que paquete pertenece
package provet.componentes;

//Importamos las librerias
import javax.swing.*;                   //Toda la libreria .swing
import javax.swing.border.EmptyBorder;  //La libreria que edita los bordes
import java.awt.*;                      //Toda la libreria .awt
import java.io.File;                    //La libreria para manejo de archivos
import java.io.IOException;             //La libreria para errores de entrada/salida
import java.nio.file.Files;             //La libreria para operaciones de archivos
import java.nio.file.StandardCopyOption;//La libreria para opciones de copia

//Inicio de la clase Panel_DocumentoSubido, que ahora hereda de PanelRedondeado
public class Panel_DocumentoSubido extends PanelRedondeado {

    // --- ENUM PARA LOS ESTADOS DE REVISIÓN ---
    public enum EstadoArchivo {
        //Declaramos las 2 unicas opciones de estado
        REVISADO("Revisado por el veterinario", new Color(34, 139, 34), "✓"),
        PENDIENTE("Pendiente de revisión", new Color(200, 140, 0), "↑");

        //Atributos del estado
        private final String texto;     //Texto descriptivo
        private final Color color;      //Color representativo
        private final String icono;     //Simbolo visual

        //Constructor de estado
        EstadoArchivo(String texto, Color color, String icono) {
            this.texto = texto;
            this.color = color;
            this.icono = icono;
        }
        
        //Getters de los atributos
        public String getTexto() { return texto; }
        public Color getColor() { return color; }
        public String getIcono() { return icono; }
    }

    // --- ENUM PARA TIPOS DE ARCHIVO E ICONOS ---
    public enum TipoArchivo {
        //Definimos los tipos soportados y sus rutas de imagen
        PDF(new String[]{".pdf"}, "/imagenes/Iconos_pnlDocumentoSubido/pdf.png"),
        IMAGEN(new String[]{".jpg", ".jpeg", ".png"}, "/imagenes/Iconos_pnlDocumentoSubido/amor.png"),
        DESCONOCIDO(new String[]{}, "/imagenes/Iconos_pnlDocumentoSubido/expediente.png");

        //Atributos del tipo
        private final String[] extensiones; //Formatos aceptados
        private final String rutaIcono;     //Ruta del recurso visual

        //Constructor de tipo
        TipoArchivo(String[] extensiones, String rutaIcono) {
            this.extensiones = extensiones;
            this.rutaIcono = rutaIcono;
        }

        //Metodo estatico que detecta el tipo segun el nombre
        public static TipoArchivo desdeNombre(String nombre) {
            if (nombre == null || nombre.isEmpty() || !nombre.contains(".")) return DESCONOCIDO;
            String min = nombre.toLowerCase();
            for (TipoArchivo t : values()) {
                for (String e : t.extensiones) if (min.endsWith(e)) return t;
            }
            return DESCONOCIDO;
        }
        public String getRuta() { return rutaIcono; }
    }

    //Atributos de la clase (Componentes UI)
    private JLabel lblIcono;            //Espacio para la imagen del archivo
    private JLabel lblNombre;           //Etiqueta para el nombre del documento
    private JLabel lblFecha;            //Etiqueta para la fecha de subida
    private JLabel lblEstado;           //Etiqueta para el estado de revision
    private JButton btnVer;             //Boton para abrir el archivo
    private JButton btnBorrar;          //Boton para eliminar el componente
    private JButton btnDescargar;       //Boton para guardar copia en disco

    //Atributos de la clase (Propiedades)
    private String rutaArchivo = "";                                //Ruta fisica del archivo
    private File archivoVinculado;                                  //Objeto archivo de Java
    private EstadoArchivo estadoActual = EstadoArchivo.PENDIENTE;   //Estado por defecto

    //Colores de los botones
    public final Color clrRojoF  = new Color(255, 235, 235);
    public final Color clrRojoT  = new Color(170, 40, 40);
    public final Color clrAzulF  = new Color(235, 245, 235);
    public final Color clrAzulT  = new Color(40, 110, 40);
    public final Color clrVerdeF = new Color(235, 240, 255);
    public final Color clrVerdeT = new Color(40, 80, 170);

    //Constructor de la clase
    public Panel_DocumentoSubido() {
        super();                        //Recibe la herencia de PanelRedondeado
        setBackground(Color.WHITE);  //Define el color que PanelRedondeado usará para el fondo
        inicializar();                  //Agrega todas las modificaciones
    }

    //Metodo inicializar (agrega todos los ajustes)
    private void inicializar() {
        //Estilizamos el panel principal
        setLayout(new BorderLayout(15, 0));                             //Define disposicion de bordes
        setBorder(new EmptyBorder(12, 15, 12, 15));          //Agrega margen interno (Padding)
        
        setPreferredSize(new Dimension(840, 105));                   //Define tamaño preferido
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 105));       //Define tamaño maximo

        //Configuramos el panel del icono (Lado izquierdo)
        JPanel pnlIcono = new JPanel(new GridBagLayout());                      //Usa GridBag para centrar
        pnlIcono.setOpaque(false);                                       //Hace el fondo transparente
        pnlIcono.setPreferredSize(new Dimension(70, 0));             //Ancho fijo para el icono
        
        GridBagConstraints gbc = new GridBagConstraints();                      //Crea restricciones de diseño
        gbc.anchor = GridBagConstraints.NORTH;                                  //Alinea al norte (arriba)
        gbc.weighty = 1.0;                                                      //Da peso vertical
        gbc.insets = new java.awt.Insets(10, 0, 0, 0);       //Agrega margen superior (10%)
        lblIcono = new JLabel();                                                //Inicializa etiqueta de icono
        actualizarIconoVisual("");                                        //Carga imagen de expediente por defecto
        pnlIcono.add(lblIcono, gbc);                              //Agrega etiqueta con restricciones
        add(pnlIcono, BorderLayout.WEST);                         //Lo posiciona al oeste

        //Configuramos el panel de informacion (Centro)
        JPanel pnlInfo = new JPanel(new GridLayout(2, 1, 0, 2));//Rejilla de 2 filas
        pnlInfo.setOpaque(false);                                        //Fondo transparente
        
        lblNombre = new JLabel("Sin archivo seleccionado");                 //Etiqueta de nombre inicial
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 25));      //Define tipografia negrita
        
        JPanel pnlDatos = new JPanel(new GridLayout(1,2,0,2));
        pnlDatos.setOpaque(false);
        lblFecha = new JLabel("Fecha: --/--/----");                         //Etiqueta de fecha inicial
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));      //Define tipografia normal
        lblFecha.setForeground(Color.GRAY);                                  //Color gris
        lblEstado = new JLabel();                                               //Inicializa etiqueta de estado
        lblEstado.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 11)); //Negrita cursiva
        pnlDatos.add(lblFecha);                                             //Agrega fecha
        pnlDatos.add(lblEstado);                                            //Agrega estado
        
        pnlInfo.add(lblNombre);         //Agrega nombre
        pnlInfo.add(pnlDatos);         //Agregamos el panel de los datos
        add(pnlInfo, BorderLayout.CENTER); //Lo posiciona al centro

        //Configuramos el panel de acciones (Lado derecho)
        JPanel pnlAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 18)); //Alineado derecha
        pnlAcciones.setOpaque(false);                                             //Fondo transparente

        btnVer = crearBoton("👁", clrVerdeF, clrVerdeT);      //Boton ver
        btnDescargar = crearBoton("💾↓", clrAzulF,clrAzulT); //Boton descargar
        btnBorrar = crearBoton("🗑", clrRojoF, clrRojoT);    //Boton borrar

        pnlAcciones.add(btnVer);                        //Agrega boton ver
        pnlAcciones.add(btnDescargar);                  //Agrega boton descargar
        pnlAcciones.add(btnBorrar);                     //Agrega boton borrar
        add(pnlAcciones, BorderLayout.EAST);  //Lo posiciona al este

        //Agregamos eventos a los botones
        btnVer.addActionListener(e -> abrirDocumento());            //Accion para visualizar
        btnBorrar.addActionListener(e -> eliminarEstePanel());      //Accion para quitar panel
        btnDescargar.addActionListener(e -> descargarDocumento());  //Accion para guardar

        actualizarEstadoVisual(); //Pinta el estado inicial
    }

    //Metodo para crear botones estilizados
    private JButton crearBoton(String t, Color bg, Color fg) {
        JButton b = new JButton(t);                                             //Crea instancia
        b.setPreferredSize(new Dimension(42, 42));                       //Tamaño cuadrado
        b.setBackground(bg); b.setForeground(fg);                                   //Define colores
        b.setFocusPainted(false); b.setCursor(new Cursor(Cursor.HAND_CURSOR));//Ajustes visuales
        b.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));  //Tipografia para emojis
        b.setBorder(BorderFactory.createLineBorder(fg.brighter(), 1)); //Borde fino
        return b;
    }

    //Metodo para abrir el documento en el sistema
    private void abrirDocumento() {
        //Si el archivo existe, Entonces..
        if (archivoVinculado != null && archivoVinculado.exists()) {
            //Lanzamos un hilo nuevo para evitar congelar la interfaz
            new Thread(() -> {
                try {
                    String os = System.getProperty("os.name").toLowerCase();
                    //Si es sistema Linux, Entonces..
                    if (os.contains("nix") || os.contains("nux")) {
                        Runtime.getRuntime().exec(new String[]{"xdg-open", archivoVinculado.getAbsolutePath()});
                    } else { //Si no, Entonces..
                        Desktop.getDesktop().open(archivoVinculado);
                    }
                } catch (IOException ex) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, "Error al abrir."));
                }
            }).start();
        }
    }

    //Metodo para descargar una copia del documento
    private void descargarDocumento() {
        //Si no hay archivo, Entonces termina el metodo
        if (archivoVinculado == null || !archivoVinculado.exists()) return;
        
        JFileChooser saver = new JFileChooser();                //Crea buscador de guardado
        saver.setSelectedFile(new File(archivoVinculado.getName())); //Sugiere nombre original
        
        //Si el usuario acepta guardar, Entonces..
        if (saver.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            new Thread(() -> {
                try {
                    Files.copy(archivoVinculado.toPath(), saver.getSelectedFile().toPath(), StandardCopyOption.REPLACE_EXISTING);
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, "¡Guardado!"));
                } catch (IOException ex) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, "Error al copiar."));
                }
            }).start();
        }
    }

    //Metodo para eliminar el componente de la vista
    private void eliminarEstePanel() {
        Container padre = this.getParent(); //Busca el contenedor padre
        //Si tiene un padre, Entonces..
        if (padre != null) {
            padre.remove(this);         //Se quita a si mismo
            padre.revalidate();             //Revalida diseño
            padre.repaint();                //Repinta
        }
    }

    //Metodo para actualizar la imagen del icono
    private void actualizarIconoVisual(String nombre) {
        TipoArchivo tipo = TipoArchivo.desdeNombre(nombre); //Busca el tipo segun extension
        try {
            java.net.URL url = getClass().getResource(tipo.getRuta());
            //Si encuentra la imagen, Entoncxes..
            if (url != null) {
                ImageIcon img = new ImageIcon(url);          //Carga imagen
                lblIcono.setIcon(new ImageIcon(img.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
                lblIcono.setText("");                           //Limpia texto
            } else { throw new Exception(); }                       //Fuerza error si no hay imagen
        } catch (Exception e) {
            lblIcono.setIcon(null); lblIcono.setText("X📄"); //Muestra emoji de respaldo
            lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        }
    }

    //Metodo para actualizar el texto y color del estado
    private void actualizarEstadoVisual() {
        //Si la etiqueta existe, Entonces..
        if (lblEstado != null) {
            lblEstado.setText(estadoActual.getIcono() + " " + estadoActual.getTexto());
            lblEstado.setForeground(estadoActual.getColor());
        }
    }

    // --- GETTERS Y SETTERS PARA EL INSPECTOR DE NETBEANS ---
    public String getRutaArchivo() { return rutaArchivo; }
    
    //Modifica la ruta y actualiza toda la informacion del panel
    public void setRutaArchivo(String ruta) {
        this.rutaArchivo = ruta;                        //Guarda ruta
        this.archivoVinculado = new File(ruta);  //Crea objeto File
        //Si el archivo existe fisicamente, Entonces..
        if (archivoVinculado.exists()) {
            lblNombre.setText(archivoVinculado.getName()); //Cambia nombre
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
            lblFecha.setText("Subido: " + sdf.format(archivoVinculado.lastModified())); //Cambia fecha
            actualizarIconoVisual(archivoVinculado.getName()); //Cambia icono
        } else { //Si no, Entonces..
            actualizarIconoVisual("");              //Regresa a icono de expediente
        }
    }

    public EstadoArchivo getEstado() { return estadoActual; }
    
    //Modifica el estado y refresca el color
    public void setEstado(EstadoArchivo est) { 
        this.estadoActual = est; 
        actualizarEstadoVisual(); 
    }
}