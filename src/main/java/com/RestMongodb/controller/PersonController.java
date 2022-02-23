package com.RestMongodb.controller;

import com.RestMongodb.domain.Person;
import com.RestMongodb.service.PeopleService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PeopleService peopleService;

    public PersonController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @PostMapping("/save")
    public Person savePerson(@RequestBody Person person){

        return peopleService.savePeople(person);
    }

    @GetMapping("/regex")
    public List<Person> getRegex(@RequestParam String query){

        return peopleService.regexPerson(query);

    }
}
