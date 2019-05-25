<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card border-primary">
    <h4 class="card-header">Edit your address</h4>
    <div class="card-body">
        ${error}
        <table class="table table-borderless">
            <thead>
            <tr>
                <td>Current address:</td>
                <td>${currentUser.postalCode} ${currentUser.city}, ${currentUser.streetAddress}</td>
            </tr>
            </thead>
        </table>
        <form method="post" action="editaddress">
            <h5>Input new address:</h5>
            <div class="form-group px-3">
                <label for="postalcode">Postal code</label>
                <input type="text" class="form-control" name="postalCode" id="postalcode" placeholder="Postal code" maxlength="6" value="${currentUser.postalCode}">
            </div>
            <div class="form-group px-3">
                <label for="city">City</label>
                <input type="text" class="form-control" name="city" id="city" placeholder="City" value="${currentUser.city}">
            </div>
            <div class="form-group px-3">
                <label for="streetaddress">Street address</label>
                <input type="text" class="form-control" name="streetAddress" id="streetaddress" placeholder="Street address" value="${currentUser.streetAddress}">
            </div>
            <div class="form-group px-3">
            <button type="submit" class="btn btn-primary">Change address</button>
            </div>
        </form>
    </div>
</div>