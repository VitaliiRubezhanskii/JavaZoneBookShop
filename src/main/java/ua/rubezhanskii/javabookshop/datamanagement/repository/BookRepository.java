package ua.rubezhanskii.javabookshop.datamanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.model.Book;
import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT book FROM Book book WHERE  book.bookTitle LIKE :title")
    List<Book>searchBook(@Param("title") String title);

    @Query("SELECT book FROM Book book WHERE book.ISBN=:isbn")
    Book getBookByIsbn(@Param("isbn") String isbn);

//    List<Book> getAllByCategory(Category category);

    List<Book> findBooksByCategory(Category category);









}

