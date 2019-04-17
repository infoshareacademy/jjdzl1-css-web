<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card border-primary">
    <h4 class="card-header">Edit your personal information</h4>
    <div class="card-body">
        ${error}
        <form method="post" action="editinfo">
            <div class="form-group px-3">
                <label for="firstName">First name</label>
                <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First name" value="${currentUser.firstName}" required>
            </div>
            <div class="form-group px-3">
                <label for="lastName">Last name</label>
                <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Last name" value="${currentUser.lastName}" required>
            </div>
            <div class="form-group px-3">
                <label for="phoneNumber">Phone number</label>
                <input class="form-control form-control-sm" type="number" name="phoneNumber" id="phoneNumber" placeholder="Phone number" min="1000000" value="${currentUser.phoneNumber}" required/>
            </div>
            <div class="form-group px-3">
                <label for="birthDate">Birth date</label>
                <input class="form-control form-control-sm" type="date" name="birthDate" id="birthDate" value="${currentUser.birthDate}" required/>
            </div>
            <div class="form-group px-3">
                <button type="submit" class="btn btn-primary">Change personal info</button>
            </div>
        </form>
    </div>
</div>