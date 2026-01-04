package com.elielSilvaDev.primeiro_projeto_spring;

import com.elielSilvaDev.primeiro_projeto_spring.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding on person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Eliel");
        person.setLastName("Pereira");
        person.setAddress("Vila Olimpia - Sumare - Brasil");
        person.setGender("Male");

        return person;
    }
}
