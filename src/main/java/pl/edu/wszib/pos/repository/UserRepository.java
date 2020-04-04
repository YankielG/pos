package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByOIC (String oic);
    User findByEmail (String  email);

}
