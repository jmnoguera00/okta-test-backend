package com.okta.integration.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.stream.Stream;

@Singleton
@Startup
public class StartupBean {
    private final PersonService personService;

    @Inject
    public StartupBean(PersonService personService) {
        this.personService = personService;
    }

    @PostConstruct
    private void startup() {

        Stream.of("Jaume Palou", "David Villafaina", "Luis Lozano", "Javier Benito",
                "Josep M Noguera", "Jose Antonio Herrera", "Alvaro Diaz").forEach(name ->
                personService.addPerson(new Person(name))
        );
        personService.getAllPersons().forEach(System.out::println);
    }

    @PreDestroy
    private void shutdown() {
        personService.clear();
    }
}