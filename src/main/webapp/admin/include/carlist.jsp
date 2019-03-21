<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
            <form method="get" action="listCar">
                <h2>List of cars</h2>
                <br/>
                ${error}
                <br/>

                <table class="table table-sm table-striped">
                            <tr>
                                <th style="text-align: center; vertical-align: middle;" >Photo</th>
                                <th style="text-align: center; vertical-align: middle;" >Id</th>
                                <th style="text-align: center; vertical-align: middle;" >Type</th>
                                <th style="text-align: center; vertical-align: middle;" >Make</th>
                                <th style="text-align: center; vertical-align: middle;" >Model</th>
                                <th style="text-align: center; vertical-align: middle;" >Year</th>
                                <th style="text-align: center; vertical-align: middle;" >Mileage</th>
                                <th style="text-align: center; vertical-align: middle;" >Engine power</th>
                                <th style="text-align: center; vertical-align: middle;" >Fuel source</th>
                                <th style="text-align: center; vertical-align: middle;" >Transmission</th>
                                <th style="text-align: center; vertical-align: middle;" >Body type</th>
                                <th style="text-align: center; vertical-align: middle;" >Color</th>
                                <th style="text-align: center; vertical-align: middle;" >Seats</th>
                            </tr>

                            <c:forEach var="car" items="${carList}">
                                <tr>
                                    <td style="text-align: center; vertical-align: middle;"><img src="../${car.photoLink}" height=150 width=225 ></td>
                                    <td style="text-align: center; vertical-align: middle;">${car.id}</td>
                                    <td style="text-align: center; vertical-align: middle;"><c:choose>
                                        <c:when test="${car.carType == 1}">
                                            Passenger
                                        </c:when>
                                        <c:when test="${car.carType == 2}">
                                            Truck
                                        </c:when>
                                        <c:otherwise>
                                            ${car.carType}
                                        </c:otherwise>
                                    </c:choose></td>
                                    <td style="text-align: center; vertical-align: middle;" >${car.make}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.model}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.year}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.mileage}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.enginePower}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.fuelSource}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.transmission}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.bodyType}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.color}</td>
                                    <td style="text-align: center; vertical-align: middle;">${car.seats}</td>
                                </tr>
                            </c:forEach>
                </table>
            </form>
</div>