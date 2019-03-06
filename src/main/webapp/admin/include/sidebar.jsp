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
                <a class="nav-link" href="#"><span data-feather="users"></span>Users list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><span data-feather="user-x"></span>Delete user</a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Cars panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="listCar.jsp"><span data-feather="list"></span>Cars list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addCar.jsp"><span data-feather="plus"></span>Add car</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="updateCarMileage.jsp"><span data-feather="upload"></span>Update car</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="deleteCar.jsp"><span data-feather="delete"></span>Delete car</a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Reservation panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="getReservationListByUserId.jsp"><span data-feather="list">

                </span>Reservation list for user</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="listReservation.jsp"><span data-feather="list"></span>All reservations </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href=""><span data-feather="plus"></span> // Add reservation //</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href=""><span data-feather="upload"></span>// Update reservation //</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href=""><span data-feather="delete"></span>// Delete reservation //</a>
            </li>
        </ul>

    </div>
</nav>