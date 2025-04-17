package org.example.ecommerce.controller;

import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    @PostMapping("/add")
    public void addCartItem(@RequestBody CartItem cartItem) {
        cartService.addCartItem(cartItem);
    }

    @DeleteMapping("/{cartItemId}")
    public void deleteCartItemById(@PathVariable int cartItemId) {
        cartService.deleteCartItemById(cartItemId);
    }

    @DeleteMapping("/delete")
    public void deleteCartItems() {
        cartService.deleteCartItems();
    }
}
