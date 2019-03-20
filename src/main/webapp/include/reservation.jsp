<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="reservation">
        <h3>List of cars available from ${startDate} to ${endDate}</h3>
        Choose starting date: <input type="date" name="startDate" required>
        Choose ending date: <input type="date" name="endDate" required>
        <button class="btn btn-primary" type="submit">Load list</button>
        ${error}
        <br/><br/>

        <table class="table table-striped">
        <tr>
            <th style="text-align: center; vertical-align: middle;">Photo</th>
            <th style="text-align: center; vertical-align: middle;">Car id</th>
            <th style="text-align: center; vertical-align: middle;">Make</th>
            <th style="text-align: center; vertical-align: middle;">Model</th>
            <th style="text-align: center; vertical-align: middle;">Year</th>
            <th style="text-align: center; vertical-align: middle;">Fuel source</th>
        </tr>

        <c:forEach var="car" items="${carListAvailableCar}">
            <tr>
                <td><c:choose>
                    <c:when test="${car.id==1}"><img src="img/1.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==2}"><img src="img/2.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==3}"><img src="img/3.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==4}"><img src="img/4.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==5}"><img src="img/5.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==6}"><img src="img/6.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==7}"><img src="img/7.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==8}"><img src="img/8.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==9}"><img src="img/9.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==10}"><img src="img/10.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==11}"><img src="img/11.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==12}"><img src="img/12.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==13}"><img src="img/13.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==14}"><img src="img/14.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==15}"><img src="img/15.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==16}"><img src="img/16.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==17}"><img src="img/17.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==18}"><img src="img/18.jpeg" height=150 width=225 ></c:when>
                    <c:when test="${car.id==19}"><img src="img/19.jpeg" height=150 width=225 ></c:when>
                </c:choose>
                </td>
                <td style="text-align: center; vertical-align: middle;">${car.id}</td>
                <td style="text-align: center; vertical-align: middle;">${car.make}</td>
                <td style="text-align: center; vertical-align: middle;">${car.model}</td>
                <td style="text-align: center; vertical-align: middle;">${car.year}</td>
                <td style="text-align: center; vertical-align: middle;">${car.fuelSource}</td>
            </tr>
        </c:forEach>
        <table class="table table-sm table-striped">

        </table>
    </form>
    <div>
        <form method="post" action="reservation">
            <h3>To add a reservation from ${startDate} to ${endDate},</h3>
            <h3>choose the car id </h3>
            <input class="form-control form-control-sm" type="number" name="carId" min="1" required/>

            <input type="hidden" name="startDate" value="${start}"/>
            <input type="hidden" name="endDate" value="${end}"/>
            <br>
            <br>
            ${errorReservation}
            ${success}


            <button class="btn btn-primary" type="submit">Add reservation</button>
        </form>
    </div>
</div>
