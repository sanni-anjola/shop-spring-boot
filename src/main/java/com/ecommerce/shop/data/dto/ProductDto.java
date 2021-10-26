package com.ecommerce.shop.data.dto;

import com.ecommerce.shop.data.model.Currency;
import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private Double price;
    private Currency currency;
    private String details;
}
