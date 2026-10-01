package com.example.email;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class PasswordResetEmail {

    public static void sendPasswordResetEmail(
            String toEmail, String resetLink) {

        String fromEmail = "man@gmail.com";
        String appPassword = "123456@8";

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                fromEmail, appPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromEmail));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));

            message.setSubject("Reset Your Password");

            String html = """
                    <html>
                    <body style="font-family: Arial;">

                        <div style="background-color:#0070e0;
                                    color:white;
                                    padding:20px;
                                    text-align:center;">
                            <h2>Password Reset</h2>
                        </div>

                        <div style="padding:25px;">

                            <p>Hello,</p>

                            <p>
                                We received a request to reset your password.
                            </p>

                            <p>
                                Click the button below to reset your password:
                            </p>

                            <p>
                                <a href="%s"
                                   style="background-color:#0070e0;
                                          color:white;
                                          padding:12px 25px;
                                          text-decoration:none;
                                          border-radius:5px;
                                          display:inline-block;">
                                    Reset Password
                                </a>
                            </p>

                            <p>
                                If you did not request this, you can ignore
                                this email.
                            </p>

                            <p>Thank you.</p>

                        </div>

                    </body>
                    </html>
                    """.formatted(resetLink);

            message.setContent(html, "text/html");

            Transport.send(message);

            System.out.println("Password reset email sent!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String email = "jatin@gmail.com";

        String resetLink = "http://localhost:8080/reset-password?token=12345";

        sendPasswordResetEmail(email, resetLink);
    }
}