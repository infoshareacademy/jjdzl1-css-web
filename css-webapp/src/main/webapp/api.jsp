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
                  <div class="meta"><i class="far fa-clock"></i> Last updated: May 20th, 2019</div>
              </div><!--//doc-header-->

              <div class="doc-body row">
                  <div class="doc-content col-md-9 col-12 order-1">
                      <div class="content-inner">
                          <section id="introduction-section" class="doc-section">
                              <h2 class="section-title">Introduction</h2>
                              <div class="section-block">
                                  <p>The CarSharingSystem API is a RESTful web service to obtain information about our cars and make reservations by clients. Also there is possibility to add, update and delete cars in database. Check out all functions.
                                  </p>
                              </div>
                          </section><!--//doc-section-->

                          <section id="http-section" class="doc-section">
                              <h2 class="section-title">HTTP</h2>
                              <div id="http-methods" class="section-block">
                                  <h3 class="block-title">Allowed HTTPs requests</h3>
                                  <ul>
                                      <li>GET - Get a resource or list of resources;</li>
                                      <li>POST - To create resource;</li>
                                      <li>PUT - Update resource;</li>
                                      <li>DELETE - To delete resource.</li>
                                  </ul>
                              </div><!--//section-block-->
                              <div id="http-responses"  class="section-block">
                                  <h3 class="block-title">Usual server responses</h3>
                                  <ul>
                                      <li>200 <code>OK</code> - the request was successful;</li>
                                      <li>201 <code>Created</code> - the request was successful and a resource was created;</li>
                                      <li>204 <code>No content</code> - the request was successful but there is no representation to return;</li>
                                      <li>400 <code>Bad Request</code> - the request could not be understood or missing required parameters;</li>
                                      <li>401 <code>Unauthorized</code> - authentication failed;</li>
                                      <li>403 <code>Forbidden</code> - access denied;</li>
                                      <li>404 <code>Not Found</code> - resource was not found;</li>
                                      <li>405 <code>Method Not Allowed</code> - requested method is not supported for resource.</li>
                                  </ul>
                              </div><!--//section-block-->
                          </section><!--//doc-section-->

                          <section id="cars-section" class="doc-section">
                              <h2 class="section-title">Cars</h2>
                              <div id="car-list" class="section-block">
                                  <h3 class="block-title">Car list</h3>
                                  <p>To obtain all resources about cars use this link:
                                      <div class="code-block language-html">
                                  <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/cars</code></pre>
                                      </div><!--//code-block-->
                                  </p>
                              </div><!--//section-block-->
                              <div id="car-id" class="section-block">
                                  <h3 class="block-title">Car by ID</h3>
                                  <p>With given ID the rest service will return chosen car:
                                  <div class="code-block language-html">
                                      <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/cars/{id}</code></pre>
                                  </div><!--//code-block-->
                                  </p>
                              </div><!--//section-block-->
                              <div id="car-add" class="section-block">
                                  <h3 class="block-title">Add car</h3>
                                  <p>With the POST method you can add new car to database with this link:
                                  <div class="code-block language-html">
                                      <pre><code>POST <span class="uri"></span>${pageContext.request.contextPath}/api/cars</code></pre>
                                  </div><!--//code-block-->
                                  Example JSON with new car object:
                                  <div class="code-block language-javascript">
                                      <pre><code>{
   "bodyType": "SEDAN",
   "carType": 1,
   "color": "SILVER",
   "enginePower": 210,
   "fuelSource": "DIESEL",
   "make": "Audi",
   "mileage": 60000,
   "model": "A4",
   "seats": 5,
   "transmission": "AUTOMATIC",
   "year": 2015
}</code></pre>
                                  </div><!--//code-block-->
                                  </p>
                              </div><!--//section-block-->
                              <div id="car-update" class="section-block">
                                  <h3 class="block-title">Update car</h3>
                                  <p>With the PUT method you can update the car with proper ID in JSON data:
                                  <div class="code-block language-html">
                                      <pre><code>PUT <span class="uri"></span>${pageContext.request.contextPath}/api/cars</code></pre>
                                  </div><!--//code-block-->
                                  Example JSON for car update:
                                  <div class="code-block language-javascript">
                                      <pre><code>{
   "bodyType": "SEDAN",
   "carType": 1,
   "color": "WHITE",
   "enginePower": 220,
   "fuelSource": "DIESEL",
   "id": 3,
   "make": "BMW",
   "mileage": 70500,
   "model": "E90",
   "seats": 5,
   "transmission": "MANUAL",
   "year": 2011
}</code></pre>
                                  </div><!--//code-block-->
                                  </p>
                              </div><!--//section-block-->
                              <div id="car-delete" class="section-block">
                                  <h3 class="block-title">Delete car</h3>
                                  <p>There is option to delete the car by ID:
                                  <div class="code-block language-html">
                                      <pre><code>DELETE <span class="uri"></span>${pageContext.request.contextPath}/api/cars/{id}</code></pre>
                                  </div><!--//code-block-->
                                  </p>
                              </div><!--//section-block-->
                          </section><!--//doc-section-->

                      </div><!--//content-inner-->
                  </div><!--//doc-content-->

                  <div class="doc-sidebar col-md-3 col-12 order-0 d-none d-md-flex">
                      <div id="doc-nav" class="doc-nav">

                          <nav id="doc-menu" class="nav doc-menu flex-column sticky">
                              <a class="nav-link scrollto" href="#introduction-section">Introduction</a>
                              <a class="nav-link scrollto" href="#http-section">HTTP</a>
                              <nav class="doc-sub-menu nav flex-column">
                                  <a class="nav-link scrollto" href="#http-methods">Allowed HTTPs requests</a>
                                  <a class="nav-link scrollto" href="#http-responses">Usual server responses</a>
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

              </div><!--//doc-card-body-->

          </div><!--//doc-card-->

      </div>
      <!-- /.container -->
    </main>

    <!-- Footer -->
    <jsp:include page="include/footer.jsp"></jsp:include>

    <!-- Scripts -->
    <script src="vendor/scripts/jquery.scrollTo.min.js"></script>
    <script src="vendor/scripts/stickyfill.min.js"></script>
    <script src="vendor/scripts/prism-min.js"></script>
    <script type="text/javascript">
        var divs = document.querySelectorAll(".uri"), i;
        for (i = 0; i < divs.length; ++i) {
            divs[i].innerHTML = window.location.origin;
        }
    </script>

  </wrapper>
  </body>

</html>
