<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
${error}
<h2>Check user in database</h2>
<form method="get" action="deleteuser">
    Choose id: <input type="number" name="id" min="0">
    <button class="btn btn-info" type="submit">Check</button>
    <br/>
    User id: ${user.id}<br/>
    User login: ${user.login}<br/>
    User email: ${user.email}<br/>
</form>
<br/>
<h2>Delete user from database</h2>
<form method="post" action="deleteuser">
    Choose id: <input type="number" name="id" min="0">
    <button class="btn btn-danger" type="submit">Delete</button>
</form>