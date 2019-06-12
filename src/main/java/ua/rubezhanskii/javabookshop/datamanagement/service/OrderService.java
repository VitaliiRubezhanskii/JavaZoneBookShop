package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Customer;
import ua.rubezhanskii.javabookshop.model.Order;

import java.util.List;

public interface OrderService {

    void saveOrder();

    List<Order> getOrdersByCustomer(Customer customer);

}
