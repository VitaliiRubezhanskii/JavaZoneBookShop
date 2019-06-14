package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Book;
import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;

public interface BookService {

    Book saveOrUpdate(Book book);
    Book delete(Book book);
    List<Book>getBooks();
    Book getBookById(Integer bookId);
    List<Book>getBooksFromCategory(Integer categoryId);
    Book getBookByIsbn(String isbn);
    List<Book>searchBook(String title, String author);
    boolean exists(Integer bookId);

    List<Book> getAllBooksByCategory(Category category);


}
