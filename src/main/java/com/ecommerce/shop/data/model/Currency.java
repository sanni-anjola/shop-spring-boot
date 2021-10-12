package com.ecommerce.shop.data.model;

import lombok.Getter;

@Getter
public enum Currency {
    NGN("Naira"),
    USD("Dollar"),
    SGD("Singapore Dollar"),
    GBP("Pounds"),
    FRC("Franc"),
    GHC("Cedis");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }
}
