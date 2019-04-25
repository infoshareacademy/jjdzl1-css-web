package com.infoshare.academy.servlets.user;

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
import java.io.UnsupportedEncodingException;

import static com.infoshare.academy.utils.RegistrationMessages.*;

@WebServlet("/editaddress")
public class ProfileAddressUpdateServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setEncoding(request, response);
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("username");

        if (userName != null) {
            request.setAttribute("currentUser", getUser(userName));
            request.getRequestDispatcher("editAddress.jsp").forward(request, response);
        } else {
            request.setAttribute("error", anonymousUser());
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setEncoding(req, resp);
        HttpSession session = req.getSession(false);
        String userName = (String) session.getAttribute("username");

        String postalCode = req.getParameter("postalCode");
        String city = req.getParameter("city");
        String streetAddress = req.getParameter("streetAddress");

        usersDao.updateUserAddress(getUser(userName).getId(), postalCode, city, streetAddress);

        resp.setHeader("Refresh", "1");
        req.getRequestDispatcher("editAddress.jsp").forward(req, resp);
    }

    private void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
    }

    public User getUser(String userName) {
        return usersDao.getUserByLogin(userName);
    }
}
