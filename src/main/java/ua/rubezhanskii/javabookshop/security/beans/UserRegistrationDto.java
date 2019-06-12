package ua.rubezhanskii.javabookshop.security.beans;

import lombok.Data;
import lombok.ToString;
import ua.rubezhanskii.javabookshop.security.model.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.Set;

@Data
@ToString
public class UserRegistrationDto {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @Email
    @NotEmpty
    private String confirmEmail;

    private Set<Role> roles = Collections.emptySet();
}
