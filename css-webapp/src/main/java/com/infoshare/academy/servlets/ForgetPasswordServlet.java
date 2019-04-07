package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/forget-password")

public class ForgetPasswordServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao dao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        String email = request.getParameter("email");
        System.out.println(email);

    }
}
