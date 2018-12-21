package main.java.controller;

import main.java.entity.RequestObject;
import main.java.entity.User;
import main.java.manager.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by amirmhp on 12/15/2018.
 */
@RestController
@RequestMapping("/user")
public class UserController {
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
    public String login(@RequestBody User user) {
        RequestObject requestObject = new RequestObject();
        requestObject.setContent(user);
        return userManager.login(requestObject);
    }

    @GetMapping(value = "/{id}")
    public User getUserProfile(@PathVariable String id, @RequestParam(value = "token") String token) throws HTTPException {
        String idOfToken = userManager.checkToken(id, token);
        if (idOfToken == null) {
            throw new HTTPException(401);
        } else {
            RequestObject requestObject = new RequestObject();
            requestObject.setRequesterId(id);
            User user = new User();
            user.setUserId(idOfToken);
            requestObject.setContent(user);
            return userManager.getUserProfile(requestObject);
        }
    }

}
