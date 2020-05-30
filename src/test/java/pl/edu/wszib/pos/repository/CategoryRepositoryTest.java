package pl.edu.wszib.pos.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.pos.model.Category;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryRepositoryTest {

    public static final String CATEGORY1 = "Testowa kategoria";
    public static final String CATEGORY2 = "Druga testowa kategoria";

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        System.out.println("-------setUp");
        Category category1 = new Category(CATEGORY1);
        Category category2 = new Category(CATEGORY2);

        assertNull(category1.getId());
        assertNull(category2.getId());

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        assertNotNull(category1.getId());
        assertNotNull(category2.getId());
    }

    @AfterEach
    void tearDown() {
        System.out.println("----tearDown");
        categoryRepository.deleteAll();
    }

    @Test
    void testFetchData() {
        Category category = categoryRepository.findAllByName(CATEGORY1);
        assertNotNull(category);
        assertEquals(CATEGORY1, category.getName());
    }
}
