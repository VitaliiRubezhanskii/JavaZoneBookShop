package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;



import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.datamanagement.service.CustomerService;
import ua.rubezhanskii.javabookshop.model.Customer;

import java.util.List;


@Repository
public class CustomerServiceImpl implements CustomerService {

    @Override
    public void saveOrUpdate(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public Customer getCustomer(String email) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }
}
