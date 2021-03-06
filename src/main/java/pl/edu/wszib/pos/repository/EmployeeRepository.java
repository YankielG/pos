package pl.edu.wszib.pos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.Employee;
import pl.edu.wszib.pos.model.Zgloszenie;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, CrudRepository<Employee, Long> {
    @Query("select  e from Employee e where e.is_active=true")
    public Page<Employee> findAllById(Long id, Pageable pageable);

    public Employee findAllByName(String name);
    public Employee findAllByEmail(String email);
}
