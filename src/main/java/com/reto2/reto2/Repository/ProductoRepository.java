package com.reto2.reto2.Repository;

import java.util.List;
import java.util.Optional;

import com.reto2.reto2.Interface.ProductoCrudRepository;
import com.reto2.reto2.Models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository {
    @Autowired
    public ProductoCrudRepository repository;

    public List<Products> getAll() {
        return repository.findAll();
    }

    public Optional<Products> getClothe(int id) {
        return repository.findById(id);
    }

    public Products create(Products clothe) {
        return repository.save(clothe);
    }

    public void update(Products clothe) {
        repository.save(clothe);
    }
    
    public void delete(Products clothe) {
        repository.delete(clothe);
    }
}
