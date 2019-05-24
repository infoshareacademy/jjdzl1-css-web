package com.infoshare.academy.utils;

public class CarMessages {

    private static final String startDangerDiv = "<div class=\"alert alert-danger\" role=\"alert\">";
    private static final String startSuccessDiv = "<div class=\"alert alert-success\" role=\"alert\">";
    private static final String endDiv = "</div>";

    public static String errorEmptyList() {
        String errorData = "List of cars is empty!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorMessage() {
        String errorData = "Car id is incorrect! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorNoSearchResults() {
        String errorData = "No search results! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String successMessageCarRm() {
        String successDate = "Success, car removed from the list";
        return startSuccessDiv + successDate + endDiv;
    }

    public static String errorCarIdIncorrect() {
        String errorData = " Id car incorrect! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorCarMileageIncorrect() {
        String errorData = " Car mileage incorrect! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorUpdateHasFailed() {
        String errorData = "The update has failed, please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String successUpdateDone() {
        String errorData = "Car successfully updated!";
        return startSuccessDiv + errorData + endDiv;
    }

    public static String errorIncorectData() {
        String errorData = "Incorrect data entered, please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorNotImage() {
        String errorData = "Uploaded file is not at image, please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String successCarAdded() {
        String errorData = "Car successfully added to database.";
        return startSuccessDiv + errorData + endDiv;
    }
}
