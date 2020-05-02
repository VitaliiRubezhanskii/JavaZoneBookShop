package ua.rubezhanskii.javabookshop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class BookDto {

    private Integer bookId;

    private String coverImage;

    private Double price;

    private String bookTitle;

    private CategoryDto category;

    private String publisher;

    private String ISBN;

    private String language;

    private String details;

    private Set<AuthorDto> authors;

    private Integer bookQuantity;

    private Integer InventoryStock;
}
