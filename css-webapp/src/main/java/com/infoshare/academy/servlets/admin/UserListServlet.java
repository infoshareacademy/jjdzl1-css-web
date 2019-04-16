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
import java.util.List;

@WebServlet("/admin/users")
public class UserListServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");

        if (name == null) {
            List<User> usersList = usersDao.getUsersList();
            req.setAttribute("usersList", usersList);
            req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
        } else {
            List<User> usersList = usersDao.searchUserByLoginOrEmail(name);
            req.setAttribute("usersList", usersList);
            req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
        }
    }
}
