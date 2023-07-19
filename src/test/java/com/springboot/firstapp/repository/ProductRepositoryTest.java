package com.springboot.firstapp.repository;

import com.springboot.firstapp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProduct() {
        //create
        Product product = new Product();
        product.setSku("ABC123");
        product.setName("Product1");
        product.setDescription("This is a test product");
        product.setPrice(BigDecimal.valueOf(19.99));
        product.setActive(true);
        product.setImageURL("https://www.google.com");

        //save product
        Product savedObject = productRepository.save(product);

        //display product information
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){
        //find or retrive an entity by id
        Product updatedproduct = productRepository.findById(1L).get();

        //modify atributes
        updatedproduct.setDescription("This is an updated product");
        updatedproduct.setImageURL("update.png");

        //save updated entity
        productRepository.save(updatedproduct);

        //display updated entity
        System.out.println(updatedproduct.toString());

    }





}