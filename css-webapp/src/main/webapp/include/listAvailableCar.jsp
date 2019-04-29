<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div class="card border-primary">
    <h4 class="card-header">Check available cars</h4>
    <div class="card-body" align="center">
        ${error}
        <form method="get" action="listAvailableCar">
            <input type="hidden" name="currentPage" value="1">
            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Start date</div>
                    </div>
                    <input type="date" class="form-control" name="startDate" id="startDate" required>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">End date</div>
                    </div>
                    <input type="date" class="form-control" name="endDate" id="endDate" required>
                    <button class="btn btn-primary ml-3" type="submit">Check</button>
                </div>
            </div>
        </form>
    </div>
</div>

<c:if test="${carListAvailableCarLimit != null}">
    <div class="card border-primary my-3">
    <h4 class="card-header">Available cars</h4>
    <div class="card-body" align="center">
        <table class="table table-responsive table-sm table-striped">
            <thead>
            <tr>
                <th scope="col">Photo</th>
                <th scope="col">Make</th>
                <th scope="col">Model</th>
                <th scope="col">Year</th>
                <th scope="col">Fuel source</th>
                <th scope="col">Power</th>
                <th scope="col">Transmission</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="car" items="${carListAvailableCarLimit}">
            <tr>
                <td class="text-center align-middle"><img src="${car.imagePath}" height=150 width=225></td>
                <td class="text-center align-middle">${car.make}</td>
                <td class="text-center align-middle">${car.model}</td>
                <td class="text-center align-middle">${car.year}</td>
                <td class="text-center align-middle">${car.fuelSource}</td>
                <td class="text-center align-middle">${car.enginePower}</td>
                <td class="text-center align-middle">${car.transmission}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    </div>
</c:if>

