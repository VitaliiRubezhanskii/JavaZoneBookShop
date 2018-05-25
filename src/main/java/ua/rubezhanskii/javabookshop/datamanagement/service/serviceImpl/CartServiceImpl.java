package ua.rubezhanskii.javabookshop.datamanagement.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.rubezhanskii.javabookshop.datamanagement.repository.CartRepository;
import ua.rubezhanskii.javabookshop.datamanagement.service.CartService;
import ua.rubezhanskii.javabookshop.dto.CartItemDto;
import ua.rubezhanskii.javabookshop.model.Cart;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartById(String globalId) {
        return null;
    }

    @Override
    public void save(Cart cartItem) {
         cartRepository.save(cartItem);
    }

    @Override
    public void delete(String globalId) {
        cartRepository.delete(globalId);
    }

    @Override
    public void deleteAll() {
        cartRepository.deleteAll();
    }


   /* @Override
    public List<Cart> getCartItems(){
        return cartRepository.findAll();
    }

    @Override
    public List<Cart>getCartByCustomer(Integer customerId){
        List<Cart> carts=new ArrayList<>();
      List<Cart>items=this.getCartItems();

              items.forEach(item->{
          if(item.getCustomer().getCustomerId()==customerId) {
              carts.add(item);
          }
      });
      return carts;
    }

    @Override
    public Cart getCartById(String globalId){
        return cartRepository.findOne(globalId);
    }*/

    @Override
    public List<CartItemDto> getCartItems() {
        CartItemDto itemDto=new CartItemDto();
        List<CartItemDto>cartItemDtos=new ArrayList<>();
        List<Cart> carts=cartRepository.findAll();

        carts.forEach(cart -> {
          itemDto.setBook(cart.getBook());
          itemDto.setCustomer(cart.getCustomer());
          cartItemDtos.add(itemDto);
        });
        return cartItemDtos;
    }

    public List<CartItemDto> getCartByCustomer(Integer customerId){
        CartItemDto itemDto=new CartItemDto();
        List<CartItemDto>cartItemDtos=new ArrayList<>();
        List<Cart> carts=cartRepository.findAll();

        carts.forEach(cart -> {
            if(cart.getCustomer().getCustomerId()==customerId) {
                itemDto.setBook(cart.getBook());
                itemDto.setCustomer(cart.getCustomer());
                cartItemDtos.add(itemDto);
            }
        });
        return cartItemDtos;


    }

    /*public void saveOrder(){
        List<CartItemDto> cartItems= getCartItemsByCustomerId(1);

    }*/



}