package pl.edu.wszib.pos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.History;

import java.util.Optional;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
    Optional<History> findById(Long h_id);
    //
}
