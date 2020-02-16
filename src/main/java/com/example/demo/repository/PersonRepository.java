package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PersonRepository extends CrudRepository<Person, Long> {
    ArrayList<Person> findAll();
    Person findPersonById(Long id);
}
