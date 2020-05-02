package ua.rubezhanskii.javabookshop.dto;

import lombok.Data;
import ua.rubezhanskii.javabookshop.model.Customer;

@Data
public class ShippingDto {

    private Integer shipping_id;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String zip;

    private String country;

    private String phoneHome;

    private String phoneMobile;

    private Customer customer;

}
