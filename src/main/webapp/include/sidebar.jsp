<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">

        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="profile"><span data-feather="user"></span>Your profile<span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>User panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="changepassword"><span data-feather="lock"></span>Change password</a>
                <a class="nav-link" href="editaddress"><span data-feather="map"></span>Edit address</a>
            </li>
        </ul>

    </div>
</nav>