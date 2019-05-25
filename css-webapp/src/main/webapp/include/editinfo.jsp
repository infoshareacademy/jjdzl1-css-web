<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card border-primary">
    <h4 class="card-header">Edit your personal information</h4>
    <div class="card-body">
        ${error}
        <form method="post" action="editinfo">
            <div class="form-group px-3">
                <label for="firstName">First name</label>
                <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First name" value="${currentUser.firstName}" pattern=".{1,30}" maxlength="30" title="1 to 30 characters" data-toggle="tooltip" data-placement="top" required>
            </div>
            <div class="form-group px-3">
                <label for="lastName">Last name</label>
                <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Last name" value="${currentUser.lastName}" pattern=".{1,30}" maxlength="30" title="1 to 30 characters" data-toggle="tooltip" data-placement="top" required>
            </div>
            <div class="form-group px-3">
                <label for="phoneNumber">Phone number</label>
                <input type="tel" name="phoneNumber" class="form-control form-control-sm" id="phoneNumber" placeholder="Phone number" pattern="[0-9]{1,11}" maxlength="11" value="${currentUser.phoneNumber}" title="For example: 600700800" data-toggle="tooltip" data-placement="top" required>
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