package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.UserValidator;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static com.infoshare.academy.utils.RegistrationMessages.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

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

        Boolean isPasswordCorrect = new UserValidator().isPasswordCorrect(password);
        Boolean isAdult = new UserValidator().isAdult(birthOfDate);
        Boolean isBeforePresentDay = new UserValidator().isBeforePresentDate(birthOfDate);

        if (!isBeforePresentDay) {
            request.setAttribute("IncorrectDateOfBirth", incorrectDateOfBirth());
            RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
            req.forward(request, response);
        } else if (!isPasswordCorrect && isAdult) {
            request.setAttribute("error", passwordIncorrectAndTooYoungMessage());
            RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
            req.forward(request, response);
        } else if (!isPasswordCorrect) {
            request.setAttribute("passwordError", passwordIncorrectMessage());
            RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
            req.forward(request, response);
        } else if (isAdult) {
            request.setAttribute("tooYoungError", tooYoungMessage());
            RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
            req.forward(request, response);
        } else {

            User user = new User(0, login, password, email, Long.parseLong(phoneNumber), firstName,
                    lastName, LocalDate.parse(birthOfDate),
                    streetAddress, postalCode, city);

            User tempUserByLogin = usersRepositoryDao.getUserByLogin(login);
            User tempUserByEmail = usersRepositoryDao.getUserByEmail(email);

            if (tempUserByEmail != null && tempUserByLogin != null) {
                request.setAttribute("loginAndEmailIsUnavailableError", loginAndEmailIsUnavailable());
                RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
                req.forward(request, response);
            } else if (tempUserByEmail != null) {
                request.setAttribute("unavailableEmailError", unavailableEmail());
                RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
                req.forward(request, response);
            } else if (tempUserByLogin != null) {
                request.setAttribute("unavailableLoginError", unavailableLogin());
                RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
                req.forward(request, response);
            } else {
                //usersRepositoryDao.addUser(user);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

}
