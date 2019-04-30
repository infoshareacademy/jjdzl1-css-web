package com.infoshare.academy.utils;

public class ReservationMessages {

    private static final String startDangerDiv = "<div class=\"alert alert-danger\" role=\"alert\">";
    private static final String startSuccessDiv = "<div class=\"alert alert-success\" role=\"alert\">";
    private static final String endDiv = "</div>";

    public static String errorEmptyListReservation() {
        String errorData = "List of reservations is empty.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorUserHaveNoReservation() {
        String errorData = "User have no reservation.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorNoReservationToRm() {
        String errorData = "No reservation to delete! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorMessage() {
        String errorData = "User or reservation id is incorrect! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorEmptyReservationList() {
        String errorData = "User has no reservation.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorIncorectIdReservation() {
        String errorData = "You want to delete someone's reservation.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorUserDoesNotHaveReser() {
        String errorData = "User doesn't have such reservation.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorEndGreaterThanStart() {
        String errorData = "The ending date must be greater than or equal to the starting date.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorStartGreaterNow() {
        String errorData = "The start date can't be passed.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorIncorrectIdCar() {
        String errorData = "You have selected an unavailable car, select an id from the list.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String successReservationRm() {
        String errorData = "Success, reservation removed from the list.";
        return startSuccessDiv + errorData + endDiv;
    }

    public static String successReservationAdd() {
        String errorData = "Success, reservation added to the list.";
        return startSuccessDiv + errorData + endDiv;
    }

    public static String errorUserDoesntExist() {
        String errorData = "The user doesn't exist.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorCarDoesntExist() {
        String errorData = "The car doesn't exist.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorIncorrectDate() {
        String errorData = "The entered date is incorrect! Please try again.";
        return startDangerDiv + errorData + endDiv;
    }

    public static String errorReservationDoesntExist() {
        String errorData = "The reservation doesn't exist.";
        return startDangerDiv + errorData + endDiv;
    }
}
