package front_end;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    List<User> users = new ArrayList<User>(Arrays.asList(new User(1, "name1", 12),
            new User(2, "name1", 13),
            new User(3, "name1", 14)
    ));

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getFirstPage() {
        return "user_page";
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getAllUsers() {
        return users;
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    List<User> addNewUser(@RequestBody User newUser) {
        users.add(newUser);
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public
    @ResponseBody
    List<User> updateUser(@PathVariable("id") int id, @RequestBody User newUser) {
        for (User user : users) {
            if (user.getId() == id) {
                user.merge(newUser);
                break;
            }
        }
        return users;
    }
}
