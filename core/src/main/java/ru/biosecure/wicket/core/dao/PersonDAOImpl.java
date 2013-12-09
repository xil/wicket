package ru.biosecure.wicket.core.dao;

import org.springframework.stereotype.Repository;
import ru.biosecure.wicket.global.core.entities.person.Person;

import java.util.Collections;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

//    @Autowired
//    private SessionFactory sessionFactory;

    public void addPerson(Person person) {
//        sessionFactory.getCurrentSession().save(person);
    }

    @SuppressWarnings("unchecked")
    public List<Person> listPerson() {
        return Collections.EMPTY_LIST;
//        return sessionFactory.getCurrentSession().createQuery("from Person")
//                .list();
    }

    public void removePerson(long id) {
//        Person person = (Person) sessionFactory.getCurrentSession().load(
//                Person.class, id);
//        if (null != person) {
//            sessionFactory.getCurrentSession().delete(person);
//        }
    }
}
