package com.example.demo.controller;

import com.example.demo.annotations.JSONGetMapping;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService mainService;

    @JSONGetMapping(value = "/person")
    public String getPerson() {
        return mainService.getPerson();
    }
}
