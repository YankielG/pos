package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.pos.model.Klient;

public interface KlientRepository extends CrudRepository<Klient, Long> {
}
