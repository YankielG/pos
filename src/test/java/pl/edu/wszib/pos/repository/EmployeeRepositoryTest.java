package pl.edu.wszib.pos.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.pos.model.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
public static final String EMP1 = "Janusz Kowalski";
public static final String EMP1_email = "jakis@tam.mail";
public static final String EMP2 = "Krzysztof Kowalewski";
public static final String EMP2_email = "jakis2@tam.mail";

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        Employee employee1 = new Employee(EMP1, EMP1_email, true );
        Employee employee2 = new Employee(EMP2, EMP2_email, false);

        assertNull(employee1.getId());
        assertNull(employee2.getId());

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        assertNotNull(employee1.getId());
        assertNotNull(employee2.getId());

    }

    @AfterEach
    void tearDown() {
        //employeeRepository.deleteAll();
    }

    @Test
    void testFetchData() {
        Employee employee = employeeRepository.findAllByName(EMP1);
        Employee employee1 = employeeRepository.findAllByEmail(EMP2_email);

        assertNotNull(employee);
        assertNotNull(employee1);

        assertEquals(EMP1, employee.getName());
        assertEquals(EMP2_email, employee1.getEmail());
    }




}
