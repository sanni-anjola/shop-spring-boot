package com.ecommerce.shop.service;

import com.ecommerce.shop.data.dto.ProductDto;
import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.repository.ProductRepository;
import com.ecommerce.shop.service.mapper.ProductMapper;
import com.ecommerce.shop.web.exception.ProductDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
class ProductServiceImplMockTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductMapper productMapper;

    @InjectMocks
    ProductService productServiceImpl;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveProductMockTest() {
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void updateProductMockTest() throws ProductDoesNotExistException {

        Product product = new Product();
        product.setId(1L);
        product.setPrice(500.0);
        ProductDto productDto = new ProductDto();
        productDto.setPrice(1200.0);
        productDto.setName("John Doe");
        when(productMapper.mapDtoToProduct(productDto, product)).then(e -> {
            product.setPrice(productDto.getPrice());
            product.setName(productDto.getName());
            return null;
        });
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);


        productServiceImpl.update(1L, productDto);

        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(product);
        assertThat(product.getPrice()).isEqualTo(1200.0);
        assertThat(product.getName()).isEqualTo("John Doe");
    }
}
