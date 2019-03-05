<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">


<!-- Head -->
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Index"></jsp:param>
</jsp:include>

<body>
<wrapper class="d-flex flex-column">

    <!-- Navigation -->
    <jsp:include page="anav.jsp"></jsp:include>

    <!-- Page Content -->
    <main class="container-fluid py-3 flex-fill">
        <div class="container">

            <jsp:include page="/include/placeholder.jsp"></jsp:include>


            <form method="get" action="listCar">
                <h2 align="center">Car list</h2>
                <input type="submit" value="POBIERZ" align="center"><br/>


                <table>

                    <div align="center">
                        <table border="1" cellpadding="5" align="center">
                            <tr>
                                <th>ID</th>
                                <th>TYPE</th>
                                <th>MAKE</th>
                                <th>MODEL</th>
                                <th>YEAR</th>
                                <th>MILEAGE</th>
                                <th>POWER</th>
                                <th>FULE</th>
                                <th>TRANSMISSION</th>
                                <th>BODY TYPE</th>
                                <th>COLOR</th>
                                <th>SEATS</th>
                            </tr>

                            <c:forEach var="car" items="carList">

                                <tr>
                                    <td>${car}</td>
                                    <td>${car.type}</td>
                                    <td>${car.make}</td>
                                    <td>${car.model}</td>
                                    <td>${car.year}</td>

                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </table>
            </form>

        </div>

        </div>


    </main>

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</wrapper>
</body>

</html>

