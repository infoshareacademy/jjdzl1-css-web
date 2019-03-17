package com.infoshare.academy.dao;

import com.infoshare.academy.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface UsersRepositoryDao {

    User addUser(User user);

    User getUserById(int id);

    User getUserByLogin(String login);

    User getUserByEmail(String email);

    List getUsersList();

    void deleteUserById(int id);

    void deleteUserByLogin(String login);

    void updateUserAddress(Integer id, String postalCode, String city, String streetAddress);

    void updateUserPassword(Integer id, String password);

    void updateUserInfo(Integer id, String firstName, String lastName, Long phoneNumber, LocalDate birthDate);
}
