package ua.rubezhanskii.javabookshop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.service.CustomerService;
import ua.rubezhanskii.javabookshop.datamanagement.service.OrderService;
import ua.rubezhanskii.javabookshop.model.Customer;
import ua.rubezhanskii.javabookshop.model.OrderItem;

@Controller
@RequestMapping(value = "/welcome/rest/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final CustomerService customerService;

    @RequestMapping(value = "/orderManager", method = RequestMethod.GET)
    public String login() {
        return "OrderManager";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getFilterByCustomer(OrderItem order, ModelAndView model) {
        model.addObject("order",order);
        model.setViewName("OrderManager");
        return model;
    }

    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public ModelAndView getFilterByDate(OrderItem order, ModelAndView model) {
        Customer customer = customerService.getCustomerByEmail("vitalii.rubezhanskii@gmail.com");
        model.addObject("listOrders", orderService.getOrdersByCustomer(customer));
        model.setViewName("OrderManager");
        return model;
    }

}
