package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/changepassword")
public class ProfilePasswordUpdateServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        if (session != null) {
            String getUser = (String) session.getAttribute("username");
            User currentUser = getUser(getUser);
            request.setAttribute("currentUser", currentUser);
            request.getRequestDispatcher("changepassword.jsp").forward(request, response);
        } else {
            request.setAttribute("error", errorMessage());
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession(false);
        String getUser = (String) session.getAttribute("username");
        User currentUser = getUser(getUser);
        Integer id = currentUser.getId();

        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        if(password1.equals(password2)){
            String password = password1;
            usersDao.updateUserPassword(id, password);
            resp.sendRedirect("LogoutServlet");
            req.getRequestDispatcher("changepassword.jsp").forward(req, resp);
        }

        else {
            req.setAttribute("error", errorMessage2());
            RequestDispatcher reqDisp = req.getRequestDispatcher("changepassword.jsp");
            reqDisp.forward(req, resp);
        }

    }

    public User getUser(String username) {
        return usersDao.getUserByLogin(username);
    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Anonymous users can't access profile!";
        return html1 + errorData + html2;
    }

    public static String errorMessage2() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Given passwords don't match, try again!";
        return html1 + errorData + html2;
    }
}
