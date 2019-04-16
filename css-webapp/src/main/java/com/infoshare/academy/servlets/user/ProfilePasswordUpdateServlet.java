package com.infoshare.academy.servlets.user;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.PasswordHashAlgorithm;
import com.infoshare.academy.utils.UserPasswordUtils;
import com.infoshare.academy.utils.UserValidator;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.infoshare.academy.utils.RegistrationMessages.*;

@WebServlet("/changepassword")
public class ProfilePasswordUpdateServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");

        if (getUser != null) {
            User currentUser = getUser(getUser);
            req.setAttribute("currentUser", currentUser);
            req.getRequestDispatcher("changepassword.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", anonymousUser());
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");
        User currentUser = getUser(getUser);
        Integer id = currentUser.getId();


        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        boolean checkPassword = UserPasswordUtils.check(password, currentUser.getPassword(), PasswordHashAlgorithm.PBKDF2);
        Boolean isPasswordCorrect = new UserValidator().isPasswordCorrect(password1);

        if (checkPassword && password1.equals(password2) && isPasswordCorrect) {
            String newPassword = password1;
            String hashedPassword = UserPasswordUtils.hash(newPassword, PasswordHashAlgorithm.PBKDF2);
            usersDao.updateUserPassword(id, hashedPassword);
            resp.sendRedirect("logout");
            req.getRequestDispatcher("changepassword.jsp").forward(req, resp);
        } else if (!checkPassword) {
            req.setAttribute("error", currentPasswordIncorrect());
            req.getRequestDispatcher("changepassword.jsp").forward(req, resp);
        } else if (!isPasswordCorrect) {
            req.setAttribute("error", passwordIncorrectMessage());
            req.getRequestDispatcher("changepassword.jsp").forward(req, resp);
        } else if (!password1.equals(password2)) {
            req.setAttribute("error", passwordNotMatchMessage());
            req.getRequestDispatcher("changepassword.jsp").forward(req, resp);
        }
    }

    public User getUser(String username) {
        return usersDao.getUserByLogin(username);
    }
}
