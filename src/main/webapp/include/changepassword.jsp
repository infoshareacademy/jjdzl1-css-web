<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Change password</h2>
${error}

<div class="table-responsive bg-light shadow-sm rounded">

    <form method="post" action="changepassword">
        <div class="form-group px-3">
            <label for="password1">New password</label>
            <input type="password" class="form-control" name="password1" id="password1">
        </div>
        <div class="form-group px-3">
            <label for="password2">Input new password again</label>
            <input type="password" class="form-control" name="password2" id="password2">
        </div>
        <button type="submit" class="btn btn-primary">Change password</button>
    </form>

</div>