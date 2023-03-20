package com.okta.integration.test;

import java.util.List;
import java.util.stream.Collectors;

public class PersonDTO {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PersonDTO toDto(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        return dto;
    }

    public static List<PersonDTO> toDto(List<Person> persons) {
        return persons.stream().map(PersonDTO::toDto).collect(Collectors.toList());
    }

    public static Person toDomain(PersonDTO dto) {
        Person domain = new Person();
        domain.setId(dto.getId());
        domain.setName(dto.getName());
        return domain;
    }

    public static List<Person> toDomain(List<PersonDTO> dtos) {
        return dtos.stream().map(PersonDTO::toDomain).collect(Collectors.toList());
    }
}
