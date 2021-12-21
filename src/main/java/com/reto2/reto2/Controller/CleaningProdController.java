package com.reto2.reto2.Controller;


import java.util.List;
import java.util.Optional;
import com.reto2.reto2.Models.Products;
import com.reto2.reto2.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")

public class CleaningProdController {
    @Autowired
    private ProductsService accessoryService;
       
     @GetMapping("/all")
    public List<Products> getAll() {
        return accessoryService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Products> getClothe(@PathVariable("id") int id) {
        return accessoryService.getClothe(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Products create(@RequestBody Products gadget) {
        return accessoryService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Products update(@RequestBody Products gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return accessoryService.delete(id);
    } 
    
}
