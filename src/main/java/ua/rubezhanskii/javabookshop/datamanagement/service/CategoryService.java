package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;

public interface CategoryService {

    Integer save(Category category);
    void update(Category category);
    List<Category>getCategories();
    void delete(Integer categoryId);
   // Category getCategoryOfBook(Book book);
    Category getCategoryById(Integer categoryId);
    boolean exists(Integer categoryId);


}
