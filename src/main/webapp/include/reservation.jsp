<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">

    <form method="get" action="reservation">
        <h2>Check available cars</h2>
        Choose starting date: <input type="date" name="startDate" required>
        Choose ending date: <input type="date" name="endDate" required>
        <button class="btn btn-primary" type="submit">Load list</button>
        ${error}
        <br/><br/>
        <input type = "hidden" name = "currentPage" value = "1">
        <table class="table table-striped">
        <tr>
            <th style="text-align: center; vertical-align: middle;">Photo</th>
            <th style="text-align: center; vertical-align: middle;">Car id</th>
            <th style="text-align: center; vertical-align: middle;">Make</th>
            <th style="text-align: center; vertical-align: middle;">Model</th>
            <th style="text-align: center; vertical-align: middle;">Year</th>
            <th style="text-align: center; vertical-align: middle;">Fuel source</th>
        </tr>

        <c:forEach var="car" items="${carListAvailableCarLimit}">
            <tr>
                <td style="text-align: center; vertical-align: middle;"><img src="${car.photoLink}" height=150 width=225 ></td>
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
            <h4>To add a reservation from ${startDate} to ${endDate},enter the car id </h4>
            <input class="form-control-sm" type="number" name="carId" min="1" required/><button class="btn btn-success" type="submit">Add reservation</button>
            <input type="hidden" name="startDate" value="${start}"/>
            <input type="hidden" name="endDate" value="${end}"/>
            ${errorReservation}
            ${success}

        </form>
    </div>
    <br/>
    <br/>

</div>
<nav>
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
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
