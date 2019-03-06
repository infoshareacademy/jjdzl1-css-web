package com.infoshare.academy.enums;


public enum BodyTypeEnum {

    CABRIOLET("Kabriolet"),
    COUPE("Coupe"),
    CONVERTIBLE("Zmienny"),
    CROSSOVER("Crossover"),
    HATCHBACK("Hatchback"),
    ROADSTER("Roadster"),
    SEDAN("Sedan"),
    TOURING("Kombi"),
    SUV("SUV"),
    MINIVAN("Minivan"),
    WAGON("Dostawczy");

    private String type;

    BodyTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static BodyTypeEnum getBodyTypeEnum(String type) {
        switch (type) {
            case "CABRIOLET":
                return CABRIOLET;
            case "COUPE":
                return COUPE;
            case "CONVERTIBLE":
                return CONVERTIBLE;
            case "CROSSOVER":
                return CROSSOVER;
            case "HATCHBACK":
                return HATCHBACK;
            case "ROADSTER":
                return ROADSTER;
            case "SEDAN":
                return SEDAN;
            case "TOURING":
                return TOURING;
            case "SUV":
                return SUV;
            case "MINIVAN":
                return MINIVAN;
            case "WAGON":
                return WAGON;
            default:
                throw new IllegalArgumentException("Type not recognized");
        }

    }

    public void Messages(String text) {
        this.type = text;
    }

}