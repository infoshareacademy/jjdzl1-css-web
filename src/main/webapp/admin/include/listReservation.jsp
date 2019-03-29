<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Reservations list</h4>
    <div class="card-body" align="center">
        ${error}
        <table class="table table-responsive table-sm table-striped">
            <thead class="thead-light">
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
            <c:forEach var="reservation" items="${reservationList}">
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