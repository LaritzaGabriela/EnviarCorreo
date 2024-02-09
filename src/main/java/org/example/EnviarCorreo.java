package org.example;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarCorreo {

    public static void main(String[] args) {
        // Llamada al método para enviar el correo
        enviarCorreo();
    }

    // Método para enviar correo
    private static void enviarCorreo() {
        // Datos del usuario (podrías manejar estos datos de manera más segura en producción)
        final String usuario = "saltenapedro@gmail.com";
        final String contraseña = "qhnv vwfr kmtw oevw";

        // Configuración de las propiedades del sistema
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Creación de la sesión con autenticación
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contraseña);
            }
        });

        try {
            // Creación del mensaje
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("seguragabriela38@gmail.com", true));
            message.setSubject("Prueba");
            message.setText("Gabriela, esto es una prueba de JavaMail.");

            // Envío del mensaje
            System.out.println("Enviando correo...");
            Transport.send(message);
            System.out.println("¡Correo enviado exitosamente!");

        } catch (MessagingException me) {
            // Manejo de la excepción: imprime la traza o registra en el sistema de registro
            System.out.println("Excepción al enviar el correo: " + me.getMessage());
            me.printStackTrace();
        }
    }
}
