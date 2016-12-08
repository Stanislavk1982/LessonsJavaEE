package com_test2;

import com_test2.model.User;
import com_test2.repo.UserRepo;
import com_test2.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserManager {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        List<User> allUsers = userService.getAllUsers();
//        for (User user : allUsers) {
//            System.out.println(user);
//
//        }

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-anotation-context.xml");
        UserService userService = context.getBean("userService", UserService.class);
//        UserRepo userRepo1 = context.getBean("userRepo1", UserRepo.class);
        System.out.println(userService);
   //     System.out.println(userRepo1);

        List<User> allUsers = userService.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
    }
}