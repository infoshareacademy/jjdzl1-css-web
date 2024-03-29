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
import java.io.IOException;

import static com.infoshare.academy.utils.RegistrationMessages.activatedMessage;

@WebServlet("/activationAccount")
public class ActivationServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String login = req.getParameter("login");
        String UUIDParam = req.getParameter("UUID");

        User user = dao.getUserByLogin(login);
        String UUIDFromBase = user.getAuthorizationNumber();

        if(UUIDParam.equals(UUIDFromBase)){
            dao.updateIsUserAccountActive(user.getId(),true);
            RequestResponse(req,resp,"Activated!", activatedMessage());
        }else{
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
    private void RequestResponse(HttpServletRequest request, HttpServletResponse response, String errorMessage, String jspError) throws ServletException, IOException {
        request.setAttribute(errorMessage, jspError);
        RequestDispatcher req = request.getRequestDispatcher("login.jsp");
        req.forward(request, response);
    }
}
