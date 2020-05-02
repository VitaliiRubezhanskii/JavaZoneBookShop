package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category save(Category category);

    void update(Category category);

    List<Category>getCategories();

    void delete(Integer categoryId);

    Category getCategoryById(Integer categoryId);

    boolean exists(Integer categoryId);

}
