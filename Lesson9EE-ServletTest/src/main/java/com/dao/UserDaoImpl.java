package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("userDao:: constructor");
    }

    private List<User> users = new ArrayList<User>(
            Arrays.asList(
                    new User("name1", 20),
                    new User("name2", 30),
                    new User("name3", 40))
    );

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> addUser(User newUser) {
        users.add(newUser);
        return users;
    }
}
