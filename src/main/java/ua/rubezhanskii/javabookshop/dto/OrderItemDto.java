package ua.rubezhanskii.javabookshop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class OrderItemDto {

    private Integer orderItemsId;

    private BookDto book;

    private Integer quantity;

    private LocalDateTime orderDate;

}
