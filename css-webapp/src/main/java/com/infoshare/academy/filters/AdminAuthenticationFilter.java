package com.infoshare.academy.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminAuthenticationFilter", urlPatterns = "/admin/*")
public class AdminAuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("username") != null);

        if (isLoggedIn && session.getAttribute("usertype").equals(1)) {
            chain.doFilter(request, response);
        } else {
            String loginURI = httpRequest.getContextPath() + "/login";
            httpResponse.sendRedirect(loginURI);
        }
    }
}
