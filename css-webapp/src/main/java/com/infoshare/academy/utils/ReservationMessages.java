package com.infoshare.academy.utils;

public class ReservationMessages {

    public static String errorEmptyListReservation() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " List of reservations is empty.";
        return html1 + errorData + html2;
    }

    public static String errorUserHaveNoReservation() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " User have no reservation.";
        return html1 + errorData + html2;
    }

    public static String errorNoReservationToRm() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "No reservation to delete !!! Please try again.";
        return html1 + errorData + html2;
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

    public static String errorUserDoesNotHaveReser() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "User does't have such a reservation.";
        return html1 + errorData + html2;
    }

    public static String errorEndGreaterThanStart() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "The ending date must be greater than or equal to the starting date.";
        return html1 + errorData + html2;
    }

    public static String errorStartGreaterNow() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "The start date can not be passed.";
        return html1 + errorData + html2;
    }

    public static String errorIncorrectIdCar() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "You have selected an unavailable car, select an id from the list.";
        return html1 + errorData + html2;
    }

    public static String successReservationRm() {
        String html1 = "<div class=\"alert alert-success\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Success, reservation removed from the list.";
        return html1 + errorData + html2;
    }

    public static String successReservationAdd() {
        String html1 = "<div class=\"alert alert-success\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "Success, reservation add to the list.";
        return html1 + errorData + html2;


    }

    public static String errorUserDoesntExist() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " The user doesn't exist.";
        return html1 + errorData + html2;
    }

    public static String errorCarDoesntExist() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " The car doesn't exist.";
        return html1 + errorData + html2;
    }

    public static String errorIncorrectDate() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = "The entered date is incorrect ! Please try again.";
        return html1 + errorData + html2;
    }
    public static String errorReservationDoesntExist() {
        String html1 = "<div class=\"alert alert-danger\" role=\"alert\">";
        String html2 = "</div>";
        String errorData = " The reservation doesn't exist.";
        return html1 + errorData + html2;
    }
}