package pl.edu.wszib.pos.service.impl;

import org.springframework.stereotype.Service;
import pl.edu.wszib.pos.exception.RecordNotFoundException;
import pl.edu.wszib.pos.model.Category;
import pl.edu.wszib.pos.model.Employee;
import pl.edu.wszib.pos.repository.CategoryRepository;
import pl.edu.wszib.pos.service.CategoryService;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private List<Category> categories = new ArrayList<>();

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories()
    {
        List<Category> result = (List<Category>) categoryRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Category>();
        }
    }

    @Override
    public List<Category> getCategory() {
        return null;
    }

    @Override
    public Category getCategory(Integer id) throws RecordNotFoundException {
        Category category = categories.get(id);
        if(category == null) {
            throw new RecordNotFoundException();
        }
        return category;
    }

    @Override
    public void delCategory(Integer id) {

    }

    @Override
    public Category saveCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }
}
