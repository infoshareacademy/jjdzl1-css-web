
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="reservation">
        <h2>List of cars available from ${startDate} to ${endDate}</h2>
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
    <div>
        <form method="post" action="reservation">
            <h2>Add new reservation to database</h2>
            Car id: <input class="form-control form-control-sm" type="number" name="carId" min="1"required/>


            Start date: <input class="form-control form-control-sm" type="date" value="${startDate}" name="startDate"required/>
            End date: <input class="form-control form-control-sm" type="date" value="${endDate}" name="endDate"  required/>

            <button class="btn btn-primary" type="submit">Add reservation</button>
        </form>
    </div>
</div>
