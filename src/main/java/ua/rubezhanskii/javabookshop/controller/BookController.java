package ua.rubezhanskii.javabookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.service.BookService;
import ua.rubezhanskii.javabookshop.model.Book;

@Controller
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
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ModelAndView saveOrUpdate(@ModelAttribute("book")Book book) {
            bookService.saveOrUpdate(book);
        return new ModelAndView("redirect:/welcome/rest/books/");
    }
    //<==========================================Remove Category==========================================================>
    @RequestMapping(value = "/remove/{bookId}")
    private ModelAndView removeBook(@PathVariable("bookId") Integer bookId){
     //   bookService.delete(bookId);
        return new ModelAndView("redirect:/welcome/rest/books/");
    }
    //<==========================================Edit Category==========================================================>

    @RequestMapping("/edit/{bookId}")
    public ModelAndView editBook(@PathVariable("bookId") Integer bookId){
        Book book=bookService.getBookById(bookId);
        return new ModelAndView("AdminPage","newBook",book);

    }

    @RequestMapping(value = "/edit/save",method = RequestMethod.POST)
    public ModelAndView editSave(@ModelAttribute("book") Book book){
        bookService.saveOrUpdate(book);
        return new ModelAndView("redirect:/welcome/rest/books/");
    }

}
