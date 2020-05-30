package pl.edu.wszib.pos.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.pos.model.Role;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {
public static final String ROLE1 = "ADMIN";
public static final String ROLE2 = "MANAGER";


    @Autowired
    RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        Role role1 = new Role(ROLE1);
        Role role2 = new Role(ROLE2);

        assertNull(role1.getId());
        assertNull(role2.getId());

        roleRepository.save(role1);
        roleRepository.save(role2);

        assertNotNull(role1.getId());
        assertNotNull(role2.getId());

    }

    @AfterEach
    void tearDown() {
        roleRepository.deleteAll();
    }

    @Test
    void testFetchData() {
        Role role = roleRepository.findByRole(ROLE1);

        assertNotNull(role);
        assertEquals(ROLE1, role.getRole());
    }

    @Test
    void testFetchAllData() {
    }
}

