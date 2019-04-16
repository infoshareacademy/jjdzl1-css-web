package com.infoshare.academy.utils;

public class ForgotPasswordMessages {

    public static String emailIncorrectMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User with this email doesn't exist! Try again!";
        return html1 + errorData + html2;
    }

    public static String emailWithTockenInfoSend() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "We send you an email with link to change your password! Link is valid for 20 minutes since now.";
        return html1 + errorData + html2;
    }
}
