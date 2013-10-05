package ru.biosecure.wicket.core.web.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.biosecure.wicket.core.repo.PersonRepository;
import ru.biosecure.wicket.core.repo.UserRepository;
import ru.biosecure.wicket.core.web.SimpleController;
import ru.biosecure.wicket.global.core.entities.Person;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 01.07.13
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/ws/rest/user")
public class UserController implements SimpleController {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private UserRepository userRepository;
    @Inject
    private PersonRepository personRepository;

    @RequestMapping("/list")
    @ResponseBody
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    @RequestMapping("/template")
    public String getScreenTemplate() {
        return "userBrowser";
    }

    @RequestMapping("/editTemplate")
    public String getEditTemplate() {
        return "userEdit";
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@PathVariable String userId) {
        return personRepository.findOne(Long.parseLong(userId));
    }

    @ResponseBody
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public Person savePerson(@RequestBody Person item) {
        if (item != null && personRepository.findOne(item.getId()) != null) {
            personRepository.save(item);
            return personRepository.findOne(item.getId());
        }
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public void addPerson(@RequestBody Person item) {
        personRepository.save(item);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePerson(@PathVariable String userId) {
        personRepository.delete(Long.parseLong(userId));
    }
}
