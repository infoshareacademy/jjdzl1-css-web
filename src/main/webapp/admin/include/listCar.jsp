<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
            <form method="get" action="listCar">
                <h2>Car list</h2>
                <button class="btn btn-primary" type="submit">Load list</button><br/><br/>

                <table class="table table-striped">
                            <tr>
                                <th>Id</th>
                                <th>Type</th>
                                <th>Make</th>
                                <th>Model</th>
                                <th>Year</th>
                                <th>Mileage</th>
                                <th>Engine power</th>
                                <th>Fuel source</th>
                                <th>Transmission</th>
                                <th>Body type</th>
                                <th>Color</th>
                                <th>Seats</th>
                            </tr>

                            <c:forEach var="car" items="${carList}">
                                <tr>
                                    <td>${car.id}</td>
                                    <td>${car.carType}</td>
                                    <td>${car.make}</td>
                                    <td>${car.model}</td>
                                    <td>${car.year}</td>
                                    <td>${car.mileage}</td>
                                    <td>${car.enginePower}</td>
                                    <td>${car.fuelSource}</td>
                                    <td>${car.transmission}</td>
                                    <td>${car.bodyType}</td>
                                    <td>${car.color}</td>
                                    <td>${car.seats}</td>
                                </tr>
                            </c:forEach>
                </table>
            </form>
</div>