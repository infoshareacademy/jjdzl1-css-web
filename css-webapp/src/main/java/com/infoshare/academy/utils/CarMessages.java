package com.infoshare.academy.utils;

public class CarMessages {

    public static String errorEmptyList() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "List of cars is empty!";
        return html1 + errorData + html2;
    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Car id is incorrect! Please try again.";
        return html1 + errorData + html2;
    }
    public static String errorNoSearchResults(){
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "No search results! Please try again.";
        return html1 + errorData + html2;
    }

    public static String successMessageCarRm() {
        String html1 = "<div class=\"alert alert-success\" role=\"alert\">";
        String html2 = "</div>";
        String successDate = "Success, car removed from the list";
        return html1 + successDate + html2;

    }

    public static String errorCarIdIncorrect() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " Id car incorrect! Please try again.";
        return html1 + errorData + html2;
    }

    public static String errorCarMileageIncorrect() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " Car mileage incorrect! Please try again.";
        return html1 + errorData + html2;
    }

    public static String errorUpdateHasFailed() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "The update has failed, please try again.";
        return html1 + errorData + html2;
    }

    public static String successUpdateDone() {
        String html1 = "<div class=\"alert alert-success\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Car successfully updated!";
        return html1 + errorData + html2;
    }
    public static String errorIncorectData() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Incorrect data entered, please try again.";
        return html1 + errorData + html2;
    }
}