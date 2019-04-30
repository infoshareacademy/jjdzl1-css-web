<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="my-3" align="center">
<nav>
    <ul class="pagination">
        <c:if test="${currentPage > 1}">
            <li class="page-item"><a class="page-link"
                                     href="listAvailableCar?startDate=${start}&endDate=${end}&currentPage=${currentPage-1}">Previous</a>
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
                                             href="listAvailableCar?startDate=${start}&endDate=${end}&currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="listAvailableCar?startDate=${start}&endDate=${end}&currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>
</div>