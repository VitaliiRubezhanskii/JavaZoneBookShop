package ua.rubezhanskii.javabookshop.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rubezhanskii.javabookshop.security.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
