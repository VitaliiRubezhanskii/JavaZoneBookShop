package ua.rubezhanskii.javabookshop.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.rubezhanskii.javabookshop.datamanagement.service.CustomerService;
import ua.rubezhanskii.javabookshop.datamanagement.service.OrderService;
import ua.rubezhanskii.javabookshop.model.Customer;
import ua.rubezhanskii.javabookshop.model.Order;

@Controller
@RequestMapping(value = "/welcome/rest/order")
@AllArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/orderManager", method = RequestMethod.GET)
    public String login() {
        return "OrderManager";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getFilterByCustomer(Order order, ModelAndView model) {
        //Order order=new Order();
        // model.addObject("customerAttribute", );
        model.addObject("order",order);
        model.setViewName("OrderManager");
        return model;
    }

    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public ModelAndView getFilterByDate(Order order, ModelAndView model) {
        Customer customer = customerService.getCustomer("vitalii.rubezhanskii@gmail.com");
        model.addObject("listOrders", orderService.getOrdersByCustomer(customer));
//         model.addObject("customerAttribute",customerAttribute);
        model.setViewName("OrderManager");
        return model;
    }

}
