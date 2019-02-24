package com.infoshare.academy.dao;

import com.infoshare.academy.domain.User;

public interface UsersRepositoryDao {

    User getUserByLogin(String login);

    String getUsersPassword(User user);

    String getUsersLogin(User user);

}
