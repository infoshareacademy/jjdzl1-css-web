<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">

    <!-- Head -->
    <jsp:include page="include/head.jsp">
        <jsp:param name="title" value="Error"></jsp:param>
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

          <div class="col-sm-9 col-md-7 col-lg-5 mx-auto text-center">
          <div class="card text-white bg-danger mb-3">
              <h3 class="card-header">Error ${code}</h3>
              <div class="card-body">
                  <h5 class="card-title">Oops, something went wrong!</h5>
                  <p class="text-danger">${type}</p>
                  <p class="text-danger">${message}</p>
                  <div class="text-center">
                      <button class="btn btn-warning" type="button" onclick="history.back();">Go back</button>
                  </div>
              </div>
          </div>
          </div>

      </div>
      <!-- /.container -->
    </main>

    <!-- Footer -->
    <jsp:include page="include/footer.jsp"></jsp:include>

  </wrapper>
  </body>

</html>
