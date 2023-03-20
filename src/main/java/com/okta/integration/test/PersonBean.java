package com.okta.integration.test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PersonBean {

    @Inject
    private PersonService personService;
    private List<Person> personList;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public String fetchPersons() {
        personList = personService.getAllPersons();
        return "success";
    }

    public String add() {
        Person person = new Person();
        person.setName(name);
        personService.addPerson(person);
        return "success";
    }
}
