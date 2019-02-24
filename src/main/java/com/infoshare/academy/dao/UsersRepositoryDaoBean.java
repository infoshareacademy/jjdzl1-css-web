package com.infoshare.academy.dao;

import com.infoshare.academy.domain.User;
import com.infoshare.academy.repository.UsersRepository;


import java.util.List;

public class UsersRepositoryDaoBean implements UsersRepositoryDao {

    @Override
    public User getUserByLogin(String login) {
        List<User> UsersList = UsersRepository.getUsersList();
        for (User user : UsersList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public String getUsersPassword(User user) {
        return user.getPassword();
    }

    @Override
    public String getUsersLogin(User user) {
        return user.getLogin();
    }
}
