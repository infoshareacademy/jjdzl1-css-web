<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">

        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="admin.jsp"><span data-feather="home"></span>Admin Home <span
                        class="sr-only">(current)</span></a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Users panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="userslist"><span data-feather="users"></span>Users list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="deleteuser"><span data-feather="user-x"></span>Delete user</a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Cars panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="addCar.jsp"><span data-feather="plus"></span>Add car</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="carlist"><span data-feather="list"></span>List of cars</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="carPanel.jsp"><span data-feather="list"></span>Car Panel</a>
            </li>

        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Reservation panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="getReservationListByUserId.jsp"><span data-feather="list">

                </span>List of reservations for the user</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="getListReservation"><span data-feather="list"></span>List of reservations</a>
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