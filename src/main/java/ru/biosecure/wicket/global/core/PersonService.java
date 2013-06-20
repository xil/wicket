package ru.biosecure.wicket.global.core;

import ru.biosecure.wicket.global.domain.Person;

import java.util.List;

public interface PersonService {

    public void addPerson(Person person);

    public List<Person> listPerson();

    public void removePerson(Integer id);
}
