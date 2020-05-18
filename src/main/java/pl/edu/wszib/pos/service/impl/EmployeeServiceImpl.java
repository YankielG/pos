package pl.edu.wszib.pos.service.impl;

import org.springframework.stereotype.Service;
import pl.edu.wszib.pos.model.Employee;
import pl.edu.wszib.pos.repository.EmployeeRepository;
import pl.edu.wszib.pos.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> result = (List<Employee>) employeeRepository.findAll();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Employee>();
        }
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }
}
