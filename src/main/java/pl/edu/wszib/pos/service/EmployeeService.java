package pl.edu.wszib.pos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.wszib.pos.model.Employee;
import pl.edu.wszib.pos.model.Zgloszenie;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    Page<Employee> findAllPageable(Pageable pageable);
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployee(Long id);
    Employee saveEmployee(Employee employee);
}
