<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div align="center">

    <form method="get" action="carPanel">
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
        <input type="hidden" name="currentPage" value="1">
    </form>
    <br/>
    ${error}
    <br/>
</div>

<c:forEach var="car" items="${carsList}">
    <div class="card border-primary" align="center">
    <h4 class="card-header" align="center">${car.make} ${car.model}</h4>
    <div class="card-body">
    <table class="table table-borderless" align="center">
        <thead>

        <tr>
            <img src="../${car.photoLink}" height=100 width=150>
            <td align="center">
                <div class="col-8 my-6">
                    <div class="input-group">
                        <input type="text" class="form-control" value="${car.make}" placeholder="Make">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Make</div>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="col-8 my-6">
                    <div class="input-group">
                        <input type="text" class="form-control" value="${car.model}" placeholder="Model">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Model</div>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="col-8 my-6">
                    <div class="input-group">
                        <input type="text" class="form-control" value="${car.year}" placeholder="Year">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Year</div>
                        </div>

                    </div>
                </div>
            </td>
            <td align="center">
                <div class="col-8 my-6">
                    <div class="input-group">
                        <input type="text" class="form-control" value="${car.mileage}" placeholder="Mileage">
                        <div class="input-group-prepend">
                            <div class="input-group-text">KM</div>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="col-8 my-6">
                    <div class="input-group">
                        <input type="text" class="form-control" value="${car.enginePower}"
                               placeholder="Engine Power">
                        <div class="input-group-prepend">
                            <div class="input-group-text">HP</div>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="col-8 my-6">
                    <div class="input-group">
                        <input type="text" class="form-control" value="${car.seats}" placeholder="Seats">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Seats</div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        </thead>
    </table>
    <div class="form-group px-3">
        <button type="submit" class="btn btn-primary">Update car</button>
        <button type="submit" class="btn btn-danger">Delete car</button>
    </div>
    <div>


</c:forEach>
</div>
</div>
</div>
<br/>
<br/>
<nav>
    <ul class="pagination">
        <c:if test="${currentPage > 1}">
            <li class="page-item"><a class="page-link"
                                     href="carPanel?make=${make}&model=${model}&fuel=${fuel}&currentPage=${currentPage-1}">Previous</a>
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
                                             href="carPanel?make=${make}&model=${model}&fuel=${fuel}&currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="carPanel?make=${make}&model=${model}&fuel=${fuel}&currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>

