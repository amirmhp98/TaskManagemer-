package sharif.Taskmanager.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sharif.Taskmanager.entity.User;

/**
 * Created by amirmhp on 1/1/2019.
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName (String userName);

}
