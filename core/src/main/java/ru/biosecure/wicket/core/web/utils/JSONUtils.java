package ru.biosecure.wicket.core.web.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Modifier;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 27.11.13
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class JSONUtils {
    public static ResponseEntity<String> toJson(Object obj) {
        return toJson(obj, HttpStatus.OK);
    }

    public static ResponseEntity<String> toJson(Object obj, HttpStatus status) {
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.STATIC).create();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(gson.toJson(obj), headers, status);
    }
}
