package com.infoshare.academy.servlets.admin;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.infoshare.academy.utils.RegistrationMessages.errorIdMessage;

@WebServlet("/admin/deleteuser")
public class DeleteUserServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null) {
            req.getRequestDispatcher("/admin/editUser.jsp").forward(req, resp);
        } else if (id.isEmpty()) {
            req.setAttribute("error", errorIdMessage());
            req.getRequestDispatcher("/admin/editUser.jsp").forward(req, resp);
        } else {
            User userById = usersDao.getUserById(Integer.valueOf(id));
            if (userById != null) {
                req.setAttribute("user", userById);
            }
            resp.sendRedirect("userslist");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null) {
            req.getRequestDispatcher("/admin/editUser.jsp").forward(req, resp);
        } else if (id.isEmpty()) {
            req.setAttribute("error", errorIdMessage());
            req.getRequestDispatcher("/admin/editUser.jsp").forward(req, resp);
        } else {
            User userById = usersDao.getUserById(Integer.valueOf(id));
            if (userById != null) {
                usersDao.deleteUserById(Integer.valueOf(id));
            }
            req.getRequestDispatcher("/admin/editUser.jsp").forward(req, resp);
        }
    }
}
