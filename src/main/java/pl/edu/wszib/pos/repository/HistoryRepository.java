package pl.edu.wszib.pos.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.model.Zgloszenie;

import java.util.Optional;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
    //Optional<History> findAllById (Long hId);

}
