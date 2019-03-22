<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div align="center">

    <form method="get" action="listAvailableCar">
        <h2>Check available cars</h2>
        Choose starting date: <input type="date" name="startDate" required>
        Choose ending date: <input type="date" name="endDate" required>
        <button class="btn btn-primary" type="submit">Load list</button>
        ${error}
        <br/><br/>
        <input type = "hidden" name = "currentPage" value = "1">

        <table class="table table-striped">
            <tr>
                <th style="text-align: center; vertical-align: middle;">Photo</th>
                <th style="text-align: center; vertical-align: middle;">Car id</th>
                <th style="text-align: center; vertical-align: middle;">Make</th>
                <th style="text-align: center; vertical-align: middle;">Model</th>
                <th style="text-align: center; vertical-align: middle;">Year</th>
                <th style="text-align: center; vertical-align: middle;">Fuel source</th>
            </tr>

            <c:forEach var="car" items="${carListAvailableCarLimit}">
                <tr>
                    <td style="text-align: center; vertical-align: middle;"><img src="${car.photoLink}" height=150 width=225 ></td>
                    <td style="text-align: center; vertical-align: middle;">${car.id}</td>
                    <td style="text-align: center; vertical-align: middle;">${car.make}</td>
                    <td style="text-align: center; vertical-align: middle;">${car.model}</td>
                    <td style="text-align: center; vertical-align: middle;">${car.year}</td>
                    <td style="text-align: center; vertical-align: middle;">${car.fuelSource}</td>
                </tr>
            </c:forEach>
        </table>
    </form>

</div>

