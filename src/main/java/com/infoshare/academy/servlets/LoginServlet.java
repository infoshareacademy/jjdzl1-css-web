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
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsersRepositoryDaoBean usersRepositoryDaoBean = new UsersRepositoryDaoBean();

        if (username.isEmpty() || password.isEmpty()) {
            out.println("Username or Password are empty! Please fill all data.");
            RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
            req.include(request, response);

        } else if (usersRepositoryDaoBean.getUserByLogin(username) == null) {

            out.println("No such user! Please check login again.");
            RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
            req.forward(request, response);

        } else if (usersRepositoryDaoBean.getUserByLogin(username) != null) {

            User user = new User(username, password, "", "");

            if (usersRepositoryDaoBean.getUsersPassword(user) == password && usersRepositoryDaoBean.getUsersLogin(user) == username) {
                RequestDispatcher req = request.getRequestDispatcher("/welcome.jsp");
                req.forward(request, response);
            } else {
                out.println("Data are incorrect! Please try again.");
                RequestDispatcher req = request.getRequestDispatcher("/login.jsp");
                req.forward(request, response);
            }

        }
    }
}
