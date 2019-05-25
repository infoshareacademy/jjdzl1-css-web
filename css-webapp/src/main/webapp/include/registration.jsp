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
            ${termsOfUse}
            <form class="needs-validation" action="register" method="post" id="register">

                <div class="form-group">
                    <label for="inputlogin">Login</label>
                    <input type="text" name="login" class="form-control" id="inputlogin" placeholder="Login" pattern=".{3,30}" maxlength="30" title="3 to 30 characters" data-toggle="tooltip" data-placement="top" required autofocus>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="inputpassword">Password</label>
                        <input type="password" name="password" class="form-control" id="inputpassword" placeholder="Password" required>
                        <span toggle="#inputpassword" class="field-icon far fa-eye input-password"></span>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="inputpassword2">Repeat password</label>
                        <input type="password" name="password2" class="form-control" id="inputpassword2" placeholder="Password" required>
                        <span toggle="#inputpassword2" class="field-icon far fa-eye input-password"></span>
                    </div>
                </div>
                <p class="card-text">
                    <small class="text-muted">Password requires at least 8 characters with one digit, big letter and special character</small>
                </p>

                <div class="mb-3">
                    <label for="inputemail">Email</label>
                    <input type="email" name="email" class="form-control" id="inputemail" placeholder="you@example.com" required>
                    <div class="invalid-feedback">
                        Please enter a valid email address
                    </div>
                </div>

                <div class="mb-3">
                    <label for="phoneNumber">Phone number</label>
                    <input type="tel" name="phoneNumber" class="form-control" id="phoneNumber" placeholder="Phone number" pattern="[0-9]{1,11}" maxlength="11" data-bind="value:inputphonenumber" title="For example: 600700800" data-toggle="tooltip" data-placement="top" required>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">First name</label>
                        <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First name" pattern=".{1,30}" maxlength="30" title="1 to 30 characters" data-toggle="tooltip" data-placement="top" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastName">Last name</label>
                        <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Last name" pattern=".{1,30}" maxlength="30" title="1 to 30 characters" data-toggle="tooltip" data-placement="top" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="birthOfDate">Birth date</label>
                    <input type="date" name="birthOfDate" class="form-control" id="birthOfDate" title="You must be over 18 years old to register account" data-toggle="tooltip" data-placement="top" required>
                </div>

                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="city">City <span class="text-muted">(Address is optional)</span></label>
                        <input type="text" name="city" class="form-control" id="city" placeholder="City">
                    </div>
                    <div class="col-md-4 mb-3">
                        <label for="streetAddress">Street address</label>
                        <input type="text" name="streetAddress" class="form-control" id="streetAddress" placeholder="Street 1">
                    </div>
                    <div class="col-md-3 mb-3">
                        <label for="postalCode">Postal code</label>
                        <input type="text" name="postalCode" class="form-control" id="postalCode" maxlength="6" placeholder="00-000">
                    </div>
                </div>
                    <div class="custom-control custom-checkbox mb-3">
                        <input type="checkbox" class="custom-control-input" name="termsCheckbox" value="termsCheckbox" id="termsCheckbox" required>
                        <label class="custom-control-label" for="termsCheckbox">I agree to CarSharingSystem </label>
                        <u data-toggle="popover" data-html="true" title="Terms of Use"
                           data-content="<h5>Introduction</h5>
			1. The following Terms of Use (ToS) specify the conditions for providing the rental car service of CarSharingSystem (CSS).
			<br/>2. For any additional information not provided in ToS you can contact us at carsharingsystem.help@gmail.com
			<h5>User account</h5>
			1. You must register as a member on the CSS in order to rent a car, to use some services and to enjoy special promotions and activities.
			<br/>2. In accordance with Customs regulations customers must provide valid and accurate data. All consignee names, address and payers name should be valid.
			<br/>3. For safety and security, each customer is allowed to create only one registered account.
			">terms of use</u>
                    </div>
                    <div class="mb-3">
                        <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
                    </div>
                    <div class="text-center">
                        <button class="btn btn-outline-primary mr-3" type="button" onclick="history.back();">Go back</button>
                        <button class="btn btn-outline-primary" type="reset" onclick="window.localStorage.clear();">Clear form</button>
                    </div>
            </form>
        </div>
    </div>
</div>