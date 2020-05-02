package ua.rubezhanskii.javabookshop.datamanagement.mapping;

import org.mapstruct.Mapper;
import ua.rubezhanskii.javabookshop.dto.ShippingDto;
import ua.rubezhanskii.javabookshop.model.Shipping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShippingMapper {

    Shipping toEntity(ShippingDto shippingDto);

    ShippingDto toDto(Shipping shipping);

    List<ShippingDto> toDtoList(List<Shipping> shippings);
}
