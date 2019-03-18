package com.infoshare.academy.utils;

import com.infoshare.academy.dao.UsersRepositoryDao;

import javax.ejb.EJB;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class UserValidator {

    @EJB
    private UsersRepositoryDao usersRepositoryDao;

    public Boolean isPasswordCorrect(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.])(?=\\S+$).{8,}$";
        return password.matches(pattern);

        /*^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=.])  # a special character must occur at least once
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
        $                 # end-of-string
        */
    }

    public Boolean isAdult(String dateOfBirth) {
        LocalDate dateOfBirthLocalDate = formatLocalDate(dateOfBirth);
        LocalDate tempDateOfBirth = transferLocalDateToLocalDateOF(dateOfBirthLocalDate);
        LocalDate tempDateOfBirthPlus18 = tempDateOfBirth.plusYears(18);
        return tempDateOfBirthPlus18.isAfter(LocalDate.now());
    }
    public Boolean isBeforePresentDate(String dateOfBirth){
        LocalDate dateOfBirthLocalDate = formatLocalDate(dateOfBirth);
        return dateOfBirthLocalDate.isBefore(LocalDate.now());
    }


    private LocalDate formatLocalDate(String date){
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, FORMATTER);
    }
    private LocalDate transferLocalDateToLocalDateOF(LocalDate localDate){
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        return LocalDate.of(year, month, day);
    }
}