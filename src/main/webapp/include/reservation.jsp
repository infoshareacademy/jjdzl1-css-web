<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="reservation">
        <h3>List of cars available from ${startDate} to ${endDate}</h3>
        Choose starting date: <input type="date" name="startDate" required>
        Choose ending date: <input type="date" name="endDate" required>
        <button class="btn btn-primary" type="submit">Load list</button>
        ${error}
        <br/><br/>

        <table class="table table-striped">
        <tr>
            <th style="text-align: center; vertical-align: middle;">Photo</th>
            <th style="text-align: center; vertical-align: middle;">Car id</th>
            <th style="text-align: center; vertical-align: middle;">Make</th>
            <th style="text-align: center; vertical-align: middle;">Model</th>
            <th style="text-align: center; vertical-align: middle;">Year</th>
            <th style="text-align: center; vertical-align: middle;">Fuel source</th>
        </tr>

        <c:forEach var="car" items="${carListAvailableCar}">
            <tr>
                <td style="text-align: center; vertical-align: middle;"><img src="${car.photoLink}" height=150 width=225 ></td>
                <td style="text-align: center; vertical-align: middle;">${car.id}</td>
                <td style="text-align: center; vertical-align: middle;">${car.make}</td>
                <td style="text-align: center; vertical-align: middle;">${car.model}</td>
                <td style="text-align: center; vertical-align: middle;">${car.year}</td>
                <td style="text-align: center; vertical-align: middle;">${car.fuelSource}</td>
            </tr>
        </c:forEach>
        <table class="table table-sm table-striped">

        </table>
    </form>
    <div>
        <form method="post" action="reservation">
            <h3>To add a reservation from ${startDate} to ${endDate},</h3>
            <h3>choose the car id </h3>
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
