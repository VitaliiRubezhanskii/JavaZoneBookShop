package ua.rubezhanskii.javabookshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="book")
public class Book implements Serializable {
    private static final long serial_UID=3L;

    private Integer bookId;
    private String coverImage;
    private Double price;
    private String bookTitle;
    private Category category;
    private String publisher;
    private String ISBN;
    private String language;
    private String details;
    private Author author;
    private Set<AuthorBook> authorBooks;
    private Set<Cart>carts;
    private Integer bookQuantity;
    private Integer InventoryStock;

    public Book() {
    }

    public Book(Integer bookId, String coverImage, Double price, String bookTitle, Category category, String publisher, String ISBN, String language,
                String details , Author author, Set<Cart> carts, Integer bookQuantity, Integer inventoryStock) {
        this.bookId = bookId;
        this.coverImage = coverImage;
        this.price = price;
        this.bookTitle = bookTitle;
        this.category = category;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.language = language;
        this.details = details;
        this.author=author;
        this.carts = carts;
        this.bookQuantity = bookQuantity;
        InventoryStock = inventoryStock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bookId")
    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Transient
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    @Column(name="coverImage")
    public String getCoverImage() {
        return coverImage;
    }
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    @Column(name="price")
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name="bookTitle")
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId")
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name="publisher")
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    @Column(name="ISBN")
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Column(name="lang")
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name="details")
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
    public Set<Cart> getCarts() {
        return carts;
    }
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
    public Set<AuthorBook> getAuthorBooks() {
        return authorBooks;
    }
    public void setAuthorBooks(Set<AuthorBook> authorBooks) {
        this.authorBooks = authorBooks;
    }

    @Column(name="bookQuantity")
    public Integer getBookQuantity() {
        return bookQuantity;
    }
    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Column(name="inventoryStock")
    public Integer getInventoryStock() {
        return InventoryStock;
    }
    public void setInventoryStock(Integer inventoryStock) {
        InventoryStock = inventoryStock;
    }
}

