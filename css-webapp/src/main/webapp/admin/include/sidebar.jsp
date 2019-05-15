<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav id="sidebar" class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">

        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="admin.jsp"><span data-feather="home"></span>Admin <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>User panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="users"><span data-feather="users"></span>User list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="edituser"><span data-feather="user-check"></span>Edit user</a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Car panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="cars"><span data-feather="list"></span>Car list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="carPanel.jsp"><span data-feather="settings"></span>Edit car</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addCar.jsp"><span data-feather="plus"></span>Add car</a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Reservation panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="listReservation.jsp"><span data-feather="list"></span>Reservation list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addReservation.jsp"><span data-feather="plus"></span>Add reservation</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="deleteReservation.jsp"><span data-feather="delete"></span>Delete reservation</a>
            </li>
        </ul>

    </div>
</nav>