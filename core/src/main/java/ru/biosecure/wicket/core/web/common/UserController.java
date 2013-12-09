package ru.biosecure.wicket.core.web.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.biosecure.wicket.core.repo.PersonRepository;
import ru.biosecure.wicket.core.repo.UserRepository;
import ru.biosecure.wicket.core.web.SimpleController;
import ru.biosecure.wicket.core.web.utils.JSONUtils;
import ru.biosecure.wicket.global.core.entities.person.Person;
import ru.biosecure.wicket.global.core.entities.scanner.ScanResult;
import ru.biosecure.wicket.global.scanner.ScannerService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    //    TODO add paging, rework sorting by fields
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getAll(HttpServletRequest request) {
        Map<String, Object> params = request.getParameterMap();
        Set<String> keys = params.keySet();
        Boolean asc = null;
        String fieldName = "";
        for (String key : keys) {
            if (key.contains("sort")) {
                //sort(+fieldName)
                asc = !key.contains("-");
                fieldName = key.substring(key.indexOf("(") + 2, key.length() - 1);
            }
        }

        List<JsonObject> list = new ArrayList<JsonObject>();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        List<Person> persons;
        if (asc != null) {
            persons = personRepository.findAll(new Sort(asc ? Sort.Direction.ASC : Sort.Direction.DESC, Arrays.asList(fieldName)));
        } else {
            persons = personRepository.findAll();
        }
        for (Person p : persons) {
            p.getScans();
            String objAsJson = gson.toJson(p);
            Map<String, Object> map = Collections.singletonMap("scansCount", (Object) p.getScansCount());
            JsonObject jsonObject = gson.fromJson(objAsJson, JsonElement.class).getAsJsonObject();
            JSONUtils.addPropsToJsonObject(jsonObject, map);
            list.add(jsonObject);
        }
        return JSONUtils.toJson(list, HttpStatus.OK);
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
        Person p = personRepository.findOne(Long.parseLong(userId));
        String str = JSONUtils.getJsonObject(p, Collections.singletonMap("scansCount", (Object) p.getScansCount()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(str, headers, HttpStatus.OK);
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
