package com_test2.service;

import com_test2.model.User;
import com_test2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier(value = "userRepo2")
//    private UserRepo userRepo1;

    @Resource
    @Qualifier(value = "userRepo2")
    private UserRepo userRepo1;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserRepo userRepo1) {
        this.userRepo1 = userRepo1;
    }

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
