package ua.rubezhanskii.javabookshop.datamanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.model.Book;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT book FROM Book book WHERE book.category=:categoryName")
    List<Book> getAllBooksWithinCategory(@Param("categoryName") String categoryName);

    @Query("SELECT book.category FROM Book book WHERE book.ISBN=:isbn")
    String getCategoryOfBook(@Param("isbn") String isbn);

    @Query("SELECT book FROM Book book WHERE  book.bookTitle LIKE :title")
    List<Book>searchBook(@Param("title") String title);

    @Query("SELECT book FROM Book book WHERE book.ISBN=:isbn")
    Book getBookByIsbn(@Param("isbn") String isbn);









}

