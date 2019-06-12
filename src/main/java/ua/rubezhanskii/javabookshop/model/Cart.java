package ua.rubezhanskii.javabookshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;


@Entity
@Table(name="cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cart implements Serializable {

    private static final long serial_UID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "globalId")
    private Integer globalId;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "cart_books",
            joinColumns = {@JoinColumn(name = "globalId")},
            inverseJoinColumns = {@JoinColumn(name = "bookId")})
    private Set<Book> books = Collections.EMPTY_SET;

    @Column(name = "bookQuantity")
    private Integer bookQuantity;

    @Column(name = "creationTime")
    private String creationTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="customerId")
    private Customer customer;
}
