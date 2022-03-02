package com.RestMongodb.service.responses;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

public class PersonResponse implements Serializable {
    @Id //no hace falta pero por buenas practica
    @Field
    private String id;
    @Field("firstName")
    private String firstName;
    @Field("lastName")
    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}

