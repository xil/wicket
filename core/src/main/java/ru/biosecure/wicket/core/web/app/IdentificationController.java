package ru.biosecure.wicket.core.web.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.biosecure.wicket.core.repo.PersonRepository;
import ru.biosecure.wicket.core.repo.UserRepository;
import ru.biosecure.wicket.core.web.utils.JSONUtils;
import ru.biosecure.wicket.global.core.entities.person.Person;
import ru.biosecure.wicket.global.scanner.ScannerService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by inver on 05.12.13.
 */
@Controller
@RequestMapping("/ws/rest/identification")
public class IdentificationController {
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

}
