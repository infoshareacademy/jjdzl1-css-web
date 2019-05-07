package com.infoshare.academy.utils;

public class ForgotPasswordMessages {

    private static final String startDangerDiv = "<div class=\"alert alert-danger\" role=\"alert\">";
    private static final String endDiv = "</div>";

    public static String emailIncorrectMessage() {
        String errorData = "User with this email doesn't exist! Try again!";
        return startDangerDiv + errorData + endDiv;
    }

    public static String emailWithTokenInfoSend() {
        String errorData = "We sent you an email with link to change your password! Link is valid for 20 minutes since now.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String changedPassword() {
        String errorData = "Your password has been successfully changed!";
        return startDangerDiv + errorData + endDiv;
    }
}
