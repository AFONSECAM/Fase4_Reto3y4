package com.reto2.reto2.Repository;


import java.util.List;
import java.util.Optional;

import com.reto2.reto2.Interface.UserCrudRepository;
import com.reto2.reto2.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository crudInterface;

    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    public List<User> listAll() {
        return crudInterface.findAll();
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = crudInterface.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }

    public User create(User user) {
        return crudInterface.save(user);
    }
    
    public User update(User user) {
        return crudInterface.save(user);
    }

    public void delete(User user) {
        crudInterface.delete(user);
    }
    
    public Optional<User> lastUserId(){
        return crudInterface.findTopByOrderByIdDesc();
    }

}
