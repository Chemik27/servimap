package com.tpfinal;

import com.tpfinal.util.UtilDutymap;
import org.apache.tomcat.util.codec.binary.*;
import sun.misc.BASE64Encoder;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.activation.*;

/**
 * Created by tino on 20/07/2016.
 */
public class Main {

    public static void main(String [] args) {


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
//                            "service.dutymap@gmail.com", "jonikarinico");
//                }
//            });
//            Transport transport = mailSession.getTransport();
//
//            MimeMessage message = new MimeMessage(mailSession);
//
//            message.setSubject("Recupera la clave de Dutymap");
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
        String asd = "";
            String lala =UtilDutymap.encriptar("maxi");
        try {
             asd = UtilDutymap.desencriptar(lala);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String response = lala;

//            String[] byteValues = response.substring(1, response.length() - 1).split(",");
//            byte[] bytes = new byte[byteValues.length];
//
//            for (int i=0, len=bytes.length; i<len; i++) {
//                bytes[i] = Byte.parseByte(byteValues[i].trim());
//            }
//
//            String str = new String(bytes);

            System.out.println(asd);
//            System.out.println(str);
//            byte[] buf = cipher.doFinal(plainTextBytes);
//            byte[] base64Bytes = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(buf);
//            base64EncryptedString = new String(base64Bytes);


    }
}
