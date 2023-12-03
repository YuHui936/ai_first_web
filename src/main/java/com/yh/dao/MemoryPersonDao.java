package com.yh.dao;

import com.yh.model.Country;
import com.yh.model.Person;

public class MemoryPersonDao implements PersonDao {
    private static final Person[] personsInMemory = {
            new Person(1, "John", "Doe", "Football", "Male", new Country("1", "USA"), true, null, "john@example.com", "123-456-7890"),
            new Person(2, "Jane", "Doe", "Basketball", "Female", new Country("2", "Canada"), false, null, "jane@example.com", "987-654-3210")
            // Add more sample persons as needed
    };

    @Override
    public Person[] getAllPersons() {
        return personsInMemory;
    }

    @Override
    public Person getPersonById(Integer personId) {
        for (Person person : personsInMemory) {
            if (person.getPersonId().equals(personId)) {
                return person;
            }
        }
        return null; // Person not found
    }

    @Override
    public void updatePerson(Person updatedPerson) {
        for (int i = 0; i < personsInMemory.length; i++) {
            if (personsInMemory[i].getPersonId().equals(updatedPerson.getPersonId())) {
                personsInMemory[i] = updatedPerson;
                break;
            }
        }
    }
}
