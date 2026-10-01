package com.example.email;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class HtmlEmailSender {

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

            message.setSubject("Welcome to Foodies App");

            String html = """
                    <html>
                    <body style="font-family: Arial;">

                        <div style="background-color: orange;
                                    color: white;
                                    padding: 20px;
                                    text-align: center;">
                            <h1>Welcome to Foodies App</h1>
                        </div>

                        <div style="padding: 20px;">
                            <p>Hello <b>Man</b>,</p>

                            <p>Welcome to Foodies App!</p>

                            <p>Enjoy delicious food and easy online ordering.</p>

                            <p>Thank you for joining us.</p>
                        </div>

                    </body>
                    </html>
                    """;

            message.setContent(html, "text/html");

            Transport.send(message);

            System.out.println("HTML email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}