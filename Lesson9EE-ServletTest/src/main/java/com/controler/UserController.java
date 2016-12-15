package com.controler;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet(urlPatterns = "/users")
public class UserController extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    public void init() throws ServletException {
        AutowireCapableBeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory();
        factory.autowireBean(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login_ui");
        String password = req.getParameter("password_ui");
        String age = req.getParameter("age_ui");
        String phone = req.getParameter("phone_ui");
        String email = req.getParameter("email_ui");
        String adres = req.getParameter("adres_ui");

        User user = new User(login,Integer.valueOf(age),password,phone,email,adres);
        List<User> users = userService.addUser(user);
        resp.getWriter().print(Arrays.toString(users.toArray()));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userNamesList =userService.getAllUsers();
                //Arrays.asList("name1", "name2", "name3", "name4", "name5");
        resp.getWriter().print(userNamesList);
    }


}
