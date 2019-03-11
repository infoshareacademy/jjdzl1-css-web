<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row my-4">
  <div class="col-lg-12">

      ${error}
      ${emptyData}
      <form class="form-signin" action="login" method="post">
          <h1 class="h3 mb-3 font-weight-normal">Please log in</h1>
          <label for="inputLogin" class="sr-only">Login</label>
          <input type="text" name="username" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
      </form>

      <br>
      <div class="alert alert-primary" role="alert">
          You don't have an account? <a href="registration.jsp" class="alert-link">Sign up here</a>
      </div>

  </div>
</div>