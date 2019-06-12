package ua.rubezhanskii.javabookshop.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.rubezhanskii.javabookshop.model.Book;
import ua.rubezhanskii.javabookshop.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Category c SET c.category=:category WHERE c.categoryId=:id")
    void update(@Param("category") String category, @Param("id") Integer id);



    @Query(value = "select category_categoryId from category inner join category_book on category.categoryId = category_book.category_categoryId where category_book.books_bookId = (select bookId from book where ISBN = :ISBN)" , nativeQuery = true)
    Integer getCategoryOfBook(@Param("ISBN") String ISBN);


}
