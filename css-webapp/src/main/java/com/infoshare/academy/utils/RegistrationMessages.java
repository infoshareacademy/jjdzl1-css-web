package com.infoshare.academy.utils;

public class RegistrationMessages {

    private static final String startDangerDiv = "<div class=\"alert alert-danger\" role=\"alert\">";
    private static final String endDiv = "</div>";

    public static String anonymousUser() {
        String errorData = "Anonymous users can't access this site!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String passwordIncorrectMessage() {
        String errorData = "Password too weak! Use at least 8 characters (one digit, letter and special character)";
        return startDangerDiv + errorData + endDiv;
    }

    public static String passwordNotMatchMessage() {
        String errorData = "Given passwords don't match, try again!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String currentPasswordIncorrect() {
        String errorData = "Current password is incorrect, please try again";
        return startDangerDiv + errorData + endDiv;
    }

    public static String tooYoungMessage() {
        String errorData = "You are too young to register account!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String tooYoungEdit() {
        String errorData = "You were supposed to be over 18 years old!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String passwordIncorrectAndTooYoungMessage() {
        String errorDataTooYoung = "You are too young to register account!";
        String errorDataIncorrectPassword = "Password too weak! Use at least 8 characters (one digit, big letter and special character)";
        return startDangerDiv + errorDataTooYoung + endDiv + startDangerDiv + errorDataIncorrectPassword + endDiv;
    }

    public static String unavailableLogin() {
        String errorData = "This login is unavailable! Please, try another one.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String unavailableEmail() {
        String errorData = "This email is unavailable! Please, try another one.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String incorrectEmail() {
        String errorData = "This email is incorrect! Please, enter correct one.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String loginAndEmailIsUnavailable() {
        String errorDataTooYoung = "This login is unavailable! Please, try another one.";
        String errorDataIncorrectPassword = "This email is unavailable! Please, try another one.";
        return startDangerDiv + errorDataTooYoung + endDiv + startDangerDiv + errorDataIncorrectPassword + endDiv;
    }

    public static String incorrectDateOfBirth() {
        String errorData = "Incorrect Date Of Birth! Please, choose it again!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String ActivatedMessage() {
        String errorData = "Activated!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorMessageLoginIncorrect() {
        String errorData = "Login or password incorrect! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String activationErrorMessage() {
        String errorData = "Your Account is not active! Check your email box and activate your account!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorMessageLoginFirst() {
        String errorData = "Please login first!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorLoginMessage() {
        String errorData = "User login incorrect! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorIdMessage() {
        String errorData = "User id incorrect! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }
}
