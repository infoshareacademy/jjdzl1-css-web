<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <h2>Check car mileage in database</h2>
            <form method="get" action="updateCar">
                Choose id: <input type="number" name="id" min="0">
                <button class="btn btn-info" type="submit">Check</button><br/>
                Car id:${id}<br/>
                Mileage:${mileage} km<br/>
            </form>

        <br/>
        <h2>Update car mileage in database</h2>
            <form method="post" action="updateCar">
                Choose id: <input type="number" name="id" min="0"><br/>
                Input actual mileage: <input type="number" name="mileage" min="0">
                <button class="btn btn-success" type="submit">Update</button>
            </form>