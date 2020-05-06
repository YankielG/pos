package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findAllById(Long id);
}
