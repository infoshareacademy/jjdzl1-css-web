package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.PasswordHashAlgorithm;
import com.infoshare.academy.utils.UserPasswordUtils;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User tempUser = createUserBasedOnFormLogin(username);
        Integer usertype = getUserType(tempUser);
        boolean checkPassword = checkPassword(tempUser,password);

        if (tempUser != null && checkPassword) {
            if (tempUser.getAccountActive()) {
                RequestDispatcher req = request.getRequestDispatcher("listAvailableCar.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("usertype", usertype);
                req.forward(request, response);
            } else {
                request.setAttribute("activationError", activationErrorMessage());
                RequestDispatcher req = request.getRequestDispatcher("login.jsp");
                req.forward(request, response);
            }
        } else {
            request.setAttribute("error", errorMessage());
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
    }

    private User createUserBasedOnFormLogin(String username) {
        return usersDao.getUserByLogin(username);
    }

    private static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Login or password incorrect! Please try again.";
        return html1 + errorData + html2;
    }

    private static String activationErrorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Your Account is not active! Check your email box and activate your account!";
        return html1 + errorData + html2;
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
