<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Edit address</h2>
${error}

<div class="table-responsive bg-light shadow-sm rounded">

    <table class="table table-borderless">
        <thead>
        <tr>
            <th>Current address:</th>
            <td>${currentUser.postalCode} ${currentUser.city}, ${currentUser.streetAddress}</td>
        </tr>
        </thead>
    </table>

    <form method="post" action="editaddress">
        <h5>Input new address:</h5>
        <div class="form-group px-3">
            <label for="postalcode">Postal code</label>
            <input type="text" class="form-control" name="postalCode" id="postalcode" placeholder="Postal code" value="${currentUser.postalCode}">
        </div>
        <div class="form-group px-3">
            <label for="city">City</label>
            <input type="text" class="form-control" name="city" id="city" placeholder="City" value="${currentUser.city}">
        </div>
        <div class="form-group px-3">
            <label for="streetaddress">Street address</label>
            <input type="text" class="form-control" name="streetAddress" id="streetaddress" placeholder="Street address" value="${currentUser.streetAddress}">
        </div>
        <button type="submit" class="btn btn-primary">Change address</button>
    </form>

</div>