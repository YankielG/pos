package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.Zgloszenie;

import java.util.List;

@Repository
public interface ZgloszenieRepository extends CrudRepository<Zgloszenie, Long> {
//    List<Zgloszenie> findByUser_ULogin(String uLogin);
}
