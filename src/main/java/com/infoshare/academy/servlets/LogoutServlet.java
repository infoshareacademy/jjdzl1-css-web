package com.infoshare.academy.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        RequestDispatcher req = request.getRequestDispatcher("welcome.jsp");

        HttpSession session = request.getSession();
        session.invalidate();

        response.setHeader("Refresh", "3;url=index.jsp");
        req.forward(request, response);
    }
}
