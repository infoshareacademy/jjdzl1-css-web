<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        ${error}
        ${emptyData}
        ${activationError}
        ${expired}
        ${changePassword}
        <div class="card card-signin my-3">
            <div class="card-body">
                <h5 class="card-title text-center">Sign In</h5>
                <form class="form-signin" action="login" method="post">
                    <div class="form-label-group">
                        <input type="text" name="username" id="inputLogin" class="form-control" placeholder="Username" required autofocus>
                        <label for="inputLogin">Login</label>
                    </div>
                    <div class="form-label-group">
                        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                        <label for="inputPassword">Password</label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
            <div class="alert alert-info mx-3" role="alert">
                Don't have an account? <a href="register" class="alert-link">Sign up here</a>
            </div>
            <div class="alert alert-info mx-3" role="alert">
                <a href="forgetPasswordForEmailForm.jsp" class="alert-link"> Don't remember your password?</a>
            </div>
        </div>
    </div>
</div>