package ua.rubezhanskii.javabookshop.model;


import javax.persistence.*;

@Entity
@Table(name = "bookxauthor")
public class AuthorBook {

    private Integer id;
    private Author author;
    private Book book;

    public AuthorBook() {
    }

    public AuthorBook(Integer id, Author author, Book book) {
        this.id = id;
        this.author = author;
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}
