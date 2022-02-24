package com.RestMongodb.domain.repository;

import java.util.List;

import com.RestMongodb.domain.Person;
import com.RestMongodb.domain.PersonResponse;
import org.springframework.data.mongodb.repository.Aggregation;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByLastName(@Param("name") String name,@Param("last_name") String last_name );

    List<PersonResponse>findByFirstName(@Param("name") String name);
    @Aggregation(pipeline = {
            "{'$match':{'firstName': {$regex: ?0 }}}",
    })
    List<Person> findRegexFirstName(String query);

    // es necesario acotar el pattern(patron) del regex entre//, ejemplo: /patron/
    @Aggregation(pipeline = {
            "{" +
                    "'$match':" +
                    "{'firstName': " +
                        "{" +
                        "$regex: /^(?0)/," +
                        "$options: i"+
                        "}" +
                    "}" +
            "}",
    })
    List<Person> findRegexFirstNameAux(String query);

    Person deleteById();

    List<Person> findByFirstNameStartingWith(String regexp);
//    Query query = new Query();
//    query.addCriteria(Criteria.where("age").lt(50).gt(20));
}
