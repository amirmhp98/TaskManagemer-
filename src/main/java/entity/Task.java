package main.java.entity;

import java.util.Date;

/**
 * Created by amirmhp on 12/15/2018.
 */
public class Task extends BaseEntity {
    String title;
    Date notifyDate;
    String taskId;
    String userId;



    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getNotifyDate() {
        return notifyDate;
    }
    public void setNotifyDate(Date notifyDate) {
        this.notifyDate = notifyDate;
    }
    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
