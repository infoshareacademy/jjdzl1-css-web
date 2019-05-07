package com.infoshare.academy.servlets;

import com.infoshare.academy.utils.MailSend;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        String from = req.getParameter("from");
        String message = req.getParameter("message");

        MailSend mail = new MailSend();
        new Thread(() -> {
            try {
                mail.sendEmailFromContactForm(subject, from, message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }).start();

        req.getRequestDispatcher("contact.jsp").forward(req, resp);

    }
}
