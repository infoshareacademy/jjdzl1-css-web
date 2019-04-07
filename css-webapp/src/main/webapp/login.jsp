<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">

    <!-- Head -->
    <jsp:include page="include/head.jsp">
        <jsp:param name="title" value="Log in"></jsp:param>
    </jsp:include>

  <body>
  <wrapper class="d-flex flex-column">

    <!-- Navigation -->
      <c:choose>
          <c:when test="${sessionScope.username != null && sessionScope.usertype == 0}">
              <jsp:include page="include/unav.jsp"></jsp:include>
          </c:when>
          <c:when test="${sessionScope.username != null && sessionScope.usertype == 1}">
              <jsp:include page="include/anav.jsp"></jsp:include>
          </c:when>
          <c:otherwise>
              <jsp:include page="include/nav.jsp"></jsp:include>
          </c:otherwise>
      </c:choose>

    <!-- Page Content -->
    <main class="container-fluid py-3 flex-fill">
      <div class="container">

      <c:choose>
          <c:when test="${sessionScope.username != null}">
              <jsp:include page="include/logged.jsp"></jsp:include>
          </c:when>
          <c:otherwise>
              <jsp:include page="include/login.jsp"></jsp:include>
          </c:otherwise>
      </c:choose>

      </div>
      <!-- /.container -->
    </main>
    
    <!-- Footer -->
    <jsp:include page="include/footer.jsp"></jsp:include>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </wrapper>
  </body>

</html>
