<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Car list</h4>
    <div class="card-body" align="center">
        ${error}
        <table class="table table-responsive table-sm table-striped">
            <thead>
            <tr>
                <th scope="col">Photo</th>
                <th scope="col">Id</th>
                <th scope="col">Type</th>
                <th scope="col">Make</th>
                <th scope="col">Model</th>
                <th scope="col">Year</th>
                <th scope="col">Mileage</th>
                <th scope="col">Engine power</th>
                <th scope="col">Fuel source</th>
                <th scope="col">Transmission</th>
                <th scope="col">Body type</th>
                <th scope="col">Color</th>
                <th scope="col">Seats</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="car" items="${carList}">
                <tr>
                    <td style="vertical-align: middle;"><img src="../${car.imagePath}" height="100" width="150"></td>
                    <td style="vertical-align: middle;">${car.id}</td>
                    <td style="vertical-align: middle;">
                        <c:choose>
                            <c:when test="${car.carType == 1}">
                                Passenger
                            </c:when>
                            <c:when test="${car.carType == 2}">
                                Truck
                            </c:when>
                            <c:otherwise>
                                ${car.carType}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td style="vertical-align: middle;">${car.make}</td>
                    <td style="vertical-align: middle;">${car.model}</td>
                    <td style="vertical-align: middle;">${car.year}</td>
                    <td style="vertical-align: middle;">${car.mileage}</td>
                    <td style="vertical-align: middle;">${car.enginePower}</td>
                    <td style="vertical-align: middle;">${car.fuelSource}</td>
                    <td style="vertical-align: middle;">${car.transmission}</td>
                    <td style="vertical-align: middle;">${car.bodyType}</td>
                    <td style="vertical-align: middle;">${car.color}</td>
                    <td style="vertical-align: middle;">${car.seats}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="my-3" align="center">
    <nav>
        <ul class="pagination">
            <c:if test="${currentPage > 1}">
                <li class="page-item"><a class="page-link" href="cars?currentPage=${currentPage-1}">Previous</a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active"><a class="page-link">
                                ${i} <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="cars?currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link" href="cars?currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>