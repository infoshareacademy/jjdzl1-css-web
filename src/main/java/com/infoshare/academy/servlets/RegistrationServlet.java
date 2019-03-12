package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthOfDate = request.getParameter("birthOfDate");
        String city = request.getParameter("city");
        String streetAddress = request.getParameter("streetAddress");
        String postalCode = request.getParameter("postalCode");

        User user = new User (0,login,password,email,Long.parseLong(phoneNumber),firstName,
                lastName, usersRepositoryDao.convertDateOfBirthFromFormulaToClassPole(birthOfDate),streetAddress,postalCode,city);

        usersRepositoryDao.addUser(user);

    }
}
