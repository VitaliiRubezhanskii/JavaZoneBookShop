package ua.rubezhanskii.javabookshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="customer_id" )
    private Integer customerId;

    @Column(name ="first_name" )
    private String firstName;

    @Column(name ="last_name" )
    private String lastName;

    @Column(name ="address" )
    private String address;

    @Column(name ="city" )
    private String city;

    @Column(name ="zip" )
    private String zip;

    @Column(name ="country" )
    private String country;

    @Column(name ="phone_home" )
    private String phoneHome;

    @Column(name ="phone_mobile" )
    private String phoneMobile;

    @Column(name ="email" )
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Order> orders ;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems ;

    @Column(name = "login")
    private String login;
}
