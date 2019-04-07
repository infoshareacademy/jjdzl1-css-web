<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">

        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="listavailablecar.jsp"><span data-feather="list"></span>Reservations <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Reservations panel</span>
        </h6>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="searchcar.jsp"><span data-feather="calendar"></span>Search cars</a>
                <a class="nav-link" href="listavailablecar.jsp"><span data-feather="calendar"></span>Check available cars</a>
                <a class="nav-link" href="reservation.jsp"><span data-feather="plus-square"></span>Add reservation</a>
                <a class="nav-link" href="listReservationCurrentUser"><span data-feather="calendar"></span>Your reservations</a>
                <a class="nav-link" href="delete"><span data-feather="trash-2"></span>Delete reservation</a>
            </li>
        </ul>

    </div>
</nav>