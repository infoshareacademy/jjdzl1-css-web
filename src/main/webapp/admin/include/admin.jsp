<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card-deck">
    <div class="card bg-light mb-3" style="max-width: 18rem;">
        <div class="card-header"><span data-feather="users"></span> User panel</div>
        <div class="card-body text-center">
            <a href="users" class="btn btn-secondary btn-lg mb-3">User list</a>
            <a href="deleteuser" class="btn btn-secondary btn-lg mb-3">Delete user</a>
        </div>
    </div>

    <div class="card bg-light mb-3" style="max-width: 18rem;">
        <div class="card-header"><span data-feather="truck"></span> Car panel</div>
        <div class="card-body text-center">
            <a href="cars" class="btn btn-secondary btn-lg mb-3">Car list</a>
            <a href="carPanel.jsp" class="btn btn-secondary btn-lg mb-3">Edit car</a>
            <a href="addCar.jsp" class="btn btn-secondary btn-lg mb-3">Add car</a>
        </div>
    </div>

    <div class="card bg-light mb-3" style="max-width: 18rem;">
        <div class="card-header"><span data-feather="list"></span> Reservation panel</div>
        <div class="card-body text-center">
            <a href="getReservationListByUserId.jsp" class="btn btn-secondary btn-lg mb-3">Reservation list</a>
            <a href="listReservation.jsp" class="btn btn-secondary btn-lg mb-3">All reservations</a>
            <a href="addReservation.jsp" class="btn btn-secondary btn-lg mb-3">Add reservation</a>
            <a href="deleteReservation.jsp" class="btn btn-secondary btn-lg mb-3">Delete reservation</a>
        </div>
    </div>
</div>