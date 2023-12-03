package com.yh.service;

import com.yh.dao.MemoryPersonDao;
import com.yh.dao.PersonDao;
import com.yh.model.Person;

public class DefaultPersonService implements PersonService {
    PersonDao personDao;

    public DefaultPersonService() {
        personDao = new MemoryPersonDao();
    }

    @Override
    public Person[] getAllPersons() {
        return personDao.getAllPersons();
    }

    @Override
    public Person getPersonById(Integer personId) {
        return personDao.getPersonById(personId);
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        personDao.updatePerson(updatedPerson);
    }
}
