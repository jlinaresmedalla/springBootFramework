package com.springboot.firstapp.repository;

import com.springboot.firstapp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        //find or retrive an entity by id
        Product product = productRepository.findByName("Product3");
        System.out.println(product.toString());
    }

    @Test
    void findByNameOrDescriptionMethod() {

        List<Product> product = productRepository.findByNameOrDescription("Product3", "Keyboard");
        product.forEach(System.out::println);
    }

    @Test
    void findByNameAndDescriptionMethod() {

        List<Product> product = productRepository.findByNameAndDescription("Product9", "Keyboard");
        product.forEach(System.out::println);
    }

    @Test
    void findDistinctByNameMethod() {

        Product product = productRepository.findDistinctByName("Product9");
        System.out.println(product.toString());
    }

    @Test
    void findByPriceGreaterThanMethod() {

        List<Product> product = productRepository.findByPriceGreaterThan(new BigDecimal(50));
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getPrice()));
    }

    @Test
    void findByPriceLessThanMethod() {

        List<Product> product = productRepository.findByPriceLessThan(new BigDecimal(80));
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getPrice()));
    }

    //Retunrs a list of products that match inside the description
    @Test
    void findByDescriptionContainingMethod() {

        List<Product> product = productRepository.findByDescriptionContaining("boar");
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getName()));
    }

    //Retunrs a list of products that match exactly the name or description
    @Test
    void findByDescriptionLikeMethod() {

        List<Product> product = productRepository.findByDescriptionLike("keyboard");
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getDescription()));
    }

    @Test
    void findByPriceBetweenMethod() {

        List<Product> product = productRepository.findByPriceBetween(new BigDecimal(50), new BigDecimal(80));
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getPrice()));
    }

    @Test
    void findByDataCreatedBetweenMethod() {

        List<Product> product = productRepository.findByDataCreatedBetween(LocalDateTime.of(2023,07,19,01,20), LocalDateTime.of(2023,07,20,21,30));
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getDataCreated()));
    }

    @Test
    void findByNameInMethod() {

        List<Product> product = productRepository.findByNameIn(List.of("Product1", "Product2", "Product5"));
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getName()));
    }

    @Test
    void findFirst3ByNameContainingMethod() {

        List<Product> product = productRepository.findFirst3ByNameContaining("rodu");
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getName()));
    }

    @Test
    void findTop4rByNameContainingMethod() {

        List<Product> product = productRepository.findTop4ByNameContaining("rodu");
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getName()));
    }

    @Test
    void findTop4ByOrderByPriceAscMethod() {

        List<Product> product = productRepository.findTop4ByOrderByPriceAsc();
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getName()+" and "+p.getPrice() ));
    }

    @Test
    void findFirst4ByOrderByNameDescMethod() {

        List<Product> product = productRepository.findFirst4ByOrderByNameDesc();
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getName()));
    }

    @Test
    void findFirst4ByOrderByNameAscMethod() {

        List<Product> product = productRepository.findFirst4ByOrderByNameAsc();
        product.forEach(p -> System.out.println(p.getId()+" and "+p.getName()));
    }
}
