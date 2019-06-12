package ua.rubezhanskii.javabookshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Author implements Serializable {

    private static final long serial_UID=2L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="authorId")
    private Integer authorId;

    @Column(name = "author1")
    private String author1;
    @Column(name = "author2")
    private String author2;
    @Column(name = "author3")
    private String author3;
    @Column(name = "author4")
    private String author4;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "author_books",
            joinColumns = {@JoinColumn(name = "authorId")},
            inverseJoinColumns = {@JoinColumn(name = "bookId")})
    private Set<Book> books = Collections.emptySet();
}
