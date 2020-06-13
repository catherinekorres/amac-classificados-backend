package com.github.classificadosamac.api.service;

import com.github.classificadosamac.api.model.Product;
import com.github.classificadosamac.api.model.User;
import com.github.classificadosamac.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    // Singleton
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product, Long id) {
        Product updated = this.findOne(id);

        updated.setName(product.getName());
        updated.setDescription(product.getDescription());
        updated.setPrice(product.getPrice());

        return productRepository.save(updated);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
