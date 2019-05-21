package com.infoshare.academy.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static javax.servlet.RequestDispatcher.*;

@WebServlet("/error")
public class ErrorHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object code = req.getAttribute(ERROR_STATUS_CODE);
        Object type = req.getAttribute(ERROR_EXCEPTION_TYPE);
        Object message = req.getAttribute(ERROR_MESSAGE);

        req.setAttribute("code", code);
        req.setAttribute("type", type);
        req.setAttribute("message", message);

        req.getRequestDispatcher("error.jsp").forward(req, resp);
    }
}
