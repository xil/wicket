package ru.biosecure.wicket.core.web.common;

import ru.biosecure.wicket.global.core.entities.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Alexey Nevinsky
 * Date: 21.10.13 23:26
 */
public class PersonJson {
    public static Map<String, Object> getJson(Person person) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        if (person != null) {
            resMap.put("id", String.valueOf(person.getId()));
            resMap.put("firstname", person.getFirstname());
            resMap.put("lastname", person.getLastname());
            resMap.put("middlename", person.getMiddlename());
            resMap.put("scansCount", Integer.toString(person.scansCount()));
        }
        return resMap;
    }
}
