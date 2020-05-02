package ua.rubezhanskii.javabookshop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.mapping.OrderItemMapper;
import ua.rubezhanskii.javabookshop.datamanagement.service.*;
import ua.rubezhanskii.javabookshop.dto.OrderItemDto;
import ua.rubezhanskii.javabookshop.model.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/welcome/rest/cart")
@RequiredArgsConstructor
public class CartController {

    private final CustomerService customerService;

    private final OrderService orderService;

    private final OrderItemMapper orderItemMapper;


    //<======================================get View with Cart Items==================================================>
    @GetMapping
    public ModelAndView getCartPage(@ModelAttribute("cartItem") Book book, ModelAndView model) {
        Customer customer = customerService.getCustomerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<OrderItemDto> items =  orderItemMapper.toDtoList(new ArrayList<>(customer.getOrderItems()));
        model.addObject("listItems", items);
        model.addObject("cartItem", new Book());
        model.addObject("total", items.size());
        model.setViewName("Cart");
        return model;
    }


    @GetMapping(value = "/checkout")
    public ModelAndView getCheckout(ModelAndView modelAndView) {
      Customer customer = customerService.getCustomerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
      modelAndView.addObject("customer", customer);
      Order order = orderService.getCurrentOrder(customer);
      order.setStatus(OrderStatus.PLACED);
      orderService.save(order);
      modelAndView.setViewName("Checkout");
      return modelAndView;



    }

    //<==========================================Remove Category=======================================================>
//    @RequestMapping(value = "/remove/{bookId}")
//    private ModelAndView removeCartItem(@PathVariable("globalId") Integer globalId) {
//        cartService.delete(globalId);
//        return new ModelAndView("redirect:/welcome/rest/cart/");
//    }
    //<==========================================Edit Category=========================================================>

//    @RequestMapping("/edit/{bookId}")
//    public ModelAndView editBook(@PathVariable("globalId") String globalId) {
//        Cart cart = cartService.getCartById(globalId);
//        return new ModelAndView("Cart", "cartItem", cart);
//
//    }

//    @RequestMapping(value = "/edit/save", method = RequestMethod.POST)
//    public ModelAndView editSave(@ModelAttribute("cart") Cart cart, Integer bookQuantity) {
//        cartService.save(cart);
//        return new ModelAndView("redirect:/welcome/rest/cart/");
//    }

}
