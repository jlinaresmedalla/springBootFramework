package com.springboot.firstapp.repository;

import com.springboot.firstapp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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

    @Test
    void findById(){
        //find or retrive an entity by id
        Product product = productRepository.findById(1L).get();

        //display entity
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod(){
        //create Entities
        List<Product> listProducts = new ArrayList<>();
        listProducts.add(new Product("QW263H", "randomProduct", "Pencil", BigDecimal.valueOf(15), false, "Alibaba.com"));
        listProducts.add(new Product("PISOD0", "2product2", "Book", BigDecimal.valueOf(100), true, "Treads.com"));
        listProducts.add(new Product("IUWS82", "9Product10", "Book", BigDecimal.valueOf(32), false, "Amazon.com"));

        //save all entities
        productRepository.saveAll(listProducts);

        //display all entities
        System.out.println(listProducts.toString());
    }

    @Test
    void findAllMethod(){
        //find all entities
        List<Product> findProducts = productRepository.findAll();

        //display all entities
        findProducts.forEach(System.out::println);
        findProducts.forEach(p -> System.out.println(p.getSku()));
    }

    @Test
    void deleteByIdMethod(){
        //delete entity by id
        productRepository.deleteById(5L);

        //display all entities
        List<Product> findProducts = productRepository.findAll();
        findProducts.forEach(System.out::println);
    }

    @Test
    void deleteMethod(){
        //find or retrive an entity by id
        Product product = productRepository.findById(1L).get();

        //delete entity
        productRepository.delete(product);

        //display all entities
        List<Product> findProducts = productRepository.findAll();
        findProducts.forEach(System.out::println);
    }


    @Test
    void deleteAllMethod(){
        //delete all entities
        //productRepository.deleteAll(); delete all entities
        Product p1 = productRepository.findById(6L).get();
        Product p2 = productRepository.findById(7L).get();

        productRepository.deleteAll(List.of(p1,p2));

        //display all entities
        List<Product> findProducts = productRepository.findAll();
        findProducts.forEach(System.out::println);

    }

    @Test
    void countMethod(){
        //count all entities
        long count = productRepository.count();

        //display all entities
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        //check if entity exists
        boolean exists1 = productRepository.existsById(1L);
        boolean exists2 = productRepository.existsById(6L);

        //display all entities
        System.out.println(exists1);
        System.out.println(exists2);
    }

}