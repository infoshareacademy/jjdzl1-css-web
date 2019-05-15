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
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{Punct}])(?=\\S+$).{8,}$";
        return password.matches(passwordPattern);

        /*^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[\\p{Punct}])  # a special character must occur at least once, one of: !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
        $                 # end-of-string
        */
    }

    public boolean isEmailCorrect(String email) {
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        return email.matches(emailPattern);
    }

    public Boolean isAdult(String dateOfBirth) {
        LocalDate dateOfBirthLocalDate = formatLocalDate(dateOfBirth);
        LocalDate tempDateOfBirth = transferLocalDateToLocalDateOF(dateOfBirthLocalDate);
        LocalDate tempDateOfBirthPlus18 = tempDateOfBirth.plusYears(18);
        return tempDateOfBirthPlus18.isAfter(LocalDate.now());
    }

    public Boolean isBeforePresentDate(String dateOfBirth) {
        LocalDate dateOfBirthLocalDate = formatLocalDate(dateOfBirth);
        return dateOfBirthLocalDate.isBefore(LocalDate.now());
    }

    public Boolean isTermsOfUseCheckboxChecked(String terms){
        return terms == null;
    }

    private LocalDate formatLocalDate(String date) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, FORMATTER);
    }

    private LocalDate transferLocalDateToLocalDateOF(LocalDate localDate) {
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        return LocalDate.of(year, month, day);
    }
}