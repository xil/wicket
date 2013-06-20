package ru.biosecure.wicket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.biosecure.wicket.dao.PersonDAO;
import ru.biosecure.wicket.domain.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Transactional
    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    @Transactional
    public List<Person> listPerson() {

        return personDAO.listPerson();
    }

    @Transactional
    public void removePerson(Integer id) {
        personDAO.removePerson(id);
    }
}
