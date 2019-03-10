<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-primary">
                <div class="container">
                  <a class="navbar-brand" href="../welcome.jsp"><img src="../img/css-logo.png" width="35" height="35" class="d-inline-block mr-1" alt=""> CarSharingSystem</a>
                          
                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                          
                  <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                      <li class="nav-item active">
                        <a class="nav-link" href="../welcome.jsp">Start
                          <span class="sr-only">(current)</span>
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="./../profile">Profile</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link text-dark" href="admin.jsp">Admin Page</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">Reservations</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">Charges</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="../contact.jsp">Contact</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link text-warning" href="../LogoutServlet">Sign out</a>
                      </li>
                    </ul>
                  </div>
                </div>
        </nav>