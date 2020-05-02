package ua.rubezhanskii.javabookshop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class AuthorDto {

    private Integer authorId;

    private String author1;

    private String author2;

    private String author3;

    private String author4;

//    private Set<BookDto> books;

}
