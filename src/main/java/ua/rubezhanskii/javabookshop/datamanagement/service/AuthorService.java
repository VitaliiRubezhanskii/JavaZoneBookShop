package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.model.Author;

import java.util.Optional;

public interface AuthorService {


    Integer save(Author author);
    Author getAuthorOfBook(Integer bookId);
}
