package ua.rubezhanskii.javabookshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;


@Entity
@Table(name="cart")
public class Cart implements Serializable {

    private static final long serial_UID=1L;
    private Book book;
    private Integer bookQuantity;
    private String globalId;
    private String creationTime;
    private Customer customer;

    public Cart() {

    }

    public Cart(Book book, Integer bookQuantity, String globalId, String creationTime) {
        this.book = book;
        this.bookQuantity = bookQuantity;
        this.globalId = generateGUID();
        this.creationTime = creationTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "globalId")
    public String getGlobalId() {
        return globalId;
    }
    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    @ManyToOne
    @JoinColumn(name = "bookId")
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    @Column(name = "bookQuantity")
    public Integer getBookQuantity() {
        return bookQuantity;
    }
    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Column(name = "creationTime")
    public String getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    @ManyToOne
    @JoinColumn(name="customerId")
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String generateGUID(){
        String prefix="GUID-";
        Integer suffix=new Random().nextInt(1500);
        Integer postfix=new Random().nextInt(15000);
        return prefix+suffix.toString()+"-"+postfix.toString();

    }

}
