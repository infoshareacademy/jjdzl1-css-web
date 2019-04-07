<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Heading Row -->
<div class="row my-4">
    <div class="col-lg-6">
        <img class="img-fluid rounded" src="img/car-city.jpg" alt="">
    </div>
    <!-- /.col-lg-8 -->
    <div class="col-lg-6">
        <h1>CarSharingSystem</h1>
        <p>Your login has been successfully registered, check your email and complete the registration process by clicking the link.</p>

        <p>CSS is an application that allows you to rent a car in one of the largest cities in Poland. The car reservation option will ensure the choice of the model according to your preferences - city car, family car, sports car or delivery vehicle.</p>
        <a class="btn btn-primary btn-lg" href="login">Log in</a>
    </div>
    <!-- /.col-md-4 -->
</div>
<!-- /.row -->

<!-- Content Row -->
<div class="row">
    <div class="col-md-4 mb-4">
        <div class="card bg-light h-100">
            <div class="card-body">
                <h2 class="card-title">Reservations</h2>
                <p class="card-text">Choose the car that suits your needs. Don't wait, just check available time and start using one of our vehicles!</p>
            </div>
            <div class="card-footer">
                <a href="listavailablecar.jsp" class="btn btn-primary">Begin now</a>
            </div>
        </div>
    </div>
    <!-- /.col-md-4 -->
    <div class="col-md-4 mb-4">
        <div class="card bg-light h-100">
            <div class="card-body">
                <h2 class="card-title">Pricing</h2>
                <p class="card-text">Every vehicle class has it's own price level per day. If you make reservation for longer period you will get discounts and even can ask our staff for individual offers.  </p>
            </div>
            <div class="card-footer">
                <a href="pricing.jsp" class="btn btn-primary">Learn more</a>
            </div>
        </div>
    </div>
    <!-- /.col-md-4 -->
    <div class="col-md-4 mb-4">
        <div class="card bg-light h-100">
            <div class="card-body">
                <h2 class="card-title">Contact</h2>
                <p class="card-text">If you have any questions, want to talk about our service, insurance or special offers please contact one of our team member.</p>
            </div>
            <div class="card-footer">
                <a href="contact.jsp" class="btn btn-primary">More</a>
            </div>
        </div>
    </div>
    <!-- /.col-md-4 -->

</div>
<!-- /.row -->