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
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import static com.infoshare.academy.utils.RegistrationMessages.*;

@WebServlet("/editinfo")
public class ProfilePersonalUpdateServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        String getUser = (String) session.getAttribute("username");

        if (getUser != null) {
            User currentUser = getUser(getUser);
            request.setAttribute("currentUser", currentUser);
            request.getRequestDispatcher("editinfo.jsp").forward(request, response);
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
        String getUser = (String) session.getAttribute("username");
        User currentUser = getUser(getUser);
        Integer id = currentUser.getId();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String birthDate = req.getParameter("birthDate");

        usersDao.updateUserInfo(id, firstName, lastName, Long.parseLong(phoneNumber), LocalDate.parse(birthDate));

        resp.setHeader("Refresh", "1");
        req.getRequestDispatcher("editinfo.jsp").forward(req, resp);
    }

    private void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
    }

    public User getUser(String username) {
        return usersDao.getUserByLogin(username);
    }
}
