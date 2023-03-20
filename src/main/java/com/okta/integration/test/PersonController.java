package com.okta.integration.test;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ejb.LockType.READ;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Lock(READ)
@Singleton
@Path("/persons")
public class PersonController {
    private final PersonService personService;

    @Inject
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Produces({APPLICATION_JSON})
    @Path("/getAll")
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons().stream().map(PersonDTO::toDto).collect(Collectors.toList());
    }

    private boolean isGreat(Person person) {
        return !person.getName().equals("Budweiser") &&
                !person.getName().equals("Coors Light") &&
                !person.getName().equals("PBR");
    }
}

