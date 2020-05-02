package ua.rubezhanskii.javabookshop.datamanagement.service;

import ua.rubezhanskii.javabookshop.dto.ShippingDto;
import ua.rubezhanskii.javabookshop.model.Shipping;

public interface ShippingService {

    ShippingDto save(Shipping shipping);

}
