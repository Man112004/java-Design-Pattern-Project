package com.example.email;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class AttachmentEmailSender {

    public static void main(String[] args) {

        String fromEmail = "man@gmail.com";
        String appPassword = "123456@8";
        String toEmail = "jatin@gmail.com";

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, appPassword);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));

            message.setSubject("Order Receipt");

            MimeBodyPart textPart = new MimeBodyPart();

            textPart.setText(
                    "Hello Man,\n\nPlease find your Order Receipt attached.");

            MimeBodyPart attachmentPart = new MimeBodyPart();

            attachmentPart.attachFile("C:/Users/Man/Desktop/Order Receipt.pdf");

            MimeMultipart multipart = new MimeMultipart();

            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email with PDF sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}