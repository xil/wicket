package ru.biosecure.wicket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.biosecure.wicket.core.dao.PersonDAO;
import ru.biosecure.wicket.global.core.app.PersonService;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.core.repo.PersonRepository;

import javax.inject.Inject;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Inject
    private PersonRepository personRepository;

    @Transactional
    public void addPerson(Person person) {
        personRepository.saveAndFlush(person);
//        personDAO.addPerson(person);
    }

    @Transactional
    public List<Person> listPerson() {
        return personRepository.findAll();
//        return personDAO.listPerson();
    }

    @Transactional
    public void removePerson(long id) {
        personDAO.removePerson(id);
    }
}
