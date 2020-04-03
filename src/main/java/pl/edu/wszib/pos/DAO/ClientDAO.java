package pl.edu.wszib.pos.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.Client;

@Repository
public interface ClientDAO extends CrudRepository<Client, Integer> {
}
