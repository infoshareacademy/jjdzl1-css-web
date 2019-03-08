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

@WebServlet("/editaddress")
public class ProfileAddressUpdateServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(true);

        if (session != null) {
            String getUser = (String) session.getAttribute("username");
            User currentUser = getUser(getUser);
            request.setAttribute("currentUser", currentUser);
            request.getRequestDispatcher("editaddress.jsp").forward(request, response);
        } else {
            request.setAttribute("error", errorMessage());
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(true);
        String getUser = (String) session.getAttribute("username");
        User currentUser = getUser(getUser);
        Integer id = currentUser.getId();

        String postalCode = req.getParameter("postalCode");
        String city = req.getParameter("city");
        String streetAddress = req.getParameter("streetAddress");

        usersDao.updateUserAddress(id, postalCode, city, streetAddress);

        resp.setHeader("Refresh", "1");
        req.getRequestDispatcher("/editaddress.jsp").forward(req, resp);
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
}
