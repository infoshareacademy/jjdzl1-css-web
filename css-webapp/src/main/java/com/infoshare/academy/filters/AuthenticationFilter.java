package com.infoshare.academy.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.infoshare.academy.utils.RegistrationMessages.anonymousUser;

@WebFilter(filterName = "AuthenticationFilter",
        urlPatterns = {"/profile", "/editaddress", "/changepassword", "/editinfo",
                "/listAvailableCar", "/reservation", "/listReservationCurrentUser", "/delete"})
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("username") != null);

        if (isLoggedIn) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("error", anonymousUser());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
