package com.infoshare.academy.servlets;

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
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.isEmpty() || password.isEmpty() )
        {

            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
            rs.include(request, response);

        }
        else
        {
            RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");
            req.forward(request, response);
        }
    }
}
