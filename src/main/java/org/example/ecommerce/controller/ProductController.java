package org.example.ecommerce.controller;

import org.example.ecommerce.DTO.ProductRequest;
import org.example.ecommerce.model.CartItem;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/search")
    public List<Product> getProductBySearch(@RequestBody ProductRequest productRequest) {
        return productService.getProductsBySearch(productRequest);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PostMapping("/add/collection")
    public void addProducts(@RequestBody List<Product> products) {
        productService.addProducts(products);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }

    @PutMapping("/{id}")
    public void updateProductById(@RequestBody Product product, @PathVariable int id) {
        productService.updateProductById(product, id);
    }

    @PutMapping("/update/collection")
    public void updateProducts(@RequestBody List<CartItem> cartItems) {
        productService.updateProducts(cartItems);
    }
}
