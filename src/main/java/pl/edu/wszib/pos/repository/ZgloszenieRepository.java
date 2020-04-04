package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.Zgloszenie;
@Repository
public interface ZgloszenieRepository extends CrudRepository<Zgloszenie, Long> {
}
