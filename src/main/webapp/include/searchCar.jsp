<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div align="center">

    <form method="get" action="searchCar">
        <h4>Search car</h4>
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
                    <option value="PETROL">PETROL</option>
                    <option value="DIESEL">DIESEL</option>
                    <option value="ELECTRIC">ELECTRIC</option>
                    <option value="HYBRID">HYBRID</option>
                    <option value="PETROLANDGAS">PETROLANDGAS</option>
                    <option value="CNG">CNG</option>
                </select>
            </div>
        </div>
        <br/>
        <button class="btn btn-primary" type="submit">Search</button>
        <input type = "hidden" name = "currentPage" value = "1">
    </form>
    <br/>
    ${error}
    <br/>
    <c:if test="${carsList !=null}">
    <table class="table table-striped">

        <tr>
            <th style="text-align: center; vertical-align: middle;">Photo</th>
            <th style="text-align: center; vertical-align: middle;">Make</th>
            <th style="text-align: center; vertical-align: middle;">Model</th>
            <th style="text-align: center; vertical-align: middle;">Year</th>
            <th style="text-align: center; vertical-align: middle;">Fuel source</th>
            <th style="text-align: center; vertical-align: middle;">Power</th>
            <th style="text-align: center; vertical-align: middle;">Transmission</th>
        </tr>
        </c:if>
        <c:forEach var="car" items="${carsList}">
            <tr>
                <td style="text-align: center; vertical-align: middle;"><img src="${car.photoLink}" height=150 width=225></td>
                <td style="text-align: center; vertical-align: middle;">${car.make}</td>
                <td style="text-align: center; vertical-align: middle;">${car.model}</td>
                <td style="text-align: center; vertical-align: middle;">${car.year}</td>
                <td style="text-align: center; vertical-align: middle;">${car.fuelSource}</td>
                <td style="text-align: center; vertical-align: middle;">${car.enginePower}</td>
                <td style="text-align: center; vertical-align: middle;">${car.transmission}</td>
            </tr>
        </c:forEach>
    </table>
</div>
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

