package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.datamanagement.repository.CategoryRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.CategoryService;
import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    public Category save(Category category){
        return categoryRepository.save(category);
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
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Categoty with Id " + categoryId + " not found"));
    }



    @Override
    public boolean exists(Integer categoryId) {
       return categoryRepository.existsById(categoryId);
    }
}
