package com.tasks;

import com.model.User;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class UserTask implements Runnable {

    private AsyncContext asyncContext;


    public UserTask(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    public void run() {
        try {
            Thread.sleep(1500);
            PrintWriter writer = asyncContext.getResponse().getWriter();
            List<User> users = Arrays.asList(
                    new User("name 1", 20),
                    new User("name 2", 30),
                    new User("name 3", 40));
            writer.print(users);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            asyncContext.complete();
        }
    }
}
