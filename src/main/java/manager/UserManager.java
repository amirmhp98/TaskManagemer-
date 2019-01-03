package main.java.manager;

import main.java.data.Database;
import main.java.entity.RequestObject;
import main.java.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by amirmhp on 12/11/2018.
 */
@Service
public class UserManager {
    @Autowired
    private Database dataBase;

    public UserManager(Database dataBase) {
        this.dataBase = dataBase;
    }

    public String addUser(RequestObject requestObject) {
        return null;
        //todo implement
    }

    //ret value = token
    public String login(RequestObject requestObject) {
        //todo implement
        return null;
    }

    public String checkToken(String id, String token) {
        String idOfToken = dataBase.checkToken(token);
        if (idOfToken == id /* or id == admin */){
            return idOfToken;
        }else return null;
    }

    public User getUserProfile (RequestObject requestObject){
        return dataBase.getUser(((User)(requestObject.getContent())).getID(), true);
    }
}
