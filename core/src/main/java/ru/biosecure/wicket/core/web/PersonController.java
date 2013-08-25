package ru.biosecure.wicket.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.biosecure.wicket.global.core.app.PersonService;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.core.repo.PersonRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ws/rest/person")
public class PersonController {

    @Inject
    private PersonService personService;

    @Inject
    private PersonRepository personRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> listPersons() {
        return personRepository.findAll();
    }

    @RequestMapping("/index")
    public String listPersons(Map<String, Object> map) {

        map.put("person", new Person());
        map.put("personList", personService.listPerson());

        return "person";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person,
                            BindingResult result) {

        personService.addPerson(person);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Integer personId) {

        personService.removePerson(personId);

        return "redirect:/index";
    }
}
