package services.Mailer;

import jakarta.mail.Address;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Mailer {
    public static void startRentMessage(String to, String uuid) throws Exception {
        String from = "Biblioteca <notificacions@iesantonlosada.gal>";
        String subject = "Se ha iniciado un nuevo prcon c" + uuid;
        String body = "<div>\n    <p>\n        Hola, se ha inicado un nuevo prSu cde devolucies el siguiente:\n    </p>\n    <img src=\"cid:qrcode\" alt=\"cQR\"/>\n</div>";
        send(from, to, subject, body, uuid);
    }

    public static void send(String from, String to, String subject, String body, String uuid) {
        Session session = getSession();
        try {
            sendMessage(session, from, to, subject, body, uuid);
            System.out.println("Correo electrenviado.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Session getSession() {
        String username = "smtp@iesantonlosada.gal";
        String password = "bcua lqlr fvlv fgas";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("smtp@iesantonlosada.gal", "bcua lqlr fvlv fgas");
            }
        });
        return session;
    }

    private static void sendMessage(Session session, String from, String to, String subject, String body, String uuid) throws MessagingException, IOException {
        File image = new File(uuid + ".png");
        MimeBodyPart imagePart = new MimeBodyPart();
        imagePart.setHeader("Content-ID", "qrcode");
        imagePart.setDisposition("inline");
        imagePart.attachFile(image);
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(body, "text/html; charset=utf-8");
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart((BodyPart)bodyPart);
        mimeMultipart.addBodyPart((BodyPart)imagePart);
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom((Address)new InternetAddress(from));
        mimeMessage.setRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse(to));
        mimeMessage.setSubject(subject);
        mimeMessage.setContent((Multipart)mimeMultipart);
        Transport.send((Message)mimeMessage);
    }
}

