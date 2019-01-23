package sharif.Taskmanager.manager;

import sharif.Taskmanager.data.*;
import sharif.Taskmanager.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by amirmhp on 12/11/2018.
 */
@Service
public class UserManager {

    @Autowired
    private UserRepository userRepository;
    private HashMap<String, String> tokens = new HashMap<>();  //<token, userId>

    public UserManager( UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String addUser(RequestObject requestObject) {
        User userToAdd = ((User)requestObject.getContent());
        return userRepository.save(userToAdd).getID().toString();
    }

    //ret value = token
    public String login(RequestObject requestObject) throws Exception {
        User userToCheck = ((User)requestObject.getContent());
        User userByUserName = userRepository.findByUserName(userToCheck.getUserName());
        if (userToCheck.getHashedPassword() == userByUserName.getHashedPassword()){
            String token =  UUID.randomUUID().toString().replace("-", "");
            tokens.put(token, userToCheck.getID().toString());
            return token;
        }
        throw new Exception("invalid username or password");
    }

    public String checkToken(String id, String token) throws Exception {
        String userIdOfToken = tokens.get(token);
        if (userIdOfToken == id /* or id == admin */){
            return userIdOfToken;
        }else throw new Exception("invalid username or password");
    }

    public User getUserProfile (RequestObject requestObject){
        return null; //dataBase.getUser(((User)(requestObject.getContent())).getID(), true);
    }

    public boolean logout(String token) throws Exception {
        if (tokens.containsKey(token)){
            tokens.remove(token);
            return true;
        }else throw new Exception("invalid username or password");
    }
}
