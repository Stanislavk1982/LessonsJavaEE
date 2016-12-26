package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    // для достучатся до контролера
    //host:port/<webcontext>/users/
    //для того чтобы достучатся до метода
    //host:port/<webcontext>/users/list
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getAllUsers() {
        return "users"; //страничка для возврата
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String sayHello(Model model) {
        model.addAttribute("user_name", "JPA test");
        return "users"; //страничка для возврата
    }
}
