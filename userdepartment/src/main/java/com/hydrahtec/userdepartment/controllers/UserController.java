package com.hydrahtec.userdepartment.controllers;

import com.hydrahtec.userdepartment.entities.User;
import com.hydrahtec.userdepartment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public User findById(@RequestParam("id") Long id) {
        Optional<User> result = repository.findById(id);

       return result.get();
    }
}
