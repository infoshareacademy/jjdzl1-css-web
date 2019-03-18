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
</div>

