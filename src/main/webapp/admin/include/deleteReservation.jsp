<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Delete reservation</h4>
    <div class="card-body" align="center">
        <form method="get" action="deleteReservation">
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
        <form method="post" action="deleteReservation">
            <div class="row">
                <div class="col-md-12 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Reservation id</div>
                    </div>
                    <input type="number" name="id" min="1" required>
                    <button class="btn btn-danger mx-2" type="submit">Delete</button>
                </div>
            </div>
        </form>
        ${error}
        ${success}
        <table class="table table-responsive table-sm table-striped">
            <thead>
            <tr>
                <th scope="col">Photo</th>
                <th scope="col">Id reservation</th>
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
            <c:forEach var="reservation" items="${reservationByUserId}">
                <tr>
                    <td style="vertical-align: middle;"><img src="../${reservation.car.photoLink}" height="100" width="150"></td>
                    <td style="vertical-align: middle;">${reservation.reservation_id}</td>
                    <td style="vertical-align: middle;">${reservation.user.id}</td>
                    <td style="vertical-align: middle;">${reservation.user.login}</td>
                    <td style="vertical-align: middle;">${reservation.car.id}</td>
                    <td style="vertical-align: middle;">${reservation.car.make}</td>
                    <td style="vertical-align: middle;">${reservation.car.model}</td>
                    <td style="vertical-align: middle;">${reservation.startDate}</td>
                    <td style="vertical-align: middle;">${reservation.endDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>