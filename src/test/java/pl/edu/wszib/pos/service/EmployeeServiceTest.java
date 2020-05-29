package pl.edu.wszib.pos.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import pl.edu.wszib.pos.model.Employee;
import pl.edu.wszib.pos.repository.EmployeeRepository;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {


    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAllPageable() {
    }

    @Test
    void getAllEmployee() {
    }

    @Test
    void getEmployee() {
    }

    @Test
    void saveEmployee() {


    }
}
