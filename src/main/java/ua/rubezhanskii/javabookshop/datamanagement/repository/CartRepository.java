package ua.rubezhanskii.javabookshop.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,String> {

    @Query("SELECT  cart FROM Cart cart WHERE cart.customer.customerId=:customerId")
    Cart getCartByCustomer(@Param("customerId") Integer customerId);

}
