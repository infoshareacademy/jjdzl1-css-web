package com.infoshare.academy.utils;

//import com.infoshare.academy.dao.UserAuthorizationDaoBean;
//import com.infoshare.academy.domain.UserAuthorization;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.UUID;

public class MailSend {

//   @EJB
//    private UserAuthorizationDaoBean bean;

    private Properties emailProperties;
    private Session mailSession;
    private MimeMessage emailMessage;

    public static void main(String args[]) throws AddressException,
            MessagingException {

        MailSend javaEmail = new MailSend();

        javaEmail.setMailServerProperties();
        javaEmail.createEmailMessage();
        javaEmail.sendEmail();
    }

    private void setMailServerProperties() {

        String emailPort = "587";//gmail's smtp port

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");

    }

    private void createEmailMessage() throws AddressException,
            MessagingException {
        //UUID uuid= UUID.randomUUID();
//        UUID uuid= bean.setAuthorizationNumberWithUUID();
//        UserAuthorization userAuthorization= new UserAuthorization(uuid.toString(),false);
        String[] toEmails = {"CarSharingSystem.help@gmail.com"};
        String emailSubject = "Registration process";
//        String emailBody =userAuthorization.toString();// uuid.toString();

        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        for (String toEmail : toEmails) {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        }

        emailMessage.setSubject(emailSubject);
//        emailMessage.setContent(emailBody, "text/html");//for a html email
//        emailMessage.setText(emailBody);// for a text email

    }

    private void sendEmail() throws AddressException, MessagingException {

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
