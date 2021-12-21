
package com.reto2.reto2.Interface;

import com.reto2.reto2.Models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoCrudRepository extends MongoRepository<Products, Integer>{
    
}
