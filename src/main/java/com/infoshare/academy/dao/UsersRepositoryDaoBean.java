package com.infoshare.academy.dao;

import com.infoshare.academy.dao.UsersRepositoryDao;
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
        //throw new IllegalArgumentException("Unexpected user login: " + login);
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
