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

            <a href="addCar.jsp"><input type="button" value="Add car"></a>

            <a href="updateCarMileage.jsp"><input type="button" value="Update car mileage"></a>

            <a href="deleteCar.jsp"><input type="button" value="Delete Car"></a>

            <a href="listCar.jsp"><input type="button" value="List Car"></a>

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
