package main.java.application;

/**
 * Created by amirmhp on 12/20/2018.
 */

import main.java.controller.UserController;
import main.java.database.Database;
import main.java.manager.TaskManager;
import main.java.manager.UserManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Database database = new Database();
        TaskManager taskManager = new TaskManager(database);
        UserManager userManager = new UserManager(database);

        UserController userController = new UserController(userManager);
        SpringApplication.run(Application.class, args);
    }
}