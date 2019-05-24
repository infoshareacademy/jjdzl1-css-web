<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Your reservations</h4>
    <div class="card-body" align="center">
        <input type="hidden" name="currentPage" value="1">
        ${error}
        <c:if test="${reservationByUserId !=null}">
            <div class="table-responsive">
            <table class="table table-sm table-striped">
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
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="reservation" items="${reservationByUserId}">
                    <tr>
                        <td><img src="${reservation.car.imagePath}" height="150" width="225"></td>
                        <td>${reservation.car.make}</td>
                        <td>${reservation.car.model}</td>
                        <td>${reservation.car.fuelSource}</td>
                        <td>${reservation.car.enginePower}</td>
                        <td>${reservation.car.transmission}</td>
                        <td>${reservation.startDate}</td>
                        <td>${reservation.endDate}</td>
                        <td>
                            <form method="get" action="reservationPdf">
                                <button class="btn btn-success" type="submit">Download PDF</button>
                                <input type="hidden" name="startDate" value="${reservation.startDate}"/>
                                <input type="hidden" name="endDate" value="${reservation.endDate}"/>
                                <input type="hidden" name="carId" value="${reservation.car.id}">
                                <input type="hidden" name="userId" value="${reservation.user.id}">
                                <input type="hidden" name="period" value="function">
                                <input type="hidden" name="price" value="function">
                                <input type="hidden" name="cost" value="function">
                                <input type="hidden" name="reservationId" value="${reservation.reservation_id}">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
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