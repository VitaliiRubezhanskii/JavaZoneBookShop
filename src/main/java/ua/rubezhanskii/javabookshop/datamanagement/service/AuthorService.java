package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.dto.AuthorDto;
import ua.rubezhanskii.javabookshop.model.Author;

import java.util.Optional;

public interface AuthorService {

    AuthorDto save(Author author);

    AuthorDto getAuthorOfBook(Integer bookId);
}
