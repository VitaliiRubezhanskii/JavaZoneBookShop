package ua.rubezhanskii.javabookshop.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class CategoryDto {

    private Integer categoryId;

    private String category;



}
