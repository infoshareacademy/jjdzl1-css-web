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

            <c:forEach var="car" items="${carListAvailableCar}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.fuelSource}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <form method="post" action="reservation">
            <h2>To add a reservation from ${startDate} to ${endDate},</h2>
            <h2>choose the car id </h2>
            <input class="form-control form-control-sm" type="number" name="carId" min="1" required/>

            <input type="hidden" name="startDate" value="${start}"/>
            <input type="hidden" name="endDate" value="${end}"/>
            <br>
            <br>
            ${errorReservation}
            ${success}


            <button class="btn btn-primary" type="submit">Add reservation</button>
        </form>
    </div>
</div>
