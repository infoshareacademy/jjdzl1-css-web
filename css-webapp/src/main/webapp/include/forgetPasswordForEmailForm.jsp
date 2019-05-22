<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-8 offset-2">
    <div class="card border-primary">
        <h4 class="card-header">Forgot your password</h4>
        <div class="card-body">
            ${IncorrectEmail}
            ${MailWithTokenSend}
                <form class="needs-validation" action="forget-password" method="post">
                    <h5 class="text-center">Confirm your identity to reset password</h5>
                    <div class="form-group">
                        <label for="inputemail">Email</label>
                        <input type="email" name="email" class="form-control" id="inputemail" placeholder="you@example.com" required>
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary">Continue</button>
                    </div>
                </form>
                <div class="text-center">
                    <button class="btn btn-outline-primary" type="button" onclick="history.back();">Go back</button>
                </div>
        </div>
    </div>
</div>