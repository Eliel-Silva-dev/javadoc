package com.hydrahtec.userdepartment.controllers;

import com.hydrahtec.userdepartment.entities.User;
import com.hydrahtec.userdepartment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        Optional<User> result = repository.findById(id);

        if(result.isPresent()) {
        return result.get();
        } else {
            throw new NoSuchElementException("Data not found");
        }
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
