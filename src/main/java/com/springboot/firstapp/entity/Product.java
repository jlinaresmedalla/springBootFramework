package com.springboot.firstapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity //Crea la entidad en la base de datos
@Getter //Genera los getters
@Setter //Genera los setters
@AllArgsConstructor //Genera el constructor con todos los argumentos
@NoArgsConstructor //Genera el constructor sin argumentos
@ToString //Genera el método toString
@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique", columnNames = "stock_keeping_unit"
                )
        }
) //Indica el nombre de la tabla y el esquema de la base de datos y las restricciones de unicidad de la tabla (SKU)
@SequenceGenerator(
        name = "product_generator",
        sequenceName = "product_sequence_name",
        allocationSize = 1
) //Indica el nombre de la secuencia y el tamaño de la secuencia
public class Product {

    @Id //Indica que es la llave primaria
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    ) //Indica que el valor es generado por la base de datos
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageURL;
    @CreationTimestamp
    private LocalDateTime dataCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

}
