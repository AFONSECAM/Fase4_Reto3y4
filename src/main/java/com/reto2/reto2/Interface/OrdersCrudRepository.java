package com.reto2.reto2.Interface;

import java.util.List;
import java.util.Optional;

import com.reto2.reto2.Models.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrdersCrudRepository extends MongoRepository<Orders, Integer>{
    
    @Query("{'salesMan.zone': ?0}")
    List<Orders> findByZone(final String country);
    
    @Query("{status: ?0}")
    List<Orders> findByStatus(final String status);
    
    Optional<Orders> findTopByOrderByIdDesc();
}
