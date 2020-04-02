package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.pos.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
