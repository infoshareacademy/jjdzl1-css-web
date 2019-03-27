<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div align="center">

    <form method="get" action="searchCar">
        <h2>Search car</h2>
        <br/>
        <div class="form-row">
            <div class="form-group col-md-4">
                MAKE:<input type="text" name="make" class="form-control">
            </div>
            <div class="form-group col-md-4">
                MODEL:<input type="text" name="model" class="form-control">
            </div>
            <div class="form-group col-md-4">
                FUEL:<select id="inputState" class="form-control" name="fuel">
                    <option selected value="">fuel...</option>
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
    </form>
        <br/>
        ${error}
        <br/>
        <input type = "hidden" name = "currentPage" value = "1">

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

            <c:forEach var="car" items="${carsList}">
                <tr>
                    <td style="text-align: center; vertical-align: middle;"><img src="${car.photoLink}" height=150 width=225 ></td>
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

