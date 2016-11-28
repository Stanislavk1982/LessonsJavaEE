package com_test2.repo;

import com_test2.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "userRepo2")
public class UserRepoImpl2 implements UserRepo {

    public UserRepoImpl2() {
    }

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("r2name1",12),
                new User("r2name2",13),
                new User("r2name3",14),
                new User("r2name4",15)
        );
    }


}
