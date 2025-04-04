package org.example.ecommerce.service;

import org.example.ecommerce.DTO.ProductRequest;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsBySearch(ProductRequest productRequest) {
        if (productRequest.category().equals("Wszystko") && !productRequest.name().isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(productRequest.name());
        }
        if (!productRequest.category().equals("Wszystko") && productRequest.name().isEmpty()) {
            return productRepository.findByCategory(productRequest.category());
        }
        if (productRequest.category().equals("Wszystko") && productRequest.name().isEmpty()) {
            return productRepository.findAll();
        }
        return productRepository.findByNameContainingIgnoreCaseAndCategory(productRequest.name(), productRequest.category());
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void addProducts(List<Product> products) {
        productRepository.saveAll(products);
    }

    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    public void updateProductById(Product product,  int productId) {
        Product productToUpdate = productRepository.getReferenceById(productId);

        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setCategory(product.getCategory());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantity(product.getQuantity());

        productRepository.save(productToUpdate);
    }
}
