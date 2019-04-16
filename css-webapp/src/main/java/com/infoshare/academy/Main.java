package com.infoshare.academy;

import com.infoshare.academy.utils.HibernateQueryApp;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        HibernateQueryApp.listAvailableCar(LocalDate.parse("2018-11-01"),LocalDate.parse("2018-11-02"));

    }
}
