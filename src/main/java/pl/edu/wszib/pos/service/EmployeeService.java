package pl.edu.wszib.pos.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.pos.model.Employee;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployee();
    Optional<Employee> getEmployee(Long id);
    Employee saveEmployee(Employee employee);
}
