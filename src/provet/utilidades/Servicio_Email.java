
//Indicamos a que paquete pertenece
package provet.utilidades;

//Importamos librerias a usar
import javax.mail.*;
import javax.mail.internet.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

//Inicio de la clase
public class Servicio_Email {

    //Atributos de la clase
    private static final String emailFrom = "patitascare.notificaciones@gmail.com";
    private static final String passwordFrom = "yrnrylwgxklboyya";
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    private int codigoEnviado;

    public Servicio_Email() {
        mProperties = new Properties();
        configurarSMTP();
    }

    // Configuración inicial del protocolo
    private void configurarSMTP() {
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        // Creamos la sesión una sola vez
        mSession = Session.getInstance(mProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, passwordFrom);
            }
        });
    }

    // Método para cargar y procesar el HTML externo
    public String obtenerContenidoTemplate(String nombreArchivo, Map<String, String> variables) throws Exception {
        // Buscamos el archivo en src/main/resources/templates/
        InputStream is = getClass().getClassLoader().getResourceAsStream("templates/" + nombreArchivo);
        if (is == null) throw new Exception("No se encontró la plantilla: " + nombreArchivo);

        // Leemos el archivo línea por línea
        String contenido = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));

        // Reemplazamos los placeholders {{variable}} por el valor real
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            contenido = contenido.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }

        return contenido;
    }

    // Generar código de 6 dígitos
    public int generarCodigoRandom() {
        long semilla = System.currentTimeMillis();
        Random random = new Random(semilla);
        int codigo = 100000 + random.nextInt(900000);

        this.codigoEnviado = codigo;
        return codigo;
    }

    // Crear el mensaje con datos dinámicos
    public void createEmail(String destinatario, String asunto, String cuerpoHtml) throws MessagingException {
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mCorreo.setSubject(asunto);
            mCorreo.setContent(cuerpoHtml, "text/html; charset=utf-8");
        } catch (MessagingException ex) {
            Logger.getLogger(Servicio_Email.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    // Envío final
    public void sendEmail() throws MessagingException {
        try {
            Transport.send(mCorreo);
        } catch (MessagingException ex) {
            Logger.getLogger(Servicio_Email.class.getName()).log(Level.SEVERE, "Error al enviar el correo", ex);
            throw ex;
        }
    }

    public int getCodigoEnviado() {
        return codigoEnviado;
    }
}
