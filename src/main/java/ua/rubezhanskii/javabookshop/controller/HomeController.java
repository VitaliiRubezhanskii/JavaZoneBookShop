package ua.rubezhanskii.javabookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.service.BookService;
import ua.rubezhanskii.javabookshop.datamanagement.service.CategoryService;


@Controller
public class HomeController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    // <==========================================Home==================================================================>
    @GetMapping(value = "/welcome/home")
    public ModelAndView homePage(){
        ModelAndView model = new ModelAndView("FrontPage");

        model.addObject("SpringBooks",bookService.getBooksFromCategory(1));
        model.addObject("HibernateBooks",bookService.getBooksFromCategory(5));
        model.addObject("JavaEEbooks",bookService.getBooksFromCategory(6));
        model.addObject("JavaSEbooks",bookService.getBooksFromCategory(3));
        model.addObject("OOPbooks",bookService.getBooksFromCategory(2));
        model.addObject("MultiBooks",bookService.getBooksFromCategory(4));
        model.addObject("ScalaBooks",bookService.getBooksFromCategory(8));
        model.addObject("RESTbooks",bookService.getBooksFromCategory(9));
//        model.addAttribute("AllBooks",bookService.getBooks());
       // model.addAttribute("countCartItems",bookService.countItems(1));
       // modelAndView.addObject("countCartItems",cartService.countItems(1));

        return model;
    }
    //<=================================================Book info======================================================>

    @GetMapping("/welcome/book")
    public String getProductById(@RequestParam("ISBN") String ISBN, Model model) {
        model.addAttribute("book", bookService.getBookByIsbn(ISBN));
      //  model.addAttribute("countCartItems",cartService.countItems(1));
        return "BookPage";
    }


    //<=================================================Browse by categories===========================================>
    @GetMapping("/books/categories/{categoryId}")
    public ModelAndView getBooksInCategory(@PathVariable("categoryId") Integer categoryId) {
        ModelAndView modelAndView = new ModelAndView("FrontPage");
        categoryService.getCategoryById(categoryId).ifPresent(category -> {
            modelAndView.addObject("books",   bookService.getAllBooksByCategory(category));
            modelAndView.addObject("category", category.getCategory());
        });
        return modelAndView;
    }

    @GetMapping("/books/categories")
    public ModelAndView getBooksInAllCategories() {
        ModelAndView modelAndView=new ModelAndView("FrontPage");
        modelAndView.addObject("books", bookService.getBooks());
        return modelAndView;
    }


}
