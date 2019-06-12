package ua.rubezhanskii.javabookshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class Customer implements Serializable {

    private static final long serial_UID=5L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="customerId" )
    private Integer customerId;

    @Column(name ="firstName" )
    private String firstName;

    @Column(name ="lastName" )
    private String lastName;

    @Column(name ="address" )
    private String address;

    @Column(name ="city" )
    private String city;

    @Column(name ="zip" )
    private String zip;

    @Column(name ="country" )
    private String country;

    @Column(name ="phoneHome" )
    private String phoneHome;

    @Column(name ="phoneMobile" )
    private String phoneMobile;

    @Column(name ="email" )
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Cart> carts = new HashSet<>();

    @Column(name = "login")
    private String login;
}
