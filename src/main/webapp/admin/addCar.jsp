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
    <form method="post" action="addCar">
        <h2>Dodawanie nowego samochodu do bazy</h2>
        Typ samochodu:<input type="text" name="carType"><br/><br/>
        Marka samochodu:<input type="text" name="make"/><br/><br/>
        Model samochodu:<input type="text" name="model"/><br/><br/>
        Rok produkcji:<input type="text" name="year"/><br/><br/>
        Przebieg:<input type="text" name="mileage"/><br/><br/>
        Moc silnika:<input type="text" name="enginePower"/><br/><br/>
        Rodzaj paliwa:<br/>
        <div class="btn-group btn-group-toggle" data-toggle="buttons">
            <label class="btn btn-secondary">
                <input type="radio" name="fuelSource" value="PETROL" id="fueloption1" autocomplete="off" checked> PETROL
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="fuelSource" value="PETROLANDGAS" id="fueloption2" autocomplete="off">
                PETROLANDGAS
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="fuelSource" value="DIESEL" id="fueloption3" autocomplete="off"> DIESEL
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="fuelSource" value="CND" id="fueloption4" autocomplete="off"> CNG
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="fuelSource" value="HYBRID" id="fueloption5" autocomplete="off"> HYBRID
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="fuelSource" value="ELECTRIC" id="fueloption6" autocomplete="off"> ELECTRIC
            </label>
        </div>
        <br/>
        Skrzynia biegów<br/>
        <div class="btn-group btn-group-toggle" data-toggle="buttons">
            <label class="btn btn-secondary">
                <input type="radio" name="transmission" value="MANUAL" id="transmisionoption1" autocomplete="off"
                       checked> MANUAL
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="transmission" value="AUTOMATIC" id="transmisionoption1" autocomplete="off"
                       checked> AUTOMATIC
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="transmission" value="SEMIAUTO" id="transmisionoption1" autocomplete="off"
                       checked> SEMIAUTO
            </label>
        </div>
        <br/>
        Typ nadwozia:<br/>
        <div class="btn-group btn-group-toggle" data-toggle="buttons">
            <label class="btn btn-secondary">
                <input type="radio" name="bodyType" value="SEDAN" id="bodyoption1" autocomplete="off" checked> SEDAN
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="bodyType" value="COUPE" id="bodyoption1" autocomplete="off" checked> COUPE
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="bodyType" value="SUV" id="bodyoption1" autocomplete="off" checked> SUV
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="bodyType" value="TOURING" id="bodyoption1" autocomplete="off" checked> TOURING
            </label>
        </div>
        <br/>
        Kolor samochodu:<br/>
        <div class="btn-group btn-group-toggle" data-toggle="buttons">
            <label class="btn btn-secondary">
                <input type="radio" name="color" value="BLACK" id="coloroption1" autocomplete="off" checked> BLACK
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="color" value="RED" id="coloroption1" autocomplete="off" checked> RED
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="color" value="WHITE" id="coloroption1" autocomplete="off" checked> WHITE
            </label>
            <label class="btn btn-secondary">
                <input type="radio" name="color" value="BLACK" id="coloroption1" autocomplete="off" checked> BLUE
            </label>
        </div>
        <br/>
        Ilość miejsc siedząsych:<input type="text" name="seats"/><br/><br/>

        <input type="submit" value="ZAPISZ">
    </form>
</div>

</main>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</wrapper>
</body>

</html>

