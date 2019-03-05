<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <h2>Check car mileage in database</h2>
            <form method="get" action="updateCar">
                Choose id: <input type="text" name="id">
                <button class="btn btn-info" type="submit">Check</button><br/>
                Car id: <%=request.getAttribute("id")%><br/>
                Mileage: <%=request.getAttribute("mileage")%> km<br/>
            </form>

        <br/>
        <h2>Update car mileage in database</h2>
            <form method="post" action="updateCar"></form>
                Choose id: <input type="text" name="id"><br/>
                Input actual mileage: <input type="text" name="mileage">
                <button class="btn btn-success" type="submit">Update</button>
            </form>