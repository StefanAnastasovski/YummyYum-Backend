package com.yummyyum.Services.SendEmail.Impl;

import com.yummyyum.Services.SendEmail.SendEmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String myAccountEmail;

    @Value("${spring.mail.password}")
    String password;

    @Override
    public void sendMimeMail(String recipient, String fullName, String code) throws Exception {
        System.out.println("Preparing to send an email");


        Properties properties = System.getProperties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }

        });

        Message message = prepareMessage(session, myAccountEmail, recipient, fullName, code);

        Transport.send(message);
        System.out.println("Message sent successfully!");
    }

    Session setEmailPropertiesAndSession() {
        Properties properties = System.getProperties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        return Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }

        });
    }

    @Override
    public void sendMimeMailToSubscribers(String subject, String text, List<String> recipients) throws Exception {
        System.out.println("Preparing to send an email to subscribers");


        Session session = this.setEmailPropertiesAndSession();

        Message message = prepareSubscribeMessage(session, myAccountEmail, subject, text, recipients);

        Transport.send(message);
        System.out.println("Message sent successfully!");
    }

    @Override
    public Message prepareMessage(Session session, String myAccountEmail, String recipient, String fullName, String code) {

        Message message = new MimeMessage(session);

        String emailBody = "<p>Hi <strong>" + fullName + "</strong>," +
                "\n<p>We received a request to reset the password on your YummyYum Account.</p>\n\n" +
                "<h2><strong>" + code + "</strong></h2>" +
                "\n\n<p>Enter this code to complete the reset.</p>" +
                "\n\n<p>Thanks for helping us keep your account secure.</p>" +
                "\n<p>The YummyYum Team</p>";

        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Test");
            message.setContent(emailBody, "text/html");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Message prepareSubscribeMessage(Session session, String myAccountEmail,
                                           String subject, String text, List<String> recipients) {

        Message message = new MimeMessage(session);

        InternetAddress[] addressTo = new InternetAddress[recipients.size()];
        for (int i = 0; i < recipients.size(); i++) {
            try {
                addressTo[i] = new InternetAddress(recipients.get(i));
            } catch (AddressException e) {
                e.printStackTrace();
            }
        }

        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipients(Message.RecipientType.TO, addressTo);
            message.setSubject("Test");
            message.setContent(text, "text/html");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
