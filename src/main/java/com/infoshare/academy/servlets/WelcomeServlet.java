package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        HttpSession session = request.getSession(true);
        PrintWriter out=response.getWriter();
        if (session != null) {
            String currentUser = (String) session.getAttribute("currentUser");
            User tempUser = getUser(currentUser);
            String welcome = "Welcome " + tempUser.getFirstName() + " " + tempUser.getLastName();
            out.print(welcome);
        } else {
            request.setAttribute("error", errorMessage());
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
        out.close();
    }

    public User getUser(String username) {
        return usersDao.getUserByLogin(username);
    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Please login first!";
        return html1 + errorData + html2;
    }
}
