package com.tpfinal.service;


import com.tpfinal.domain.Transaction;
import com.tpfinal.domain.User;
import com.tpfinal.util.UtilServimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Service
public class MailService {

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    public String sendEmail(String email) throws MessagingException {

        String emailHashed = UtilServimap.encriptar(email);
        emailHashed = emailHashed.replaceAll("/","asd753159asd");

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "service.servimap");
        props.put("mail.smtp.password", "jonikarinico");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("no-reply@servimap.com"));
            InternetAddress toAddress = new InternetAddress(email);

            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject("Recupera la clave de Servimap");
            message.setContent("Hola, <br> Para generar una nueva contraseña hace click sobre el link <a href=\"http://localhost:9000/#/passwordSecurity/" + emailHashed + "\"" +
                    ">Generar password</a>", "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, "service.servimap", "jonikarinico");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            logger.error("Email no enviado", e);
            throw e;
        }
        return new String("OK");
    }

    public void rejectService(Transaction transaction) {

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "service.servimap");
        props.put("mail.smtp.password", "jonikarinico");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("no-reply@servimap.com"));
            InternetAddress toAddress = new InternetAddress(transaction.getFromUser().getEmail());

            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject("Un servicio ha sido rechazado");
            message.setContent("Hola "+ transaction.getFromUser().getFullName() + ", <br> " +
                    "Queríamos avisarte que el proveedor ha rechazado el servicio que solicitaste" +
                    " por el siguiente motivo: " + transaction.getRejection() +
                    ". <br> Podés nuevamente solicitar otro servicio o buscar diferentes proveedores." +
                    "<br><br>ServiMap", "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, "service.servimap", "jonikarinico");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            logger.error("Email no enviado", e);
        }
    }

    public void confirmService(Transaction transaction) {

        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "service.servimap");
        props.put("mail.smtp.password", "jonikarinico");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("no-reply@servimap.com"));
            InternetAddress toAddress = new InternetAddress(transaction.getFromUser().getEmail());

            User proveedor = userService.findByIdUser(transaction.getToUser());

            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject("Tu servicio ha sido aceptado");
            message.setContent("Hola "+ transaction.getFromUser().getFullName() + ", <br> " +
                    "Queríamos avisarte que el proveedor ha aceptado el servicio que solicitaste. <br>" +
                    "Te pasamos la información para que te pongas en contacto:" +
                    "<br> Proveedor: " + proveedor.getFullName() +
                    "<br> Email: " + proveedor.getEmail() +
                    "<br> Teléfono: " + proveedor.getPhone() +
                    "<br>" +
                    "<br>"+
                    "Muchas gracias por confiar en nosotros." +
                    "<br> ServiMap."
                    ,"text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, "service.servimap", "jonikarinico");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            logger.error("Email no enviado", e);
        }
    }

    public void newTransaction(Transaction transaction) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "service.servimap");
        props.put("mail.smtp.password", "jonikarinico");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("no-reply@servimap.com"));
            User proveedor = userService.findByIdUser(transaction.getToUser());
            InternetAddress toAddress = new InternetAddress(proveedor.getEmail());


            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject("Te quieren contratar");
            message.setContent("Hola "+ proveedor.getFullName() + ", <br> " +
                            "Queríamos avisarte que un usuario requiere de tus servicios. <br>" +
                            "Ingresa a ServiMap y responde la solicitud." +
                            "<br>"+
                            "Muchas gracias por confiar en nosotros." +
                            "<br> ServiMap."
                    ,"text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, "service.servimap", "jonikarinico");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            logger.error("Email no enviado", e);
        }
    }
}