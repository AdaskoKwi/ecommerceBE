package org.example.ecommerce.repository;

import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    boolean existsByProductId(int id);

    CartItem findByProduct(Product product);
}
