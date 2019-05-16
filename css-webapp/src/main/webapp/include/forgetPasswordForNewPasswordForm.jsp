<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card border-primary">
    <h4 class="card-header">Change your password</h4>
    <div class="card-body">
        ${incorrectTypeOfPassword}
        ${notTheSamePassword}
        <form method="post" action="resetPassword">
            <div class="form-group px-3">
                <label for="inputpassword">New password</label>
                <p class="card-text"><small class="text-muted">Password requires at least 8 characters with one digit, big letter and special character</small></p>
                <input type="password" class="form-control" name="password1" id="inputpassword" required>
                <span toggle="#inputpassword" class="field-icon far fa-eye input-password"></span>
            </div>
            <div class="form-group px-3">
                <label for="inputpassword2">Confirm new password</label>
                <input type="password" class="form-control" name="password2" id="inputpassword2" required>
                <span toggle="#inputpassword2" class="field-icon far fa-eye input-password"></span>
            </div>
            <div class="form-group px-3">
                <button type="submit" class="btn btn-primary">Change password</button>
            </div>
        </form>
    </div>
</div>