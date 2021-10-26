package com.ecommerce.shop.service;

import com.ecommerce.shop.data.dto.ProductDto;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import com.ecommerce.shop.web.exception.ProductDoesNotExistException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
public class ProductServiceImplTest {
    @Autowired
    ProductService productServiceImpl;

    @Autowired
    ProductRepository productRepository;

    @Test
    void updateProductTest() throws ProductDoesNotExistException {
        Product product = productRepository.findById(110L).orElse(null);
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("Luxury chair");

        ProductDto productDto = new ProductDto();
        productDto.setName("mexican chair");

        // call the service update method
        product = productServiceImpl.update(110L, productDto);
        assertThat(product.getName()).isEqualTo(productDto.getName());
        assertThat(product.getPrice()).isEqualTo(4500);
    }


}
