package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Customer;

import java.util.List;

public interface CustomerService{

    void saveOrUpdate(Customer customer);
    void delete(Customer customer);
    Customer getCustomer(String email);
    List<Customer>getAllCustomers();

}
