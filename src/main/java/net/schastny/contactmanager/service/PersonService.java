package net.schastny.contactmanager.service;

import net.schastny.contactmanager.domain.Person;

import java.util.List;

public interface PersonService {

    public void addPerson(Person person);

    public List<Person> listPerson();

    public void removePerson(Integer id);
}
