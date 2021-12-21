package com.reto2.reto2.Service;

import java.util.List;
import java.util.Optional;
import com.reto2.reto2.Models.Products;
import com.reto2.reto2.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    private ProductoRepository clotheRepository;

    public List<Products> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Products> getClothe(int id) {
        return clotheRepository.getClothe(id);
    }

    public Products create(Products accesory) {
        if (accesory.getBrand() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Products update(Products accesory) {

         if (accesory.getId() != null) {
            Optional<Products> accesoryDb = clotheRepository.getClothe(accesory.getId());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getClothe(id).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
