package com.controller;

import com.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;




    // для достучатся до контролера
    //host:port/<webcontext>/users/
    //для того чтобы достучатся до метода
    //host:port/<webcontext>/users/list
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getAllUsers() {
        return "users"; //страничка для возврата
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello/{login}/{password}")
    public String sayHello(Model model, @PathVariable(value = "login") String name,
                           @PathVariable(value = "password") String password) {
        model.addAttribute("user_name", String.format("JPA test for user with cred %s %s", name, password));
        return "users";//страничку для возврата
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usersEntityList")
    public String getAllUsers(Model model) {
        model.addAttribute("usersList", userDAO.getAllUsers());
        return "users";//страничку для возврата
    }


}

//    create table company(
//        id int not null primary key auto_increment,
//        description varchar(35));
//
//        insert into company(description) values ('company description1'), ('company description1');
//
//        create table users(
//        id int not null primary key auto_increment,
//        name varchar(25),
//        surname varchar(35),
//        company_id int not null,
//        foreign key (company_id) references company(id)
//        );
//
//        insert into users(name,surname,company_id) values ('xxx', 'yyyy', 1), ('xxx2', 'yyy2', 2), ('xxx3', 'yyy3', 1);