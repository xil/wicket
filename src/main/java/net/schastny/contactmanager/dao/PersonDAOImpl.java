package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPerson(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @SuppressWarnings("unchecked")
    public List<Person> listPerson() {

        return sessionFactory.getCurrentSession().createQuery("from Person")
                .list();
    }

    public void removePerson(Integer id) {
        Person person = (Person) sessionFactory.getCurrentSession().load(
                Person.class, id);
        if (null != person) {
            sessionFactory.getCurrentSession().delete(person);
        }
    }
}
