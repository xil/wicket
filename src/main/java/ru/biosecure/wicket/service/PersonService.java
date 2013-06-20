package ru.biosecure.wicket.service;

import ru.biosecure.wicket.domain.Person;

import java.util.List;

public interface PersonService {

    public void addPerson(Person person);

    public List<Person> listPerson();

    public void removePerson(Integer id);
}
