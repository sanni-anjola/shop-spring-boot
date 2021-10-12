package com.ecommerce.shop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ShopApplicationTests {

    @Autowired
    DataSource dataSource;

    @Value("${test-name: Jack}")
    private String name;

    @Value("${test-year: 2015}")
    private String currentYear;

    @Test
    void printValues(){
        log.info("Name -> {}", name);
        log.info("Name -> {}", currentYear);
    }
    @Test
    void connectToDatabaseTest() {
        assertThat(dataSource).isNotNull();
        log.info("DataSource properties -> {}", dataSource);
        try {
            Connection connection = dataSource.getConnection();
            assertThat(connection).isNotNull();
            log.info("Database -> {}", connection.getCatalog());

        }catch (SQLException exception){
            log.info("An exception occured -> {}", exception.getMessage());
        }
    }

}
