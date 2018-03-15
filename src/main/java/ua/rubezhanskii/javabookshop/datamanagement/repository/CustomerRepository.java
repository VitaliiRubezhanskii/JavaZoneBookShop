package ua.rubezhanskii.javabookshop.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT customer FROM Customer customer WHERE customer.email=:email")
    Customer getCustomer(@Param("email") String email);



}
