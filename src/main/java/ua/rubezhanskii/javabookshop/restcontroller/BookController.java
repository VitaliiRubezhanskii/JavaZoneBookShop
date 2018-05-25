package ua.rubezhanskii.javabookshop.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.service.BookService;
import ua.rubezhanskii.javabookshop.model.Book;

import java.util.List;

@RestController
@RequestMapping("/welcome/admin/books")
public class BookController {


   @Autowired
   private BookService bookService;

//<=================================================get View with Books================================================>
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getBookPage(ModelAndView model) {
    Book book=new Book();
    model.addObject("book", book);
    model.addObject("listBooks",bookService.getBooks());
    model.setViewName("AdminPage");
    return model;
}



    //<==========================================Add Book==========================================================>
    @PostMapping("/book")
    public Book save(@RequestBody Book book) {
            bookService.saveOrUpdate(book);
        return book;
    }

    //<==========================================Remove Category==========================================================>
    @DeleteMapping("/book")
    public Book delete(@RequestBody Book book){
     return bookService.delete(book);

    }
    //<==========================================Edit Category==========================================================>

    @PutMapping("/edit")
    public Book edit(@RequestBody Book book){
        return bookService.getBookById(book.getBookId());
            }


    @GetMapping("/book/{isbn}")
    public Book getBookByISBN(@PathVariable("isbn") String ISBN){
        return bookService.getBookByIsbn(ISBN);
    }

    @GetMapping("/book/all")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

}
