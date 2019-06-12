package ua.rubezhanskii.javabookshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book implements Serializable {

    private static final long serial_UID=3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bookId")
    private Integer bookId;

    @Column(name="coverImage")
    private String coverImage;

    @Column(name="price")
    private Double price;

    @Column(name="bookTitle")
    private String bookTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @Column(name="publisher")
    private String publisher;

    @Column(name="ISBN")
    private String ISBN;

    @Column(name="lang")
    private String language;

    @Column(name="details")
    private String details;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<Author> authors = Collections.emptySet();

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<Cart> carts = Collections.emptySet();

    @Column(name="bookQuantity")
    private Integer bookQuantity;

    @Column(name="inventoryStock")
    private Integer InventoryStock;
}

