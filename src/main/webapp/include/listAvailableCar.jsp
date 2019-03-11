<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="listAvailableCar">
        <h2>List available car</h2>
        Choose startDate:<input type="date" name="startDate" required>
        Choose eddDate:<input type="date" name="endDate" required>
        <button class="btn btn-primary" type="submit">Load list</button>
        ${error}
        <br/><br/>

        <table class="table table-striped">
            <tr>
                <th>Car id</th>
                <th>Car make</th>
                <th>Car model</th>

            </tr>

            <c:forEach var="reservation" items="${reservationListAvailableCar}">
                <tr>

                    <td>${reservation.car.id}</td>
                    <td>${reservation.car.make}</td>
                    <td>${reservation.car.model}</td>


                </tr>
            </c:forEach>
        </table>
    </form>
</div>

