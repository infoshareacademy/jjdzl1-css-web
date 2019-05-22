<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br class="card border-primary">
${error}
${success}
<h4 class="card-header" align="center">Booking with an identification number ${reservationId} .</h4>
<div class="card-body" align="center">

    <div class="table-responsive">
        <table class="table table-sm table-borderless">
            <tbody>
            <tr>
                <td align="left">
                    <h4>${car.make} ${car.model} </h4><br>
                    <p style="margin-left: 10%; text-align: left">
                        Year: ${car.year} </br>
                        Mileage: ${car.mileage} km </br>
                        Engine power: ${car.enginePower} hp </br>
                        Fuel source: ${car.fuelSource}</br>
                        Transmission: ${car.transmission}</br>
                        Body type: ${car.bodyType}</br>
                        Color: ${car.color}</br>
                        Seats: ${car.seats}
                    </p>
                </td>
                <td><img src="${car.imagePath}" height="200" width="300"></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<h4 class="card-header" align="left">Customer</h4>
<div align="left">
    <div>
        <p style="margin-left: 5%; text-align: left">
            First name: ${user.firstName}</br>
            Last name: ${user.lastName} </br>
            Email: ${user.email}</br>
            Phone number: ${user.phoneNumber}</br>
        </p>
    </div>
</div>
<h4 class="card-header" align="left">Reservation</h4>
<div align="left">
    <p style="margin-left: 5%; text-align: left">
        Starting day: ${startDate}</br>
        Ending day: ${endDate}</br>
        Rental days : ${period} day</br>
        Price per day : ${price} PLN / day</br>
        The total cost of : ${cost} PLN</br>
    </p>
    <br>
</div>
<form method="get" action="reservationPdf">
    <button class="btn btn-success" type="submit" style="margin-left: 5%">Download PDF</button>
    <input type="hidden" name="startDate" value="${startDate}"/>
    <input type="hidden" name="endDate" value="${endDate}"/>
    <input type="hidden" name="carId" value="${car.id}">
    <input type="hidden" name="userId" value="${user.id}">
    <input type="hidden" name="period" value="${period}">
    <input type="hidden" name="price" value="${price}">
    <input type="hidden" name="cost" value="${cost}">
    <input type="hidden" name="reservationId" value="${reservationId}">

</form>
<br>
</div>



