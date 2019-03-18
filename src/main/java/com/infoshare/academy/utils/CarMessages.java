package com.infoshare.academy.utils;

public class CarMessages {

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Car id is incorrect! Please try again.";
        return html1 + errorData + html2;
    }

    public static String successMessageCarRm() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String successDate = "Success, car removed from the list";
        return html1 + successDate + html2;

    }
}
