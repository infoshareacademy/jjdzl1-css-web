 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 ${IncorrectEmail}
 ${MailWithTokenSend}
 <div class="row my-4">
    <div class="col-md-6 offset-3 text-center">
        <form class="form-signin" action="forget-password" method="post">

            <h1 class="h3 mb-3 font-weight-normal">Please write your email to sent you new password:</h1>

            <div class="mb-3">
                <label for="inputemail">Email</label>
                <input type="email" name="email" class="form-control" id="inputemail" placeholder="you@example.com"
                       required>

                <div class="invalid-feedback">
                    Please enter a valid email address
                </div>

            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Confirm Email</button>

        </form>
    </div>
</div>