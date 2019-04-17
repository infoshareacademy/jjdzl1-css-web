<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div class="card border-primary">
    <h4 class="card-header">Search for cars</h4>
    <div class="card-body">
        ${error}
        <form method="get" action="searchCar">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <input type="text" name="make" class="form-control" placeholder="--MAKE--">
                </div>
                <div class="form-group col-md-4">
                    <input type="text" name="model" class="form-control" placeholder="--MODEL--">
                </div>
                <div class="form-group col-md-4">
                    <select id="inputState" class="form-control" name="fuel">
                        <option selected value="">--FUEL--</option>
                        <option value="PETROL">Petrol</option>
                        <option value="PETROLANDGAS">Petrol/Gas</option>
                        <option value="DIESEL">Diesel</option>
                        <option value="CNG">CNG</option>
                        <option value="HYBRID">Hybrid</option>
                        <option value="ELECTRIC">Electric</option>
                    </select>
                </div>
            </div>
            <div class="text-center">
                <button class="btn btn-primary" type="submit">Search</button>
                <input type="hidden" name="currentPage" value="1">
            </div>
        </form>
    </div>
</div>

<c:if test="${carsList != null}">
    <div class="card border-primary my-3">
        <h4 class="card-header">Car list</h4>
        <div class="card-body" align="center">
            <table class="table table-responsive table-sm table-striped">
                <thead>
                <tr>
                    <th scope="col">Photo</th>
                    <th scope="col">Make</th>
                    <th scope="col">Model</th>
                    <th scope="col">Year</th>
                    <th scope="col">Engine power</th>
                    <th scope="col">Fuel source</th>
                    <th scope="col">Transmission</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="car" items="${carsList}">
                <tr>
                    <td style="vertical-align: middle;"><img src="${car.imagePath}" height="150" width="225"></td>
                    <td style="vertical-align: middle;">${car.make}</td>
                    <td style="vertical-align: middle;">${car.model}</td>
                    <td style="vertical-align: middle;">${car.year}</td>
                    <td style="vertical-align: middle;">${car.enginePower}</td>
                    <td style="vertical-align: middle;">${car.fuelSource}</td>
                    <td style="vertical-align: middle;">${car.transmission}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</c:if>

<div class="my-3" align="center">
    <nav>
        <ul class="pagination">
            <c:if test="${currentPage > 1}">
                <li class="page-item"><a class="page-link"
                                         href="searchCar?make=${make}&model=${model}&fuel=${fuel}&currentPage=${currentPage-1}">Previous</a>
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
                                                 href="searchCar?make=${make}&model=${model}&fuel=${fuel}&currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="searchCar?make=${make}&model=${model}&fuel=${fuel}&currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
