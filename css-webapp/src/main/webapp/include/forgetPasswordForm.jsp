 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row my-4">
    <div class="col-md-6 offset-3 text-center">
        <form class="form-signin" action="ForgetPassword" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Please write your email to sent you new password:</h1>
            <div class="form-group">
                <label for="inputEmail" class="sr-only">Email</label>
                <input type="text" name="email" id="inputEmail" class="form-control" placeholder="email" required autofocus>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Confirm Email</button>
        </form>
    </div>
</div>