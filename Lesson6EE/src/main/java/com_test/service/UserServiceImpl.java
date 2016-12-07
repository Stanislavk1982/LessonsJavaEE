package com_test.service;

import com_test.model.User;
import com_test.repo.UserRepo;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepo userRepo1;

    public List<User> getAllUsers() {
        return userRepo1.getAllUsers();
    }

    public UserRepo getUserRepo1() {
        return userRepo1;
    }

    public void setUserRepo1(UserRepo userRepo1) {
        this.userRepo1 = userRepo1;
    }
}
