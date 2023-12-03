package com.yh.dao;

import com.yh.model.Person;

public interface PersonDao {
    Person[] getAllPersons();

    Person getPersonById(Integer personId);

    void updatePerson(Person updatedPerson);
}
