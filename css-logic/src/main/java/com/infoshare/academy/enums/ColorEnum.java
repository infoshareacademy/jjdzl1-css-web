package com.infoshare.academy.enums;

public enum ColorEnum {

    BEIGE("Beżowy"),
    BLACK("Czarny"),
    BLUE("Niebieski"),
    GOLD("Złoty"),
    GREY("Szary"),
    RED("Czerwony"),
    SILVER("Srebrny"),
    WHITE("Biały"),
    YELLOW("Żółty"),
    OTHER("Inny");

    private String color;

    ColorEnum(String color) { this.color = color; }

    public String getColor() { return color; }

    public static ColorEnum getColorEnum(String color) {
        switch (color) {
            case "BEIGE":
                return BEIGE;
            case "BLACK":
                return BLACK;
            case "BLUE":
                return BLUE;
            case "RED":
                return RED;
            case "GOLD":
                return GOLD;
            case "SILVER":
                return SILVER;
            case "GREY":
                return GREY;
            case "WHITE":
                return WHITE;
            case "YELLOW":
                return YELLOW;
            case "OTHER":
                return OTHER;
            default:
                throw new IllegalArgumentException("Color not recognized");
        }
    }

    public void Messages(String text) {
        this.color = text;
    }
}

