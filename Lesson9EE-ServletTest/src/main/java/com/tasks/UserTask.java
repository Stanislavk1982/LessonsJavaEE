package com.tasks;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class UserTask implements Runnable {
    private AsyncContext asyncContext;

    @Autowired
    private UserService userService;

    public UserTask(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    public void run() {
        try {
            Thread.sleep(1500);
            PrintWriter writer = asyncContext.getResponse().getWriter();
            ServletRequest request = asyncContext.getRequest();
            String age = request.getParameter("age_ui");
            String name = request.getParameter("login_ui");
            String password = request.getParameter("password_ui");
            List<User> users = Arrays.asList(
                    new User("name 1", 20),
                    new User("name 2", 30),
                    new User("name 3", 40),
                    new User(name, 50, password)

            );

//            User user = new User(name, Integer.valueOf(age), password);
//            List<User> users = userService.addUser(user);
            writer.print(users);

        } catch (Exception e) {
            System.out.println("test "+e.getLocalizedMessage());
        } finally {
            asyncContext.complete();
        }
    }
}
