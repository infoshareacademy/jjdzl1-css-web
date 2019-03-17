package com.infoshare.academy.utils;

public class RegistrationMessages {
    public static String passwordIncorrectMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Password too weak! Use at least 8 characters (one digit, letter and special character)";
        return html1 + errorData + html2;
    }

    public static String tooYoungMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "You are too young to register account!";
        return html1 + errorData + html2;
    }

    public static String passwordIncorrectAndTooYoungMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorDataTooYoung = "You are too young to register account!";
        String html3 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html4 = "</div>";
        String errorDataIncorrectPassword = "Password too weak! Use at least 8 characters (one digit, letter and special character)";
        return html1 + errorDataTooYoung + html2 + html3 + errorDataIncorrectPassword + html4;
    }

    public static String unavailableLogin() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "This login is unavailable! Please, try another one.";
        return html1 + errorData + html2;
    }

    public static String unavailableEmail() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "This email is unavailable! Please, try another one.";
        return html1 + errorData + html2;
    }

    public static String loginAndEmailIsUnavailable() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorDataTooYoung = "This login is unavailable! Please, try another one.";
        String html3 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html4 = "</div>";
        String errorDataIncorrectPassword = "This email is unavailable! Please, try another one.";
        return html1 + errorDataTooYoung + html2 + html3 + errorDataIncorrectPassword + html4;
    }
}
