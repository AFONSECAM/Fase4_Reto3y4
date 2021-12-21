package com.reto2.reto2.Models;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Orders {
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    private Map<Integer, Products> products;
    private Map<Integer, Integer> quantities;
}
