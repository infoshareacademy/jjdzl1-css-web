package com.infoshare.academy.utils;

import java.time.LocalDate;

public class MyQuery {


    public String getSearchCar(String make, String model, String fuel) {
        return "SELECT c FROM Car c WHERE c.make='" + make + "' OR c.model='" + model + "' OR c.fuelSource='" + fuel + "'";
    }

    public String getCar() {
        return "SELECT c FROM Car c";
    }

    public String countCars() {
        return "SELECT COUNT(c) FROM Car c";
    }

    public String getAvailableCar(LocalDate startDate, LocalDate endDate) {
        return "SELECT c FROM Car c " +
                "where id NOT IN" +
                " (SELECT r.car.id FROM Reservation r WHERE NOT "  +
                "((startDate>'"+endDate+"')"+
                "or (endDate<'"+startDate+"'))) order by c.id ASC";
    }

    public String getReservation(Integer id) {
        return "SELECT r FROM Reservation r WHERE user='" + id + "'";
    }

    public String getReservationList(String login, String name) {
        return "SELECT r FROM Reservation r WHERE" +
                " user.login='" + login + "'  OR  (car.make='" + name + "'OR car.model='" + name + "')";
    }

    public String getUserByLogin() {
        return "SELECT u FROM User u WHERE login=:login";
    }

    public String getUserByEmail() {
        return "SELECT u FROM User u WHERE email=:email";
    }

    public String getUserByToken() {
        return "SELECT u FROM User u WHERE passwordTokenUUID=:passwordTokenUUID";
    }

    public String getUserList() {
        return "SELECT u FROM User u ";
    }

    public String searchUser(String name) {
        return "SELECT u FROM User u WHERE u.login LIKE '%" + name + "%' OR u.email LIKE '%" + name + "%'";
    }

    public String deleteUserByLogin() {
        return "DELETE FROM User u WHERE u.login=:login";
    }

    public String updateUserAdress() {
        return "UPDATE User u SET u.postalCode=:postalCode, u.city=:city, u.streetAddress=:streetAddress WHERE u.id=:id";
    }

    public String updateUserPassword() {
        return "UPDATE User u SET u.password=:password WHERE u.id=:id";
    }

    public String updateUserInfo() {
        return "UPDATE User u SET u.firstName=:firstName, u.lastName=:lastName, u.phoneNumber=:phoneNumber, u.birthDate=:birthDate WHERE u.id=:id";
    }

    public String updateIsUserAccountActive() {
        return "UPDATE User u SET u.isAccountActive=:isAccountActive WHERE u.id=:id";
    }

    public String countUsers() {
        return "SELECT COUNT(u) FROM User u";
    }

    public String updateTokenData(){
        return "UPDATE User u SET u.passwordTokenUUID=:passwordTokenUUID, u.passwordTokenDateTime=:passwordTokenDateTime WHERE u.id=:id";
    }
}
