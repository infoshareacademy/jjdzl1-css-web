package com.infoshare.academy.domain;

import com.infoshare.academy.enums.BodyTypeEnum;
import com.infoshare.academy.enums.ColorEnum;
import com.infoshare.academy.enums.FuelSourceEnum;
import com.infoshare.academy.enums.TransmissionEnum;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;
    @Column(name = "car_type")
    private Integer carType;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Integer year;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "engine_power")
    private Integer enginePower;



    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_source")
    private FuelSourceEnum fuelSource;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission")
    private TransmissionEnum transmission;

    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    private BodyTypeEnum bodyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private ColorEnum color;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "image_path")
    private String imagePath;

    //CarTruck
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "cargo_space")
    private Integer cargoSpace;


    @OneToMany(mappedBy = "car")
    @JsonbTransient
    private List<Reservation> reservations;

    public Car() {
    }

    public Car(Integer carType, String make, String model, Integer year, Integer mileage, Integer enginePower,
               FuelSourceEnum fuelSource, TransmissionEnum transmission, BodyTypeEnum bodyType,
               ColorEnum color, Integer seats, String imagePath) {
        this.carType = carType;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.enginePower = enginePower;
        this.fuelSource = fuelSource;
        this.transmission = transmission;
        this.bodyType = bodyType;
        this.color = color;
        this.seats = seats;
        this.imagePath = imagePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public FuelSourceEnum getFuelSource() {
        return fuelSource;
    }

    public void setFuelSource(FuelSourceEnum fuelSource) {
        this.fuelSource = fuelSource;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public BodyTypeEnum getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyTypeEnum bodyType) {
        this.bodyType = bodyType;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(Integer cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public String getImagePath() { return imagePath;}

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        if (reservations == null) {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
        reservation.setCar(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carType=" + carType +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", enginePower=" + enginePower +
                ", fuelSource=" + fuelSource +
                ", transmission=" + transmission +
                ", bodyType=" + bodyType +
                ", color=" + color +
                ", seats=" + seats +
                ", imagePath=" + imagePath +
                '}';
    }
}