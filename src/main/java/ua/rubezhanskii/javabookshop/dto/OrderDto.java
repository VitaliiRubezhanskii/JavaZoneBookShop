package ua.rubezhanskii.javabookshop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ua.rubezhanskii.javabookshop.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class OrderDto {


    private Integer orderId;

    private LocalDateTime orderDate;

    private OrderStatus status;

    private Set<OrderItemDto> orderItems;

    private CustomerDto customer;

}
