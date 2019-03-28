<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row my-4">
    <div class="col-lg-12">
        <h2>Our cars</h2>

        ${error}
        ${emptyData}

        <c:forEach var="car" items="${carExampleList}">
        <table class="table table-striped">
            <tr>
                <th style="text-align: center; vertical-align: middle;">Photo</th>
                <th style="text-align: center; vertical-align: middle;">Make</th>
                <th style="text-align: center; vertical-align: middle;">Model</th>
                <th style="text-align: center; vertical-align: middle;">Year</th>
                <th style="text-align: center; vertical-align: middle;">Fuel source</th>
                <th style="text-align: center; vertical-align: middle;">Engine power</th>
                <th style="text-align: center; vertical-align: middle;">Transmission</th>
            </tr>
            <tr>
                <td style="text-align: center; vertical-align: middle;"><img src="${car.photoLink}" height=150
                                                                             width=225></td>
                <td style="text-align: center; vertical-align: middle;">${car.make}</td>
                <td style="text-align: center; vertical-align: middle;">${car.model}</td>
                <td style="text-align: center; vertical-align: middle;">${car.year}</td>
                <td style="text-align: center; vertical-align: middle;">${car.fuelSource}</td>
                <td style="text-align: center; vertical-align: middle;">${car.enginePower}</td>
                <td style="text-align: center; vertical-align: middle;">${car.transmission}</td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <div class="alert alert-primary" role="alert">
            Do you want to reserve one of those cars? <a href="login" class="alert-link">Log in here</a>
        </div>

    </div>
</div>