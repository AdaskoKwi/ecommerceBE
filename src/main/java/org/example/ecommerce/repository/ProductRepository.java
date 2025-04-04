package org.example.ecommerce.repository;

import org.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByNameContainingIgnoreCaseAndCategory(String name, String category);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(String category);
}
