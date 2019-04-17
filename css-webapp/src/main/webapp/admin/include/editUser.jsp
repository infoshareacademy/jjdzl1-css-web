<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card border-primary">
    <h4 class="card-header">Choose user by login</h4>
    <div class="card-body" align="center">
        ${error}
        <form method="get" action="edituser">
            <div class="input-group">
                <input type="text" name="login" class="form-control" min="1" value="${user.login}" placeholder="Login">
                <span class="input-group-btn mx-2">
					<button class="btn btn-primary" type="submit">Edit</button>
                </span>
            </div>
        </form>
    </div>
</div>

<c:if test="${user.id != null}">
    <div class="card border-primary my-3">
        <h4 class="card-header">Edit user - ${user.login} (id: ${user.id})</h4>
        <div class="card-body">
            <form method="post" action="edituser">
                <input type="hidden" name="id" value="${user.id}">
                <div class="row">
                    <div class="col-md-6 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Login</div>
                        </div>
                        <input type="text" class="form-control" id="login" value="${user.login}" readonly>
                    </div>
                    <div class="col-md-6 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Email</div>
                        </div>
                        <input type="text" class="form-control" id="email" value="${user.email}" readonly>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">First name</div>
                        </div>
                        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First name"
                               value="${user.firstName}" required>
                    </div>
                    <div class="col-md-6 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Last name</div>
                        </div>
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name"
                               value="${user.lastName}" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Phone number</div>
                        </div>
                        <input type="number" class="form-control" name="phoneNumber" id="phoneNumber" min="1000000"
                               value="${user.phoneNumber}" required>
                    </div>
                    <div class="col-md-6 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Birth date</div>
                        </div>
                        <input type="date" class="form-control" name="birthDate" id="birthDate"
                               value="${user.birthDate}" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Postal code</div>
                        </div>
                        <input type="text" class="form-control" name="postalCode" id="postalCode"
                               value="${user.postalCode}">
                    </div>
                    <div class="col-md-4 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">City</div>
                        </div>
                        <input type="text" class="form-control" name="city" id="city" value="${user.city}">
                    </div>
                    <div class="col-md-4 input-group mb-2">
                        <div class="input-group-prepend">
                            <div class="input-group-text">Street address</div>
                        </div>
                        <input type="text" class="form-control" name="streetAddress" id="streetAddress"
                               value="${user.streetAddress}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-form-label mb-2">Status</label>
                    <div class="btn-group btn-outline-toggle" data-toggle="buttons">
                        <label class="btn btn-outline-secondary">
                            <input type="radio" name="isAccountActive" value="true" id="isActive1"
                                   <c:if test="${user.isAccountActive == true}">checked</c:if>> Active
                        </label>
                        <label class="btn btn-outline-secondary">
                            <input type="radio" name="isAccountActive" value="false" id="isActive2"
                                   <c:if test="${user.isAccountActive == false}">checked</c:if>> Disabled
                        </label>
                    </div>
                </div>

                <div class="form-group px-3 text-center">
                    <button type="submit" class="btn btn-primary">Edit user</button>
                </div>
            </form>

            <div class="form-group px-3 text-center">
                <form method="post" action="deleteuser">
                    <input type="hidden" name="id" value="${user.id}">
                    <button class="btn btn-danger" onclick="return confirm('Are you sure?')" type="submit">Delete user
                    </button>
                </form>
            </div>

            <div class="text-center">
                <button class="btn btn-outline-primary" type="button" onclick="history.back();">Previous page</button>
            </div>

        </div>
    </div>
</c:if>