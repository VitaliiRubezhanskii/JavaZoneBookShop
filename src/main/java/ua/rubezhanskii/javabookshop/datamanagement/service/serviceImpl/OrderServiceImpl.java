package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.repository.OrderRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.CartService;
import ua.rubezhanskii.javabookshop.datamanagement.service.OrderService;
import ua.rubezhanskii.javabookshop.dto.CartItemDto;
import ua.rubezhanskii.javabookshop.model.Customer;
import ua.rubezhanskii.javabookshop.model.Order;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartService cartService;

    @Override
    public List<Order> getOrdersByCustomer(Customer customer) {
        return orderRepository.getOrdersByCustomer(customer);
    }

    @Override
    public void saveOrder() {
        Order order=new Order();
        List<CartItemDto> cartItemDtos=cartService.getCartItems();
      //  order.setCartItems(cartItemDtos);
        order.setCustomer(cartItemDtos.get(0).getCustomer());
        order.setOrderDate(null);
    orderRepository.save(order);


    }
}
