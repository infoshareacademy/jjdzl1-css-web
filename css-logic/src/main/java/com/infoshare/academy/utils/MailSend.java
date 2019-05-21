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

    private static final String CONTACT_EMAIL = "carsharingsystem.help@gmail.com";

    private Properties emailProperties;
    private Session mailSession;
    private MimeMessage emailMessage;

    public void sendEmailForRegistrationProcess(String login, String mailAddress, String UUID) throws AddressException,
            MessagingException {

        MailSend javaEmail = new MailSend();

        javaEmail.setMailServerProperties();
        javaEmail.createEmail("Registration_process", mailAddress, createBodyContentForRegistrationEmail(login, UUID));
        javaEmail.sendEmail();
    }

    public void sendEmailForForgotPasswordProcess(String mailAddress, String UUID) throws AddressException,
            MessagingException {

        MailSend javaEmail = new MailSend();

        javaEmail.setMailServerProperties();
        javaEmail.createEmail("Forgot_password_process", mailAddress, createBodyContentWithTokenInformationEmail(UUID));
        javaEmail.sendEmail();
    }

    public void sendEmailFromContactForm(String subject, String mailAddress, String content) throws AddressException,
            MessagingException {

        MailSend javaEmail = new MailSend();

        String mails = mailAddress + "," + CONTACT_EMAIL;

        String fullContent = "Message from: " + mailAddress + "<br/><br/>" + content + "<br/><br/>CarSharingSystem contact form";

        javaEmail.setMailServerProperties();
        javaEmail.createMultipleEmail(subject, mails, fullContent);
        javaEmail.sendEmail();
    }

    public void sendEmailWithReservation(String subject, String mailAddress, String content) throws AddressException,
            MessagingException {

        MailSend javaEmail = new MailSend();

        String fullContent = "Message from CarSharingSystem <br/><br/>" + content + "<br/><br/>CarSharingSystem reservation form.";

        javaEmail.setMailServerProperties();
        javaEmail.createMultipleEmail(subject, mailAddress, fullContent);
        javaEmail.sendEmail();
    }


    private void setMailServerProperties() {
        String emailPort = "587"; //gmail's smtp port
        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
    }

    private void createEmail(String subjectOfEmail, String destinationAddress, String emailBodyContent) throws AddressException, MessagingException {
        String[] toEmails = {destinationAddress};
        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        for (String toEmail : toEmails) {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        }

        emailMessage.setSubject(subjectOfEmail);
        emailMessage.setContent(emailBodyContent, "text/html");
    }

    private void createMultipleEmail(String subjectOfEmail, String destinationAddresses, String emailBodyContent) throws AddressException, MessagingException {
        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        emailMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationAddresses));

        emailMessage.setSubject(subjectOfEmail);
        emailMessage.setContent(emailBodyContent, "text/html");
    }

    private void sendEmail() throws AddressException, MessagingException {
        String emailHost = "smtp.gmail.com";
        String fromUser = "CarSharingSystem.help"; //just the id alone without @gmail.com
        String fromUserEmailPassword = "CSS12345";

        Transport transport = mailSession.getTransport("smtp");

        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }

    private String createBodyContentForRegistrationEmail(String Login, String UUID) {
        return "Hello <b>" + Login + "</b> <br>\n Click this link to activate your account in " +
                "CAR SHARING SYSTEM: \n" + "http://localhost:8080/jjdzl1-css/activationAccount?login=" + Login + "&UUID=" + UUID;
    }

    private String createBodyContentWithTokenInformationEmail(String UUID) {
        return "Click this link to change your password " +
                "CAR SHARING SYSTEM: \n" + "http://localhost:8080/jjdzl1-css/forgetPasswordValidator?tokenUUID=" + UUID;
    }
}
