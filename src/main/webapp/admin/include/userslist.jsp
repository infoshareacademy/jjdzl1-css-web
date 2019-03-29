<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">User list</h4>
    <div class="card-body" align="center">

        <table class="table table-responsive table-sm table-striped">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">User type</th>
                <th scope="col">Login</th>
                <th scope="col">Email</th>
                <th scope="col">First name</th>
                <th scope="col">Last name</th>
                <th scope="col">Phone number</th>
                <th scope="col">Birth date</th>
                <th scope="col">Address</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${usersList}">
                <tr>
                    <td>${user.id}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.userType == 1}">
                                Admin
                            </c:when>
                            <c:otherwise>
                                User
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.birthDate}</td>
                    <td>${user.postalCode} ${user.city}, ${user.streetAddress}</td>
                    <td>
                        <form method="get" action="edituser">
                            <input type="hidden" name="id" value="${user.id}">
                            <button class="btn btn-primary" type="submit">Edit</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>