<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="d-flex align-items-center p-3 my-3 text-white-50 bg-primary rounded shadow-sm">
    <div class="lh-100">
        <h5 class="mb-0 text-white lh-100">Admin Dashboard</h5>
    </div>
</div>

<div class="card-deck">
    <div class="card border-primary bg-light mb-3" style="min-width: 14rem;">
        <div class="card-header"><span data-feather="users"></span> User panel</div>
        <div class="card-body text-center">
            <a href="users" class="btn btn-secondary btn-lg mb-3">User list</a><br>
            <a href="edituser" class="btn btn-secondary btn-lg mb-3">Edit user</a>
        </div>
    </div>

    <div class="card border-primary bg-light mb-3" style="min-width: 14rem;">
        <div class="card-header"><span data-feather="truck"></span> Car panel</div>
        <div class="card-body text-center">
            <a href="cars" class="btn btn-secondary btn-lg mb-3">Car list</a><br>
            <a href="carPanel.jsp" class="btn btn-secondary btn-lg mb-3">Edit car</a><br>
            <a href="addCar.jsp" class="btn btn-secondary btn-lg mb-3">Add car</a>
        </div>
    </div>

    <div class="card border-primary bg-light mb-3" style="min-width: 14rem;">
        <div class="card-header"><span data-feather="list"></span> Reservation panel</div>
        <div class="card-body text-center">
            <a href="getReservationListByUserId.jsp" class="btn btn-secondary btn-lg mb-3">Reservation list</a>
            <a href="listReservation.jsp" class="btn btn-secondary btn-lg mb-3">All reservations</a>
            <a href="addReservation.jsp" class="btn btn-secondary btn-lg mb-3">Add reservation</a>
            <a href="deleteReservation.jsp" class="btn btn-secondary btn-lg mb-3">Delete reservation</a>
        </div>
    </div>
</div>