package main.java.manager;

import main.java.database.Database;
import main.java.entity.Task;

/**
 * Created by amirmhp on 12/11/2018.
 */
public class TaskManager {

    Database database;

    public TaskManager(Database database) {
        this.database = database;
    }

    public Task addTask(Task taskToAdd, String ownerUserId){
        return null;
        //todo implement
    }
}
