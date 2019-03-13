package com.infoshare.academy.utils;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.dao.UsersRepositoryDaoBean;
import com.infoshare.academy.domain.User;

import javax.ejb.EJB;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class UserValidator {

    @EJB
    private UsersRepositoryDao usersRepositoryDao;

    public Boolean isPasswordCorrect(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(pattern);

        /*^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])  # a special character must occur at least once
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
        $                 # end-of-string
        */
    }

    public Boolean isAdult(String dateOfBirth) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirthLocalDate = LocalDate.parse(dateOfBirth, FORMATTER);
        Integer year = dateOfBirthLocalDate.getYear();
        Month month = dateOfBirthLocalDate.getMonth();
        Integer day = dateOfBirthLocalDate.getDayOfMonth();
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate date1 = date.plusYears(18);
        return date1.isAfter(LocalDate.now());
    }

    public Boolean doesExist(String login) {
        User user;
        try {
            user = usersRepositoryDao.getUserByLogin(login);
        }catch (NullPointerException e){
            System.out.println(e);
            return true;
        }
        return user == null;
    }
}