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

    private UsersRepositoryDaoBean usersRepositoryDaoBean = new UsersRepositoryDaoBean();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        User tempUser = createUserBasedOnFormLogin(username);

        if (tempUser != null && tempUser.getPassword().equals(password)) {
            RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
            req.forward(request, response);
        } else {
            request.setAttribute("error", errorMessage());
            RequestDispatcher req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
    }

    public User createUserBasedOnFormLogin(String username) {
        return usersRepositoryDaoBean.getUserByLogin(username);
    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Login or password incorrect! Please try again.";
        return html1 + errorData + html2;
    }
}
