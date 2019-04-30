<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Reservation - check available cars</h4>
    <div class="card-body" align="center">
        ${error}
        ${errorReservation}
        ${success}
        <form method="get" action="reservation">
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
            <div class="table-responsive">
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
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="car" items="${carListAvailableCarLimit}">
                <tr>
                    <td><img src="${car.imagePath}" height="150" width="225"></td>
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.fuelSource}</td>
                    <td>${car.enginePower}</td>
                    <td>${car.transmission}</td>
                    <td>
                        <form method="post" action="reservation">
                            <button class="btn btn-success" type="submit">Add reservation</button>
                            <input type="hidden" name="startDate" value="${start}"/>
                            <input type="hidden" name="endDate" value="${end}"/>
                            <input type="hidden" name="carId" value="${car.id}">
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </table>
            </div>
        </div>
    </div>
</c:if>

<div class="my-3" align="center">
    <nav>
        <ul class="pagination">
            <c:if test="${currentPage >1}">
                <li class="page-item"><a class="page-link"
                                         href="reservation?startDate=${start}&endDate=${end}&currentPage=${currentPage-1}">Previous</a>
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
                        <li class="page-item"><a class="page-link"
                                                 href="reservation?startDate=${start}&endDate=${end}&currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="reservation?startDate=${start}&endDate=${end}&currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
