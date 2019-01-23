package sharif.Taskmanager.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sharif.Taskmanager.data.TaskRepository;
import sharif.Taskmanager.entity.RequestObject;
import sharif.Taskmanager.entity.SystemException;
import sharif.Taskmanager.entity.Task;

/**
 * Created by amirmhp on 12/11/2018.
 */
@Service
public class TaskManager {

	@Autowired
	UserManager userManager;
	@Autowired
	TaskRepository taskRepository;



	public TaskManager(UserManager userManager, TaskRepository taskRepository) {
		this.userManager = userManager;
		this.taskRepository = taskRepository;
	}

	public Task addTask(RequestObject requestObject) throws SystemException{
		String userId = requestObject.getRequesterId();
		Task task = (Task) requestObject.getContent();
		if (!validateTask(task)) throw new SystemException("invalid task");
		Task taskId = taskRepository.save(task);

		return task;
	}
	private boolean validateTask (Task task){
		//todo validate
		return true;
	}
}
