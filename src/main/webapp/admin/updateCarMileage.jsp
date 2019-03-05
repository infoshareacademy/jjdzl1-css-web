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


            <form method="get" action="updateCar">
                <h2>Aktualizacja danych samochodu</h2>
                Podaj id samochodu<input type="text" name="id">
                <input type="submit" value="POBIERZ"><br/><%=request.getAttribute("error")%><br/>
                Przebieg samochodu o id : <%=request.getAttribute("id")%>
                wynosi:  <%=request.getAttribute("mileage")%> km
            </form>
            <form method="post" action="updateCar">
                <br/>
                <br/>
                Podaj id samochodu:<input type="text" name="id">
                Podaj aktualny przebieg samochodu:<input type="text" name="mileage">

                <input type="submit" value="ZAPISZ">
                <a href="/admin/admin.jsp"></a>
            </form>
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
