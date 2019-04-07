package com.infoshare.academy;

import com.infoshare.academy.utils.HibernatQuery;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        HibernatQuery.listAvailableCar(LocalDate.parse("2018-11-01"),LocalDate.parse("2018-11-02"));

    }
}
