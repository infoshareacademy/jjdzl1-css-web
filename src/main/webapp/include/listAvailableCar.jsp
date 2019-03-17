<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div align="center">

    <form method="get" action="listAvailableCar">
        <h2>List of cars available from ${startDate} to ${endDate} </h2>
        Choose starting date: <input type="date" name="startDate" required>
        Choose ending date: <input type="date" name="endDate" required>
        <button class="btn btn-primary" type="submit">Load list</button>
        ${error}
        <br/><br/>

        <table class="table table-striped">
            <tr>
                <th>Car id</th>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Fuel source</th>
            </tr>

            <c:forEach var="reservation" items="${reservationListAvailableCar}">
                <tr>
                    <td>${reservation.car.id}</td>
                    <td>${reservation.car.make}</td>
                    <td>${reservation.car.model}</td>
                    <td>${reservation.car.year}</td>
                    <td>${reservation.car.fuelSource}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>

