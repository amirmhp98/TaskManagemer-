package main.java.database;

import main.java.entity.Task;
import main.java.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by amirmhp on 12/20/2018.
 */
public class Database {

    HashMap<String, User> users;
    HashMap<String, Task> tasks;
    HashMap<String, String> tokens;
    private final AtomicLong userCounter = new AtomicLong();
    private final AtomicLong taskCounter = new AtomicLong();

    private final long fixedKey = 8432198;

    public Database() {
        this.users = new HashMap<>();
        this.tasks = new HashMap<>();
        this.tokens = new HashMap<>();
    }

    public String addUser(User user) {
        users.put(user.getUserId(), user);
        String token = String.valueOf(userCounter.incrementAndGet() + fixedKey);
        tokens.put(token, user.getUserId());
        return token;
    }

    public User getUser(String userId, boolean fullUser) {
        User user = users.get(userId);
        if (fullUser) {
            ArrayList<Task> nowTasks = new ArrayList<>(tasks.values());
            ArrayList<Task> userTasks = new ArrayList<>();
            //todo find a better way
            for (Task nowTask : nowTasks) {
                if (nowTask.getUserId().equals(userId)) {
                    userTasks.add(nowTask);
                }
            }
            user.setTasks(userTasks);
        }
        return user;
    }

    public String checkToken(String token) {
        if (tokens.containsKey(token)){
            return tokens.get(token);
        }else return null;
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    public String addTask(Task task) {
        tasks.put(task.getUserId(), task);
        return task.getTaskId();
    }

}
