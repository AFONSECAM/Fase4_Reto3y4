
package com.reto2.reto2.Controller;

import java.util.List;
import java.util.Optional;

import com.reto2.reto2.Models.Orders;
import com.reto2.reto2.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/order")
@CrossOrigin("*")
public class OrdersController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/all")
    public List<Orders> getAll(){
        return orderService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Orders> getOrder(@PathVariable("id") int id){
        return orderService.getOrder(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders create(@RequestBody Orders order){
        return orderService.create(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders update(@RequestBody Orders order){
        return orderService.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return orderService.delete(id);
    }
    
    @GetMapping("/zona/{zona}")
    public List<Orders> findByZone(@PathVariable("zona") String zona){
        return orderService.findByZone(zona);
    }

    @GetMapping("/salesman/{id}")
    public List<Orders> ordersSalesManByID(@PathVariable("id") Integer id){
        return orderService.ordersSalesManByID(id);
    }

    @GetMapping("/state/{state}/{id}")
    public List<Orders> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id){
        return orderService.ordersSalesManByState(state, id);
    }

    @GetMapping("/date/{date}/{id}")
    public List<Orders> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
        return orderService.ordersSalesManByDate(dateStr,id);
    }
}

