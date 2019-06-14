package ua.rubezhanskii.javabookshop.security.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.security.beans.UserRegistrationDto;
import ua.rubezhanskii.javabookshop.security.model.Role;
import ua.rubezhanskii.javabookshop.security.model.User;
import ua.rubezhanskii.javabookshop.security.repository.RoleRepository;
import ua.rubezhanskii.javabookshop.security.repository.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserSecurityServiceImpl implements UserSecurityService,  UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public User saveUser(UserRegistrationDto userData) {
        User user = new User();
        user.setName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(userData.getPassword()));
        user.setEmail(userData.getEmail());
        user.setRoles(new HashSet<Role>(Arrays.asList(new Role("ROLE_USER"))));
        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
