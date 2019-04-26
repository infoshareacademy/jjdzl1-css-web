package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@WebServlet("/forgetPasswordValidator")

public class ForgetPasswordValidationServlet extends HttpServlet {

    private Logger LOGGER = Logger.getLogger(ForgetPasswordValidationServlet.class.getName());

    @EJB
    private UsersRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tokenFromRequest = req.getParameter("tokenUUID");
        LocalDateTime now = LocalDateTime.now();
        User userFromDatabaseDeliveredByToken = dao.getUserByToken(tokenFromRequest);
        LOGGER.info("Czy null? : " + userFromDatabaseDeliveredByToken);
        if (userFromDatabaseDeliveredByToken == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            LocalDateTime dateTimeFromBase = userFromDatabaseDeliveredByToken.getPasswordTokenDateTime();
            LOGGER.info("data z bazy: " + dateTimeFromBase);
            boolean isAfter = now.isAfter(dateTimeFromBase);
            if (!isAfter) {
                LOGGER.info("Wpuść dalej");
                req.getRequestDispatcher("forgetPasswordForNewPasswordForm.jsp").forward(req, resp);
            } else {
                LOGGER.info("Odrzuć");
            }

        }

    }

}
