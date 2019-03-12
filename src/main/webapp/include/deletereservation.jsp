<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="delete">
        <h2>List of reservations for the current user</h2>
        <button class="btn btn-primary" type="submit">Load list</button>
        <br/><br/>
        ${error}
        <table class="table table-striped">
            <tr>
                <th>Id reservation</th>
                <th>User id</th>
                <th>User login</th>
                <th>Car id</th>
                <th>Car make</th>
                <th>Car model</th>
                <th>Start date</th>
                <th>End date</th>

            </tr>

            <c:forEach var="reservation" items="${reservationByUserId}">
                <tr>
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
        </table>
    </form>
    <form method="post" action="delete">
        Choose reservation id:<input type="number" name="id" min="0" required>
        <button class="btn btn-primary" type="submit">Delete</button>
    </form>
</div>