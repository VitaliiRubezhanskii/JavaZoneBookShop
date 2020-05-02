package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Customer;
import ua.rubezhanskii.javabookshop.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    OrderItem save(OrderItem orderItem);

    Integer countOrderItemsByCustomer(Customer customer);

    List<OrderItem> findAllOrderItemsByCustomer(Customer customer);

}
