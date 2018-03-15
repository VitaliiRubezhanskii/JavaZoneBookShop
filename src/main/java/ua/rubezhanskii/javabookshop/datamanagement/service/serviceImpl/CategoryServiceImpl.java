package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.datamanagement.repository.CategoryRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.CategoryService;
import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;


@Repository
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
        categoryRepository.delete(categoryId);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findOne(categoryId);
    }

  /*  @Override
    public Category getCategoryOfBook(Book book){
        return categoryRepository.getCategoryOfBook(book.getISBN());
   }
*/
    @Override
    public boolean exists(Integer categoryId) {
       return categoryRepository.exists(categoryId);
    }
}
