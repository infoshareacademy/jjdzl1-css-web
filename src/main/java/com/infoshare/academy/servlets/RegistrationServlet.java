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
        UserValidator userValidator = new UserValidator();

        if(!isPasswordCorrect && isAdult) {
            request.setAttribute("error", passwordIncorrectAndTooYoungMessage());
            RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
            req.forward(request, response);
        }
        else if (!isPasswordCorrect) {
            request.setAttribute("passwordError", passwordIncorrectMessage());
            RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
            req.forward(request, response);
        }
        else if (isAdult) {
            request.setAttribute("tooYoungError", tooYoungMessage());
            RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
            req.forward(request, response);
        } else {
            User user = new User(0, login, password, email, Long.parseLong(phoneNumber), firstName,
                    lastName, LocalDate.parse(birthOfDate),
                    streetAddress, postalCode, city);
            System.out.println(user);

            if(userValidator.doesExist(login)){
                System.out.println("Error");
            }

            //usersRepositoryDao.addUser(user);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private static String passwordIncorrectMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Password too weak! Use at least 8 characters (one digit, letter and special character)";
        return html1 + errorData + html2;
    }

    private static String tooYoungMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "You are too young to register account!";
        return html1 + errorData + html2;
    }

    private static String passwordIncorrectAndTooYoungMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorDataTooYoung = "You are too young to register account!";
        String html3 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html4 = "</div>";
        String errorDataIncorrectPassword = "Password too weak! Use at least 8 characters (one digit, letter and special character)";
        return html1 + errorDataTooYoung + html2 + html3 + errorDataIncorrectPassword + html4;
    }
}
