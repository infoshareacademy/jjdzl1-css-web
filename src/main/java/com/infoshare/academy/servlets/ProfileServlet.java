package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.infoshare.academy.utils.RegistrationMessages.*;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");

        if (getUser != null) {
            User currentUser = getUser(getUser);
            req.setAttribute("currentUser",currentUser);
            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", anonymousUser());
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    public User getUser(String username) {
        return usersDao.getUserByLogin(username);
    }
}
