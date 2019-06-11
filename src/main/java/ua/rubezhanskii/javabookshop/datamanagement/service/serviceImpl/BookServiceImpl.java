package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.repository.BookRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.BookService;
import ua.rubezhanskii.javabookshop.model.Book;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
    private BookRepository bookRepository;




    @Override
    public Book saveOrUpdate(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book delete(Book book) {
         bookRepository.delete(book);
         return book;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.getOne(bookId);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }

    @Override
    public List<Book> getBooksFromCategory(Integer categoryId) {
        List<Book> neededBooks=new ArrayList<>();
        List<Book> allBooks= getBooks();
        allBooks.forEach(book -> {
            if((book.getCategory().getCategoryId())==categoryId){
                neededBooks.add(book);
            }
        });

        return neededBooks;
    }

    @Override
    public List<Book> searchBook(String title, String author) {
        return bookRepository.searchBook(title);
    }

    @Override
    public boolean exists(Integer bookId) {
        return true;
    }
}

