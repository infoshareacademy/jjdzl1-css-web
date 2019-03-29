package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.*;

import javax.ejb.EJB;
import javax.mail.MessagingException;
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
        Boolean isEmailCorrect = new UserValidator().isEmailCorrect(email);
        Boolean isAdult = new UserValidator().isAdult(birthOfDate);
        Boolean isBeforePresentDay = new UserValidator().isBeforePresentDate(birthOfDate);

        if (!isBeforePresentDay) {
            RequestResponse(request, response, "IncorrectDateOfBirth", incorrectDateOfBirth());
        } else if (!isPasswordCorrect && isAdult) {
            RequestResponse(request, response, "error", passwordIncorrectAndTooYoungMessage());
        } else if (!isPasswordCorrect) {
            RequestResponse(request, response, "passwordError", passwordIncorrectMessage());
        } else if (!isEmailCorrect) {
            RequestResponse(request, response, "emailError", incorrectEmail());
        } else if (isAdult) {
            RequestResponse(request, response, "tooYoungError", tooYoungMessage());
        } else {

            String hashedPassword = UserPasswordUtils.hash(password, PasswordHashAlgorithm.PBKDF2);

            User user = new User(0, login, hashedPassword, email, Long.parseLong(phoneNumber), firstName,
                    lastName, LocalDate.parse(birthOfDate),
                    streetAddress, postalCode, city);

            User tempUserByLogin = usersRepositoryDao.getUserByLogin(login);
            User tempUserByEmail = usersRepositoryDao.getUserByEmail(email);

            if (tempUserByEmail != null && tempUserByLogin != null) {
                RequestResponse(request, response, "loginAndEmailIsUnavailableError", loginAndEmailIsUnavailable());
            } else if (tempUserByEmail != null) {
                RequestResponse(request, response, "unavailableEmailError", unavailableEmail());
            } else if (tempUserByLogin != null) {
                RequestResponse(request, response, "unavailableLoginError", unavailableLogin());
            } else {
                createUser(request, response, user);
            }
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        setUUIDAndActivationStatusForNewUser(user);
        usersRepositoryDao.addUser(user);
        try {
            usersRepositoryDao.sendEmailToNewUser(user.getLogin(), user.getEmail(), user.getAuthorizationNumber());
            response.sendRedirect("afterRegistration.jsp");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void RequestResponse(HttpServletRequest request, HttpServletResponse response, String errorMessage, String jspError) throws ServletException, IOException {
        request.setAttribute(errorMessage, jspError);
        RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
        req.forward(request, response);
    }

    private void setUUIDAndActivationStatusForNewUser(User user) {
        UUIDGeneratorForNewUser generator = new UUIDGeneratorForNewUser();
        user.setAuthorizationNumber(generator.getGeneratedNewUUIDForNewUser());
        user.setAccountActive(false);
    }
}
