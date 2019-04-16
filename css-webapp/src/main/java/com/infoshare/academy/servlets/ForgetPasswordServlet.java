package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.ForgotPasswordMessages;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

import static com.infoshare.academy.utils.RegistrationMessages.incorrectDateOfBirth;

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
        User user = dao.getUserByEmail(email);
        System.out.println(user);
        if(user == null){
            RequestResponse(request, response, "IncorrectEmail", ForgotPasswordMessages.emailIncorrectMessage());
        }

    }
    private void RequestResponse(HttpServletRequest request, HttpServletResponse response, String errorMessage, String jspError) throws ServletException, IOException {
        request.setAttribute(errorMessage, jspError);
        RequestDispatcher req = request.getRequestDispatcher("forgetPasswordForm.jsp");
        req.forward(request, response);
    }
}
