package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.infoshare.academy.utils.RegistrationMessages.errorMessageLoginFirst;

public class WelcomeServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset-UTF-8");
        HttpSession session = req.getSession(true);
        PrintWriter out=resp.getWriter();
        if (session != null) {
            String currentUser = (String) session.getAttribute("currentUser");
            User tempUser = getUser(currentUser);
            String welcome = "Welcome " + tempUser.getFirstName() + " " + tempUser.getLastName();
            out.print(welcome);
        } else {
            req.setAttribute("error", errorMessageLoginFirst());
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        out.close();
    }

    public User getUser(String username) {
        return usersDao.getUserByLogin(username);
    }

}
