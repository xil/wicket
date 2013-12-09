package ru.biosecure.wicket.core.scanner;

import org.springframework.stereotype.Service;
import ru.biosecure.wicket.global.core.entities.person.Person;
import ru.biosecure.wicket.global.scanner.PersonBean;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 14.10.13
 * Time: 0:41
 * To change this template use File | Settings | File Templates.
 */

@Service
public class PersonBeanImpl implements PersonBean {

    private Person person = null;

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
