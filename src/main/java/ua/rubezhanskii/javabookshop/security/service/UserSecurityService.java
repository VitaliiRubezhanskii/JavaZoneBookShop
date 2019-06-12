package ua.rubezhanskii.javabookshop.security.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ua.rubezhanskii.javabookshop.security.beans.UserRegistrationDto;
import ua.rubezhanskii.javabookshop.security.model.User;

import java.util.Optional;

public interface UserSecurityService extends UserDetailsService {
    Optional<User> findUserByEmail(String email);
    User saveUser(UserRegistrationDto user);
}
