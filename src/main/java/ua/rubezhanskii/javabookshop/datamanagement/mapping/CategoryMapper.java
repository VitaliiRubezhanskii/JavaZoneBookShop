package ua.rubezhanskii.javabookshop.datamanagement.mapping;

import org.mapstruct.Mapper;
import ua.rubezhanskii.javabookshop.dto.CategoryDto;
import ua.rubezhanskii.javabookshop.model.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    List<CategoryDto> toDtoList(List<Category> categories);

}
