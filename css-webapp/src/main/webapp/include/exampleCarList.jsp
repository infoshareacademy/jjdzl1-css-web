<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
        <h4 class="card-header">Our cars</h4>
    <div class="card-body" align="center">

        ${error}
        ${emptyData}

        <div class="table-responsive">
        <table class="table table-sm table-striped">
            <thead>
            <tr>
                <th scope="col">Photo</th>
                <th scope="col">Make</th>
                <th scope="col">Model</th>
                <th scope="col">Year</th>
                <th scope="col">Fuel source</th>
                <th scope="col">Engine power</th>
                <th scope="col">Transmission</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="car" items="${carExampleList}">
            <tr>
                <td><img src="${car.imagePath}" height="75" width="110"></td>
                <td>${car.make}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
                <td>${car.fuelSource}</td>
                <td>${car.enginePower}</td>
                <td>${car.transmission}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
        <br>
        <div class="alert alert-primary" role="alert">
            Do you want to reserve one of those cars? <a href="login" class="alert-link">Log in here</a>
        </div>
    </div>
</div>