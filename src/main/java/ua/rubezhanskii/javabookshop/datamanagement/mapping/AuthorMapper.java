package ua.rubezhanskii.javabookshop.datamanagement.mapping;

import org.mapstruct.Mapper;
import ua.rubezhanskii.javabookshop.dto.AuthorDto;
import ua.rubezhanskii.javabookshop.model.Author;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toEntity(AuthorDto authorDto);

    AuthorDto toDto(Author author);

    List<AuthorDto> toDtoList(List<Author> authors);

}
