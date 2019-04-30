<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">User reservations</h4>
    <div class="card-body" align="center">
        <form method="get" action="getReservationListByUserId">
            <div class="row">
                <div class="col-md-12 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">User id</div>
                    </div>
                    <input type="number" name="id" min="1" required>
                    <button class="btn btn-primary mx-2" type="submit">Load list</button>
                </div>
            </div>
        </form>
        ${error}
        <div class="table-responsive">
        <table class="table table-sm table-striped">
            <thead>
            <tr>
                <th scope="col">Photo</th>
                <th scope="col">Reservation id</th>
                <th scope="col">User id</th>
                <th scope="col">User login</th>
                <th scope="col">Car id</th>
                <th scope="col">Car make</th>
                <th scope="col">Car model</th>
                <th scope="col">Start date</th>
                <th scope="col">End date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="reservation" items="${reservationListByUserId}">
                <tr>
                    <td><img src="../${reservation.car.imagePath}" height="100" width="150"></td>
                    <td>${reservation.reservation_id}</td>
                    <td>${reservation.user.id}</td>
                    <td>${reservation.user.login}</td>
                    <td>${reservation.car.id}</td>
                    <td>${reservation.car.make}</td>
                    <td>${reservation.car.model}</td>
                    <td>${reservation.startDate}</td>
                    <td>${reservation.endDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>