package pl.edu.wszib.pos.service;

import pl.edu.wszib.pos.exception.RecordNotFoundException;
import pl.edu.wszib.pos.model.Category;

import java.util.Collection;
import java.util.List;

public interface CategoryService {

    List<Category> getCategory();
    Category getCategory(Integer id) throws RecordNotFoundException;
    void delCategory(Integer id);
    Category saveCategory(Category category);
    Category updateCategory(Category category);
}
