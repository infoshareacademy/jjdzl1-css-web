package com.infoshare.academy.servlets;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.*;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;



@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {

    @EJB
    private UsersRepositoryDao usersDao;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);

        String newPassword = req.getParameter("password1");
        String confirmPassword = req.getParameter("password2");

        User user = getUserFromAttribute(req);
        Integer id = user.getId();

        Boolean isPasswordCorrect = new UserValidator().isPasswordCorrect(newPassword);
        Boolean isTheSame = newPassword.equals(confirmPassword);

        if(isTheSame && isPasswordCorrect){
            hashAndUpdatePassword(newPassword, id);
            RequestResponseLogin(req,resp,"changePassword", ForgotPasswordMessages.changedPassword());

        }
        else if(!isPasswordCorrect) {
            RequestResponse(req, resp, "incorrectTypeOfPassword", RegistrationMessages.passwordIncorrectMessage());

        }else{
            RequestResponse(req, resp, "notTheSamePassword", RegistrationMessages.passwordNotMatchMessage());
        }
    }

    private void hashAndUpdatePassword(String newPassword, Integer id) {
        String hashedPassword = UserPasswordUtils.hash(newPassword, PasswordHashAlgorithm.PBKDF2);
        usersDao.updateUserPassword(id,hashedPassword);
    }

    private User getUserFromAttribute(HttpServletRequest req) {
        return (User) req.getSession().getAttribute("USER");
    }

    private void RequestResponse(HttpServletRequest request, HttpServletResponse response, String errorMessage, String jspError) throws ServletException, IOException {
        request.setAttribute(errorMessage, jspError);
        RequestDispatcher req = request.getRequestDispatcher("forgetPasswordForNewPasswordForm.jsp");
        req.forward(request, response);
    }
    private void RequestResponseLogin(HttpServletRequest request, HttpServletResponse response, String errorMessage, String jspError) throws ServletException, IOException {
        request.setAttribute(errorMessage, jspError);
        RequestDispatcher req = request.getRequestDispatcher("login.jsp");
        req.forward(request, response);
    }

}
