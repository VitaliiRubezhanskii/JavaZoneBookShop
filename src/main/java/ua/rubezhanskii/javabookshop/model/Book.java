package ua.rubezhanskii.javabookshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="book")
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"category", "authors", "orderItems"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private Integer bookId;

    @Column(name="cover_image")
    private String coverImage;

    @Column(name="price")
    private Double price;

    @Column(name="book_title")
    private String bookTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
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
    private Set<Author> authors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<OrderItem> orderItems;

    @Column(name="book_quantity")
    private Integer bookQuantity;

    @Column(name="inventory_stock")
    private Integer InventoryStock;
}

