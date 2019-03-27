<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row my-4">
    <div class="col-md-6 offset-3 text-center">
        ${error}
        ${emptyData}
        ${activationError}
        <form class="form-signin" action="login" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Please log in here</h1>
            <div class="form-group">
                <label for="inputLogin" class="sr-only">Username</label>
                <input type="text" name="username" id="inputLogin" class="form-control" placeholder="Username" required autofocus>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
        </form>
        <br>
        <div class="alert alert-primary" role="alert">
            Don't have an account? <a href="register" class="alert-link">Sign up here</a>
        </div>
    </div>
</div>