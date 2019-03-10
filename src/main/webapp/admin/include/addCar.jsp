<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <form method="post" action="addCar">
        <h2>Add new car to database</h2>
        Car type: <input class="form-control form-control-sm" type="number" name="carType" min="1" max="2" required/>
        Car make: <input class="form-control form-control-sm" type="text" name="make"required/>
        Car model: <input class="form-control form-control-sm" type="text" name="model"required/>
        Year: <input class="form-control form-control-sm" type="number" name="year" min="2005" max="2020" required/>
        Mileage: <input class="form-control form-control-sm" type="number" name="mileage"min="0" max="999999" required/>
        Engine power: <input class="form-control form-control-sm" type="number" name="enginePower"required min="0"/>

        Rodzaj paliwa:<br/>
        <div class="btn-group btn-outline-toggle" data-toggle="buttons">
            <label class="btn btn-outline-secondary">
                <input type="radio" name="fuelSource" value="PETROL" id="fueloption1" autocomplete="off" > Petrol
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="fuelSource" value="PETROLANDGAS" id="fueloption2" autocomplete="off">
                PetrolAndGas
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="fuelSource" value="DIESEL" id="fueloption3" autocomplete="off" checked> Diesel
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="fuelSource" value="CND" id="fueloption4" autocomplete="off"> CNG
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="fuelSource" value="HYBRID" id="fueloption5" autocomplete="off"> Hybdrid
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="fuelSource" value="ELECTRIC" id="fueloption6" autocomplete="off"> Electric
            </label>
        </div>
        <br/>
        Transmission:<br/>
        <div class="btn-group btn-outline-toggle" data-toggle="buttons">
            <label class="btn btn-outline-secondary">
                <input type="radio" name="transmission" value="MANUAL" id="transmissionoption1" autocomplete="off" checked> Manual
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="transmission" value="AUTOMATIC" id="transmissionoption2" autocomplete="off"> Automatic
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="transmission" value="SEMIAUTO" id="transmissionoption3" autocomplete="off"> Semiauto
            </label>
        </div>
        <br/>

        Body type:<br/>
        <div class="btn-group btn-outline-toggle" data-toggle="buttons">
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="CABRIOLET" id="bodyoption1" autocomplete="off"> Cabriolet
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="COUPE" id="bodyoption2" autocomplete="off"> Coupe
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="CROSSOVER" id="bodyoption3" autocomplete="off"> Crossover
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="HATCHBACK" id="bodyoption4" autocomplete="off"> Hatchback
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="ROADSTER" id="bodyoption5" autocomplete="off"> Roadster
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="SEDAN" id="bodyoption6" autocomplete="off" checked> Sedan
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="TOURING" id="bodyoption7" autocomplete="off"> Touring
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="SUV" id="bodyoption8" autocomplete="off"> SUV
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="bodyType" value="MINIVAN" id="bodyoption9" autocomplete="off"> Minivan
            </label>
        </div>
        <br/>

        Color:<br/>
        <div class="btn-group btn-outline-toggle" data-toggle="buttons">
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="BEIGE" id="coloroption1" autocomplete="off"> Beige
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="BLACK" id="coloroption2" autocomplete="off" checked> Black
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="BLUE" id="coloroption3" autocomplete="off"> Blue
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="GOLD" id="coloroption4" autocomplete="off"> Gold
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="GREY" id="coloroption5" autocomplete="off"> Grey
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="RED" id="coloroption6" autocomplete="off"> Red
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="SILVER" id="coloroption7" autocomplete="off"> Silver
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="WHITE" id="coloroption8" autocomplete="off"> White
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="YELLOW" id="coloroption9" autocomplete="off"> Yellow
            </label>
            <label class="btn btn-outline-secondary">
                <input type="radio" name="color" value="OTHER" id="coloroption10" autocomplete="off"> Other
            </label>
        </div>
        <br/>

        Number of seats: <input class="form-control form-control-sm" type="number" name="seats" min="1" max="9" required/><br/>

        <button class="btn btn-primary" type="submit">Add car</button>
    </form>