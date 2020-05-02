package ua.rubezhanskii.javabookshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.service.BookService;
import ua.rubezhanskii.javabookshop.dto.BookDto;
import ua.rubezhanskii.javabookshop.model.Book;

@Controller
@RequestMapping("/welcome/admin/books")
@RequiredArgsConstructor
public class BookController {

   private final BookService bookService;

//<=================================================get View with Books================================================>
    @GetMapping
    public ModelAndView getBookPage(ModelAndView model) {
    model.addObject("book", new Book());
    model.addObject("listBooks",bookService.getBooks());
    model.setViewName("AdminPage");
    return model;
}

    @PostMapping(value = "/addBook")
    public ModelAndView saveOrUpdate(@ModelAttribute("book")Book book) {
            bookService.save(book);
        return new ModelAndView("redirect:/welcome/rest/books/");
    }
    //<==========================================Remove Category==========================================================>
    @GetMapping(value = "/remove/{bookId}")
    private ModelAndView removeBook(@PathVariable("bookId") Integer bookId){
        bookService.delete(bookId);
        return new ModelAndView("redirect:/welcome/rest/books/");
    }
    //<==========================================Edit Category==========================================================>

    @RequestMapping("/edit/{bookId}")
    public ModelAndView editBook(@PathVariable("bookId") Integer bookId){
        BookDto book = bookService.getBookById(bookId);
        return new ModelAndView("AdminPage","newBook",book);

    }

    @RequestMapping(value = "/edit/save",method = RequestMethod.POST)
    public ModelAndView editSave(@ModelAttribute("book") Book book){
        bookService.save(book);
        return new ModelAndView("redirect:/welcome/rest/books/");
    }

}
