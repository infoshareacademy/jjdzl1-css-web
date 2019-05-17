<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">

    <!-- Head -->
    <jsp:include page="include/head.jsp">
        <jsp:param name="title" value="Api"></jsp:param>
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

          <div class="card bg-light border-primary">

              <div id="doc-header" class="doc-header text-center">
                  <h1 class="doc-title"><i class="icon fa fa-car"></i> CarSharingSystem API</h1>
                  <div class="meta"><i class="far fa-clock"></i> Last updated: May 17th, 2019</div>
              </div><!--//doc-header-->

              <div class="doc-body row">
                  <div class="doc-content col-md-9 col-12 order-1">
                      <div class="content-inner">
                          <section id="introduction-section" class="doc-section">
                              <h2 class="section-title">Introduction</h2>
                              <div class="section-block">
                                  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec imperdiet turpis. Curabitur aliquet pulvinar ultrices. Etiam at posuere leo. Proin ultrices ex et dapibus feugiat <a href="#">link example</a> aenean purus leo, faucibus at elit vel, aliquet scelerisque dui. Etiam quis elit euismod, imperdiet augue sit amet, imperdiet odio. Aenean sem erat, hendrerit  eu gravida id, dignissim ut ante. Nam consequat porttitor libero euismod congue.
                                  </p>
                              </div>
                          </section><!--//doc-section-->
                          <section id="http-section" class="doc-section">
                              <h2 class="section-title">Allowed HTTP requests</h2>
                              <div id="step1"  class="section-block">
                                  <h3 class="block-title">Step One</h3>
                                  <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis.
                                  </p>
                                  <div class="code-block">
                                      <h6>Default code example:</h6>
                                      <p><code>bower install &lt;package&gt;</code></p>
                                      <p><code>npm install &lt;package&gt;</code></p>
                                  </div><!--//code-block-->
                              </div><!--//section-block-->
                          </section><!--//doc-section-->

                      </div><!--//content-inner-->
                  </div><!--//doc-content-->

                  <div class="doc-sidebar col-md-3 col-12 order-0 d-none d-md-flex">
                      <div id="doc-nav" class="doc-nav">

                          <nav id="doc-menu" class="nav doc-menu flex-column sticky">
                              <a class="nav-link scrollto" href="#introduction-section">Introduction</a>
                              <a class="nav-link scrollto" href="#http-section">Allowed HTTP requests</a>
                              <nav class="doc-sub-menu nav flex-column">
                                  <a class="nav-link scrollto" href="#step1">Step One</a>
                                  <a class="nav-link scrollto" href="#step2">Step Two</a>
                                  <a class="nav-link scrollto" href="#step3">Step Three</a>
                              </nav><!--//nav-->
                              <a class="nav-link scrollto" href="#cars-section">Cars</a>
                              <nav class="doc-sub-menu nav flex-column">
                                  <a class="nav-link scrollto" href="#car-list">Car list</a>
                                  <a class="nav-link scrollto" href="#car-id">Car by ID</a>
                                  <a class="nav-link scrollto" href="#car-add">Add car</a>
                                  <a class="nav-link scrollto" href="#car-update">Update car</a>
                                  <a class="nav-link scrollto" href="#car-delete">Delete car</a>
                              </nav><!--//nav-->
                          </nav><!--//doc-menu-->

                      </div>
                  </div><!--//doc-sidebar-->

              </div>

      </div>
      <!-- /.container -->
    </main>

    <!-- Footer -->
    <jsp:include page="include/footer.jsp"></jsp:include>

    <!-- Scripts -->
    <script src="vendor/scripts/jquery.scrollTo.min.js"></script>
    <script src="vendor/scripts/stickyfill.min.js"></script>

  </wrapper>
  </body>

</html>
