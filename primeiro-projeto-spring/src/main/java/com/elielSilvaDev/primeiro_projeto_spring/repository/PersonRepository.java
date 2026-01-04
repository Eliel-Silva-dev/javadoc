package com.elielSilvaDev.primeiro_projeto_spring.repository;

import com.elielSilvaDev.primeiro_projeto_spring.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
