<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-8 offset-2">
    <div class="card border-primary">
        <h4 class="card-header">Register new account</h4>
        <div class="card-body">
            ${error}
            ${passwordError}
            ${passwordNotMatchError}
            ${emailError}
            ${tooYoungError}
            ${unavailableLoginError}
            ${unavailableEmailError}
            ${loginAndEmailIsUnavailableError}
            ${IncorrectDateOfBirth}
            <form class="needs-validation" action="register" method="post" id="register">

                <div class="form-group">
                    <label for="inputlogin">Login</label>
                    <input type="text" name="login" class="form-control" id="inputlogin" placeholder="Login" required
                           autofocus>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="inputpassword">Password</label>
                        <input type="password" name="password" class="form-control" id="inputpassword"
                               placeholder="Password" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputpassword2">Repeat assword</label>
                        <input type="password" name="password2" class="form-control" id="inputpassword2"
                               placeholder="Password" required>
                    </div>
                </div>
                <p class="card-text">
                    <small class="text-muted">Password requires at least 8 characters with one digit, big letter and
                        special character
                    </small>
                </p>

                <div class="mb-3">
                    <label for="inputemail">Email</label>
                    <input type="email" name="email" class="form-control" id="inputemail" placeholder="you@example.com"
                           required>
                    <div class="invalid-feedback">
                        Please enter a valid email address
                    </div>
                </div>

                <div class="mb-3">
                    <label for="phoneNumber">Phone number</label>
                    <input type="number" name="phoneNumber" class="form-control" id="phoneNumber"
                           placeholder="600123999" min="1000000" step="1" data-bind="value:inputphonenumber" required>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">First name</label>
                        <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First name"
                               required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastName">Last name</label>
                        <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Last name"
                               required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="birthOfDate">Birth date</label>
                    <input type="date" name="birthOfDate" class="form-control" id="birthOfDate" required>
                </div>

                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="city">City <span class="text-muted">(Address is optional)</span></label>
                        <input type="text" name="city" class="form-control" id="city" placeholder="">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="streetAddress">Street address</label>
                        <input type="text" name="streetAddress" class="form-control" id="streetAddress" placeholder="">
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="postalCode">Postal code</label>
                        <input type="text" name="postalCode" class="form-control" id="postalCode" placeholder="">
                    </div>
                </div>
                <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
            </form>
        </div>
    </div>
</div>