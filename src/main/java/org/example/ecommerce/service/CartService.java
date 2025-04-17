package org.example.ecommerce.service;

import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    CartItemRepository cartItemRepository;

    @Autowired
    public CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public void deleteCartItemById(int productId) {
        cartItemRepository.deleteById(productId);
    }

    public void deleteCartItems() {
        cartItemRepository.deleteAll();
    }
}
