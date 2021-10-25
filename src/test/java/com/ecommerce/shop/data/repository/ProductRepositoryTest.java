package com.ecommerce.shop.data.repository;

import com.ecommerce.shop.data.model.Currency;
import com.ecommerce.shop.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepositoryImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void createProductTest(){
        Product product = new Product();
        product.setName("Luxury Sofa");
        product.setPrice(4000.0);
        product.setCurrency(Currency.NGN);
        product.setDetails("Lorem");

        assertThat(product).isNotNull();
        log.info("Product before saving -> {}", product );
        productRepositoryImpl.save(product);
        assertThat(product.getId()).isNotNull();
        log.info("Product after saving -> {}", product );
    }

    @Test
    @Transactional
    void whenFindAllProductIsCalledThenProductListIsReturnedTest(){
        List<Product> products = productRepositoryImpl.findAll();
        assertThat(products).hasSize(5);
        log.info("Product returned from database -> {}", products);
    }
    @Test
    void findExistingProductById(){
       Product existingProduct = productRepositoryImpl.findById(110L).orElse(null);

       assertThat(existingProduct).isNotNull();
       log.info("Product -> {}", existingProduct);
    }


    @Test
    void deleteAnExistingProductById(){
        assertThat(productRepositoryImpl.findById(110L).orElse(null)).isNotNull();
        productRepositoryImpl.deleteById(110L);
        assertThat(productRepositoryImpl.findById(110L).orElse(null)).isNull();
    }
}