package com.tpfinal.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Properties;

public class UtilDutymap {

    public static String encriptar(String texto) {

        String secretKey = "áÁéÉaí3Í4ó5Ó4545ú227Úü965dtÜt822AFñÑ12GHEe3e4eeee55856e7e8eeeee90"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    public static String desencriptar(String textoEncriptado) throws Exception {

        String secretKey = "áÁéÉaí3Í4ó5Ó4545ú227Úü965dtÜt822AFñÑ12GHEe3e4eeee55856e7e8eeeee90"; //llave para desenciptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

//    public static void enviarEmail(){
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
//    }
}
