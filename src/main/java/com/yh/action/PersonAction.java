package com.yh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yh.model.Person;
import com.yh.service.DefaultPersonService;
import com.yh.service.PersonService;

public class PersonAction extends ActionSupport {
    private PersonService personService = new DefaultPersonService();
    private Person[] persons;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private Person person;

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }


    public String list() {
        // Assume personService is injected through Spring or other DI framework
        persons = personService.getAllPersons();
        return SUCCESS;
    }

    private String personId; // Add a new property to store the personId from the request

    public String edit() {
        // Similar logic as before to retrieve person information
        if (personId != null && !personId.isEmpty()) {
            try {
                Integer selectedPersonId = Integer.parseInt(personId);
                person = personService.getPersonById(selectedPersonId);
                return SUCCESS;
            } catch (NumberFormatException e) {
                addActionError("Invalid personId. Please select a valid person.");
                return ERROR;
            }
        } else {
            addActionError("PersonId is required. Please select a person to edit.");
            return ERROR;
        }
    }

    public String update() {
        // Update logic here using personService
        if (person != null) {
            personService.updatePerson(person);
            return SUCCESS;
        } else {
            addActionError("Person information is null. Cannot update.");
            return ERROR;
        }
    }

    // Add a getter and setter for personId
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

}
