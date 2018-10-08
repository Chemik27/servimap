package com.tpfinal;

//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.activation.*;

/**
 * Created by tino on 20/07/2016.
 */
public class Main {

    public static void main(String [] args) {
//        UserService userService = new UserService();
//        userService.changePassword("zxc123zxc", "admin2@gmail.com");

// Recipient's email ID needs to be mentioned.
//        Properties props = new Properties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.auth", "true");
//
//
//        try {
//            Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
//                protected PasswordAuthentication  getPasswordAuthentication() {
//                    return new PasswordAuthentication(
//                            "service.servimap@gmail.com", "jonikarinico");
//                }
//            });
//            Transport transport = mailSession.getTransport();
//
//            MimeMessage message = new MimeMessage(mailSession);
//
//            message.setSubject("Recupera la clave de Servimap");
//            message.setContent(
//                    "<img src=\"cid:C:/xampp/htdocs/Tp_Final/tp-final/backend/src/main/java/com/tpfinal/a.jpg\"/>" +
//                    "<br><br>" +
//                    "Hola, <br> Para generar una nueva contraseña hace click sobre el link <a href=\"http://localhost:9000/#/passwordSecurity/maxi\">Generar password</a>", "text/html"
//            );
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("s.maximilianno@gmail.com"));
//
//            transport.connect();
//            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
//            transport.close();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        String asd = "";
//            String lala =UtilServimap.encriptar("maxi");
//        try {
//             asd = UtilServimap.desencriptar(lala);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String response = lala;

//            String[] byteValues = response.substring(1, response.length() - 1).split(",");
//            byte[] bytes = new byte[byteValues.length];
//
//            for (int i=0, len=bytes.length; i<len; i++) {
//                bytes[i] = Byte.parseByte(byteValues[i].trim());
//            }
//
//            String str = new String(bytes);

//            System.out.println(asd);
//            System.out.println(str);
//            byte[] buf = cipher.doFinal(plainTextBytes);
//            byte[] base64Bytes = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(buf);
//            base64EncryptedString = new String(base64Bytes);


    }
}
