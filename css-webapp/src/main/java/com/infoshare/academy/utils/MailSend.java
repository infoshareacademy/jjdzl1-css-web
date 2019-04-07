package com.infoshare.academy.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSend {

    private Properties emailProperties;
    private Session mailSession;
    private MimeMessage emailMessage;

    public void sentEmail(String login, String mailAddress, String UUID) throws AddressException,
            MessagingException {

        MailSend javaEmail = new MailSend();

        javaEmail.setMailServerProperties();
        javaEmail.createEmailMessage(login, mailAddress, UUID);
        javaEmail.sentEmail();
    }

    private void setMailServerProperties() {

        String emailPort = "587";//gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

    }

    private void createEmailMessage(String Login, String destinationAdress, String UUID) throws AddressException, MessagingException {
        String[] toEmails = {destinationAdress};
        String emailSubject = "Registration process in CAR SHARING SYSTEM";
        String emailBody = "Hello " + Login + "\n Click this link to activate your account in " +
                "CAR SHARING SYSTEM: \n" + "localhost:8080/jjdzl1-css/activationAccount?login=" + Login + "&UUID=" + UUID;
        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        for (String toEmail : toEmails) {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        }

        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");//for a html email
//      emailMessage.setText(emailBody);// for a text email

    }

    private void sentEmail() throws AddressException, MessagingException {

        String emailHost = "smtp.gmail.com";
        String fromUser = "CarSharingSystem.help";//just the id alone without @gmail.com
        String fromUserEmailPassword = "CSS12345";

        Transport transport = mailSession.getTransport("smtp");

        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }

}
