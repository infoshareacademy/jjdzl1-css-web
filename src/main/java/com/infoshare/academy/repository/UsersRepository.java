package com.infoshare.academy.repository;

import com.infoshare.academy.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {



    private static List<User> fillUsersRepositoryWithDefalutUsers() {
        List<User> usersRepositoryList = new ArrayList<>();
        User user1 = new User("admin", "admin", "Jaś", "Fasola");
        User user2 = new User("root", "root", "Krzyś", "Kowalski");
        User user3 = new User("spejson", "legia", "Adrian", "Puchacki");
        usersRepositoryList.add(user1);
        usersRepositoryList.add(user2);
        usersRepositoryList.add(user3);
        return usersRepositoryList;
    }

    public static List<User> getUsersList() {
        return fillUsersRepositoryWithDefalutUsers();
    }
}
