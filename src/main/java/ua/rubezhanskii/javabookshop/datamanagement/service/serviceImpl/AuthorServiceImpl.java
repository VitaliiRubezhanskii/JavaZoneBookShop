package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.repository.AuthorRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.AuthorService;
import ua.rubezhanskii.javabookshop.model.Author;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public Integer save(Author author) {
        Author savedAuthor=authorRepository.save(author);
        return  savedAuthor.getAuthorId();
    }

    @Override
    public Author getAuthorOfBook(Integer authorId) {
       return authorRepository.findById(authorId).orElse(new Author());
    }
}
