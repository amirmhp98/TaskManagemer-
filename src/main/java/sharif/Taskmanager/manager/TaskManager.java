package sharif.Taskmanager.manager;

import org.springframework.stereotype.Service;
import sharif.Taskmanager.entity.Task;

/**
 * Created by amirmhp on 12/11/2018.
 */
@Service
public class TaskManager {
//    @Autowired
//    Database database;

    public TaskManager(/*Database database*/) {
//        this.database = database;
    }

    public Task addTask(Task taskToAdd, String ownerUserId){
        return null;
        //todo implement
    }
}
