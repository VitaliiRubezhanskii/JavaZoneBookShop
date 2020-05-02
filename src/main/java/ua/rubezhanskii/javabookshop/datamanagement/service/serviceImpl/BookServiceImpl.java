package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.mapping.BookMapper;
import ua.rubezhanskii.javabookshop.datamanagement.repository.BookRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.BookService;
import ua.rubezhanskii.javabookshop.datamanagement.service.CategoryService;
import ua.rubezhanskii.javabookshop.dto.BookDto;
import ua.rubezhanskii.javabookshop.model.Book;
import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    private final CategoryService categoryService;

    @Override
    public BookDto save(Book book) {
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public void delete(Integer id) {
         bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> getBooks() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    public List<BookDto> getAllBooksByCategory(Category category) {
        return bookMapper.toDtoList(bookRepository.findBooksByCategory(category));
    }

    @Override
    public BookDto getBookById(Integer bookId) {
        return bookMapper.toDto(bookRepository.getOne(bookId));
    }

    @Override
    public BookDto getBookByIsbn(String isbn) {
        return bookMapper.toDto(bookRepository.getBookByIsbn(isbn));
    }

    @Override
    public List<BookDto> getBooksFromCategory(Integer categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return bookMapper.toDtoList(bookRepository.findBooksByCategory(category));
    }

    @Override
    public List<BookDto> searchBook(String title, String author) {
        return bookMapper.toDtoList(bookRepository.searchBook(title));
    }

    @Override
    public boolean exists(Integer bookId) {
        return true;
    }
}

