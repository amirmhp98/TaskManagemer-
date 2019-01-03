package main.java.data;

import main.java.entity.User;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by amirmhp on 1/3/2019.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
