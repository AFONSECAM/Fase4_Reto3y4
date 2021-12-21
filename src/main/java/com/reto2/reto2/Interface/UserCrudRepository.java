package com.reto2.reto2.Interface;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.reto2.reto2.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 *
 * @author andre
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    public Optional <User> findByEmail(String email);
    
    List<User> findByBirthtDay(Date date);
    
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    List<User> findByMonthBirthtDay(String monthBirthtDay);
    
    List<User> findOneByOrderByIdDesc();
    
    //seleccionar el usuario con el ultimo id
    public Optional<User> findTopByOrderByIdDesc();
}
