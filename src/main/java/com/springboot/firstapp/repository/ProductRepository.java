package com.springboot.firstapp.repository;

import com.springboot.firstapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String product3);

    //Retunrs a list of products that match the name or description
    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByDescriptionContaining(String description);

    List<Product> findByDescriptionLike(String description);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByDataCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Product> findByNameIn(List<String> name);

    List<Product> findFirst3ByNameContaining(String name);

    List<Product> findTop4ByNameContaining(String name);

    List<Product> findTop4ByOrderByPriceAsc();

    List<Product> findFirst4ByOrderByNameDesc();

    List<Product> findFirst4ByOrderByNameAsc();
}
