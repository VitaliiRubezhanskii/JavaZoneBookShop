package ua.rubezhanskii.javabookshop.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.model.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}
