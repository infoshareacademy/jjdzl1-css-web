<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card-body" align="center">
${error}


<c:if test="${reservations != null}">
    <div class="card border-primary my-3">
        <h4 class="card-header">Edit reservation - ${reservations.reservation_id}</h4>
        <div class="card-body">
            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Login</div>
                    </div>
                    <input type="text" class="form-control" value="${reservations.user.login}" readonly>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Name</div>
                    </div>
                    <input type="text" class="form-control"
                           value="${reservations.user.firstName} ${reservations.user.lastName}" readonly>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Phone number</div>
                    </div>
                    <input type="number" class="form-control" value="${reservations.user.phoneNumber}" readonly>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Email</div>
                    </div>
                    <input type="text" class="form-control" value="${reservations.user.email}" readonly>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Car make</div>
                    </div>
                    <input type="text" class="form-control" value="${reservations.car.make}" readonly>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Car model</div>
                    </div>
                    <input type="text" class="form-control" value="${reservations.car.model}" readonly>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Year</div>
                    </div>
                    <input type="text" class="form-control" value="${reservations.car.year}" readonly>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Fuel source</div>
                    </div>
                    <input type="text" class="form-control" value="${reservations.car.fuelSource}" readonly>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Start date</div>
                    </div>
                    <input type="date" class="form-control" value="${reservations.startDate}" readonly>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">End date</div>
                    </div>
                    <input type="date" class="form-control" value="${reservations.endDate}" readonly>
                </div>
            </div>

            <div class="text-center">
                <button class="btn btn-outline-primary" type="button" onclick="history.back();">Previous page</button>
            </div>

        </div>
    </div>
</c:if>