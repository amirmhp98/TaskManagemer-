package main.java.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by amirmhp on 12/11/2018.
 */
@Entity
public class User extends BaseEntity{

    private String userName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;
    private String phoneNumber;
    private String hashedPassword;
    private String email;

    @OneToMany
    private List<Task> tasks;


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getID() {
        return ID;
    }
    public void setID(String userId) {
        this.ID = userId;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String passwordHash) {
        this.hashedPassword = passwordHash;
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
