package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.dto.BookDto;
import ua.rubezhanskii.javabookshop.model.Book;
import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;

public interface BookService {

    BookDto save(Book book);

    void delete(Book book);

    List<BookDto> getBooks();

    BookDto getBookById(Integer bookId);

    List<BookDto> getBooksFromCategory(Integer categoryId);

    BookDto getBookByIsbn(String isbn);

    List<BookDto>searchBook(String title, String author);

    boolean exists(Integer bookId);

    List<BookDto> getAllBooksByCategory(Category category);


}
