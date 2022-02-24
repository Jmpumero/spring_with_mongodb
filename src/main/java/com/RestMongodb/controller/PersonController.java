package com.RestMongodb.controller;

import com.RestMongodb.domain.Person;
import com.RestMongodb.domain.PersonResponse;
import com.RestMongodb.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/findByName")
    public List<PersonResponse> findName(@RequestParam String query){
        return peopleService.findByFirstName(query);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person data){
        return peopleService.updatePerson(id, data);
    }

    @DeleteMapping("/delete_by/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable String id){

        try {

            peopleService.deletePersonById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/many")
    public ResponseEntity<HttpStatus> deleteMany(@RequestBody List<String> ids){

        try {
            peopleService.deleteManySimple(ids);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
