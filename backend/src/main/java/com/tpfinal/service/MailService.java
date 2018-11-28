package com.tpfinal.service;


import com.tpfinal.util.UtilServimap;
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
            e.printStackTrace();
            throw e;
        }
        return new String("OK");
    }
//
//
//    public static void main(String[] args)
//    {
//        String to = "s.maximilianno@gmail.com";
//        sendEmail(to);
//    }
}