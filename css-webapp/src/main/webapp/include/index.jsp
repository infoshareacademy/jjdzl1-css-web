<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Heading Row -->
<div class="row mb-3 mt-2">
    <div class="col-lg-6">
        <img class="img-fluid rounded" src="img/car-city.jpg" alt="">
    </div>
    <!-- /.col-lg-8 -->
    <div class="col-lg-6">
        <h1>CarSharingSystem</h1>
        <hr class="my-1">
        <p>CSS is an application that allows you to rent a car in one of the largest cities in Poland. The car reservation option will ensure the choice of the model according to your preferences - city car, family car, sports car or delivery vehicle.</p>
        <a class="btn btn-primary btn-lg" href="carlist">Try it out!</a>
    </div>
    <!-- /.col-md-4 -->
</div>
<!-- /.row -->

<!-- Content Row -->
<div class="row">
    <div class="col-md-4 mb-2">
        <div class="card bg-dark text-white h-100">
            <div class="card-body">
                <h4 class="card-title">Reservations</h4>
                <p class="card-text">Choose the car that suits your needs. Don't wait, just check available time and start using one of our vehicles!</p>
            </div>
            <div class="card-footer">
                <a href="listAvailableCar.jsp" class="btn btn-primary">Begin now »</a>
            </div>
        </div>
    </div>
    <!-- /.col-md-4 -->
    <div class="col-md-4 mb-2">
        <div class="card bg-dark text-white h-100">
            <div class="card-body">
                <h4 class="card-title">Pricing</h4>
                <p class="card-text">Every vehicle class has it's own price level per day. If you make reservation for longer period you will get discounts and even can ask our staff for individual offers.  </p>
            </div>
            <div class="card-footer">
                <a href="pricing.jsp" class="btn btn-primary">Details »</a>
            </div>
        </div>
    </div>
    <!-- /.col-md-4 -->
    <div class="col-md-4 mb-2">
        <div class="card bg-dark text-white h-100">
            <div class="card-body">
                <h4 class="card-title">Contact</h4>
                <p class="card-text">If you have any questions, want to talk about our service, insurance or special offers please contact one of our team member.</p>
            </div>
            <div class="card-footer">
                <a href="contact.jsp" class="btn btn-primary">More »</a>
            </div>
        </div>
    </div>

</div>
<!-- /.row -->