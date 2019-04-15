package com.infoshare.academy.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/login")
public class LoginFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(LoginFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String remoteAddr = request.getRemoteAddr();

        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
            String username = request.getParameter("username");
            LOGGER.info("[LOGIN] Requested login to user: " + username + ", from IP: " + remoteAddr);
        }

        chain.doFilter(request, response);
    }
}
