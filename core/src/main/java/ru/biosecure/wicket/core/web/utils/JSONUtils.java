package ru.biosecure.wicket.core.web.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

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
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(gson.toJson(obj), headers, status);
    }

    public static void addPropsToJsonObject(JsonObject obj, Map<String, Object> propsToInject) {
        for (Map.Entry<String, Object> entry : propsToInject.entrySet()) {
            obj.addProperty(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    public static String getJsonObject(Object obj, Map<String, Object> propsToInject) {
        assert propsToInject != null : "propsToInject must not be null!";

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String objAsJson = gson.toJson(obj);
        JsonObject jsonObject = gson.fromJson(objAsJson, JsonElement.class).getAsJsonObject();
        for (Map.Entry<String, Object> entry : propsToInject.entrySet()) {
            jsonObject.addProperty(entry.getKey(), String.valueOf(entry.getValue()));
        }

        return jsonObject.toString();
    }
}
