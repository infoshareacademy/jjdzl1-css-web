<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="delete">
        <h2>List of reservations for the current user</h2>
    </form>
    <br/>
    <table class="table table-sm table-striped">
        <tr>
            <th style="text-align: center; vertical-align: middle;">Photo</th>

            <th style="text-align: center; vertical-align: middle;">Make</th>
            <th style="text-align: center; vertical-align: middle;">Model</th>
            <th style="text-align: center; vertical-align: middle;">Fuel source</th>
            <th style="text-align: center; vertical-align: middle;">Power</th>
            <th style="text-align: center; vertical-align: middle;">Transmission</th>
            <th style="text-align: center; vertical-align: middle;">Start date</th>
            <th style="text-align: center; vertical-align: middle;">End date</th>
            <th style="text-align: center; vertical-align: middle;">Delete</th>
        </tr>

        <c:forEach var="reservation" items="${reservationByUserId}">
            <tr>
                <td style="text-align: center; vertical-align: middle;"><img src="${reservation.car.photoLink}" height=150 width=225></td>
                <td style="text-align: center; vertical-align: middle;">${reservation.car.make}</td>
                <td style="text-align: center; vertical-align: middle;">${reservation.car.model}</td>
                <td style="text-align: center; vertical-align: middle;">${reservation.car.fuelSource}</td>
                <td style="text-align: center; vertical-align: middle;">${reservation.car.enginePower}</td>
                <td style="text-align: center; vertical-align: middle;">${reservation.car.transmission}</td>
                <td style="text-align: center; vertical-align: middle;">${reservation.startDate}</td>
                <td style="text-align: center; vertical-align: middle;">${reservation.endDate}</td>
                <td style="text-align: center; vertical-align: middle;">
                    <form method="post" action="delete">
                        <input type="hidden" name="id" value="${reservation.reservation_id}">
                        <button class="btn btn-danger" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    ${error}
    ${success}
</div>