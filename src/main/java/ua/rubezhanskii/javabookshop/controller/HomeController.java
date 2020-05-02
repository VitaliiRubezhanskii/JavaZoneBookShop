package ua.rubezhanskii.javabookshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.mapping.BookMapper;
import ua.rubezhanskii.javabookshop.datamanagement.service.*;
import ua.rubezhanskii.javabookshop.dto.BookDto;
import ua.rubezhanskii.javabookshop.model.*;

import java.time.LocalDateTime;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookService bookService;

    private final CategoryService categoryService;

    private final OrderItemService orderItemService;

    private final CustomerService customerService;

    private final OrderService orderService;

    private final BookMapper bookMapper;

    // <==========================================Home==================================================================>
    @GetMapping(value = "/welcome/home")
    public ModelAndView homePage(){
        ModelAndView model = new ModelAndView("FrontPage");
        model.addObject("SpringBooks",bookService.getBooksFromCategory(1));
        model.addObject("HibernateBooks",bookService.getBooksFromCategory(5));
        model.addObject("JavaEEbooks", bookService.getBooksFromCategory(6));
        model.addObject("JavaSEbooks",bookService.getBooksFromCategory(3));
        model.addObject("OOPbooks",bookService.getBooksFromCategory(2));
        model.addObject("MultiBooks",bookService.getBooksFromCategory(4));
        model.addObject("ScalaBooks",bookService.getBooksFromCategory(8));
        model.addObject("RESTbooks",bookService.getBooksFromCategory(9));
        model.addObject("AllBooks",bookService.getBooks());
        model.addObject("countCartItems", orderItemService.countOrderItemsByCustomer(customerService.getCustomerByEmail(SecurityContextHolder.getContext().getAuthentication().getName())));
        return model;
    }
    //<=================================================Book info======================================================>

    @GetMapping("/welcome/book")
    public String getProductById(@RequestParam("ISBN") String ISBN, Model model) {
        model.addAttribute("book", bookService.getBookByIsbn(ISBN));

      //  model.addAttribute("countCartItems",cartService.countItems(1));
        return "BookPage";
    }

    @PostMapping("/welcome/book")
    public String addBookToCart(@RequestParam("ISBN") String ISBN, Model model) {
        Book book = bookMapper.toEntity(bookService.getBookByIsbn(ISBN));
        model.addAttribute("book", book );
        Customer customer = customerService
            .getCustomerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Order order = orderService.getCurrentOrder(customer);

        OrderItem orderItem = new OrderItem();
        orderItem.setBook(book);
        orderItem.setCustomer(customer);
        orderItem.setOrderDate(LocalDateTime.now());
        orderItem.setQuantity(1);

        if (order == null){
            order = new Order();
            order.setStatus(OrderStatus.IN_PROGRESS);
            order.setCustomer(customer);
            order.setOrderDate(LocalDateTime.now());
            order = orderService.save(order);
        }
        orderItem.setOrder(order);
        OrderItem savedOrderItem = orderItemService.save(orderItem);
        return "BookPage";
    }

    //<=================================================Browse by categories===========================================>
    @GetMapping("/books/categories/{categoryId}")
    public ModelAndView getBooksInCategory(@PathVariable("categoryId") Integer categoryId) {
        ModelAndView modelAndView = new ModelAndView("FrontPage");
        Category category = categoryService.getCategoryById(categoryId);
            modelAndView.addObject("books",   bookService.getAllBooksByCategory(category));
            modelAndView.addObject("category", category.getCategory());

        return modelAndView;
    }

    @GetMapping("/books/categories")
    public ModelAndView getBooksInAllCategories() {
        ModelAndView modelAndView=new ModelAndView("FrontPage");
        modelAndView.addObject("books", bookService.getBooks());
        return modelAndView;
    }


}
