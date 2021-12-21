package com.reto2.reto2.Service;

import java.util.List;
import java.util.Optional;

import com.reto2.reto2.Models.Orders;
import com.reto2.reto2.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Orders> getAll(){
        return orderRepository.getAll();
    }
    
    public Optional<Orders> getOrder(int id){
        return orderRepository.getOrder(id);
    }
    
    public Orders create(Orders order) {
        Optional<Orders> orderIdMaxima = orderRepository.lastUserId();
        if (order.getId() == null) {
            if (orderIdMaxima.isEmpty()){
                order.setId(1);
            }else{
                order.setId(orderIdMaxima.get().getId() + 1);
            }
        }
        Optional<Orders> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.create(order);            
        }else{
            return order;
         } 
    }
    
    public Orders update(Orders order){
        if(order.getId() != null){
            Optional<Orders> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()){
                if (order.getStatus() != null){
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }
    
    public boolean delete(int id){
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Orders> findByZone(String zona){
        return orderRepository.findByZone(zona);
    }

    public List<Orders> ordersSalesManByID(Integer id){
        return orderRepository.ordersSalesManByID(id);
    }

    public List<Orders> ordersSalesManByState(String state, Integer id){
        return orderRepository.ordersSalesManByState(state, id);
    }

    public List<Orders> ordersSalesManByDate(String dateStr, Integer id) {
        return orderRepository.ordersSalesManByDate(dateStr,id);
    }
}
