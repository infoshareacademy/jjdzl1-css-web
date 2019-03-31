package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

@WebServlet("/admin/edituser")
public class EditUserServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null) {
            req.getRequestDispatcher("/admin/edituser.jsp").forward(req, resp);
        } else if (id.isEmpty()) {
            req.setAttribute("error", errorMessage());
            req.getRequestDispatcher("/admin/edituser.jsp").forward(req, resp);
        } else {
            User userById = usersDao.getUserById(Integer.valueOf(id));
            if (userById == null){
                req.setAttribute("error", errorMessage());
            }
            if (userById != null) {
                req.setAttribute("user", userById);
            }
            req.getRequestDispatcher("/admin/edituser.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setEncoding(req, resp);

        String id = req.getParameter("id");

        if (id == null) {
            req.getRequestDispatcher("/admin/edituser.jsp").forward(req, resp);
        } else if (id.isEmpty()) {
            req.setAttribute("error", errorMessage());
            req.getRequestDispatcher("/admin/edituser.jsp").forward(req, resp);
        } else {

            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String phoneNumber = req.getParameter("phoneNumber");
            String birthDate = req.getParameter("birthDate");

            String postalCode = req.getParameter("postalCode");
            String city = req.getParameter("city");
            String streetAddress = req.getParameter("streetAddress");

            usersDao.updateUserInfo(Integer.parseInt(id), firstName, lastName, Long.parseLong(phoneNumber), LocalDate.parse(birthDate));
            usersDao.updateUserAddress(Integer.parseInt(id), postalCode, city, streetAddress);

            resp.sendRedirect("users");
        }
    }

    private void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User id incorrect! Please try again.";
        return html1 + errorData + html2;
    }
}
