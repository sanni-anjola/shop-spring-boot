package com.ecommerce.shop.data.repository;

import com.ecommerce.shop.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
