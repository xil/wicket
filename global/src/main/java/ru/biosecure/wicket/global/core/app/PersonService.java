package ru.biosecure.wicket.global.core.app;

import ru.biosecure.wicket.global.core.entities.Person;

import java.util.List;

public interface PersonService {

    public void addPerson(Person person);

    public List<Person> listPerson();

    public void removePerson(long id);

    List<Person> findPersonByScanId(String[] splitIds);
}
