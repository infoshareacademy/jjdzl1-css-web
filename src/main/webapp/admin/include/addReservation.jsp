<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="post" action="addReservation">
    <h2>Add new reservation to database</h2>
    Car id: <input class="form-control form-control-sm" type="number" name="carId" min="1" required/>
    User id: <input class="form-control form-control-sm" type="number" name="userId" min="1" required/>
    Start date: <input class="form-control form-control-sm" type="date" name="startDate" required/>
    End date: <input class="form-control form-control-sm" type="date" name="endDate" required/>
    <br/>
    ${error}
    ${success}
    <br/>
    <button class="btn btn-primary" type="submit">Add reservation</button>
</form>