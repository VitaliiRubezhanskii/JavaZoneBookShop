package ua.rubezhanskii.javabookshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ordertable")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order implements Serializable {

    private static final long serial_UID=6L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "orderDate")
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="customerId")
    private Customer customer;
}

