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

    public String createPerson(String payload) throws Exception {
        JSONObject payloadObj = new JSONObject(payload);
        JSONObject returnObj = new JSONObject();

        if (!payloadObj.has("name") || !payloadObj.has("age")) {
            throw new Exception("Name and age must be present");
        }

        returnObj.put("name", payloadObj.getString("name"));
        returnObj.put("age", payloadObj.getString("age"));

        return returnObj.toString();
    }
}
