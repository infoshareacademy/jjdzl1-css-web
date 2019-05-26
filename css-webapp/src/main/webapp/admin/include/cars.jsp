<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Car list</h4>
    <div class="card-body" align="center">
        ${error}
            <div class="table-responsive">
        <table class="table table-sm table-striped">
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
                    <td><img src="../${car.imagePath}" height="100" width="150"></td>
                    <td>${car.id}</td>
                    <td>
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
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.mileage} km</td>
                    <td>${car.enginePower} hp</td>
                    <td>${car.fuelSource}</td>
                    <td>${car.transmission}</td>
                    <td>${car.bodyType}</td>
                    <td>${car.color}</td>
                    <td>${car.seats}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            </div>
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