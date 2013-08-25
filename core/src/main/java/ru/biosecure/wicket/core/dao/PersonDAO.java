package ru.biosecure.wicket.core.dao;

import ru.biosecure.wicket.global.core.entities.Person;

import java.util.List;

public interface PersonDAO {

    public void  addPerson(Person person);

    public List<Person> listPerson();

    public void removePerson(long id);
}