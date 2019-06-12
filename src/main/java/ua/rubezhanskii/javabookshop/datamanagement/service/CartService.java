package ua.rubezhanskii.javabookshop.datamanagement.service;


import ua.rubezhanskii.javabookshop.dto.CartItemDto;
import ua.rubezhanskii.javabookshop.model.Cart;

import java.util.List;


public interface CartService {


    void save(Cart cart);
    void delete(Integer globalId);
    void deleteAll();
    List<CartItemDto> getCartItems();
    List<CartItemDto>getCartByCustomer(Integer customerId);
    Cart getCartById(String globalId);


}
