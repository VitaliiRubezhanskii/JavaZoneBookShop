package ua.rubezhanskii.javabookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ua.rubezhanskii.javabookshop.datamanagement.service.BookService;
import ua.rubezhanskii.javabookshop.datamanagement.service.CartService;
import ua.rubezhanskii.javabookshop.model.Book;


@Controller

@RequestMapping("/welcome")
public class HomeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CartService cartService;

    // <==========================================Home==================================================================>
    @RequestMapping(value = {"/home/","home"},method = RequestMethod.GET)
    public String homePage(Model model){


        model.addAttribute("SpringBooks",bookService.getBooksFromCategory(1));
        model.addAttribute("HibernateBooks",bookService.getBooksFromCategory(5));
        model.addAttribute("JavaEEbooks",bookService.getBooksFromCategory(6));
        model.addAttribute("JavaSEbooks",bookService.getBooksFromCategory(3));
        model.addAttribute("OOPbooks",bookService.getBooksFromCategory(2));
        model.addAttribute("MultiBooks",bookService.getBooksFromCategory(4));
        model.addAttribute("ScalaBooks",bookService.getBooksFromCategory(8));
        model.addAttribute("RESTbooks",bookService.getBooksFromCategory(9));
//        model.addAttribute("AllBooks",bookService.getBooks());
       // model.addAttribute("countCartItems",bookService.countItems(1));
       // modelAndView.addObject("countCartItems",cartService.countItems(1));

        return "FrontPage";
    }
    //<=================================================Book info======================================================>

    @RequestMapping("/book")
    public String getProductById(@RequestParam("ISBN") String ISBN, Model model) {
        model.addAttribute("book", bookService.getBookByIsbn(ISBN));
      //  model.addAttribute("countCartItems",cartService.countItems(1));
        return "BookPage";
    }


    //<=================================================Browse by categories===========================================>
   /* @RequestMapping("/book/categories")
    public ModelAndView getBooksInCategory(@RequestParam("category") String category) {
        ModelAndView modelAndView=new ModelAndView("FrontPage");
        modelAndView.addObject("books",bookJdbcTemplate.getBooksFromCategory(category));
        modelAndView.addObject("category",category);
        return modelAndView;
    }
    @RequestMapping("/book/CategoriesAll")
    public ModelAndView getBooksInAllCategories() {
        ModelAndView modelAndView=new ModelAndView("FrontPage");
        modelAndView.addObject("books",bookJdbcTemplate.getBooks());
        return modelAndView;
    }*/


}
