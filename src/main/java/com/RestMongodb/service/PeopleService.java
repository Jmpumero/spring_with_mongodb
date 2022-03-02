package com.RestMongodb.service;

import com.RestMongodb.domain.Person;
import com.RestMongodb.repository.PersonRepository;
import com.RestMongodb.service.responses.PersonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    PersonRepository personRepository;



    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public  List<PersonResponse> findByFirstName(String query){
        return personRepository.findByFirstName(query);
    }

    public Person savePeople(Person person){
        return personRepository.save(person);

    }


    public List<Person> regexPerson(String query){

        return personRepository.findRegexFirstNameAux(query);
    }

    public void deletePersonById(String id){
        personRepository.deleteById(id);

    }

    public ResponseEntity<Person> updatePerson(String id,Person data){

        Optional<Person> personData = personRepository.findById(id);
        if (personData.isPresent()) {
            Person _tutorial = personData.get();
            _tutorial.setFirstName(data.getFirstName());
            _tutorial.setLastName(data.getLastName());

            return new ResponseEntity<>(personRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    public void deleteManySimple(List<String> ids){
        try {
            for (String x:ids) {
                personRepository.deleteById( x);
            }


        }catch (Exception e){
                System.out.println(e);
        }
    }
}
