<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Edit personal information</h2>
${error}

<div class="table-responsive bg-light shadow-sm rounded">

    <form method="post" action="editinfo">
        <div class="form-group px-3">
            <label for="firstName">First name</label>
            <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First name" value="${currentUser.firstName}" required>
            <div class="invalid-feedback">
                Valid first name is required
            </div>
        </div>
        <div class="form-group px-3">
            <label for="lastName">Last name</label>
            <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Last name" value="${currentUser.lastName}" required>
            <div class="invalid-feedback">
                Valid last name is required
            </div>
        </div>
    <div class="form-group px-3">
        <label for="phoneNumber">Phone number</label>
        <input class="form-control form-control-sm" type="number" name="phoneNumber" id="phoneNumber" value="${currentUser.phoneNumber}" required/>
    </div>
    <div class="form-group px-3">
        <label for="birthDate">Birth date</label>
        <input class="form-control form-control-sm" type="date" name="birthDate" id="birthDate" value="${currentUser.birthDate}" required/>
    </div>
        <button type="submit" class="btn btn-primary">Change personal info</button>
    </form>

</div>