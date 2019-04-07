package com.infoshare.academy.enums;

public enum TransmissionEnum {

    AUTOMATIC("Automatyczna"),
    MANUAL("Manualna"),
    SEMIAUTO("Półautomatyczna");

    private String transmission;

    TransmissionEnum(String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public static TransmissionEnum getTransmissionEnum(String transmission) {
        switch (transmission){
            case "AUTOMATIC":
                return AUTOMATIC;
            case "MANUAL":
                return MANUAL;
            case "SEMIAUTO":
                return SEMIAUTO;
                default:
                    throw new IllegalArgumentException("Transmission not recognized");
        }
    }

    public void Messages(String text) {
        this.transmission = text;
    }
}
