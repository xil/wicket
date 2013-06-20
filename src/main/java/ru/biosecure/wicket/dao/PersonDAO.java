package ru.biosecure.wicket.dao;

import ru.biosecure.wicket.global.domain.Person;

import java.util.List;

public interface PersonDAO {

    public void  addPerson(Person person);

    public List<Person> listPerson();

    public void removePerson(Integer id);
}