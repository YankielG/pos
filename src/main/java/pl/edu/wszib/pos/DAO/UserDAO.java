package pl.edu.wszib.pos.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
}
