package com.reto2.reto2.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cleaningproducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    private Integer id;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private double price;
    private boolean availability = true;
    private int quantity;
    private String photography;
}