package com_test.repo;

import com_test.model.User;

import java.util.Arrays;
import java.util.List;

public class UserRepoImpl implements UserRepo {

    private UserRepo userRepo1;

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("name1",12),
                new User("name2",13),
                new User("name3",14),
                new User("name4",15)
        );
    }

    public UserRepo getUserRepo1() {
        return userRepo1;
    }

    public void setUserRepo1(UserRepo userRepo1) {
        this.userRepo1 = userRepo1;
    }
}
