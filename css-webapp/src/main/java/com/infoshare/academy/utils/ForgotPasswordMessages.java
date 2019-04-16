package com.infoshare.academy.utils;

public class ForgotPasswordMessages {

    public static String emailIncorrectMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User with this email doesn't exist! Try again!";
        return html1 + errorData + html2;
    }
}
