package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.ForgotPasswordMessages;
import com.infoshare.academy.utils.MailSend;
import com.infoshare.academy.utils.UUIDGeneratorForUser;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@WebServlet("/forget-password")

public class ForgetPasswordServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao dao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        String email = request.getParameter("email");
        System.out.println(email);
        User user = dao.getUserByEmail(email);
        System.out.println(user);
        if (user == null) {
            RequestResponse(request, response, "IncorrectEmail", ForgotPasswordMessages.emailIncorrectMessage());
        } else {
            setExpireTimeAndUIDDTokenForUserInForgotPasswordProcess(user);
            System.out.println(user);
            dao.updateChangePasswordTokenData(user.getId(), user.getPasswordTokenUUID(), user.getPasswordTokenDateTime());
            MailSend mail = new MailSend();
            new Thread(() -> {
                try {
                    mail.sentEmailForForgotPasswordProcess(user.getEmail(), user.getPasswordTokenUUID());
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }).start();
            RequestResponse(request, response, "MailWithTokenSend", ForgotPasswordMessages.emailWithTockenInfoSend());
        }
    }

    private void RequestResponse(HttpServletRequest request, HttpServletResponse response, String errorMessage, String jspError) throws ServletException, IOException {
        request.setAttribute(errorMessage, jspError);
        RequestDispatcher req = request.getRequestDispatcher("forgetPasswordForm.jsp");
        req.forward(request, response);
    }

    private void setExpireTimeAndUIDDTokenForUserInForgotPasswordProcess(User user) {
        UUIDGeneratorForUser generator = new UUIDGeneratorForUser();
        user.setPasswordTokenUUID(generator.getGeneratedNewUUIDForForgotPasswordProcess());
        LocalDateTime now = LocalDateTime.now();
        user.setPasswordTokenDateTime(now.plus(1, ChronoUnit.MINUTES));
    }
}
