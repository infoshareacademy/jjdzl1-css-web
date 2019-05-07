package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.UserPasswordUtils;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
        User userFromDatabaseDeliveredByToken = getUserAndCreateAttribute(req, tokenFromRequest);
        if (userFromDatabaseDeliveredByToken == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            LocalDateTime dateTimeFromBase = userFromDatabaseDeliveredByToken.getPasswordTokenDateTime();
            LOGGER.info("Date from DB: " + dateTimeFromBase);
            boolean isAfter = now.isAfter(dateTimeFromBase);
            if (!isAfter) {
                req.getRequestDispatcher("forgetPasswordForNewPasswordForm.jsp").forward(req, resp);
            } else {
                RequestResponse(req, resp, "expired", UserPasswordUtils.expiredToken());
            }
        }
    }

    private User getUserAndCreateAttribute(HttpServletRequest req, String tokenFromRequest) {
        User userFromDatabaseDeliveredByToken = dao.getUserByToken(tokenFromRequest);
        LOGGER.info("User: " + userFromDatabaseDeliveredByToken);
        req.getSession().setAttribute("USER", dao.getUserByToken(tokenFromRequest));
        return userFromDatabaseDeliveredByToken;
    }

    private void RequestResponse(HttpServletRequest request, HttpServletResponse response, String errorMessage, String jspError) throws ServletException, IOException {
        request.setAttribute(errorMessage, jspError);
        RequestDispatcher req = request.getRequestDispatcher("login.jsp");
        req.forward(request, response);
    }
}
