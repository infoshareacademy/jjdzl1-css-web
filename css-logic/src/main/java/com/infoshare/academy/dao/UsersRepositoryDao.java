package com.infoshare.academy.dao;

import com.infoshare.academy.domain.User;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface UsersRepositoryDao {

    User addUser(User user);

    User getUserById(int id);

    User getUserByLogin(String login);

    User getUserByEmail(String email);

    User getUserByToken(String passwordTokenUUID);

    List getUsersList();

    List<User> searchUserByLoginOrEmail(String name);

    void deleteUserById(int id);

    void deleteUserByLogin(String login);

    void updateUserAddress(Integer id, String postalCode, String city, String streetAddress);

    void updateUserPassword(Integer id, String password);

    void updateUserInfo(Integer id, String firstName, String lastName, Long phoneNumber, LocalDate birthDate);

    void sendEmailToNewUser(String login, String email, String UUID) throws MessagingException;

    void sendEmailToUserWithForgotPasswordToken(String email, String UUID);

    void updateIsUserAccountActive(Integer id, Boolean isActive);

    int countUsers();

    List<User> getUsersListPaged(int currentPage, int pageSize);

    void updateChangePasswordTokenData(Integer id, String passwordTokenUIDD, LocalDateTime expireDateTimeToken);
}
