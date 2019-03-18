package com.infoshare.academy.utils;

public class ReservationMessages {

    public static String noReservationToRm() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "No reservation to delete !!! Please try again.";
        return html1 + errorData + html2;
    }

    public static String successMessageReservationRm() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String successDate = "Success, reservation removed from the list";
        return html1 + successDate + html2;

    }

    public static String errorMessage() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User or reservation id is incorrect! Please try again.";
        return html1 + errorData + html2;
    }

    public static String errorEmptyReservationList() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User has no reservation.";
        return html1 + errorData + html2;
    }

    public static String errorIncorectIdReservation() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "You want to delete someone's reservation.";
        return html1 + errorData + html2;
    }

    public static String successReservationRm() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Success, reservation removed from the list.";
        return html1 + errorData + html2;
    }

    public static String errorUserDoesNotHaveReser() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User does't have such a reservation.";
        return html1 + errorData + html2;
    }
}
