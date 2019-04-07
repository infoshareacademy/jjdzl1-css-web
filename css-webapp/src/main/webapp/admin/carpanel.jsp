<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">

<!-- Head -->
<jsp:include page="include/head.jsp">
    <jsp:param name="title" value="Admin"></jsp:param>
</jsp:include>

<body>
<wrapper class="d-flex flex-column">

    <!-- Navigation -->
    <jsp:include page="include/anav.jsp"></jsp:include>

    <!-- Sidebar -->
    <jsp:include page="include/sidebar.jsp"></jsp:include>

    <!-- Page Content -->
    <main class="flex-fill col-md-10 ml-sm-auto py-3">
        <div class="container">

            <jsp:include page="include/carpanel.jsp"></jsp:include>

        </div>
        <!-- /.container -->
    </main>

    <!-- Footer -->
    <jsp:include page="include/footer.jsp"></jsp:include>

    <!-- Bootstrap core JavaScript -->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    <script>feather.replace()</script>

</wrapper>
</body>

</html>