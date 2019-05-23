<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                    <p>The CarSharingSystem API is a RESTful web service to obtain information about our
                                        cars and make reservations by clients. Also there is possibility to add, update
                                        and delete cars in database. Check out all functions.
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
                                <div id="http-responses" class="section-block">
                                    <h3 class="block-title">Usual server responses</h3>
                                    <ul>
                                        <li>200 <code>OK</code> - the request was successful;</li>
                                        <li>201 <code>Created</code> - the request was successful and a resource was
                                            created;
                                        </li>
                                        <li>204 <code>No content</code> - the request was successful but there is no
                                            representation to return;
                                        </li>
                                        <li>400 <code>Bad Request</code> - the request could not be understood or
                                            missing required parameters;
                                        </li>
                                        <li>401 <code>Unauthorized</code> - authentication failed;</li>
                                        <li>403 <code>Forbidden</code> - access denied;</li>
                                        <li>404 <code>Not Found</code> - resource was not found;</li>
                                        <li>405 <code>Method Not Allowed</code> - requested method is not supported for
                                            resource.
                                        </li>
                                    </ul>
                                </div><!--//section-block-->
                            </section><!--//doc-section-->

                            <section id="hello-selection" class="doc-section">
                                <h2 class="section-title">HELLO</h2>
                                <div id="hello" class="section-block">
                                    <h3 class="block-title">Hello</h3>
                                    <p>Should return:"Hello from CarSharingSystem!"
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/hello</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div><!--//section-block-->
                                <br>
                            </section>

                            <section id="cars-section" class="doc-section">
                                <h2 class="section-title">CARS</h2>
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
                                    <h3 class="block-title">Add car<span class="small"> (only for admin users)</span>
                                    </h3>
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
                                    <h3 class="block-title">Update car<span class="small"> (only for admin users)</span>
                                    </h3>
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
                                    <h3 class="block-title">Delete car<span class="small"> (only for admin users)</span>
                                    </h3>
                                    <p>There is option to delete the car by ID:
                                    <div class="code-block language-html">
                                        <pre><code>DELETE <span class="uri"></span>${pageContext.request.contextPath}/api/cars/{id}</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div><!--//section-block-->
                            </section><!--//doc-section-->
                            <br>
                            <section id="reservations-section" class="doc-section">
                                <h2 class="section-title">RESERVATIONS</h2>
                                <div id="reservations-list" class="section-block">
                                    <h3 class="block-title">Reservation list<span
                                            class="small"> (only for admin users)</span></h3>
                                    <p>To obtain all resources about reservations use this link:
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/reservations</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div><!--//section-block-->
                                <div id="reservations-id" class="section-block">
                                    <h3 class="block-title">Reservation by ID<span
                                            class="small"> (only for admin users)</span></h3>
                                    <p>With given ID in query param the rest service will return chosen reservation:
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/reservation</code></pre>
                                    </div><!--//code-block-->
                                    Example JSON for get reservation by id :
                                    <div class="code-block language-javascript">
                                      <pre><code>{
    "car": {
        "bodyType": "SUV",
        "carType": 1,
        "color": "BLACK",
        "enginePower": 280,
        "fuelSource": "PETROL",
        "id": 11,
        "imagePath": "img/11.jpeg",
        "make": "Mercedes",
        "mileage": 115000,
        "model": "ML350",
        "seats": 7,
        "transmission": "AUTOMATIC",
        "year": 2016
    },
    "endDate": "2019-04-06",
    "reservation_id": 4,
    "startDate": "2019-04-05",
    "user": {
        "accountActive": true,
        "birthDate": "1985-10-11",
        "city": "Lublin",
        "email": "marek@example.com",
        "firstName": "Marek",
        "id": 2,
        "isAccountActive": true,
        "lastName": "Kowalski",
        "login": "marek",
        "phoneNumber": 691029123,
        "postalCode": "20-155",
        "streetAddress": "Koncertowa 4",
        "userType": 0
    }
}</code></pre>
                                    </div>
                                </div><!--//section-block-->
                                <div id="available-list" class="section-block">
                                    <h3 class="block-title">All available car list</h3>
                                    <p>With given startDate and endDate in query param the rest service will return all
                                        available cars list:
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/availableAllCar</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div><!--//section-block-->

                                <div id="available-list-paging" class="section-block">
                                    <h3 class="block-title">Available car list paging</h3>
                                    <p>With given startDate,endDate,currentPage,pageSize in query param the rest service
                                        will return available cars list:
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/availableCar</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div><!--//section-block-->
                                <div id="reservations-user" class="section-block">
                                    <h3 class="block-title">Reservation for user</h3>
                                    <p>With given ID user, currentPage,pageSize in query param the rest service will
                                        return reservation list for user:
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/reservationUser</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div><!--//section-block-->
                                <div id="reservation-add" class="section-block">
                                    <h3 class="block-title">Add reservation</h3>
                                    <p>With the POST method you can add new reservation with given in form param
                                        userId,carId,startDate,endDate to database with this link:
                                    <div class="code-block language-html">
                                        <pre><code>POST <span class="uri"></span>${pageContext.request.contextPath}/api/reservations</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div><!--//section-block-->
                                <div id="reservation-delete" class="section-block">
                                    <h3 class="block-title">Delete reservation<span class="small"> (only for admin users)</span>
                                    </h3>
                                    <p>There is option to delete the reservation by ID from query param:
                                    <div class="code-block language-html">
                                        <pre><code>DELETE <span class="uri"></span>${pageContext.request.contextPath}/api/reservations</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div><!--//section-block-->
                            </section><!--//doc-section-->
                            <br>
                            <section id="users-section" class="doc-section">
                                <h2 class="section-title">USERS</h2>
                                <div id="users-list" class="section-block">
                                    <h3 class="block-title">User list<span class="small"> (only for admin users)</span>
                                    </h3>
                                    <p>To obtain all resources about users use this link:
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/users</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div>
                                <div id="users-login" class="section-block">
                                    <h3 class="block-title">Get user by login<span
                                            class="small"> (only for admin users)</span></h3>
                                    <p>With given login the rest service will return chosen user:
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/users/login</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div>
                                <div id="users-id" class="section-block">
                                    <h3 class="block-title">Get user by id<span
                                            class="small"> (only for admin users)</span></h3>
                                    <p>With given login the rest service will return chosen user:
                                    <div class="code-block language-html">
                                        <pre><code>GET <span class="uri"></span>${pageContext.request.contextPath}/api/users/id</code></pre>
                                    </div><!--//code-block-->
                                    Example JSON for car update:
                                    <div class="code-block language-javascript">
                                      <pre><code>
   }
    "accountActive": true,
    "birthDate": "1981-01-15",
    "city": "Lublin",
    "email": "darek_giza@op.pl",
    "firstName": "Darek",
    "id": 4,
    "isAccountActive": true,
    "lastName": "Giza",
    "login": "darek",
    "phoneNumber": 772123124,
    "postalCode": "20-121",
    "streetAddress": "Al. Królewska 41",
    "userType": 0
}</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div>
                                <div id="users-delete-id" class="section-block">
                                    <h3 class="block-title">Delete user by id<span
                                            class="small"> (only for admin users)</span>
                                    </h3>
                                    <p>There is option to delete the user by ID:
                                    <div class="code-block language-html">
                                            <pre><code>DELETE <span
                                                    class="uri"></span>${pageContext.request.contextPath}/api/users/id</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div>
                                <div id="users-delete-login" class="section-block">
                                    <h3 class="block-title">Delete user by login<span class="small"> (only for admin users)</span>
                                    </h3>
                                    <p>There is option to delete the user by login:
                                    <div class="code-block language-html">
                                            <pre><code>DELETE <span
                                                    class="uri"></span>${pageContext.request.contextPath}/api/users/login</code></pre>
                                    </div><!--//code-block-->
                                    </p>
                                </div>


                            </section>


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
                                <nav class="doc-sub-menu nav flex-column">
                                    <a class="nav-link scrollto" href="#hello">Hello</a>
                                </nav><!--//nav-->
                                <a class="nav-link scrollto" href="#cars-section">Cars</a>
                                <nav class="doc-sub-menu nav flex-column">
                                    <a class="nav-link scrollto" href="#car-list">Car list</a>
                                    <a class="nav-link scrollto" href="#car-id">Car by ID</a>
                                    <a class="nav-link scrollto" href="#car-add">Add car</a>
                                    <a class="nav-link scrollto" href="#car-update">Update car</a>
                                    <a class="nav-link scrollto" href="#car-delete">Delete car</a>
                                </nav><!--//nav-->
                                <a class="nav-link scrollto" href="#reservations-section">Reservations</a>
                                <nav class="doc-sub-menu nav flex-column">
                                    <a class="nav-link scrollto" href="#reservations-section">Reservations list</a>
                                    <a class="nav-link scrollto" href="#reservations-id">Reservation by ID</a>
                                    <a class="nav-link scrollto" href="#available-list">All available car list</a>
                                    <a class="nav-link scrollto" href="#available-list-paging">Available car list paging</a>
                                    <a class="nav-link scrollto" href="#reservations-user">Reservation for user</a>
                                    <a class="nav-link scrollto" href="#reservation-add">Add reservation</a>
                                    <a class="nav-link scrollto" href="#reservation-delete">Delete reservation</a>
                                    <a class="nav-link scrollto" href="#reservations-section">Reservations</a>
                                    <nav class="doc-sub-menu nav flex-column">
                                        <a class="nav-link scrollto" href="#users-section">Users list</a>
                                        <a class="nav-link scrollto" href="#users-login">Get user by login</a>
                                        <a class="nav-link scrollto" href="#users-id">Get user by id</a>
                                        <a class="nav-link scrollto" href="#users-delete-id">Delete user by id</a>
                                        <a class="nav-link scrollto" href="#users-delete-login">Delete user by login</a>
                                    </nav><!--//nav-->
                                </nav><!--//nav-->
                            </nav><!--//doc-menu-->

                        </div>
                    </div>
                    <!--//doc-sidebar-->

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
