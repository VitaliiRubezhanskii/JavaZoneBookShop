package ua.rubezhanskii.javabookshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="author")
public class Author implements Serializable {
    private static final long serial_UID=2L;

    private Integer authorId;
    private String author1;
    private String author2;
    private String author3;
    private String author4;
    private Set<AuthorBook> authorBooks;

    public Author() {

    }

    public Author(Integer authorId, String author1, String author2, String author3, String author4) {
        this.authorId = authorId;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.author4 = author4;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="authorId")
    public Integer getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Column(name = "author1")
    public String getAuthor1() {
        return author1;
    }
    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    @Column(name = "author2")
    public String getAuthor2() {
        return author2;
    }
    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    @Column(name = "author3")
    public String getAuthor3() {
        return author3;
    }
    public void setAuthor3(String author3) {
        this.author3 = author3;
    }

    @Column(name = "author4")
    public String getAuthor4() {
        return author4;
    }
    public void setAuthor4(String author4) {
        this.author4 = author4;
    }

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    public Set<AuthorBook> getAuthorBooks() {
        return authorBooks;
    }
    public void setAuthorBooks(Set<AuthorBook> authorBooks) {
        this.authorBooks = authorBooks;
    }
}
