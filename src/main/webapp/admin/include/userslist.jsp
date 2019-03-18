<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
            <form method="get" action="userslist">
                <h2>Users list</h2>

                <table class="table table-sm table-striped">
                            <tr>
                                <th>Id</th>
                                <th>User type</th>
                                <th>Login</th>
                                <th>Email</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Phone number</th>
                                <th>Birth date</th>
                                <th>Address</th>
                            </tr>

                            <c:forEach var="user" items="${usersList}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${user.userType == 1}">
                                                ADMIN
                                            </c:when>
                                            <c:otherwise>
                                                USER
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
                                </tr>
                            </c:forEach>
                </table>
            </form>
</div>