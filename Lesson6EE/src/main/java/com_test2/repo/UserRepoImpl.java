package com_test2.repo;

import com_test2.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "userRepo1")
public class UserRepoImpl implements UserRepo {

    public UserRepoImpl() {
    }

    public List<User> getAllUsers() {
        return Arrays.asList(
                new User("name1", 12),
                new User("name2", 13),
                new User("name3", 14),
                new User("name4", 15)
        );
    }


}
