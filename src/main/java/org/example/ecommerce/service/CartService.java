package org.example.ecommerce.service;

import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.repository.CartItemRepository;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    CartItemRepository cartItemRepository;
    ProductRepository productRepository;

    @Autowired
    public CartService(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    public void addCartItem(CartItem cartItem) {
        if (cartItemRepository.existsByProductId(cartItem.getProduct().getId())) {
            CartItem cartItemToUpdate = cartItemRepository.findByProduct(cartItem.getProduct());

            if (cartItemToUpdate.getAmountInCart() < cartItem.getProduct().getQuantity()) {
                cartItemToUpdate.setAmountInCart(cartItemToUpdate.getAmountInCart() + 1);
                cartItemRepository.save(cartItemToUpdate);
            }
        } else {
            cartItem.setAmountInCart(1);
            cartItemRepository.save(cartItem);
        }
    }

    public void deleteCartItemById(int productId) {
        cartItemRepository.deleteById(productId);
    }

    public void deleteCartItems() {
        cartItemRepository.deleteAll();
    }
}
