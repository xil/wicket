package ru.biosecure.wicket.core.web.common;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.biosecure.wicket.core.repo.PersonRepository;
import ru.biosecure.wicket.core.repo.UserRepository;
import ru.biosecure.wicket.core.web.SimpleController;
import ru.biosecure.wicket.core.web.utils.JSONUtils;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.scanner.ScanResult;
import ru.biosecure.wicket.global.scanner.ScannerService;

import javax.inject.Inject;

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

    //    TODO add paging, add sorting by fields
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getAll() {
        return JSONUtils.toJson(personRepository.findAll());
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
    public ResponseEntity<String> getPerson(@PathVariable String userId) {
        return JSONUtils.toJson(personRepository.findOne(Long.parseLong(userId)));
    }

    @ResponseBody
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> savePerson(@PathVariable long userId, @RequestBody String item) {
        Person p = null;
        if (item != null && personRepository.findOne(userId) != null) {
            Gson gson = new Gson();
            p = gson.fromJson(item, Person.class);
            p.setId(userId);
            p = personRepository.save(p);
        }
        return JSONUtils.toJson(p);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addPerson(@RequestBody String item) {
        Gson gson = new Gson();
        Person p = gson.fromJson(item, Person.class);
        return JSONUtils.toJson(personRepository.saveAndFlush(p));
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
