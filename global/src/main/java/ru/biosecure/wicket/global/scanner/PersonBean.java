package ru.biosecure.wicket.global.scanner;

import ru.biosecure.wicket.global.core.entities.person.Person;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 14.10.13
 * Time: 0:40
 * To change this template use File | Settings | File Templates.
 */
public interface PersonBean {

    void setPerson(Person person);

    Person getPerson();
}
