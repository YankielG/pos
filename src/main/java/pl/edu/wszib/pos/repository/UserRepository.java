package pl.edu.wszib.pos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //List<User> findByIdAndUFNameAndULName();

}
