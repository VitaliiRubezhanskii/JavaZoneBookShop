package ua.rubezhanskii.javabookshop.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.rubezhanskii.javabookshop.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Category c SET c.category=:category WHERE c.categoryId=:id")
    void update(@Param("category") String category, @Param("id") Integer id);

  /*  @Query("SELECT  Category FROM Book book INNER  JOIN Category category ON  book.categoryId=category.categoryId WHERE book.ISBN=:ISBN")
    Category getCategoryOfBook(@Param("ISBN") String ISBN);

*/
}
