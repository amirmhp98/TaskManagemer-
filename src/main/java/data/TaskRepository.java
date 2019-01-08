package main.java.data;

import main.java.entity.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by amirmhp on 1/1/2019.
 */
public interface TaskRepository extends CrudRepository<Task, String> {

}
