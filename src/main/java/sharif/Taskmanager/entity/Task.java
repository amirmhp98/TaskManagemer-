package sharif.Taskmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by amirmhp on 12/15/2018.
 */
@Entity
public class Task extends BaseEntity {
    private String name;
    private Date notifyDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String taskId;
    private String userId;
    private String AssignerUserId;



    public String getName() {
        return name;
    }
    public void setName(String title) {
        this.name = title;
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
    public String getAssignerUserId() {
        return AssignerUserId;
    }
    public void setAssignerUserId(String assignerUserId) {
        AssignerUserId = assignerUserId;
    }
}
