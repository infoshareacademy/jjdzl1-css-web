<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-primary">
                <div class="container">
                  <a class="navbar-brand d-none d-md-block" href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/img/css-logo.png" width="35" height="35" class="d-inline-block mr-1" alt=""> CarSharingSystem</a>
                  <a class="navbar-brand d-sm-block d-md-none" href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/img/css-logo.png" width="35" height="35" class="d-inline-block mr-1" alt=""> CSS</a>
                          
                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                          
                  <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                      <li class="nav-item">
                        <a class="nav-link active" id="nav-home" href="${pageContext.request.contextPath}/index.jsp">Start
                          <span class="sr-only">(current)</span>
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" id="nav-login" href="${pageContext.request.contextPath}/login">Log in</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" id="nav-pricing" href="${pageContext.request.contextPath}/pricing.jsp">Pricing</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" id="nav-contact" href="${pageContext.request.contextPath}/contact">Contact</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link text-dark" id="nav-api" href="${pageContext.request.contextPath}/api.jsp">API</a>
                      </li>
                    </ul>
                  </div>
                </div>
        </nav>