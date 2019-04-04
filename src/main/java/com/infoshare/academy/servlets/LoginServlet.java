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

import static com.infoshare.academy.utils.RegistrationMessages.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User tempUser = createUserBasedOnFormLogin(username);
        Integer usertype = getUserType(tempUser);
        boolean checkPassword = checkPassword(tempUser, password);

        if (tempUser != null && checkPassword) {
            if (tempUser.getAccountActive()) {
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                session.setAttribute("usertype", usertype);
                req.getRequestDispatcher("listAvailableCar.jsp").forward(req, resp);
            } else {
                req.setAttribute("activationError", activationErrorMessage());
            }
        } else {
            req.setAttribute("error", errorMessageLoginIncorrect());
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    private User createUserBasedOnFormLogin(String username) {
        return usersDao.getUserByLogin(username);
    }

    private Integer getUserType(User tempUser) {
        Integer usertype = null;
        try {
            usertype = tempUser.getUserType();
        } catch (NullPointerException e) {
            System.out.println("Login error (usertype): " + e);
        }
        return usertype;
    }

    private boolean checkPassword(User tempUser, String password) {
        boolean checkPassword = false;
        try {
            checkPassword = UserPasswordUtils.check(password, tempUser.getPassword(), PasswordHashAlgorithm.PBKDF2);
        } catch (NullPointerException e) {
            System.out.println("Login error (password): " + e);
        }
        return checkPassword;
    }
}
