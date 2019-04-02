<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Your reservations</h4>
    <div class="card-body" align="center">
        <input type="hidden" name="currentPage" value="1">
        ${error}
        <c:if test="${reservationByUserId !=null}">
            <table class="table table-responsive table-sm table-striped">
                <thead>
                <tr>
                    <th scope="col">Photo</th>
                    <th scope="col">Make</th>
                    <th scope="col">Model</th>
                    <th scope="col">Fuel source</th>
                    <th scope="col">Power</th>
                    <th scope="col">Transmission</th>
                    <th scope="col">Start date</th>
                    <th scope="col">End date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="reservation" items="${reservationByUserId}">
                    <tr>
                        <td style="vertical-align: middle;"><img src="${reservation.car.photoLink}" height="150" width="225"></td>
                        <td style="vertical-align: middle;">${reservation.car.make}</td>
                        <td style="vertical-align: middle;">${reservation.car.model}</td>
                        <td style="vertical-align: middle;">${reservation.car.fuelSource}</td>
                        <td style="vertical-align: middle;">${reservation.car.enginePower}</td>
                        <td style="vertical-align: middle;">${reservation.car.transmission}</td>
                        <td style="vertical-align: middle;">${reservation.startDate}</td>
                        <td style="vertical-align: middle;">${reservation.endDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
            <nav>
                <ul class="pagination">
                    <c:if test="${currentPage >1}">
                        <li class="page-item"><a class="page-link"
                                                 href="listReservationCurrentUser?currentPage=${currentPage-1}">Previous</a>
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
                                                         href="listReservationCurrentUser?currentPage=${i}">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${currentPage lt noOfPages}">
                        <li class="page-item"><a class="page-link"
                                                 href="listReservationCurrentUser?currentPage=${currentPage+1}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
    </div>
</div>