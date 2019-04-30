<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Search for users</h4>
    <div class="card-body" align="center">
        <form method="get" action="users">
            <div class="input-group">
                <input type="text" name="name" class="form-control" placeholder="Login/Email">
                <span class="input-group-btn mx-2">
					<button class="btn btn-primary" type="submit">Search</button>
                </span>
            </div>
        </form>
    </div>
</div>

<div class="card border-primary my-3">
    <h4 class="card-header">User list</h4>
    <div class="card-body" align="center">
        <div class="table-responsive">
        <table class="table table-sm table-striped">
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
                <th scope="col">Status</th>
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
                    <td>
                        <c:choose>
                            <c:when test="${user.isAccountActive eq true}">
                                <span data-feather="check-circle" title="Active" data-toggle="tooltip" data-placement="top" title="Active"></span>
                            </c:when>
                            <c:otherwise>
                                <span data-feather="x-circle" title="Disabled" data-toggle="tooltip" data-placement="top" title="Disabled"></span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <form method="get" action="edituser">
                            <input type="hidden" name="login" value="${user.login}">
                            <button class="btn btn-primary btn-sm" type="submit">Edit</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>

<div class="my-3" align="center">
    <nav>
        <ul class="pagination">
            <c:if test="${currentPage > 1}">
                <li class="page-item"><a class="page-link" href="users?currentPage=${currentPage-1}">Previous</a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active"><a class="page-link">
                                ${i} <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="users?currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link" href="users?currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>