package com.example.demo.controller;

import com.example.demo.annotations.JSONGetMapping;
import com.example.demo.annotations.JSONPostMapping;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService mainService;

    @JSONGetMapping(value = "/person")
    public String getPerson() {
        return mainService.getAllPeople();
    }

    @JSONGetMapping(value = "/person/{id}")
    public String getPerson(@PathVariable Long id) {
        return mainService.getPerson(id);
    }

    @JSONPostMapping(value = "/person")
    public String createPerson(@RequestBody String payload) throws Exception {
        return mainService.createPerson(payload);
    }
}