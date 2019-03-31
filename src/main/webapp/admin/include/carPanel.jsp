<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<div class="card border-primary">
    <h4 class="card-header">Search for cars</h4>
    <div class="card-body">
        ${error}
        ${success}
        <form method="get" action="carPanel">
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
                        <option value="PETROL">Petrol</option>
                        <option value="PETROLANDGAS">Petrol/Gas</option>
                        <option value="DIESEL">Diesel</option>
                        <option value="CNG">CNG</option>
                        <option value="HYBRID">Hybrid</option>
                        <option value="ELECTRIC">Electric</option>
                    </select>
                </div>
            </div>
            <div class="text-center">
                <button class="btn btn-primary" type="submit">Search</button>
                <input type="hidden" name="currentPage" value="1">
            </div>
        </form>
    </div>
</div>

<form method="post" action="carPanel">
<c:forEach var="car" items="${carsList}">
    <div class="card border-primary my-3" align="center">
        <h4 class="card-header" align="center">${car.make} ${car.model} (id: ${car.id})</h4>
        <div class="card-body">

            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <img src="../${car.photoLink}" class="rounded" height="133" width="200">
                    </div>
                    <div class="col-md-4">
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" name="make" value="${car.make}"
                                   placeholder="Make">
                            <div class="input-group-prepend">
                                <div class="input-group-text">Make</div>
                            </div>
                        </div>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" name="model" value="${car.model}"
                                   placeholder="Model">
                            <div class="input-group-prepend">
                                <div class="input-group-text">Model</div>
                            </div>
                        </div>
                        <div class="input-group mb-2">
                            <input type="number" class="form-control" name="year" value="${car.year}"
                                   placeholder="Year">
                            <div class="input-group-prepend">
                                <div class="input-group-text">Year</div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-4">
                        <div class="input-group mb-2">
                            <input type="number" class="form-control" name="mileage" value="${car.mileage}"
                                   placeholder="Mileage">
                            <div class="input-group-prepend">
                                <div class="input-group-text">Mileage (km)</div>
                            </div>
                        </div>
                        <div class="input-group mb-2">
                            <input type="number" class="form-control" name="enginePower"
                                   value="${car.enginePower}"
                                   placeholder="Engine Power">
                            <div class="input-group-prepend">
                                <div class="input-group-text">Engine power (hp)</div>
                            </div>
                        </div>
                        <div class="input-group mb-2">
                            <input type="number" class="form-control" name="seats" value="${car.seats}"
                                   placeholder="Seats">
                            <div class="input-group-prepend">
                                <div class="input-group-text">Seats</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="text-center">
                <input type="hidden" name="id" value="${car.id}">
                <button type="submit" class="btn btn-primary">Update car</button></form>


    <form method="post" action="deleteCar">
        <input type="hidden" name="id" value="${car.id}">
        <button type="submit" class="btn btn-danger" style="float: right;" >Delete car</button>
    </form>
    </div>
</c:forEach>

</div>
</div>



<div align="center">
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
</div>