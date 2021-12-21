package com.reto2.reto2.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import com.reto2.reto2.Interface.OrdersCrudRepository;
import com.reto2.reto2.Models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    @Autowired
    public OrdersCrudRepository repository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Orders> getAll() {
        return (List<Orders>) repository.findAll();
    }
    
    public Optional<Orders> getOrder(int id){
        return repository.findById(id);
    }
    
    public Orders create(Orders order){
        return repository.save(order);
    }
    
    public void update(Orders order){
        repository.save(order);
    }
    
    public void delete(Orders order){
        repository.delete(order);
    }
    
    public List<Orders> findByZone(String zona){
        return repository.findByZone(zona);
    }
    
    public Optional<Orders> lastUserId(){
        return repository.findTopByOrderByIdDesc();
    }

    public List<Orders> ordersSalesManByID(Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        List<Orders> orders = mongoTemplate.find(query, Orders.class);
        return orders;
    }

    public List<Orders> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                            .and("status").is(state);
        
        query.addCriteria(criterio);
        
        List<Orders> orders = mongoTemplate.find(query,Orders.class);
        
        return orders;
    }

    public List<Orders> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria dateCriteria = Criteria.where("registerDay")
                        .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                        .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                        .and("salesMan.id").is(id);
        
        query.addCriteria(dateCriteria);
        
        List<Orders> orders = mongoTemplate.find(query,Orders.class);
        
        return orders;       
    }
}
