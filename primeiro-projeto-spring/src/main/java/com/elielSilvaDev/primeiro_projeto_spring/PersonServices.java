package com.elielSilvaDev.primeiro_projeto_spring;

import com.elielSilvaDev.primeiro_projeto_spring.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);

            persons.add(person);
        }

        return persons;
    }

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

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("firstName" + i);
        person.setLastName("LastName" + i);
        person.setAddress("Brasil");
        person.setGender(i % 2 == 0 ? "MAle":"Female");

        return person;
    }

}
