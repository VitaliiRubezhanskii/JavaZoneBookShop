package ua.rubezhanskii.javabookshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="shipping")
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"customer", "order"})
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="shipping_id")
    private Integer shipping_id;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String zip;

    private String country;

    private String phoneHome;

    private String phoneMobile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> order;

}
