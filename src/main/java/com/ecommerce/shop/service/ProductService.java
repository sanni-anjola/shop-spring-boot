package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findById(Long id);
    void deleteById(Long id);
    List<Product> addProducts(List<Product> products);
}
