package sharif.Taskmanager.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sharif.Taskmanager.data.TaskRepository;
import sharif.Taskmanager.entity.RequestObject;
import sharif.Taskmanager.entity.Task;
import sharif.Taskmanager.entity.User;

import javax.xml.ws.http.HTTPException;

/**
 * Created by amirmhp on 12/11/2018.
 */
@Service
public class TaskManager {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserManager userManager;

    public TaskManager(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }

    public User addTask(RequestObject requestObject) {
        Task taskToAdd = (Task) requestObject.getContent();
        Long userId = taskToAdd.getUserId();
        checkTokenAccessToUser(userId, requestObject.getToken());
        if (!validateTask(taskToAdd)) {
            throw new HTTPException(400);
        }
        taskToAdd = taskRepository.save(taskToAdd);
        User taskOwner = userManager.getUser(userId);
        taskOwner.getTasks().add(taskToAdd);
        userManager.saveUser(taskOwner);
        return taskOwner;
    }

    private boolean validateTask(Task task) {
        return true;
        //todo implement
    }


    public User removeTask(RequestObject requestObject) {
        Task taskToRemove = (Task) requestObject.getContent();
        Long userId = taskToRemove.getUserId();
        checkTokenAccessToUser(userId, requestObject.getToken());
        User taskOwner = userManager.getUser(userId);
        taskOwner = removeTaskFromUserTaskList(taskOwner, taskToRemove.getTaskId());
        taskToRemove = taskRepository.findById(taskToRemove.getTaskId()).get();
        taskRepository.delete(taskToRemove);
        return taskOwner;
    }

    private User removeTaskFromUserTaskList(User user, Long taskId) {
        int taskToRemoveIndex = -1;
        for (Task task : user.getTasks()) {
            if (task.getTaskId().equals(taskId)) {
                taskToRemoveIndex = user.getTasks().indexOf(task);
                break;
            }
        }
        if (taskToRemoveIndex == -1) {
            throw new HTTPException(400);
        }
        user.getTasks().remove(taskToRemoveIndex);
        return user;
    }


    public Task getTask(RequestObject requestObject) {
        Task taskToShow = (Task) requestObject.getContent();
        Long userId = userManager.getUserIdOfToken(requestObject.getToken());
        checkTokenAccessToUser(userId, requestObject.getToken());
        taskToShow = taskRepository.findById(taskToShow.getTaskId()).get();
        if (taskToShow == null) {
            throw new HTTPException(400);
        }
        return taskToShow;
    }

    private boolean checkTokenAccessToUser(Long id, String token) {
        return userManager.checkTokenAccessToUser(id, token);
    }
}
