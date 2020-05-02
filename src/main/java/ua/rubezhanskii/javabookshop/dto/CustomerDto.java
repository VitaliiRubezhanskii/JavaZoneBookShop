package ua.rubezhanskii.javabookshop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CustomerDto {

    private Integer customerId;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String zip;

    private String country;

    private String phoneHome;

    private String phoneMobile;

    private String email;

    private String login;

    private List<OrderItemDto> orderItems ;
}
