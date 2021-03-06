package sharif.Taskmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sharif.Taskmanager.entity.RequestObject;
import sharif.Taskmanager.entity.User;
import sharif.Taskmanager.manager.UserManager;

/**
 * Created by amirmhp on 12/15/2018.
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        RequestObject requestObject = new RequestObject();
        requestObject.setContent(user);
        return userManager.addUser(requestObject);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setContent(user);
        return userManager.login(requestObject);
    }


    @GetMapping(value = "/logout")
    public boolean logout(@RequestParam(value = "token") String token) throws Exception {
        System.out.println("got the message");
        return userManager.logout(token);
    }

    @GetMapping(value = "/{id}")
    public User getUserProfile(@PathVariable String id, @RequestParam(value = "token") String token) throws Exception {

            RequestObject requestObject = new RequestObject();
            requestObject.setRequesterId(id);
            User user = new User();
            user.setID(Long.parseLong(id));
            requestObject.setContent(user);
            requestObject.setToken(token);
            return userManager.getUser(requestObject);

    }
}
