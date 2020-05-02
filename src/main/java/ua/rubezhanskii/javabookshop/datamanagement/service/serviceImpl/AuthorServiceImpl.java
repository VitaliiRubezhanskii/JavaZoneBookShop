package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.mapping.AuthorMapper;
import ua.rubezhanskii.javabookshop.datamanagement.repository.AuthorRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.AuthorService;
import ua.rubezhanskii.javabookshop.dto.AuthorDto;
import ua.rubezhanskii.javabookshop.model.Author;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    @Override
    public AuthorDto save(Author author) {
        return authorMapper.toDto(authorRepository.save(author));
    }

    @Override
    public AuthorDto getAuthorOfBook(Integer authorId) {
       Author author = authorRepository.findById(authorId).orElse(new Author());
       return authorMapper.toDto(author);
    }
}
