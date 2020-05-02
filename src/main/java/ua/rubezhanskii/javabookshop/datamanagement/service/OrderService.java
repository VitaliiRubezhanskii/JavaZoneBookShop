package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Customer;
import ua.rubezhanskii.javabookshop.model.Order;
import ua.rubezhanskii.javabookshop.model.OrderItem;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    List<Order> getOrdersByCustomer(Customer customer);

    Order getCurrentOrder(Customer customer);





}
