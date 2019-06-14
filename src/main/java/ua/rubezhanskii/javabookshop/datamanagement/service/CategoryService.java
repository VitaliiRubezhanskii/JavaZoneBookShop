package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Integer save(Category category);
    void update(Category category);
    List<Category>getCategories();
    void delete(Integer categoryId);
   // Category getCategoryOfBook(Book book);


    Optional<Category> getCategoryById(Integer categoryId);


    boolean exists(Integer categoryId);

    Optional<Category> getCategoryOfBook(String ISBN);


}
