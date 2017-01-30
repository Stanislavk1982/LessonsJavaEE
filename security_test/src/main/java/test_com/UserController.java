package test_com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/users")
public class UserController {


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String user() {
        return "users_page";
    }


}
