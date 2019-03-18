<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card-deck">
    <div class="card bg-light mb-3" style="max-width: 18rem;">
        <div class="card-header"><span data-feather="users"></span> Users panel</div>
        <div class="card-body text-center">
            <a href="userslist" class="btn btn-secondary btn-lg mb-3">Users list</a>
            <a href="deleteuser" class="btn btn-secondary btn-lg mb-3">Delete user</a>
        </div>
    </div>

    <div class="card bg-light mb-3" style="max-width: 18rem;">
        <div class="card-header"><span data-feather="truck"></span> Cars panel</div>
        <div class="card-body text-center">
            <a href="carlist" class="btn btn-secondary btn-lg mb-3">Cars list</a>
            <a href="addCar.jsp" class="btn btn-secondary btn-lg mb-3">Add car</a>
            <a href="updateCarMileage.jsp" class="btn btn-secondary btn-lg mb-3">Update mileage</a>
            <a href="deleteCar.jsp" class="btn btn-secondary btn-lg mb-3">Delete car</a>
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