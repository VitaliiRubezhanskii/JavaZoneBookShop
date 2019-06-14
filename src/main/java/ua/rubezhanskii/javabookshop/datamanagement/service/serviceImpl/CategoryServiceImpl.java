package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.datamanagement.repository.CategoryRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.CategoryService;
import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Integer save(Category category){
        Category savedCategory=categoryRepository.save(category);
        return  savedCategory.getCategoryId();
    }

    @Override
    public void update(Category category) {
        categoryRepository.update(category.getCategory(),category.getCategoryId());
    }

    @Override
    public void delete(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

   @Override
    public Optional<Category> getCategoryOfBook(String ISBN){
        Integer id = categoryRepository.getCategoryOfBook(ISBN);
        return getCategoryById(id);
   }

    @Override
    public boolean exists(Integer categoryId) {
       return categoryRepository.existsById(categoryId);
    }
}
