<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card border-primary">
    <h4 class="card-header">Your profile</h4>
    <div class="card-body">
        <table class="table table-borderless">
            <tbody>
            <tr>
                <th>Login:</th>
                <td>${currentUser.login}</td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>${currentUser.email}</td>
            </tr>
            <tr>
                <th>First name:</th>
                <td>${currentUser.firstName}</td>
            </tr>
            <tr>
                <th>Last name:</th>
                <td>${currentUser.lastName}</td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>${currentUser.phoneNumber}</td>
            </tr>
            <tr>
                <th>Birth date:</th>
                <td>${currentUser.birthDate}</td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>${currentUser.postalCode} ${currentUser.city}, ${currentUser.streetAddress}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>