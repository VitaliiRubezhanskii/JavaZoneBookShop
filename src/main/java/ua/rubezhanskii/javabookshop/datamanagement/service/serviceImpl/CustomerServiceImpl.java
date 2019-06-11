package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;



import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.service.CustomerService;
import ua.rubezhanskii.javabookshop.model.Customer;

import java.util.List;


@Service
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
