package utility;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.util.Properties;

public class EmailReportSender {
    public static void main(String[] args) {
        final String username = "adoniabhishek9@gmail.com";
        final String password = "ikck slvm jeyc cdlf";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("adoniabhishek2@gmail.com")  // Change this
            );
            message.setSubject("Cucumber Test Report");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hi,\n\nPlease find the test report attached.\n\nThanks.");

            MimeBodyPart attachment = new MimeBodyPart();
            attachment.attachFile(new File("target/cucumber-reports/html-report.html"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachment);

            message.setContent(multipart);
            Transport.send(message);

            System.out.println("✅ Report emailed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

