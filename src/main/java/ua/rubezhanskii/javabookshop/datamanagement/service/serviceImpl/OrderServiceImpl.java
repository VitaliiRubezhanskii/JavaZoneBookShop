package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.repository.OrderItemRepository;
import ua.rubezhanskii.javabookshop.datamanagement.repository.OrderRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.OrderService;
import ua.rubezhanskii.javabookshop.model.Customer;
import ua.rubezhanskii.javabookshop.model.Order;
import ua.rubezhanskii.javabookshop.model.OrderItem;
import ua.rubezhanskii.javabookshop.model.OrderStatus;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersByCustomer(Customer customer) {
        return orderRepository.findAllByCustomer(customer);
    }

    @Override
    public Order getCurrentOrder(Customer customer) {
        return orderRepository.findAllByCustomerAndStatus(customer, OrderStatus.IN_PROGRESS);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
