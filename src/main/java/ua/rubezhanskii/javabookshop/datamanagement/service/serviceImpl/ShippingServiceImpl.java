package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.rubezhanskii.javabookshop.datamanagement.mapping.ShippingMapper;
import ua.rubezhanskii.javabookshop.datamanagement.repository.ShippingRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.ShippingService;
import ua.rubezhanskii.javabookshop.dto.ShippingDto;
import ua.rubezhanskii.javabookshop.model.Shipping;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    private final ShippingRepository shippingRepository;

    private final ShippingMapper shippingMapper;

    @Override
    public ShippingDto save(Shipping shipping) {
        return shippingMapper.toDto(shippingRepository.save(shipping));
    }
}
