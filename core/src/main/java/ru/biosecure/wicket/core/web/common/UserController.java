package ru.biosecure.wicket.core.web.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.biosecure.wicket.core.repo.PersonRepository;
import ru.biosecure.wicket.core.repo.UserRepository;
import ru.biosecure.wicket.core.web.SimpleController;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.scanner.ScanResult;
import ru.biosecure.wicket.global.scanner.ScannerService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Inject
    private ScannerService scannerService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String, String>> getAll() {
        List<Person> persons = personRepository.findAll();
        if (persons != null) {
            List<Map<String, String>> resList = new ArrayList<Map<String, String>>();
            for (Person p : persons) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("firstname", p.getFirstname());
                map.put("lastname", p.getLastname());
                map.put("middlename", p.getMiddlename());
                resList.add(map);
            }
            return resList;
        }
        return null;
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
            return personRepository.save(item);
        }
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Person addPerson(@RequestBody Person item) {
        return personRepository.saveAndFlush(item);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePerson(@PathVariable String userId) {
        personRepository.delete(Long.parseLong(userId));
    }

    @RequestMapping(value = "/scanning/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public String scanningPerson(@PathVariable String userId) {
        logger.warn("Scanning user with id '" + userId + "'");
        Person person = personRepository.findOne(Long.parseLong(userId));
        if (person != null) {
            try {
                scannerService.scan(person);
            } catch (Exception e) {
                logger.error("Error", e);
            }
        }
        return "scanning";
    }

    @RequestMapping(value = "/scanningState/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public ScanResult getStateOfScanning(@PathVariable String userId) {
        logger.warn("Get status of scanner for user with id '" + userId + "'");
        Person person = personRepository.findOne(Long.parseLong(userId));
        if (person != null) {
            try {
                return scannerService.getResult(person);
            } catch (Exception e) {
                logger.error("Error", e);
            }
        }
        return null;
    }
}
