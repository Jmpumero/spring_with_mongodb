package com.RestMongodb.service;

import com.RestMongodb.domain.Person;
import com.RestMongodb.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeopleService {

    PersonRepository personRepository;

    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePeople(Person person){
        return personRepository.save(person);

    }

    public List<Person> regexPerson(String query){

        return personRepository.findRegexFirstNameAux(query);
    }

}
