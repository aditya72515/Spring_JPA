package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        Product product = new Product();
        product.setName("Product1");
        product.setDescription("Product 1 Description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("Product1.png");

        Product savedObject = productRepository.save(product);

        System.out.println(product.getId());
        System.out.println(savedObject);
    }


    @Test
    void updateUsingSaveMethod(){

        Long id = 1L;
        Product product = productRepository.findById(id).get();
        product.setName("Updated product 1");
        product.setDescription("updated product 1 Description");

        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }


}