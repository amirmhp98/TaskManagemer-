package main.java.manager;

import main.java.data.Database;
import main.java.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by amirmhp on 12/11/2018.
 */
@Service
public class TaskManager {
    @Autowired
    Database database;

    public TaskManager(Database database) {
        this.database = database;
    }

    public Task addTask(Task taskToAdd, String ownerUserId){
        return null;
        //todo implement
    }
}
