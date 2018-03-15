package ua.rubezhanskii.javabookshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.service.AuthorService;
import ua.rubezhanskii.javabookshop.datamanagement.service.BookService;
import ua.rubezhanskii.javabookshop.datamanagement.service.CartService;
import ua.rubezhanskii.javabookshop.model.Book;
import ua.rubezhanskii.javabookshop.model.Cart;


@Controller
@RequestMapping(value = "/welcome/rest/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;


    //<======================================get View with Cart Items==================================================>
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getCartPage(@ModelAttribute("cartItem") Book book, ModelAndView model) {
        // Book book=new Book();
        model.addObject("listItems", cartService.getCartByCustomer(1));
       // model.addObject("author", bookService.get);
        model.addObject("cartItem", new Book());//TODO
        model.setViewName("Cart");
        return model;
    }

    //<==========================================Remove Category=======================================================>
    @RequestMapping(value = "/remove/{bookId}")
    private ModelAndView removeCartItem(@PathVariable("globalId") String globalId) {
        cartService.delete(globalId);
        return new ModelAndView("redirect:/welcome/rest/cart/");
    }
    //<==========================================Edit Category=========================================================>

    @RequestMapping("/edit/{bookId}")
    public ModelAndView editBook(@PathVariable("globalId") String globalId) {
        Cart cart = cartService.getCartById(globalId);
        return new ModelAndView("Cart", "cartItem", cart);

    }

    @RequestMapping(value = "/edit/save", method = RequestMethod.POST)
    public ModelAndView editSave(@ModelAttribute("cart") Cart cart, Integer bookQuantity) {
        cartService.save(cart);
        return new ModelAndView("redirect:/welcome/rest/cart/");
    }

}