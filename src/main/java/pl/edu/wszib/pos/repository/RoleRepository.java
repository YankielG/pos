package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.pos.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByRole (String role);
}
