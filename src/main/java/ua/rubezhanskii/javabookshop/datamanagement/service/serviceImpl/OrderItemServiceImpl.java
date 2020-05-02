package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.repository.OrderItemRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.OrderItemService;
import ua.rubezhanskii.javabookshop.model.Customer;
import ua.rubezhanskii.javabookshop.model.OrderItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> findAllOrderItemsByCustomer(Customer customer) {
        return orderItemRepository.findOrderItemsByCustomer(customer);
    }

    @Override
    public Integer countOrderItemsByCustomer(Customer customer) {
        return orderItemRepository.countOrderItemsByCustomer(customer);
    }
}
