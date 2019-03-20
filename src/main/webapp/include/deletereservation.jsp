<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="delete">
        <h2>List of reservations for the current user</h2>
        <button class="btn btn-primary" type="submit">Load list</button>
        <br/><br/>
${error}
        <table class="table table-sm table-striped">
            <tr>
                <th style="text-align: center; vertical-align: middle;">Photo</th>
                <th style="text-align: center; vertical-align: middle;">Id reservation</th>
                <th style="text-align: center; vertical-align: middle;">User id</th>
                <th style="text-align: center; vertical-align: middle;">User login</th>
                <th style="text-align: center; vertical-align: middle;">Car id</th>
                <th style="text-align: center; vertical-align: middle;">Car make</th>
                <th style="text-align: center; vertical-align: middle;">Car model</th>
                <th style="text-align: center; vertical-align: middle;">Start date</th>
                <th style="text-align: center; vertical-align: middle;">End date</th>
            </tr>

            <c:forEach var="reservation" items="${reservationByUserId}">
                <tr>
                    <td><c:choose>
                        <c:when test="${reservation.car.id==1}"><img src="img/1.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==2}"><img src="img/2.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==3}"><img src="img/3.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==4}"><img src="img/4.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==5}"><img src="img/5.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==6}"><img src="img/6.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==7}"><img src="img/7.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==8}"><img src="img/8.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==9}"><img src="img/9.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==10}"><img src="img/10.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==11}"><img src="img/11.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==12}"><img src="img/12.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==13}"><img src="img/13.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==14}"><img src="img/14.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==15}"><img src="img/15.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==16}"><img src="img/16.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==17}"><img src="img/17.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==18}"><img src="img/18.jpeg" height=150 width=225 ></c:when>
                        <c:when test="${reservation.car.id==19}"><img src="img/19.jpeg" height=150 width=225 ></c:when>
                        </c:choose>
                    <td style="text-align: center; vertical-align: middle;">${reservation.reservation_id}</td>
                    <td style="text-align: center; vertical-align: middle;">${reservation.user.id}</td>
                    <td style="text-align: center; vertical-align: middle;">${reservation.user.login}</td>
                    <td style="text-align: center; vertical-align: middle;">${reservation.car.id}</td>
                    <td style="text-align: center; vertical-align: middle;">${reservation.car.make}</td>
                    <td style="text-align: center; vertical-align: middle;">${reservation.car.model}</td>
                    <td style="text-align: center; vertical-align: middle;">${reservation.startDate}</td>
                    <td style="text-align: center; vertical-align: middle;">${reservation.endDate}</td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <form method="post" action="delete">
        Choose reservation id:<input type="number" name="id" min="1" required>
        <button class="btn btn-primary" type="submit">Delete</button>
        ${success}
    </form>
</div>