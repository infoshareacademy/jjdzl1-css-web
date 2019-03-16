<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Check car in database</h2>
<form method="get" action="deleteCar">
    Choose id: <input type="number" name="id" min="1">
    <button class="btn btn-info" type="submit">Check</button>
    <br/>
    Car id: ${car.id}<br/>
    Make: ${car.make}<br/>
    Model: ${car.model}<br/>
    Year: ${car.year}<br/>
</form>
${error}
<br/>
<h2>Delete car from database</h2>
<form method="post" action="deleteCar">
    Choose id: <input type="number" name="id" min="1">
    <button class="btn btn-danger" type="submit">Delete</button>
</form>