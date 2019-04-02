<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Reservations list</h4>
    <div class="card-body" align="center">
        <form method="get" action="getListReservation">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <input type="text" name="login" class="form-control" placeholder="--LOGIN--">
                </div>
                <div class="form-group col-md-4">
                    <input type="text" name="name" class="form-control" placeholder="--MAKE/MODEL--">
                </div>
                <div class="text-center">
                    <button class="btn btn-primary" type="submit">Search</button>
                    <input type="hidden" name="currentPage" value="1">
                </div>
            </div>
        </form>
    </div>
    ${error}
    <c:if test="${reservationList !=null}">
    <table class="table table-responsive table-sm table-striped">
        <thead>
        <tr>
            <th scope="col">Photo</th>
            <th scope="col">User login</th>
            <th scope="col">Car make</th>
            <th scope="col">Car model</th>
            <th scope="col">Start date</th>
            <th scope="col">End date</th>
            <th scope="col">Action</th>
        </tr>
        </c:if>
        </thead>
        <tbody>
        <c:forEach var="reservation" items="${reservationList}">
            <tr>
                <td style="vertical-align: middle;"><img src="../${reservation.car.photoLink}" height="100"
                                                         width="150"></td>
                <td style="vertical-align: middle;">${reservation.user.login}</td>
                <td style="vertical-align: middle;">${reservation.car.make}</td>
                <td style="vertical-align: middle;">${reservation.car.model}</td>
                <td style="vertical-align: middle;">${reservation.startDate}</td>
                <td style="vertical-align: middle;">${reservation.endDate}</td>
                <td style="vertical-align: middle;">
                    <form method="get" action="editReservation">
                        <input type="hidden" name="id" value="${reservation.reservation_id}">
                        <button class="btn btn-primary" type="submit">Details</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<input type="hidden" name="currentPage" value="1">
<div>
    <div class="my-3" align="center">
        <nav>
            <ul class="pagination">
                <c:if test="${currentPage > 1}">
                    <li class="page-item"><a class="page-link"
                                             href="getListReservation?login=${login}&name=${name}&currentPage=${currentPage-1}">Previous</a>
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
                                                     href="getListReservation?login=${login}&name=${name}&currentPage=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage lt noOfPages}">
                    <li class="page-item"><a class="page-link"
                                             href="getListReservation?login=${login}&name=${name}&currentPage=${currentPage+1}">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>