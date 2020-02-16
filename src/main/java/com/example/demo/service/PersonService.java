package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public String getPerson(Long id) {
        JSONObject returnObj = new JSONObject();
        Person person = personRepository.findPersonById(id);
        returnObj.put("id", person.getId());
        returnObj.put("name", person.getName());
        returnObj.put("age", person.getAge());
        return returnObj.toString();
    }

    public String getAllPeople() {
        JSONObject returnObj = new JSONObject();
        JSONArray returnArr = new JSONArray();

        ArrayList<Person> allPeople = personRepository.findAll();
        for (Person currPerson: allPeople) {
            JSONObject currObj = new JSONObject();
            currObj.put("id", currPerson.getId());
            currObj.put("name", currPerson.getName());
            currObj.put("age", currPerson.getName());
            returnArr.put(currObj);
        }

        returnObj.put("content", returnArr);
        return returnObj.toString();
    }

    public String createPerson(String payload) throws Exception {
        JSONObject payloadObj = new JSONObject(payload);
        if (!payloadObj.has("name") || !payloadObj.has("age")) {
            throw new Exception("Name and age must be present");
        }

        Person person = new Person();
        person.setName(payloadObj.getString("name"));
        person.setAge(payloadObj.getString("age"));

        personRepository.save(person);
        return payloadObj.toString();
    }
}
