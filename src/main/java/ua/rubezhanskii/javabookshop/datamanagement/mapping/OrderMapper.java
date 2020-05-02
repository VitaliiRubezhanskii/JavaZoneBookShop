package ua.rubezhanskii.javabookshop.datamanagement.mapping;

import org.mapstruct.Mapper;
import ua.rubezhanskii.javabookshop.dto.OrderDto;
import ua.rubezhanskii.javabookshop.model.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDto orderDto);

    OrderDto toDto(Order order);

    List<OrderDto> toDtoList(List<Order> orders);




}
