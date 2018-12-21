package main.java.manager;

import main.java.database.Database;
import main.java.entity.RequestObject;
import main.java.entity.User;

/**
 * Created by amirmhp on 12/11/2018.
 */
public class UserManager {

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
        return dataBase.getUser(((User)(requestObject.getContent())).getUserId(), true);
    }
}
