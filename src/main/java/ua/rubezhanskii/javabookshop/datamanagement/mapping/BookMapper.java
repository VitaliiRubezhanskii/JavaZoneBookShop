package ua.rubezhanskii.javabookshop.datamanagement.mapping;

import org.mapstruct.Mapper;
import ua.rubezhanskii.javabookshop.dto.BookDto;
import ua.rubezhanskii.javabookshop.model.Book;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(BookDto book);

    BookDto toDto(Book book);

    List<BookDto> toDtoList(List<Book> books);

}
