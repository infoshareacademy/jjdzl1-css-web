package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.MailSend;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.infoshare.academy.utils.RegistrationMessages.messageSent;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");

        if (getUser != null) {
            User currentUser = getUser(getUser);
            req.setAttribute("currentUser", currentUser);
        }

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
        req.setAttribute("messageSent", messageSent());

        req.getRequestDispatcher("contact.jsp").forward(req, resp);
    }

    public User getUser(String username) {
        return usersDao.getUserByLogin(username);
    }
}
