package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.pos.model.Pracownik;

public interface PracownikRepository extends CrudRepository<Pracownik, Long> {
}
