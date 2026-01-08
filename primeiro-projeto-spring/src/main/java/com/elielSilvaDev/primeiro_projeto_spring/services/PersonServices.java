package com.elielSilvaDev.primeiro_projeto_spring.services;

import com.elielSilvaDev.primeiro_projeto_spring.exception.ResourceNotFoundException;
import com.elielSilvaDev.primeiro_projeto_spring.model.Person;
import com.elielSilvaDev.primeiro_projeto_spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people");

        return repository.findAll();
/*
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);

            persons.add(person);
        }

        return persons;
*/
    }

    public Person findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        /*
        logger.info("Finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Eliel");
        person.setLastName("Pereira");
        person.setAddress("Vila Olimpia - Sumare - Brasil");
        person.setGender("Male");

        return person;
        */
    }

    public Person create(Person person) {
        logger.info("creating one person");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("updating one person");

        Person entity =  repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        Person entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
        //return repository.deleteById(id);
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
