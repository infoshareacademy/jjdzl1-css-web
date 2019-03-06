<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <h2>Check car in database</h2>
            <form method="get" action="deleteCar">
                Choose id: <input type="text" name="id">
                <button class="btn btn-info" type="submit">Check</button><br/>
                Car id: <%=request.getAttribute("id")%><br/>
                Make: <%=request.getAttribute("make")%><br/>
                Model: <%=request.getAttribute("model")%><br/>
                Year: <%=request.getAttribute("year")%><br/>
            </form>

        <br/>
        <h2>Delete car from database</h2>
            <form method="post" action="deleteCar">
            Choose id: <input type="text" name="id">
            <button class="btn btn-danger" type="submit">Delete</button>
            </form>