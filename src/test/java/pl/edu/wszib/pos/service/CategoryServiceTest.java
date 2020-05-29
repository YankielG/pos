package pl.edu.wszib.pos.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.pos.model.Category;
import pl.edu.wszib.pos.repository.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

//    @Test
//    void testSaveCategory() {
//        Category category = new Category();
//        category.setName("Testowy");
//        categoryService.saveCategory(category);
////        assertTrue(true);
//    }

}
