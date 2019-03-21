<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="deleteReservation">
        <h2>Reservations list</h2>
        Choose user id: <input type="number" name="id" min="1" required>
        <button class="btn btn-primary" type="submit">Load list</button>
        <br/><br/>
${error}
        <table class="table table-sm table-striped">
            <tr>
                <th style="text-align: center; vertical-align: middle;" >Photo</th>
                <th style="text-align: center; vertical-align: middle;" >Id reservation</th>
                <th style="text-align: center; vertical-align: middle;" >User id</th>
                <th style="text-align: center; vertical-align: middle;" >User login</th>
                <th style="text-align: center; vertical-align: middle;" >Car id</th>
                <th style="text-align: center; vertical-align: middle;" >Car make</th>
                <th style="text-align: center; vertical-align: middle;" >Car model</th>
                <th style="text-align: center; vertical-align: middle;" >Start date</th>
                <th style="text-align: center; vertical-align: middle;" >End date</th>
            </tr>

            <c:forEach var="reservation" items="${reservationByUserId}">
                <tr>
                    <td style="text-align: center; vertical-align: middle;" ><img src="../${reservation.car.photoLink}" height=150 width=225 ></td>
                    <td style="text-align: center; vertical-align: middle;" >${reservation.reservation_id}</td>
                    <td style="text-align: center; vertical-align: middle;" >${reservation.user.id}</td>
                    <td style="text-align: center; vertical-align: middle;" >${reservation.user.login}</td>
                    <td style="text-align: center; vertical-align: middle;" >${reservation.car.id}</td>
                    <td style="text-align: center; vertical-align: middle;" >${reservation.car.make}</td>
                    <td style="text-align: center; vertical-align: middle;" >${reservation.car.model}</td>
                    <td style="text-align: center; vertical-align: middle;" >${reservation.startDate}</td>
                    <td style="text-align: center; vertical-align: middle;" >${reservation.endDate}</td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <form method="post" action="deleteReservation">
        Choose reservation id: <input type="number" name="id" min="1" required>
        <button class="btn btn-primary" type="submit">Delete</button>
        ${success}
    </form>
</div>