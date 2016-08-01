package com.tpfinal.service;


import com.tpfinal.util.UtilDutymap;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {


    public static String sendEmail(String email)
    {
        String emailHashed = UtilDutymap.encriptar(email);
        emailHashed = emailHashed.replaceAll("/","asd753159asd");


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("service.dutymap", "jonikarinico");
                    }
                });

        try {
            Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication  getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            "service.dutymap@gmail.com", "jonikarinico");
                }
            });
            Transport transport = mailSession.getTransport();

            MimeMessage message = new MimeMessage(mailSession);

            message.setSubject("Recupera la clave de Dutymap");
            message.setContent(
                    "<img src=\"cid:C:/xampp/htdocs/Tp_Final/tp-final/backend/src/main/java/com/tpfinal/a.jpg\"/>" +
                    "<br><br>" +
                    "Hola, <br> Para generar una nueva contraseña hace click sobre el link <a href=\"http://localhost:9000/#/passwordSecurity/" + emailHashed + "\"" +
                    ">Generar password</a>", "text/html"
            );
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            transport.connect();
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return new String("FALLO");
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