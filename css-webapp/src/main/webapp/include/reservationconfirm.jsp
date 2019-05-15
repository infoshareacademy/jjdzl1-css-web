<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br class="card border-primary">
<h4 class="card-header" align="center">Reservation</h4>
<div class="card-body" align="center">
    ${error}
    <div class="table-responsive">
        <table class="table table-sm table-striped">
            <tbody>
            <tr>
                <td><img src="${car.imagePath}" height="300" width="450"></td>
                <td>
                    <h4>${car.make} ${car.model} ${car.year}</h4><br>

                    Mileage: ${car.mileage}, </br>
                    Engine power: ${car.enginePower}, </br>
                    Fuel source: ${car.fuelSource}</br>
                    Transmission: ${car.transmission}</br>
                    Body type: ${car.bodyType}</br>
                    Color: ${car.color}</br>
                    Seats: ${car.seats}</td>
            </tr>
            </tbody>
        </table>
        <br>
        <br>
        <h4 class="card-header">Personal data:</h4>
        <div>
            First name: ${user.firstName}</br>
            Last name: ${user.lastName} </br>
            Email: ${user.email}</br>
            Phone number: ${user.phoneNumber}</br>
        </div>

        <br>
        <br>
        <h4 class="card-header">Booking time from:</h4>
        <div>
            <br>
            Starting day: ${startDate}</br>
            Ending day: ${endDate}</br>
            Rental days : ${period} day</br>
            Price per day :
            <c:choose>
                <c:when test="${car.carType == 1}">80</c:when>
                <c:when test="${car.carType == 2}">150</c:when>
                <c:when test="${car.carType == 3}">300</c:when>
            </c:choose>
            PLN / day</br>
            The total cost of :
            <c:choose>
                <c:when test="${car.carType == 1}">${period*80}</c:when>
                <c:when test="${car.carType == 2}">${period*150}</c:when>
                <c:when test="${car.carType == 3}">${period*300}</c:when>
            </c:choose>
            PLN</br>
            <br>
        </div>


        <form method="post" action="reservationconfirm">
            <button class="btn btn-success" type="submit">Confirm reservation</button>
            <input type="hidden" name="startDate" value="${start}"/>
            <input type="hidden" name="endDate" value="${end}"/>
            <input type="hidden" name="carId" value="${car.id}">

        </form>




    </div>
</div>



