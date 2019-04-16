package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.PasswordHashAlgorithm;
import com.infoshare.academy.utils.UserPasswordUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

import static com.infoshare.academy.utils.RegistrationMessages.activationErrorMessage;
import static com.infoshare.academy.utils.RegistrationMessages.errorMessageLoginIncorrect;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String remoteAddr = req.getRemoteAddr();
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User tempUser = getUserBasedOnLogin(username);
        if (tempUser == null){
            LOGGER.info("[LOGIN] Requested login to non existing user: " + username + ", from IP: " + remoteAddr);
            req.setAttribute("error", errorMessageLoginIncorrect());
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        boolean isPasswordCorrect = checkPassword(tempUser, password);

        if (isPasswordCorrect) {
            if (tempUser.getAccountActive()) {
                HttpSession session = req.getSession();
                Integer usertype = tempUser.getUserType();
                session.setAttribute("username", username);
                session.setAttribute("usertype", usertype);
                LOGGER.info("[LOGIN] Successful login to user: " + username + ", usertype=" + usertype + ", from IP: " + remoteAddr);
                req.getRequestDispatcher("listAvailableCar.jsp").forward(req, resp);
            } else {
                req.setAttribute("activationError", activationErrorMessage());
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", errorMessageLoginIncorrect());
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    private User getUserBasedOnLogin(String username) {
        return usersDao.getUserByLogin(username);
    }

    private boolean checkPassword(User tempUser, String password) {
        return UserPasswordUtils.check(password, tempUser.getPassword(), PasswordHashAlgorithm.PBKDF2);
    }
}
