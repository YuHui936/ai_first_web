package com.yh.service;

import com.yh.model.Person;

public interface PersonService {
    Person[] getAllPersons();

    Person getPersonById(Integer personId);

    void updatePerson(Person person);

}
