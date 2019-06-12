package ua.rubezhanskii.javabookshop.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rubezhanskii.javabookshop.security.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {


    Role findByRole(String role);
}
