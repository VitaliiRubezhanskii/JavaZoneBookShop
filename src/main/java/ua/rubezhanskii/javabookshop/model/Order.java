package ua.rubezhanskii.javabookshop.model;



import ua.rubezhanskii.javabookshop.dto.CartItemDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "ordertable")
public class Order implements Serializable {
    private static final long serial_UID=6L;

    private Integer orderId;
    private Date orderDate;
    private List<CartItemDto> cartItems;
    private Customer customer;

    public Order() {
    }

    public Order(Integer orderId, Date orderDate, List<CartItemDto> cartItems, Customer customer) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.cartItems = cartItems;
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Column(name = "orderDate")
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /*
    public List<CartItemDto> getCartItems() {
        return cartItems;
    }
    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }*/

    @ManyToOne
    @JoinColumn(name="customerId")
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", cartItems=" + cartItems +
                ", customer=" + customer +
                '}';
    }
}

