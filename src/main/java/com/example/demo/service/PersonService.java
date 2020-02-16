package com.example.demo.service;

import com.example.demo.model.Person;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public String getPerson() {
        JSONObject returnObj = new JSONObject();

        Person person = new Person();
        person.setAge("25");
        person.setName("Azadi");

        returnObj.put("age", person.getAge());
        returnObj.put("name", person.getName());
        return returnObj.toString();
    }
}
