<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card border-primary">
    <h4 class="card-header">Add reservation</h4>
    <div class="card-body">
        ${error}
        ${success}
        <form method="post" action="addReservation">
            <div class="form-group px-3">
                <label for="carId">Car id</label>
                <input type="number" class="form-control form-control-sm" name="carId" id="carId" min="1" required>
            </div>
            <div class="form-group px-3">
                <label for="userId">User id</label>
                <input type="number" class="form-control form-control-sm" name="userId" id="userId" min="1" required>
            </div>
            <div class="form-group px-3">
                <label for="startDate">Start date</label>
                <input type="date" class="form-control form-control-sm" name="startDate" id="startDate" required>
            </div>
            <div class="form-group px-3">
                <label for="endDate">End date</label>
                <input type="date" class="form-control form-control-sm" name="endDate" id="endDate" required>
            </div>
            <div class="form-group px-3">
                <button class="btn btn-primary" type="submit">Add reservation</button>
            </div>
        </form>
    </div>
</div>