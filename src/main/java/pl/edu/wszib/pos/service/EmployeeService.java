package pl.edu.wszib.pos.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.wszib.pos.repository.EmployeeRepository;
import pl.edu.wszib.pos.repository.RoleRepository;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


}
