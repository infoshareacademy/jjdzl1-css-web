package com.infoshare.academy.enums;

public enum FuelSourceEnum {

    PETROL("Bezołowiowa"),
    PETROLANDGAS("LPG"),
    DIESEL("Diesel"),
    CNG("CNG"),
    HYBRID("Hybrydowy"),
    ELECTRIC("Elektryczny");

    private String fuel;

    FuelSourceEnum(String fuel) { this.fuel = fuel; }

    public String getFuel() {
        return fuel;
    }

    public  static FuelSourceEnum getFuelEnum(String fuel) {
        switch (fuel) {
            case "PETROL":
                return PETROL;
            case "PETROLANDGAS":
                return PETROLANDGAS;
            case "DIESEL":
                return DIESEL;
            case "CNG":
                return CNG;
            case "HYBRID":
                return HYBRID;
            case "ELECTRIC":
                return ELECTRIC;
            default:
                throw new IllegalArgumentException("Fuel not recognized");
        }
    }

    public void Messages(String text) {
        this.fuel = text;
    }
}
