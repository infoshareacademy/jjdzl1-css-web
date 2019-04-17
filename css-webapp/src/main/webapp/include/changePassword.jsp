<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card border-primary">
    <h4 class="card-header">Change your password</h4>
    <div class="card-body">
        ${error}
        <form method="post" action="changepassword">
            <div class="form-group px-3">
                <label for="password">Current password</label>
                <input type="password" class="form-control" name="password" id="password" required>
            </div>
            <div class="form-group px-3">
                <label for="inputpassword">New password</label>
                <p class="card-text">
                    <small class="text-muted">Password requires at least 8 characters with one digit, big letter and
                        special character
                    </small>
                </p>
                <input type="password" class="form-control" name="password1" id="inputpassword" required>
            </div>
            <div class="form-group px-3">
                <label for="inputpassword2">Confirm new password</label>
                <input type="password" class="form-control" name="password2" id="inputpassword2" required>
            </div>
            <div class="form-group px-3">
                <button type="submit" class="btn btn-primary">Change password</button>
            </div>
        </form>
    </div>
</div>