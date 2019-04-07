<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card border-primary">
    <h4 class="card-header">Add new car</h4>
    <div class="card-body">

        <form class="needs-validation" action="addCar" method="post" id="newcar">
            <div class="form-group">
                <label class="col-form-label mb-2">Car type</label>
                <div class="btn-group btn-outline-toggle" data-toggle="buttons">
                    <label class="btn btn-outline-secondary">
                        <input type="radio" name="carType" value="1" id="carType1" autocomplete="off" checked> Passenger
                    </label>
                    <label class="btn btn-outline-secondary">
                        <input type="radio" name="carType" value="2" id="carType2" autocomplete="off"> Truck
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Make</div>
                    </div>
                    <input type="text" class="form-control" name="make" id="make" placeholder="Make" required>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Model</div>
                    </div>
                    <input type="text" class="form-control" name="model" id="model" placeholder="Model" required>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Year</div>
                    </div>
                    <input type="number" class="form-control" name="year" id="year" placeholder="Year" min="1950" max="2100" required>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Mileage (km)</div>
                    </div>
                    <input type="number" class="form-control" name="mileage" id="mileage" placeholder="Mileage" min="0" max="999999" required>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Engine power (hp)</div>
                    </div>
                    <input type="number" class="form-control" name="enginePower" id="enginePower" placeholder="Engine power" min="0" max="2000" required>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Seats number</div>
                    </div>
                    <input type="number" class="form-control" name="seats" id="seats" placeholder="Seats number" min="0" max="100" required>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Fuel source</div>
                    </div>
                    <select class="form-control" id="fuelsource" name="fuelSource">
                        <option value="PETROL">Petrol</option>
                        <option value="PETROLANDGAS">Petrol/Gas</option>
                        <option value="DIESEL">Diesel</option>
                        <option value="CNG">CNG</option>
                        <option value="HYBRID">Hybrid</option>
                        <option value="ELECTRIC">Electric</option>
                    </select>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Transmission</div>
                    </div>
                    <select class="form-control" id="transmission" name="transmission">
                        <option value="MANUAL">Manual</option>
                        <option value="AUTOMATIC">Automatic</option>
                        <option value="SEMIAUTO">Semiauto</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Body type</div>
                    </div>
                    <select class="form-control" id="bodytype" name="bodyType">
                        <option value="CABRIOLET">Cabriolet</option>
                        <option value="COUPE">Coupe</option>
                        <option value="CONVERTIBLE">Convertible</option>
                        <option value="CROSSOVER">Crossover</option>
                        <option value="HATCHBACK">Hatchback</option>
                        <option value="ROADSTER">Roadster</option>
                        <option value="SEDAN">Sedan</option>
                        <option value="TOURING">Touring</option>
                        <option value="SUV">SUV</option>
                        <option value="MINIVAN">Minivan</option>
                        <option value="WAGON">Wagon</option>
                    </select>
                </div>
                <div class="col-md-6 input-group mb-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Color</div>
                    </div>
                    <select class="form-control" id="color" name="color">
                        <option value="BEIGE">Beige</option>
                        <option value="BLACK">Black</option>
                        <option value="BLUE">Blue</option>
                        <option value="GOLD">Gold</option>
                        <option value="GREY">Grey</option>
                        <option value="RED">Red</option>
                        <option value="SILVER">Silver</option>
                        <option value="WHITE">White</option>
                        <option value="YELLOW">Yellow</option>
                        <option value="OTHER">Other</option>
                    </select>
                </div>
            </div>
            <div class="mb-3">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Add car</button>
            </div>
            <div class="text-center">
                <button class="btn btn-outline-primary" type="reset" onclick="window.localStorage.clear();">Clear form</button>
            </div>
        </form>

    </div>
</div>