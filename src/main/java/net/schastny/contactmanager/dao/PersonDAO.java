package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Person;

import java.util.List;

public interface PersonDAO {

    public void  addPerson(Person person);

    public List<Person> listPerson();

    public void removePerson(Integer id);
}