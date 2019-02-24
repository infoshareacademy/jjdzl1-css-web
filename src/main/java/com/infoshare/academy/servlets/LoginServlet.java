package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDaoBean;
import com.infoshare.academy.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsersRepositoryDaoBean usersRepositoryDaoBean = new UsersRepositoryDaoBean();
        User user = usersRepositoryDaoBean.getUserByLogin(username);

        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("emptyData", "Username or Password are empty! Please fill all data");
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.include(request, response);

        } else if (usersRepositoryDaoBean.getUserByLogin(username) != null
                && usersRepositoryDaoBean.getUsersPassword(user).equals(password)
                && usersRepositoryDaoBean.getUsersLogin(user).equals(username)) {

            RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
            req.forward(request, response);

        } else {
            request.setAttribute("error", "Data are incorrect! Please try again.");
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
    }
}
