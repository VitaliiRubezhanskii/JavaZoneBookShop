package ua.rubezhanskii.javabookshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="category")
public class Category implements Serializable {

    private static final long serial_UID=4L;

    private Integer categoryId;
    private String category;
    private Set<Book> books;

    public Category() {

    }

    public Category(Integer categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="categoryId")
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    @Column(name="category")
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    public Set<Book> getBooks() {
        return books;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}



